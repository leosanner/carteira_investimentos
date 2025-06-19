package br.com.leonardosanner.carteira_investimentos.modules.user.useCases;

import java.net.PasswordAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leonardosanner.carteira_investimentos.modules.user.dto.AuthUserDTO;

@Service
public class AuthUserCredentials {
    
    @Autowired
    PasswordAuthentication passwordAuthentication;

    public void execute(AuthUserDTO authUserDTO) {

    }
}
