package umfg.api.backend.java.ExemploAPIJava.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "addressId")

public class AddressEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String addressId;
    @Column(nullable = false)
    private String logradouro;
    @Column
    private String numero;
    @Column
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String cep;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;


    public AddressEntity(String logradouro, String numero, String complemento, String cidade, String estado, String cep, UserEntity user) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.user = user;
    }
}
