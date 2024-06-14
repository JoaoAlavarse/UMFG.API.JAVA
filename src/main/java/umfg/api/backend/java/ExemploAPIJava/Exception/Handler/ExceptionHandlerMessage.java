package umfg.api.backend.java.ExemploAPIJava.Exception.Handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionHandlerMessage {
    private HttpStatus status;
    private String mensagem;
}
