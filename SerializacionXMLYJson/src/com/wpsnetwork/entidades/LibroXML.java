package com.wpsnetwork.entidades;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class LibroXML {
	Libro libro;
	
	public LibroXML(int codigo, String titulo, int anho, String autor) {
		libro = new Libro(codigo, titulo, anho, autor);
	}
	
	public void guardarLibro(){
		try(XMLEncoder out = new XMLEncoder(new FileOutputStream("libro.xml"))){
			
			out.writeObject(libro);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Libro leerLibro(){
		try(XMLDecoder in = new XMLDecoder(new FileInputStream("libro.xml"))){
			
			libro = (Libro) in.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return libro;
	}
}
