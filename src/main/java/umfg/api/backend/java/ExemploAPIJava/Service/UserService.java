package umfg.api.backend.java.ExemploAPIJava.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umfg.api.backend.java.ExemploAPIJava.DTO.UserDTO;
import umfg.api.backend.java.ExemploAPIJava.Entity.UserEntity;
import umfg.api.backend.java.ExemploAPIJava.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository respository;

    public UserEntity create(UserDTO data){
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
}
