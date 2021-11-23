package br.unisep.edu.tads.exemplo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisep.edu.tads.exemplo1.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{}
