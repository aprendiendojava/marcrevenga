package com.wpsnetwork.entidades;

import java.io.Serializable;

public class Autor implements Serializable{
	private static final long serialVersionUID = -8671509531850894746L;
	private int codigo;
	private String nombre;
	
	public Autor(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Autor [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
