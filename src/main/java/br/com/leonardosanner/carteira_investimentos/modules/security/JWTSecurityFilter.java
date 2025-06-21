package br.com.leonardosanner.carteira_investimentos.modules.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class JWTSecurityFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secret;

    private SecretKey secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String headerToken = request.getHeader("Authorization");

        if (headerToken != null) {
            headerToken = headerToken.replace("Bearer", "");

            try {
                secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
                String subject = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(headerToken)
                        .getPayload().getSubject();

                request.setAttribute("username", subject);

            } catch (JwtException e) {
                System.out.println("Invalid Token: " + e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}
