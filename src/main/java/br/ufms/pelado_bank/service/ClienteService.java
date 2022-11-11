package br.ufms.pelado_bank.service;

import br.ufms.pelado_bank.dto.response.ClienteResponse;
import br.ufms.pelado_bank.model.Cliente;
import br.ufms.pelado_bank.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public void novoCliente(ClienteResponse clienteResponse) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteResponse, cliente);
        clienteRepository.save(cliente);
    }

    @Transactional
    public void atualizarCliente(Long id, ClienteResponse clienteResponse) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(clienteResponse, cliente);
    }

    public Page<ClienteResponse> listarClientes(Pageable pageable) {
        Page<Cliente> all = clienteRepository.findAll(pageable);
        List<ClienteResponse> clienteResponses = all.map(cliente -> {
            ClienteResponse clienteResponse = new ClienteResponse();
            BeanUtils.copyProperties(cliente, clienteResponse);
            return clienteResponse;
        }).stream().toList();
        return new PageImpl<>(clienteResponses);
    }

    public ClienteResponse buscarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        ClienteResponse clienteResponse = new ClienteResponse();
        BeanUtils.copyProperties(cliente, clienteResponse);
        return clienteResponse;
    }

}
