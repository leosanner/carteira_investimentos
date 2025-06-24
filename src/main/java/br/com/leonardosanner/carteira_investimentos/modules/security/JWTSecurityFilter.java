package br.com.leonardosanner.carteira_investimentos.modules.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Service
public class JWTSecurityFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secret;

    private  JWTValidator jwtValidator;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String headerToken = request.getHeader("Authorization");
        SecurityContextHolder.getContext().setAuthentication(null);

        if (headerToken != null) {
            headerToken = headerToken.replace("Bearer", "");
            jwtValidator.validate(headerToken);
//            try {
//                secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//                String subject = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(headerToken)
//                        .getPayload().getSubject();
//
//                request.setAttribute("username", subject);
//                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(subject, Collections.emptyList());
//
//                SecurityContextHolder.getContext().setAuthentication(auth);
//
//            } catch (JwtException e) {
//                System.out.println("Invalid Token: " + e.getMessage());
//            }


        }

        filterChain.doFilter(request, response);
    }
}
