package umfg.api.backend.java.ExemploAPIJava.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umfg.api.backend.java.ExemploAPIJava.DTO.LoginDTO;
import umfg.api.backend.java.ExemploAPIJava.DTO.UserDTO;
import umfg.api.backend.java.ExemploAPIJava.Entity.UserEntity;
import umfg.api.backend.java.ExemploAPIJava.Exception.User.CpfException;
import umfg.api.backend.java.ExemploAPIJava.Exception.User.EmailException;
import umfg.api.backend.java.ExemploAPIJava.Exception.User.LoginException;
import umfg.api.backend.java.ExemploAPIJava.Exception.User.PasswordException;
import umfg.api.backend.java.ExemploAPIJava.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository respository;

    public UserEntity create(UserDTO data){
        verifyEmail(data.email());
        verifyCpf(data.cpf());
        if(!(data.senha().equals(data.confirmarSenha()))) {
            throw new PasswordException();
        }
        return respository.save(new UserEntity(data.nome(), data.email(), data.senha(),
                data.cpf(), data.genero()));
    }

    public List<UserEntity> getAll(){
        return respository.findAll();
    }

    public UserEntity getById(String userId){
        return respository.findById(userId).orElseThrow(RuntimeException::new);
    }

    public UserEntity update(String userId, UserDTO data){
        UserEntity user = this.getById(userId);
        user.setNome(data.nome());
        user.setCPF(data.cpf());
        user.setEmail(data.email());
        user.setSenha(data.senha());
        user.setGenero(data.genero());

        return respository.save(user);
    }

    public void delete(String userId){
        UserEntity user = this.getById(userId);
        respository.delete(user);
    }

    public UserEntity login(LoginDTO data){
        UserEntity usuario = respository.findByEmail(data.email()).orElseThrow(LoginException::new);

        if(!(usuario.getSenha().equals(data.senha()))){
            throw new LoginException();
        }

        return usuario;
    }

    private void verifyEmail(String email){
        if(!(email.contains("@") && email.contains(".com"))){
            throw new EmailException();
        }
    }

    private void verifyCpf(String cpf){

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            throw new CpfException();
        }

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (10 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit > 9) {
            firstDigit = 0;
        }

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (11 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit > 9) {
            secondDigit = 0;
        }

        // Verifica se os dígitos verificadores calculados correspondem aos do CPF

        if(!(Character.getNumericValue(cpf.charAt(9)) == firstDigit &&
                Character.getNumericValue(cpf.charAt(10)) == secondDigit)){
            throw new CpfException();
        }
    }
}
