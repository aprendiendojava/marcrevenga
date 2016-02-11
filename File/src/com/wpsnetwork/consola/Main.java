package com.wpsnetwork.consola;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		//Una carpeta
		File rutaCarpeta = new File("c:/windows");
		
		if(rutaCarpeta.isFile())
			System.out.println("Es un fichero");
		
		if(rutaCarpeta.isDirectory())
			System.out.println("Es una carpeta");

		//Crear una carpeta
		rutaCarpeta = new File("c:/temp");
		boolean creada = rutaCarpeta.mkdir();
		
		//Ejecutar un fichero
		File rutaFichero = new File("c:/windows/notepad.exe");
		
		try {
		
			if(rutaFichero.canExecute())
				Runtime.getRuntime().exec(rutaFichero.getAbsolutePath());
		
			//Crear un fichero
			rutaFichero = new File("c:/temp/fichero1.txt");
			if(!rutaFichero.exists())
				rutaFichero.createNewFile();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
