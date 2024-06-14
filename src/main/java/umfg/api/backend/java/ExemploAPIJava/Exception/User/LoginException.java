package umfg.api.backend.java.ExemploAPIJava.Exception.User;

public class LoginException extends RuntimeException{
    public LoginException(){
        super("Login inválido!");
    }
}
