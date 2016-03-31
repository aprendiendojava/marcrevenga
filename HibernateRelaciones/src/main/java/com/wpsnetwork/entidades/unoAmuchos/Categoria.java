package com.wpsnetwork.entidades.unoAmuchos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIAS")
public class Categoria implements Serializable{
	private int id;
	private String nombre;
	private List<Producto> productos;
	
	public Categoria() {
		super();
	}

	public Categoria(int id, String nombre, List<Producto> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.productos = productos;
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

	@OneToMany(	mappedBy = "categoria",
				fetch = FetchType.LAZY,
				cascade={CascadeType.PERSIST})
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
