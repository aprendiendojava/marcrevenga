package com.wpsnetwork.entidades.muchosAmuchos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="LIBROS_N_M")
public class Libro implements Serializable{
	private int id;
	private String nombre;
	private List<Autor> autores;
	
	public Libro() {
		super();
	}

	public Libro(int id, String nombre, List<Autor> autores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autores = autores;
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

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
				name = "LIBROS_AUTORES",
				joinColumns = @JoinColumn(name="id_libro"),
				inverseJoinColumns = @JoinColumn(name = "id_autor"))
	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	

}
