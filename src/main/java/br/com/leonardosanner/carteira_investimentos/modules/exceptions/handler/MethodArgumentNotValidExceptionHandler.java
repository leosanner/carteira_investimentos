package br.com.leonardosanner.carteira_investimentos.modules.exceptions.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.leonardosanner.carteira_investimentos.modules.exceptions.GenericDTO;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<GenericDTO>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<GenericDTO> dtos = new ArrayList<>();
        
        e.getBindingResult().getFieldErrors().forEach(err -> {
            dtos.add(new GenericDTO(err.getField(), err.getDefaultMessage()));
        });

        return new ResponseEntity<>(dtos, HttpStatus.BAD_REQUEST);
    }

}
