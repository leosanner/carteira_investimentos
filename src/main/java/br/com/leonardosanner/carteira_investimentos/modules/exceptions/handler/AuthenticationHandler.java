package br.com.leonardosanner.carteira_investimentos.modules.exceptions.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.leonardosanner.carteira_investimentos.modules.exceptions.GenericDTO;
import br.com.leonardosanner.carteira_investimentos.modules.exceptions.auth.PasswordIncorretException;
import br.com.leonardosanner.carteira_investimentos.modules.exceptions.auth.UserNotFoundException;

@ControllerAdvice
public class AuthenticationHandler {
    

    @ExceptionHandler(PasswordIncorretException.class) 
    public ResponseEntity<GenericDTO> handlePasswordIncorrect(PasswordIncorretException e) {
        return ResponseEntity.badRequest().body(new GenericDTO("password", e.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class) 
    public ResponseEntity<GenericDTO> handlePasswordIncorrect(UserNotFoundException e) {
        return ResponseEntity.badRequest().body(new GenericDTO("username", e.getMessage()));
    }

}
