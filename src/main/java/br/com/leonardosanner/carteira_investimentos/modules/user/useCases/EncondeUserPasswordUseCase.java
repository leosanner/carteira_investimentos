package br.com.leonardosanner.carteira_investimentos.modules.user.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncondeUserPasswordUseCase {
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String excecute(String password) {
        return passwordEncoder.encode(password);
    }
}
