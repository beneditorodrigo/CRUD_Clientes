package com.beneditorodrigo.clientes.controllers;

import com.beneditorodrigo.clientes.entity.Cliente;
import com.beneditorodrigo.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("cliente")
    public Cliente cadastrar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping("clientes")
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
}
