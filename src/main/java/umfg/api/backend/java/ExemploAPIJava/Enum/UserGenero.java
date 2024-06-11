package umfg.api.backend.java.ExemploAPIJava.Enum;

public enum UserGenero {
    MASCULINO("masculino"),
    FEMININO("feminino");

    private final String genero;

    UserGenero(String genero) {
        this.genero = genero;
    }

    private String getGenero(){return genero;}
}
