package umfg.api.backend.java.ExemploAPIJava.DTO;

import umfg.api.backend.java.ExemploAPIJava.Enum.UserGenero;

public record UserDTO(
        String nome,
        String email,
        String senha,
        String cpf,
        UserGenero genero
) {
}
