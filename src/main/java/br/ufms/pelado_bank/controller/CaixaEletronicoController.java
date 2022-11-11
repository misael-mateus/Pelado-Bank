package br.ufms.pelado_bank.controller;

import br.ufms.pelado_bank.dto.request.CaixaEletronicoRequest;
import br.ufms.pelado_bank.dto.request.SaqueRequest;
import br.ufms.pelado_bank.service.PeladoBankFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/caixa-eletronico")
public class CaixaEletronicoController {

    private final PeladoBankFacade peladoBankService;

    public CaixaEletronicoController(PeladoBankFacade peladoBankService) {
        this.peladoBankService = peladoBankService;
    }

    @PostMapping
    public ResponseEntity<Void> novoCaixaEletronico(@RequestBody CaixaEletronicoRequest caixaEletronicoRequest) {
        try {
            peladoBankService.novoCaixaEletronico(caixaEletronicoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<CaixaEletronicoRequest>> listarCaixasEletronicos(Pageable pageable) {
        try {
            return ResponseEntity.ok(peladoBankService.listarCaixasEletronicos(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaixaEletronicoRequest> buscarCaixaEletronico(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(peladoBankService.buscarCaixaEletronico(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/abrir-caixa/{id}")
    public ResponseEntity<Void> abrirCaixa(@PathVariable Long id) {
        try {
            peladoBankService.abrirCaixaEletronico(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @PostMapping("/fechar-caixa/{id}")
    public ResponseEntity<Void> fecharCaixa(@PathVariable Long id) {
        try {
            peladoBankService.fecharCaixaEletronico(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @PostMapping("/{id}/saque")
    public ResponseEntity<Void> saque(@PathVariable Long id, @RequestBody SaqueRequest saqueRequest){
        try{
            this.peladoBankService.saqueCaixaEletronico(id, saqueRequest);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

}
