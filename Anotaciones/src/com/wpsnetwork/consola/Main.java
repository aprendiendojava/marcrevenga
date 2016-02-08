package com.wpsnetwork.consola;

import java.lang.reflect.Field;

import com.wpsnetwork.anotaciones.Descripcion;
import com.wpsnetwork.entidades.Persona;
import com.wpsnetwork.entidades.RepositorioPersona;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Class metadato = Persona.class;
		Field codigo = metadato.getDeclaredField("codigo");
		
		//Accedemos a las anotaciones de la propiedad privada
		Descripcion anotacion = codigo.getAnnotation(Descripcion.class);
		
		//Contenido de la propiedad value de la anotación
		System.out.println(anotacion.value());
		
		Persona p = new Persona(8, "Pepito");
		RepositorioPersona repositorio = new RepositorioPersona();
		
		repositorio.add(p);
	}

}
