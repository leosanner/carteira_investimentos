package br.com.leonardosanner.carteira_investimentos.modules.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JWTSecurityFilter extends OncePerRequestFilter {

    private final JWTValidator jwtValidator;

    public JWTSecurityFilter(JWTValidator jwtValidator) {
        this.jwtValidator = jwtValidator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String headerToken = request.getHeader("Authorization");
        SecurityContextHolder.getContext().setAuthentication(null);

        if (headerToken != null) {
            headerToken = headerToken.replace("Bearer", "");
            jwtValidator.validate(headerToken);
        }

        filterChain.doFilter(request, response);
    }
}
