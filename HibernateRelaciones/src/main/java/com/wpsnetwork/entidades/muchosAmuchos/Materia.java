package com.wpsnetwork.entidades.muchosAmuchos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIAS")
public class Materia implements Serializable{
	private int id;
	private String nombre;
	
	public Materia() {
		super();
	}

	public Materia(int id, String nombre) {
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
