package br.ufms.pelado_bank.repository;

import br.ufms.pelado_bank.model.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    Optional<Cartao> findByNumeroAndSenha(Integer numero, String senha);

    Page<Cartao> findAllByClienteId(Long clienteId, Pageable pageable);
}