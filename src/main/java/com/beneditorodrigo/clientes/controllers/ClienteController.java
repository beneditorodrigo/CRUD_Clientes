package com.beneditorodrigo.clientes.controllers;

import com.beneditorodrigo.clientes.entity.Cliente;
import com.beneditorodrigo.clientes.repository.ClienteRepository;
import com.beneditorodrigo.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @PostMapping("cliente")
    public Cliente cadastrar(@Valid @RequestBody Cliente cliente) throws Exception {
        boolean emailEmUso = clienteService.verificaEmailEmUso(cliente);

        if(emailEmUso){
            throw new Exception("Email já em uso");
        }
        return clienteRepository.save(cliente);
    }

    @GetMapping("clientes")
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("cliente/{id}")
    public Optional<Cliente> buscarCliente(@PathVariable Long id){
        return clienteRepository.findById(id);
    }


    @PutMapping("cliente/{id}")
    public Cliente atualizaCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) throws Exception {
        boolean idExiste = clienteService.verificaExistenciaId(id);

        if(!idExiste){
            throw new Exception("ID/Cliente inexistente");
        }

        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("cliente/{id}")
    public void excluirCliente(@PathVariable Long id) throws Exception {
        boolean idExiste = clienteService.verificaExistenciaId(id);

        if (!idExiste){
            throw new Exception("ID não existe");
        }

        clienteRepository.deleteById(id);
    }
}
