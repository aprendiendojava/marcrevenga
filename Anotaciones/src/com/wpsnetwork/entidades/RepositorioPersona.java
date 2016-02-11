package com.wpsnetwork.entidades;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.wpsnetwork.anotaciones.ValidarPersona;

public class RepositorioPersona {
	private List<Persona> personas = new ArrayList<>();
	
	public void add(Persona persona){
		if(!validaPersona(persona))
			throw new RuntimeException("La persona no cumple las condiciones");
		
		personas.add(persona);	//Si todo va bien
	}
	
	private boolean validaPersona(Persona persona){
		boolean resultado = true;
		
		Class metadato = Persona.class;
//		ValidarPersona anotacion = (ValidarPersona) metadato.getAnnotation(ValidarPersona.class);
//		
//		if(anotacion == null)
//			return false;			//No cumplimos las restricciones, tiene que haber la anotación
//		else
//			resultado = validacion(anotacion, metadato, persona);
		
		//Para varias anotaciones
		ValidarPersona[] anotaciones = (ValidarPersona[]) metadato.getAnnotationsByType(ValidarPersona.class);
		
		if(anotaciones.length == 0)
			resultado = false;
		else{
			for(ValidarPersona a : anotaciones)
				if((resultado != false) && (!validacion(a, metadato, persona)))
					resultado = false;
		}
		
		return resultado;
	}
	
	private boolean validacion(ValidarPersona anotacion, Class metadato, Persona persona){
		boolean resultado = true;
		
		int min = anotacion.minCodigo();
		int max = anotacion.maxCodigo();
		
		try {
			
			int codigo = (int) metadato.getMethod("getCodigo").invoke(persona);
			
			if((codigo < min) || (codigo>max))
				resultado = false;
			else{
				String patron = anotacion.patronNombre();
				String nombre = (String) metadato.getMethod("getNombre").invoke(persona);
				
				if(!Pattern.compile(patron).matcher(nombre).find()){
					resultado = false;
				}
			}
			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
}









