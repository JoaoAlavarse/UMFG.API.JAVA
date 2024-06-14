package umfg.api.backend.java.ExemploAPIJava.Exception.User;

public class EmailException extends RuntimeException{
    public EmailException() {
        super("Email inválido!");
    }
}
