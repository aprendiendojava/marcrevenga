package com.wpsnetwork.jpa.entidades;

public class Dato {
	private String nombre;
	private String info;
	
	
	public Dato() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Dato(String nombre, String info) {
		super();
		this.nombre = nombre;
		this.info = info;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	@Override
	public String toString() {
		return "Dato [nombre=" + nombre + ", info=" + info + "]";
	}
	
	
}
