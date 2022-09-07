package com.beneditorodrigo.clientes.repository;

import com.beneditorodrigo.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
