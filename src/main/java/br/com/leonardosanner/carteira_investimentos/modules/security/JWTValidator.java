package br.com.leonardosanner.carteira_investimentos.modules.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.crypto.SecretKey;
import java.util.Collections;

public class JWTValidator {

    @Autowired
    private SecretKey secretKey;

    public void validate(String headerToken) {
        try {
//            secretKey = getSecretKey();
            String subject = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(headerToken)
                    .getPayload().getSubject();

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(subject, Collections.emptyList());

            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch (JwtException e) {
            System.out.println("Invalid Token: " + e.getMessage());
        }
    }
}
