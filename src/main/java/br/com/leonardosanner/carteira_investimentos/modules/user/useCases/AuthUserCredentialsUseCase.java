package br.com.leonardosanner.carteira_investimentos.modules.user.useCases;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.leonardosanner.carteira_investimentos.modules.user.UserEntity;
import br.com.leonardosanner.carteira_investimentos.modules.user.UserRepository;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.ResponseTokenDTO;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.AuthUserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import br.com.leonardosanner.carteira_investimentos.modules.exceptions.auth.UserNotFoundException;
import br.com.leonardosanner.carteira_investimentos.modules.exceptions.auth.PasswordIncorretException;

@Service
public class AuthUserCredentialsUseCase {
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expirationTime;

    @Value("${jwt.issuer}")
    private String issuer;


    public ResponseEntity<ResponseTokenDTO> execute(AuthUserDTO authUserDTO) {
        Optional<UserEntity> userCredentials = this.userRepository.findByUsername(authUserDTO.getUsername());

        if (!userCredentials.isPresent()) {
            throw new UserNotFoundException("Username incorret.");
        }
        
        boolean correctPassword = this.passwordEncoder.matches(authUserDTO.getPassword(), userCredentials.get().getPassword());

        if (!correctPassword) {
            throw new PasswordIncorretException("Password incorrect.");
        }

        return ResponseEntity.ok().body(generateToken(authUserDTO.getUsername()));
    }

    private ResponseTokenDTO generateToken(String username){
        Date currenDate = new Date();
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
    
        String token = Jwts.builder()
        .subject(username)
        .issuer(issuer)
        .issuedAt(currenDate)
        .expiration(expirationDate)
        .signWith(getEncryptKey(), Jwts.SIG.HS256)
        .compact();

        return new ResponseTokenDTO(token, username, issuer, currenDate, expirationDate);
    }

    private SecretKey getEncryptKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
}
