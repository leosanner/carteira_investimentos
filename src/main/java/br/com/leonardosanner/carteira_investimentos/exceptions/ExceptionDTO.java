package br.com.leonardosanner.carteira_investimentos.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionDTO {
    private String field;
    private String message;
}
