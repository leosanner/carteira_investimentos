package br.com.leonardosanner.carteira_investimentos.modules.exceptions.auth;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
