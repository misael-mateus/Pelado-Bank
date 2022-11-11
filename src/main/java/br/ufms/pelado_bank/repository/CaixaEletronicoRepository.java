package br.ufms.pelado_bank.repository;

import br.ufms.pelado_bank.model.CaixaEletronico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaixaEletronicoRepository extends JpaRepository<CaixaEletronico, Long> {
}