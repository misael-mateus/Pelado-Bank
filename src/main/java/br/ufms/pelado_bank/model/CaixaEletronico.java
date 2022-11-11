package br.ufms.pelado_bank.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class CaixaEletronico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private BigDecimal saldoDisponivel;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;
    @Enumerated(EnumType.STRING)
    private StatusCaixaEletronico status;
}
