package com.wpsnetwork.consola;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String s = "Hola";
		
		s = s.toUpperCase();
		
		System.out.println(s);

		StringBuilder buffer = new StringBuilder();	//Crea un StringBuilder vacío
		buffer.append("a");
		buffer.append("b");
		buffer.append("c");
		
		System.out.println(buffer.toString());
		
		//Eliminar todo el contenido
		buffer.delete(0, buffer.length());
		
		for(char i='A'; i<= 'Z'; i++)
			buffer.append(i);
		
		System.out.println(buffer);
		System.out.println(buffer.toString());
		
		String texto = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme ...";
		
		//Buscar donde se encuentra una palabra
		int pos = 0;
		
		while((pos = texto.indexOf(" de ", pos)) != -1){
			System.out.println("Coincidencia encontrada en pos: " + pos);
			pos++;
		}
		
		//Obtener las palabras sueltas
		String[] palabras = texto.split("(\\s+)|(\\p{Punct}+\\s*)");
		
		System.out.println(Arrays.toString(palabras));
		
		StringTokenizer stringToken = new StringTokenizer(texto," .,");	//Por defecto el delimitador
																	 	//  es espacio, tabulador y 
																		//  salto de línea
		while(stringToken.hasMoreTokens())
			System.out.println(stringToken.nextToken());
		
		//Busca cadenas que cumplen con un patrón
		Pattern patron = Pattern.compile("(\\d{8})(\\p{Alpha})");	//Comprueba DNI
		
		String dnis = "12345678A  87654321B";
		Matcher coincidencia = patron.matcher(dnis);	//Este va a buscar las coincidencias
		
		//Si la cadena coincide exactamente con el patrón
//		if(coincidencia.matches())
//			System.out.println("Coincide");
//		else
//			System.out.println("No coincide");
		
		while(coincidencia.find())
			System.out.println(coincidencia.group(2));
		
		
		//La clase Scanner
		//Permite leer textos y extraer tipos primitivos
		
		String csv = "1;Pepito;23;2;Juanito;25";
		Scanner scanner = new Scanner(csv);	//Separa las cosas por unos delimitadores por defecto
											//  que son: espacio y salto línea
		scanner.useDelimiter(";");
		
		while(scanner.hasNext()){
			int id = scanner.nextInt();
			String nombre = scanner.next();
			int edad = scanner.nextInt();
			System.out.println("Id: " + id + " Nombre: " + nombre + "Edad: " + edad);
		}
			
		scanner.close(); //Cierra todos los canales de dentro del scanner
	}

}





















