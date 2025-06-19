package br.com.leonardosanner.carteira_investimentos.modules.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.leonardosanner.carteira_investimentos.modules.exceptions.GenericDTO;
import br.com.leonardosanner.carteira_investimentos.modules.exceptions.search.UserFoundException;

@ControllerAdvice
public class SearchHandler {
    
    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<GenericDTO> handleUserFoundException(UserFoundException e) {
        
        GenericDTO except = new GenericDTO("username", e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(except);
    }
}
