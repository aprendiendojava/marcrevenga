package com.wpsnetwork.consola;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.prefs.Preferences;

public class Main {

	public static void main(String[] args) {
		//Propiedades del sistema
		System.out.println(System.getProperties()
								  .toString()
								  .replace(",", "\n"));
		
		System.out.println(System.getProperty("user.country"));
		System.out.println(System.getProperty("user.language"));
		
		//Finalizar la aplicación
		//System.exit(0);
		
		//Ficheros de propiedades (Archivos de configuración)
		
		Properties configuracion = new Properties();
		try {
			
			configuracion.load(new FileReader("src/com/wpsnetwork/configuracion.properties"));
		
		
		
			System.out.println(configuracion);
			System.out.println(configuracion.getProperty("usuario"));
			
			configuracion.setProperty("idioma", "es");	//Lo guarda en memoria
			
			configuracion.store(new FileWriter("src/com/wpsnetwork/configuracion.properties"), 
								"Comentario del fichero de configuracion");
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Configuraciones de programa
		//==============================
		
		Preferences registroWindowsUsuario = Preferences.userRoot();
					//HKEY_CURRENT_USER/Software/JavaSoft/prefs
					//Solo para este usuario
		registroWindowsUsuario = registroWindowsUsuario.node("com/wpsnetwork/preferencias");
		registroWindowsUsuario.put("usuario", "Manganito");
		
		System.out.println(registroWindowsUsuario.get("usuario", "Valor por defecto si no lo encuentra"));

		Preferences registroWindowsSystema = Preferences.systemRoot();
				//32 bits --> HKEY_LOCAL_MACHINE/SOFTWARE/JavaSoft/Prefs
				//64 bits --> HKEY_LOCAL_MACHINE/SOFTWARE/Wow6432Node/JavaSoft/Prefs
		
		//Obtener la MV de Java
		//======================
		Runtime mv = Runtime.getRuntime();
		
		//Ejecutar una aplicación externa
		try {
			
			Process p = mv.exec("calc.exe");
			p.destroy(); //Finaliza la aplicación ejecutada
			
			System.out.println("Memoria total de la MV: " + mv.totalMemory() + " bytes\n"
								+ "Memoria libre: " + mv.freeMemory() + " bytes");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


















