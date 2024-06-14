package umfg.api.backend.java.ExemploAPIJava.Exception.User;

public class CpfException extends RuntimeException{
    public CpfException(){
        super("Cpf inválido!");
    }
}
