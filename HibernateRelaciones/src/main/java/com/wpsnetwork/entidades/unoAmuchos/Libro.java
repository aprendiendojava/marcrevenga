package com.wpsnetwork.entidades.unoAmuchos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIBROS_1_N")
public class Libro implements Serializable{
	private int id;
	private String titulo;
	private Persona persona;
	
	public Libro() {
		super();
	}

	public Libro(int id, String titulo, Persona persona) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.persona = persona;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name = "PERSONA")
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
