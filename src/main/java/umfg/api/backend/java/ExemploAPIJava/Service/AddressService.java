package umfg.api.backend.java.ExemploAPIJava.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umfg.api.backend.java.ExemploAPIJava.DTO.AddressDTO;
import umfg.api.backend.java.ExemploAPIJava.Entity.AddressEntity;
import umfg.api.backend.java.ExemploAPIJava.Repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private UserService userService;

    public AddressEntity create(AddressDTO data){
        return repository.save(new AddressEntity(data.logradouro(), data.numero(), data.complemento(), data.cidade(),
                data.estado(), data.cep(), this.userService.getById(data.userId())));
    }

    public List<AddressEntity> getAll(){return repository.findAll();}

    public AddressEntity getById(String addressId){return repository.findById(addressId).orElseThrow(RuntimeException::new);}

    public AddressEntity update(String addressId, AddressDTO data){
        AddressEntity address = this.getById(addressId);

        address.setLogradouro(data.logradouro());
        address.setNumero(data.numero());
        address.setComplemento(data.complemento());
        address.setCidade(data.cidade());
        address.setEstado(data.estado());
        address.setCep(data.cep());

        return repository.save(address);
    }

    public void delete(String addressId){
        AddressEntity address = this.getById(addressId);
        repository.delete(address);
    }
}
