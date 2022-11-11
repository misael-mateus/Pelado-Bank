package br.ufms.pelado_bank.service;

import br.ufms.pelado_bank.dto.request.CartaoRequest;
import br.ufms.pelado_bank.model.Cartao;
import br.ufms.pelado_bank.model.CartaoStatus;
import br.ufms.pelado_bank.model.Cliente;
import br.ufms.pelado_bank.repository.CartaoRepository;
import br.ufms.pelado_bank.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CartaoService {

    private final CartaoRepository cartaoRepository;
    private final ClienteRepository clienteRepository;

    public CartaoService(CartaoRepository cartaoRepository, ClienteRepository clienteRepository) {
        this.cartaoRepository = cartaoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cartao novoCartao(CartaoRequest cartaoRequest){
        Cartao cartao = new Cartao();
        BeanUtils.copyProperties(cartaoRequest, cartao);
        cartao.setDataAbertura(LocalDate.now());
        cartao.setDataValidade(LocalDate.now().plusYears(5));
        cartao.setSaldo(new BigDecimal(0));
        cartao.setDataEncerramento(null);
        cartao.setStatus(CartaoStatus.ATIVO);
        Optional<Cliente> cliente = clienteRepository.findById(cartaoRequest.getClienteId());
        if (cliente.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        }
        cartao.setCliente(cliente.get());
        //cliente.get().addCartao(cartao);
        return this.cartaoRepository.saveAndFlush(cartao);
    }

    public Cartao buscarCartaoPeloNumeroESenha(Integer numero, String senha){
        Optional<Cartao> byNumeroAndSenha = this.cartaoRepository.findByNumeroAndSenha(numero, senha);
        if (byNumeroAndSenha.isEmpty()) {
            throw new RuntimeException("Cartão não encontrado");
        }
        return byNumeroAndSenha.get();
    }

    public Page<Cartao> buscarTodosCartoesDoCliente(Long clienteId, Pageable pageable) {
        return this.cartaoRepository.findAllByClienteId(clienteId, pageable);
    }

}
