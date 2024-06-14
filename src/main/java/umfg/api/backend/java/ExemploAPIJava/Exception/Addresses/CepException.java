package umfg.api.backend.java.ExemploAPIJava.Exception.Addresses;

public class CepException extends RuntimeException{
    public CepException(){
        super("Cep inválido!");
    }
}
