package br.ufms.pelado_bank.controller;

import br.ufms.pelado_bank.dto.response.ClienteResponse;
import br.ufms.pelado_bank.model.Cartao;
import br.ufms.pelado_bank.service.PeladoBankFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

    private final PeladoBankFacade peladoBankService;


    public ClienteController(PeladoBankFacade peladoBankService) {
        this.peladoBankService = peladoBankService;
    }

    @PostMapping
    public ResponseEntity<Cartao> novoCliente(@RequestBody ClienteResponse clienteResponse) {
        try {
            peladoBankService.novoCliente(clienteResponse);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<ClienteResponse>> listarClientes(Pageable pageable) {
        try {
            return ResponseEntity.ok(peladoBankService.listarClientes(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCliente(@PathVariable Long id, @RequestBody ClienteResponse clienteResponse) {
        try {
            peladoBankService.atualizarCliente(id, clienteResponse);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarCliente(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(peladoBankService.buscarCliente(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
