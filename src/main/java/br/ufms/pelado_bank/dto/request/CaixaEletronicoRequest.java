package br.ufms.pelado_bank.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link br.ufms.pelado_bank.model.CaixaEletronico} entity
 */
@Data
public class CaixaEletronicoRequest implements Serializable {
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private BigDecimal saldoDisponivel;
}