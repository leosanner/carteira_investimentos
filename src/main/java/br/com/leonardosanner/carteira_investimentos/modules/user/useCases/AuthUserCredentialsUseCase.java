package br.com.leonardosanner.carteira_investimentos.modules.user.useCases;

import java.net.PasswordAuthentication;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.leonardosanner.carteira_investimentos.modules.user.UserEntity;
import br.com.leonardosanner.carteira_investimentos.modules.user.UserRepository;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.AuthUserDTO;

import br.com.leonardosanner.carteira_investimentos.modules.exceptions.auth.UserNotFoundException;

@Service
public class AuthUserCredentialsUseCase {
    
    @Autowired
    PasswordAuthentication passwordAuthentication;

    @Autowired
    UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secret;

    public void execute(AuthUserDTO authUserDTO) {
        Optional<UserEntity> userCredentials = userRepository.findByUsername(authUserDTO.getUsername());

        if (!userCredentials.isPresent()) {
            throw new UserNotFoundException("username / password incorret.");
        }

    }
}
