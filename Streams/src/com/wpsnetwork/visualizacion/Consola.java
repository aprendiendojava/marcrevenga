package com.wpsnetwork.visualizacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.wpsnetwork.entidades.Persona;

public class Consola {

	public static void main(String[] args) {
		List<String> listaNombres = new ArrayList<>();
		
		listaNombres.add("Pedro");
		listaNombres.add("Juan");
		listaNombres.add("María");
		listaNombres.add("José");
		listaNombres.add("Marta");
		listaNombres.add("Juan");
		
		List<String> resultado = new ArrayList<>();
		//Obtener la lista de nombres, sin repetidos, que tengan más de 3 letras.
		//El resultado tiene que estar ordenado.
//		for(String n : listaNombres){		//Ponemos en el resultado los mayores de 3 letras
//			if((n.length() > 3) && (!resultado.contains(n))) 
//				resultado.add(n);
//		}
//		
//		resultado.sort(new Comparator<String>() {	//Ordeno
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});
		
		String[] nombres = listaNombres.stream()
					.sorted()		//Ordena por el método compare() de la clase
					.distinct()		//Elimina repetidos
					.filter(e -> e.length() > 3)
					.toArray(len -> new String[len]);
		
		System.out.println(Arrays.toString(nombres));
		
//		//Obtener un array con las longitudes de los nombres
//		int[] longitudes = listaNombres.stream()
//									   .mapToInt( e->e.length() )
//									   .toArray();
//		
//		System.out.println(Arrays.toString(longitudes));
		
		//Obtener un array con las longitudes de los nombres
				int[] longitudes = listaNombres.stream()
											   .mapToInt( String::length )
											   .toArray();
				
				System.out.println(Arrays.toString(longitudes));
				
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Pedro", 50));
		personas.add(new Persona("Pedro2", 50));
		personas.add(new Persona("Juan", 49));
		personas.add(new Persona("Marta", 30));
		personas.add(new Persona("Luis", 30));
		personas.add(new Persona("María", 26));
		
		//Obtener el nombre de la persona más mayor
//		SELECT nombre FROM personas WHERE edad = (SELECT max(edad) FROM personas);
		
		String nombre = personas.stream()
								//Si hay repetidos se queda con el primero que encuentre
								.max( (e1, e2) -> Integer.compare(e1.getEdad(), e2.getEdad()))
								.get()		//Devuelve la persona
								.getNombre();
		
		System.out.println(nombre);
		
		//Obtener los nombres de las personas ordenadas
		String[] n2 = personas.stream()		
						      .map( Persona::getNombre )	//Convierte de Persona a String
						      .sorted()						//Ordena Strings
						      .toArray(len->new String[len]);
		
		System.out.println(Arrays.toString(n2));
		
		//Queremos las medias de las edades
		double media = personas.stream()
							   .mapToInt(Persona::getEdad)	//Convierte de Persona a int
							   .average()					//Media
							   .getAsDouble();				//Obtiene el valor double
		
		System.out.println("Media: " + media);
		
		//Queremos sumatorio de las edades
		int suma = personas.stream()
						   .mapToInt(Persona::getEdad)	//Convierte de Persona a int
						   .sum();						//Sumatorio
						   
				
		System.out.println("Sumatorio: " + suma);
		
		int sumaEdad = personas.stream()
								.reduce(new Persona("", 0), (acc, e)-> {
											acc.setEdad(acc.getEdad() + e.getEdad());
											return acc;
										})
								.getEdad();
								
		System.out.println(sumaEdad);
		
		//Agrupar por edades
		Map<Integer, List<Persona>> mapa = personas.stream()
												   .collect(Collectors.groupingBy(Persona::getEdad));
				
		for(int edad: mapa.keySet()){
			System.out.println("Edad : " + edad);
			for(Persona p : mapa.get(edad)){
				System.out.println("	Nombre: " + p.getNombre());
			}
		}
		
		//Crear dos grupos. Uno para personas de edad > 30 y otro para edad <=30
		Map<Boolean, List<Persona>> mapa2 = personas.stream()
													.collect(Collectors.partitioningBy(p->p.getEdad()<=30));
		
		for(boolean cond: mapa2.keySet()){
			System.out.println("Condición : " + cond);
			for(Persona p : mapa2.get(cond)){
				System.out.println("	Nombre: " + p.getNombre());
			}
		}
		
		//Obtener todos los nombres de personas en único String
		String nombresPersonas = personas.stream()
								 		 .map(Persona::getNombre)
								 		 .collect(Collectors.joining("-"));
		
		System.out.println(nombresPersonas);
	}

}

















