package com.wpsnetwork;

import com.wpsnetwork.entidades.LibroJson;
import com.wpsnetwork.entidades.LibroXML;

public class Main {

	public static void main(String[] args) {
		LibroXML libro1 = new LibroXML(1, "Titulo 1", 2000, "Autor 1");
		
		libro1.guardarLibro();
		
		System.out.println(libro1.leerLibro());
		
		LibroJson libro2 = new LibroJson(2, "Titulo 2", 4000, "Autor 2");
		
		libro2.guardarLibro();
		
		System.out.println(libro2.leerLibro());

	}

}
