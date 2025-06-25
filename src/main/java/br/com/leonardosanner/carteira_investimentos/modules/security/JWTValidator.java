package br.com.leonardosanner.carteira_investimentos.modules.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Service
public class JWTValidator {

    @Value("${jwt.secret}")
    private String secret;

    private SecretKey secretKey;

    public void validate(String headerToken) {
        try {
            System.out.println(secret);
            secretKey = getSecretKey();
            System.out.println("Secretkey: " + secretKey);
            String subject = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(headerToken)
                    .getPayload().getSubject();

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(subject, Collections.emptyList());

            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch (JwtException e) {
            System.out.println("Invalid Token: " + e.getMessage());
        }
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
}
