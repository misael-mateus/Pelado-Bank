package br.ufms.pelado_bank.controller;

import br.ufms.pelado_bank.dto.request.CartaoRequest;
import br.ufms.pelado_bank.dto.response.CartaoResponse;
import br.ufms.pelado_bank.model.Cartao;
import br.ufms.pelado_bank.service.PeladoBankFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cartao")
public class CartaoController {
    private final PeladoBankFacade peladoBankService;

    public CartaoController(PeladoBankFacade peladoBankService) {
        this.peladoBankService = peladoBankService;
    }

    @PostMapping
    public ResponseEntity<Cartao> novoCartao(@RequestBody CartaoRequest cartaoRequest) {
        try {
            return ResponseEntity.ok(peladoBankService.novoCartao(cartaoRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page<Cartao>> buscarTodosCartaoPeloClienteId(@PathVariable Long id, Pageable pageable) {
        try {
            return ResponseEntity.ok(peladoBankService.buscarTodosCartaoPeloClienteId(id, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
