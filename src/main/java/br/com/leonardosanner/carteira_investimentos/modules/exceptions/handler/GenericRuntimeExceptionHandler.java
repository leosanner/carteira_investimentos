package br.com.leonardosanner.carteira_investimentos.modules.exceptions.handler;


import br.com.leonardosanner.carteira_investimentos.modules.exceptions.GenericDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericRuntimeExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GenericDTO> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.badRequest().body(new GenericDTO(RuntimeException.class.getName(), e.getMessage()));
    }
}
