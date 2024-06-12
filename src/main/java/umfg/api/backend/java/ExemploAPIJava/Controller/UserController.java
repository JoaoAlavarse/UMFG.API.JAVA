package umfg.api.backend.java.ExemploAPIJava.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umfg.api.backend.java.ExemploAPIJava.DTO.UserDTO;
import umfg.api.backend.java.ExemploAPIJava.Entity.UserEntity;
import umfg.api.backend.java.ExemploAPIJava.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class    UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody UserDTO data){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.create(data));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.getAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getById(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.getById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserEntity> update(@PathVariable String userId, @RequestBody UserDTO data){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.update(userId, data));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable String userId){
        this.service.delete(userId);
    return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
    }
}
