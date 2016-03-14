package com.wpsnetwork.entidades.unoAmuchos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAS_1_N")
public class Persona implements Serializable{
	private int id;
	private String nombre;
	
	public Persona() {
		super();
	}

	public Persona(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
