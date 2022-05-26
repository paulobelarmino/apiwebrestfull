package com.residencia.aulaseadrest.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(name ="nome", length = 50, nullable= false)
	String nome;
	/*int idade;
	Date nascimento;
	Date deleted;
	*/
}
