package umfg.api.backend.java.ExemploAPIJava.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umfg.api.backend.java.ExemploAPIJava.DTO.UserDTO;
import umfg.api.backend.java.ExemploAPIJava.Entity.UserEntity;
import umfg.api.backend.java.ExemploAPIJava.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
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
}
