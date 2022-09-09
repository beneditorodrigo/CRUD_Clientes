package com.beneditorodrigo.clientes.controllers;

import com.beneditorodrigo.clientes.entity.Cliente;
import com.beneditorodrigo.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("cliente")
    public Cliente cadastrar(@RequestBody Cliente cliente) throws Exception {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

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

    @DeleteMapping("cliente/{id}")
    public void excluirCliente(@PathVariable Long id) throws Exception {
        boolean idExiste = clienteRepository.findById(id)
                .stream()
                .anyMatch(clienteExiste -> !clienteExiste.equals(id));

        if (!idExiste){
            throw new Exception("ID não existe");
        }

        clienteRepository.deleteById(id);
    }
}
