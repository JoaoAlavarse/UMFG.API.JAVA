package umfg.api.backend.java.ExemploAPIJava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umfg.api.backend.java.ExemploAPIJava.Entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity,String> {
}
