package br.ufms.pelado_bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private String bandeira;
    private LocalDate dataValidade;
    @Enumerated(EnumType.STRING)
    private CartaoStatus status;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoCartao tipoCartao;
    private BigDecimal saldo;
    @ManyToOne
    @JsonIgnore
    private Cliente cliente;
}
