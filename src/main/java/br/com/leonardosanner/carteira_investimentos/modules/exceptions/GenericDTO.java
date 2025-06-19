package br.com.leonardosanner.carteira_investimentos.modules.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericDTO {
    private String field;
    private String message;
}
