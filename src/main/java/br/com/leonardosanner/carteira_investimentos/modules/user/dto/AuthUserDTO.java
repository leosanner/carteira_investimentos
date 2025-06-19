package br.com.leonardosanner.carteira_investimentos.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUserDTO {
    private String username;
    private String password;
}
