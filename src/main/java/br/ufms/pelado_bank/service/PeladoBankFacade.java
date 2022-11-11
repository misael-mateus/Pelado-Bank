package br.ufms.pelado_bank.service;

import br.ufms.pelado_bank.dto.request.CartaoRequest;
import br.ufms.pelado_bank.dto.request.CaixaEletronicoRequest;
import br.ufms.pelado_bank.dto.response.ClienteResponse;
import br.ufms.pelado_bank.dto.request.SaqueRequest;
import br.ufms.pelado_bank.model.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PeladoBankFacade {

    private final ClienteService clienteService;
    private final CaixaEletronicoService caixaEletronicoService;
    private final CartaoService cartaoService;

    public PeladoBankFacade(ClienteService clienteService, CaixaEletronicoService caixaEletronicoService, CartaoService cartaoService) {
        this.clienteService = clienteService;
        this.caixaEletronicoService = caixaEletronicoService;
        this.cartaoService = cartaoService;
    }

    public void novoCliente(ClienteResponse clienteResponse) {
        clienteService.novoCliente(clienteResponse);
    }

    public Page<ClienteResponse> listarClientes(Pageable pageable) {
        return clienteService.listarClientes(pageable);
    }

    public void atualizarCliente(Long id, ClienteResponse clienteResponse) {
        clienteService.atualizarCliente(id, clienteResponse);
    }

    public ClienteResponse buscarCliente(Long id) {
        return clienteService.buscarCliente(id);
    }

    public Cartao novoCartao(CartaoRequest cartaoRequest) {
        return cartaoService.novoCartao(cartaoRequest);
    }

    public Cartao buscarCartao(Integer numero, String senha) {
        return cartaoService.buscarCartaoPeloNumeroESenha(numero, senha);
    }

    public Page<Cartao> buscarTodosCartaoPeloClienteId(Long clienteId, Pageable pageable) {
        return cartaoService.buscarTodosCartoesDoCliente(clienteId, pageable);
    }

    public void novoCaixaEletronico(CaixaEletronicoRequest caixaEletronicoRequest) {
        caixaEletronicoService.novoCaixaEletronico(caixaEletronicoRequest);
    }

    public Page<CaixaEletronicoRequest> listarCaixasEletronicos(Pageable pageable) {
        return caixaEletronicoService.listarCaixasEletronicos(pageable);
    }

    public CaixaEletronicoRequest buscarCaixaEletronico(Long id) {
        return caixaEletronicoService.buscarCaixaEletronico(id);
    }

    public void abrirCaixaEletronico(Long id) {
        caixaEletronicoService.abrirCaixaEletronico(id);
    }

    public void fecharCaixaEletronico(Long id) {
        caixaEletronicoService.fecharCaixaEletronico(id);
    }

    public void saqueCaixaEletronico(Long id, SaqueRequest saqueRequest) {
        caixaEletronicoService.saque(id, saqueRequest);
    }
}
