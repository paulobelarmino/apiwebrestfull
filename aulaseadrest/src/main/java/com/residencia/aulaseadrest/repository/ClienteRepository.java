package com.residencia.aulaseadrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.residencia.aulaseadrest.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public Cliente findAllByNome(String nome);
	//public Cliente deletByNome(String nome);
}
