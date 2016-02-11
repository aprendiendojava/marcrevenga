package com.wpsnetwork.entidades;

public class Cliente implements Comparable<Cliente>, Cloneable {
	private int codigo;
	private String nombre;
	private int edad;
	
	
	public Cliente() {
		super();
	}
	
	public Cliente(int codigo, String nombre, int edad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
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


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	@Override
	public int compareTo(Cliente o) {
		
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public int hashCode() {
		return codigo*50;
	}

	@Override
	public boolean equals(Object obj) {
		
		return this.codigo == ((Cliente)obj).codigo;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	
	
	
}
