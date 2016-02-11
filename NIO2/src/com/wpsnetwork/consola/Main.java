package com.wpsnetwork.consola;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

	public static void main(String[] args) throws URISyntaxException {
		//Path -> Representa un ruta
		
		Path pathUri = Paths.get(new URI("file:///temp/fichero1.txt"));
		//Path path = Paths.get("c:/temp/fichero1.txt");
		Path path = Paths.get("c:/temp", "fichero1.txt");
		
		
		Path carpeta = Paths.get("c:/temp");
		Path fichero = Paths.get("c:/temp/fichero1.txt");
		
		//Obtiene ruta relativa respecto otro Path
		System.out.println(carpeta.relativize(fichero));
		
		//Obtener la ruta absoluta combinando dos Paths
		carpeta = Paths.get("c:/temp");
		fichero = Paths.get("fichero1.txt");
		
		System.out.println(carpeta.resolve(fichero));
		
		//Para operar con Paths usaremos la clase Files
		try {
		
			//Files.createDirectory(carpeta);					//crea una carpeta
			//Files.createFile(carpeta.resolve(fichero));		//crea un fichero
			
			//Files.copy(carpeta.resolve(fichero), 
//										carpeta.resolve(Paths.get("fichero2.txt")), 
//										StandardCopyOption.REPLACE_EXISTING);
			
			
			//El walk permite crear un stream para navegar por el disco duro
			Files.walk(Paths.get("c:","windows"), FileVisitOption.FOLLOW_LINKS)
				 .filter( f -> Files.isReadable(f) && Files.isDirectory(f))
				 .forEach( f -> System.out.println(f));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}




