package br.ufms.pelado_bank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link br.ufms.pelado_bank.model.Cartao} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoResponse implements Serializable {
    private Integer numero;
    private String bandeira;
    private String senha;
    private BigDecimal saldo;
}