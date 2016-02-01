package com.wpsnetwork.consola;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(2.0); 	//Si mostramos un número, es sin formato de idioma

		//Leer con formato en función del idioma
		Scanner scanner = new Scanner("83,25");		//Lee bien
		System.out.println(scanner.nextDouble());
		
		Scanner scannerIngles = new Scanner("22.44");
		scannerIngles.useLocale(Locale.ENGLISH);				//Especificamos el idioma del Scanner
		System.out.println(scannerIngles.nextDouble());
		
		//Leemos el idioma de un fichero de propiedades
		Properties propiedades = new Properties();
		
		try {
			
			propiedades.load(new FileReader("src/aplicacion.properties"));
			
			Locale.setDefault(new Locale(propiedades.getProperty("idioma"),	//Cambiamos el idioma MV
										propiedades.getProperty("pais")));
			
			ResourceBundle recursos = PropertyResourceBundle.getBundle("textos/internacionalizacion");
			
			System.out.println(recursos.getString("texto1"));
			System.out.println(recursos.getString("texto2"));
			System.out.println(recursos.getString("texto3"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Mostrar números con formato de idioma
		System.out.printf("%.2f\n", 2.3);
		
		String valor = String.format("%.2f", 5.67);
		System.out.println(valor);
		
		
	}

}












