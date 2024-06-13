package umfg.api.backend.java.ExemploAPIJava.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import umfg.api.backend.java.ExemploAPIJava.Enum.UserGenero;
import umfg.api.backend.java.ExemploAPIJava.Enum.UserStatus;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "userId")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false, unique = true)
    private String CPF;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGenero genero;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<AddressEntity> addresses;

    public UserEntity(String nome, String email, String senha, String CPF, UserGenero genero) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = CPF;
        this.genero = genero;
        this.status = UserStatus.ATIVO;
    }
}
