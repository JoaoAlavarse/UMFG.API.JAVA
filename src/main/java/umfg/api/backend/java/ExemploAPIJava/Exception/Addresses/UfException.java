package umfg.api.backend.java.ExemploAPIJava.Exception.Addresses;

public class UfException extends RuntimeException{
    public UfException(){
        super("UF inválido, digite apenas a sigla do estado!");
    }
}
