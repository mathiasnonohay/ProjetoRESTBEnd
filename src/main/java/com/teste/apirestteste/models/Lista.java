package com.teste.apirestteste.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LISTA")
public class Lista implements Serializable {

	private static final long serialVersionUID = 1L;

	// Definição de variáveis

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String desafio;

	private String nome;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesafio() {
		return desafio;
	}

	public void setDesafio(String desafio) {
		this.desafio = desafio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
