package com.beneditorodrigo.clientes.service;

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
}
