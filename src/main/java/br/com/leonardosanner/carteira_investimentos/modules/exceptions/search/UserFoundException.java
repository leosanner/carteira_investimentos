package br.com.leonardosanner.carteira_investimentos.modules.exceptions.search;

public class UserFoundException extends RuntimeException{
    
    public UserFoundException() {
        super("Username already exists");
    }
}