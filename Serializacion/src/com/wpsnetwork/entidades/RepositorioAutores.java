package com.wpsnetwork.entidades;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAutores implements Serializable{
	private static final long serialVersionUID = -3477736585282130853L;
	static public List<Autor> autores = new ArrayList<>();
	transient private LocalDateTime ultimaLectura;
	static private RepositorioAutores instance = new RepositorioAutores();
	
	static{
		autores.add(new Autor(1,"Autor 1"));
		autores.add(new Autor(2,"Autor 2"));
		autores.add(new Autor(3,"Autor 3"));
	}
	
	private RepositorioAutores() {
		super();
	}
	
	static public RepositorioAutores getInstance(){
		return instance;
	}

	public List<Autor> getAll(){
		return autores;
	}

	@Override
	public String toString() {
		return "RepositorioAutores [ultimaLectura=" + ultimaLectura + "Lista autores= " + autores + "]";
	}
	
	public void serializacionObject(File fichero) throws FileNotFoundException, IOException{
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(fichero)
				));
		out.writeObject(this);
		out.close();
	}
	
	public void deserializacionObject(File fichero) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(fichero)
				));
		RepositorioAutores repositorio = (RepositorioAutores) in.readObject();
		
		in.close();
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.defaultWriteObject(); //Hace la serialización por defecto
		out.writeObject(autores);
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException{
		in.defaultReadObject();
		autores = (List<Autor>) in.readObject();
		instance.ultimaLectura = LocalDateTime.now();
	}
	
	
}
