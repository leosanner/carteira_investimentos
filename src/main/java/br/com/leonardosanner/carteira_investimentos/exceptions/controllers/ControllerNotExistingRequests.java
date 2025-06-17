package br.com.leonardosanner.carteira_investimentos.exceptions.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import br.com.leonardosanner.carteira_investimentos.exceptions.ExceptionDTO;

@ControllerAdvice
public class ControllerNotExistingRequests {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionDTO> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {

        ExceptionDTO dto = new ExceptionDTO(e.getClass().getName(), e.getMessage());

        return ResponseEntity.badRequest().body(dto);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ExceptionDTO> handlerNoResourceFoundException(NoResourceFoundException e) {

        ExceptionDTO dto = new ExceptionDTO(e.getClass().getName(), e.getMessage());

        return ResponseEntity.badRequest().body(dto);
    }
}