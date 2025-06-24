package br.com.leonardosanner.carteira_investimentos.modules.exceptions.search;

public class WalletNotFoundException extends RuntimeException{
    public WalletNotFoundException(String msg) {
        super(msg);
    }
}
