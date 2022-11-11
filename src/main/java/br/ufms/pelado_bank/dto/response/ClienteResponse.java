package br.ufms.pelado_bank.dto.response;

import br.ufms.pelado_bank.model.Cliente;
import br.ufms.pelado_bank.model.TipoCliente;
import lombok.Data;

import java.math.BigDecimal;

/**
 * A DTO for the {@link Cliente} entity
 */
@Data
public class ClienteResponse {
    private String nome;
    private TipoCliente tipoCliente;
    private BigDecimal saldo;
}
