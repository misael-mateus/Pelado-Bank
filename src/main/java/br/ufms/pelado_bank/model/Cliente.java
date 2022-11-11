package br.ufms.pelado_bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Cartao> cartoes = new ArrayList<>();


    public void addCartao(Cartao cartao) {
        this.cartoes.add(cartao);
    }
}
