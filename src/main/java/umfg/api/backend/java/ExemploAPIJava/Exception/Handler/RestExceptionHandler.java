package umfg.api.backend.java.ExemploAPIJava.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import umfg.api.backend.java.ExemploAPIJava.Exception.User.CpfException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CpfException.class)
    private ResponseEntity<ExceptionHandlerMessage> invalidCpf(CpfException exception){
        ExceptionHandlerMessage message = new ExceptionHandlerMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
