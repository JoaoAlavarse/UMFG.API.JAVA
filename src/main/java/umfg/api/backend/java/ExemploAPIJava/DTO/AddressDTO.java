package umfg.api.backend.java.ExemploAPIJava.DTO;

public record AddressDTO(

        String logradouro,
        String numero,
        String complemento,
        String cidade,
        String estado,
        String cep,
        String userId
) {
}
