package com.beneditorodrigo.clientes.service;

import com.beneditorodrigo.clientes.entity.Cliente;
import com.beneditorodrigo.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public boolean verificaExistenciaId(Long id){
        boolean idExiste = clienteRepository.findById(id)
                .stream()
                .anyMatch(clienteExiste -> !clienteExiste.equals(id));
        return idExiste;
    }

    public boolean verificaEmailEmUso(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
        return emailEmUso;
    }
}
