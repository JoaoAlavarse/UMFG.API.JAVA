package umfg.api.backend.java.ExemploAPIJava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umfg.api.backend.java.ExemploAPIJava.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
