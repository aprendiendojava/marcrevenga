package com.wpsnetwork.consola;

import java.io.*;
import java.nio.file.*;

import com.wpsnetwork.entidades.Autor;
import com.wpsnetwork.entidades.RepositorioAutores;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Autor a1 = new Autor(1,"Pepito");

		Path fichero = Paths.get("fichero.ser");
//		ObjectOutputStream out = new ObjectOutputStream(
//										new BufferedOutputStream(
//												new FileOutputStream(fichero.toFile())
//										));
//		out.writeObject(a1);
//		out.close();
//		
//		ObjectInputStream in = new ObjectInputStream(
//										new BufferedInputStream(
//												new FileInputStream(fichero.toFile())
//										));
//		a1 = (Autor) in.readObject();
//		in.close();
//		
//		System.out.println(a1);
		
		//Serializar un objeto complejo
		RepositorioAutores.getInstance().serializacionObject(fichero.toFile());
		RepositorioAutores.getInstance().deserializacionObject(fichero.toFile());
		
		System.out.println(RepositorioAutores.getInstance());
	}

}










