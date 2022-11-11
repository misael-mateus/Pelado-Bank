package br.ufms.pelado_bank.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaqueRequest {
    private Integer numero;
    private String senha;
    private BigDecimal valor;
}
