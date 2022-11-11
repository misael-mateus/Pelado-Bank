package br.ufms.pelado_bank.repository;

import br.ufms.pelado_bank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}