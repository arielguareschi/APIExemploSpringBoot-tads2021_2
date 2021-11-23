package br.unisep.edu.tads.exemplo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisep.edu.tads.exemplo1.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
