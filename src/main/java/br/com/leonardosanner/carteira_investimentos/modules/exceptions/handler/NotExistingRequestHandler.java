package br.com.leonardosanner.carteira_investimentos.modules.exceptions.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import br.com.leonardosanner.carteira_investimentos.modules.exceptions.GenericDTO;

@ControllerAdvice
public class NotExistingRequestHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<GenericDTO> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {

        GenericDTO dto = new GenericDTO(e.getClass().getName(), e.getMessage());

        return ResponseEntity.badRequest().body(dto);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<GenericDTO> handlerNoResourceFoundException(NoResourceFoundException e) {

        GenericDTO dto = new GenericDTO(e.getClass().getName(), e.getMessage());

        return ResponseEntity.badRequest().body(dto);
    }
}