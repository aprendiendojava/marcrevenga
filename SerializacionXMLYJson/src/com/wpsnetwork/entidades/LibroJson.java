package com.wpsnetwork.entidades;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LibroJson {
	Libro libro;
	
	public LibroJson(int codigo, String titulo, int anho, String autor) {
		libro = new Libro(codigo, titulo, anho, autor);
	}
	
	public void guardarLibro(){
		try(FileOutputStream out = new FileOutputStream("libro.json")){
			
			ObjectMapper codificador = new ObjectMapper();
			codificador.writeValue(out, libro);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Libro leerLibro(){
		try(FileInputStream in = new FileInputStream("libro.json")){
			
			ObjectMapper codificador = new ObjectMapper();
			libro = codificador.readValue(in, Libro.class);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return libro;
	}
}
