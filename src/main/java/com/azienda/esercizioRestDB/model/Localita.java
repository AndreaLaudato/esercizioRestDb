package com.azienda.esercizioRestDB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "localita")
public class Localita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Float temperatura;
	
	@Override
	public String toString() {
		return "Localita [id=" + id + ", nome=" + nome + ", temperatura=" + temperatura + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}

	public Localita(Integer id, String nome, Float temperatura) {
		super();
		this.id = id;
		this.nome = nome;
		this.temperatura = temperatura;
	}

	public Localita() {
		super();
	}
	
}
