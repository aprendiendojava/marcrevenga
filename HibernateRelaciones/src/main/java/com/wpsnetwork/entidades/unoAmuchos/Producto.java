package com.wpsnetwork.entidades.unoAmuchos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTOS")
public class Producto implements Serializable{
	private int id;
	private String nombre;
	private Categoria categoria;
	
	public Producto() {
		super();
	}

	public Producto(int id, String nombre, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
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

	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="CATEGORIA")
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
