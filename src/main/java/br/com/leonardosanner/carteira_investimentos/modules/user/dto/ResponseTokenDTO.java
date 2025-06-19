package br.com.leonardosanner.carteira_investimentos.modules.user.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// return the information related to the sign in and token of the user.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTokenDTO {

    private String token;
    private String username;
    private String issuer;
    private Date issuedAt;
    private Date expirationDate;
}
