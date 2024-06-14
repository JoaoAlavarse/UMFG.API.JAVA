package umfg.api.backend.java.ExemploAPIJava.Exception.User;

public class PasswordException extends RuntimeException{
    public PasswordException(){
        super("As senhas não conferem!");
    }
}
