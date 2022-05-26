package com.residencia.aulaseadrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.aulaseadrest.model.Cliente;
import com.residencia.aulaseadrest.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	//cria um objeto do serviço para o qual o controlador tem acesso.
	//Faz a injeção de dependência do serviço dentro da classe do controlador
	public ClienteService service;
		ClienteController(ClienteService service){
			this.service = service;
	}
	
	//iniciando a criação dos métodos
	
	@GetMapping
	public List<Cliente> listAll(){
		return service.listAll();
	}
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cliente> getOne(@PathVariable Long id){
		
		Optional<Cliente> cliente = service.findById(id);
		
		if(cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(cliente.get());
		}
	
	}
	
		
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente c) {
		Cliente cliente = service.insert(c);
		return ResponseEntity.status(201).body(cliente);
	}	

		
	@PutMapping(path = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id,  @RequestBody Cliente c	){
		return service.findById(id)
				.map(dado -> {service.saveAndFlush(c);
							return ResponseEntity.ok(c);
							}).orElse(ResponseEntity.notFound().build());
	}
	
 
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return service.findById(id)
				.map(dado ->{service.delete(dado);
				return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
	

	
// Fim da Classe


}


