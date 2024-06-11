package umfg.api.backend.java.ExemploAPIJava.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umfg.api.backend.java.ExemploAPIJava.DTO.UserDTO;
import umfg.api.backend.java.ExemploAPIJava.Entity.UserEntity;
import umfg.api.backend.java.ExemploAPIJava.Repository.UserRepository;

import java.util.List;

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
}
