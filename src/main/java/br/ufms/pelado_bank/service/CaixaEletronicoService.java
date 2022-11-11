package br.ufms.pelado_bank.service;

import br.ufms.pelado_bank.dto.request.CaixaEletronicoRequest;
import br.ufms.pelado_bank.dto.request.SaqueRequest;
import br.ufms.pelado_bank.model.CaixaEletronico;
import br.ufms.pelado_bank.model.Cartao;
import br.ufms.pelado_bank.model.StatusCaixaEletronico;
import br.ufms.pelado_bank.repository.CaixaEletronicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CaixaEletronicoService {

    private final CaixaEletronicoRepository caixaEletronicoRepository;
    private final CartaoService cartaoService;

    public CaixaEletronicoService(CaixaEletronicoRepository caixaEletronicoRepository, CartaoService cartaoService) {
        this.caixaEletronicoRepository = caixaEletronicoRepository;
        this.cartaoService = cartaoService;
    }

    public void novoCaixaEletronico(CaixaEletronicoRequest caixaEletronicoRequest) {
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        BeanUtils.copyProperties(caixaEletronicoRequest, caixaEletronico);
        caixaEletronico.setDataAbertura(LocalDate.now());
        caixaEletronico.setStatus(StatusCaixaEletronico.DISPONIVEL);
        caixaEletronicoRepository.save(caixaEletronico);
    }

    public void fecharCaixaEletronico(Long id) {
        CaixaEletronico caixaEletronico = caixaEletronicoRepository.findById(id).orElseThrow();
        caixaEletronico.setDataEncerramento(LocalDate.now());
        caixaEletronico.setStatus(StatusCaixaEletronico.INDISPONIVEL);
        caixaEletronicoRepository.save(caixaEletronico);
    }

    public void abrirCaixaEletronico(Long id) {
        CaixaEletronico caixaEletronico = caixaEletronicoRepository.findById(id).orElseThrow();
        caixaEletronico.setDataAbertura(LocalDate.now());
        caixaEletronico.setStatus(StatusCaixaEletronico.DISPONIVEL);
        caixaEletronicoRepository.save(caixaEletronico);
    }

    public void deletarCaixaEletronico(Long id) {
        caixaEletronicoRepository.deleteById(id);
    }

    public Page<CaixaEletronicoRequest> listarCaixasEletronicos(Pageable pageable) {
        Page<CaixaEletronico> all = caixaEletronicoRepository.findAll(pageable);
        List<CaixaEletronicoRequest> caixaEletronicoRespons = all.map(caixaEletronico -> {
            CaixaEletronicoRequest caixaEletronicoRequest = new CaixaEletronicoRequest();
            BeanUtils.copyProperties(caixaEletronico, caixaEletronicoRequest);
            return caixaEletronicoRequest;
        }).stream().toList();
        return new PageImpl<>(caixaEletronicoRespons);
    }

    public CaixaEletronicoRequest buscarCaixaEletronico(Long id) {
        CaixaEletronico caixaEletronico = caixaEletronicoRepository.findById(id).orElseThrow();
        CaixaEletronicoRequest caixaEletronicoRequest = new CaixaEletronicoRequest();
        BeanUtils.copyProperties(caixaEletronico, caixaEletronicoRequest);
        return caixaEletronicoRequest;
    }

    @Transactional
    public void saque(Long idCaixaEletronico, SaqueRequest saqueRequest) {
        Cartao cartao = this.cartaoService.buscarCartaoPeloNumeroESenha(saqueRequest.getNumero(), saqueRequest.getSenha());

        Optional<CaixaEletronico> caixaEletronico = caixaEletronicoRepository.findById(idCaixaEletronico);
        if (caixaEletronico.isEmpty()) {
            throw new RuntimeException("Caixa eletrônico não encontrado");
        }

        if (saqueRequest.getValor().compareTo(caixaEletronico.get().getSaldoDisponivel()) > 0){
            throw new RuntimeException("Não tem grana suficiente");
        }

        cartao.setSaldo(cartao.getSaldo().subtract(saqueRequest.getValor()));
        caixaEletronico.get().setSaldoDisponivel(caixaEletronico.get().getSaldoDisponivel().subtract(saqueRequest.getValor()));
    }


}
