package umfg.api.backend.java.ExemploAPIJava.Enum;

public enum UserStatus {
    ATIVO("ativo"),
    INATIVO("inativo");

    private final String status;

    UserStatus(String status) {
        this.status = status;
    }

    private String getStatus(){return status;}
}
