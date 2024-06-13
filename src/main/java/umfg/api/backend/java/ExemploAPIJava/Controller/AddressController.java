package umfg.api.backend.java.ExemploAPIJava.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umfg.api.backend.java.ExemploAPIJava.DTO.AddressDTO;
import umfg.api.backend.java.ExemploAPIJava.Entity.AddressEntity;
import umfg.api.backend.java.ExemploAPIJava.Service.AddressService;

import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping
    public ResponseEntity<AddressEntity> create(@RequestBody AddressDTO data){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.create(data));
    }

    @GetMapping
    public ResponseEntity<List<AddressEntity>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.getAll());
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressEntity> getById(@PathVariable String addressId){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.getById(addressId));
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressEntity> update(@PathVariable String addressId, @RequestBody AddressDTO data){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.update(addressId,data));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<String> delete(@PathVariable String addressId){
        this.service.delete(addressId);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso");
    }

}
