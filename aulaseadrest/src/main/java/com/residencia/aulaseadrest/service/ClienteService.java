package com.residencia.aulaseadrest.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.stereotype.Service;

import com.residencia.aulaseadrest.model.Cliente;
import com.residencia.aulaseadrest.repository.ClienteRepository;

@Service
public class ClienteService {
	
	ClienteRepository repository;
	ClienteService(ClienteRepository repository){
		this.repository = repository;
	}

	public Cliente insert(Cliente c) {
		return repository.save(c);
	}

	public Cliente update(Cliente c) {
		return repository.save(c);
	}

	public void delete (Cliente c) {
		repository.delete(c);
	}
	
	public Cliente saveAndFlush(Cliente c) {
		return repository.saveAndFlush(c);
	}

	public Optional<Cliente> findById(Long id){
		return repository.findById(id);
	}

	public List<Cliente> listAll(){
		return repository.findAll();
	}
	




//Fim da classe


}
