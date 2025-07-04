package br.com.leonardosanner.carteira_investimentos.modules.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   JWTSecurityFilter jwtSecurityFilter) throws Exception{
        http.csrf(csrf -> csrf.disable())
        .sessionManagement(session -> {
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);})

        .authorizeHttpRequests(authorizeRequests ->{
            authorizeRequests
                    .requestMatchers("/auth/**").permitAll()
                    .requestMatchers("/user/**").permitAll()
                    .requestMatchers("/wallet/**").permitAll()

                    .anyRequest().authenticated();
        })
                .addFilterBefore(jwtSecurityFilter, BasicAuthenticationFilter.class);
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
