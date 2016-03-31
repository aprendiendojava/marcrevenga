package com.wpsnetwork.entidades;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Libro implements Externalizable{
	private int codigo;
	private String titulo;
	private int anho;
	private String autor;
	
	public Libro() {
		
	}
	
	public Libro(int codigo, String titulo, int anho, String autor) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.anho = anho;
		this.autor = autor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + ", anho=" + anho + ", autor=" + autor + "]";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(codigo);
		out.writeUTF(titulo);
		out.writeInt(anho);
		out.writeUTF(autor);		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		codigo = in.readInt();
		titulo = in.readUTF();
		anho = in.readInt();
		autor = in.readUTF();	
		
	}
	
	
}
