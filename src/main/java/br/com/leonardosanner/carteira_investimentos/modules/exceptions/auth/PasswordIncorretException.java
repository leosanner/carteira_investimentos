package br.com.leonardosanner.carteira_investimentos.modules.exceptions.auth;

public class PasswordIncorretException extends RuntimeException{
   public PasswordIncorretException(String msg) {
      super(msg);
   }
}
