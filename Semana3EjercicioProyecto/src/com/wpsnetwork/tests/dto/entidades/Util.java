package com.wpsnetwork.tests.dto.entidades;

import static org.junit.Assert.fail;

import java.util.List;

import com.wpsnetwork.dto.entidades.*;


public class Util {

	static public void checkEqualLibro(String mensaje, Libro viejo, Libro nuevo, int nivel){
		nivel--;
		if(nivel != 0){
			if((viejo == null) & (nuevo == null)) return;
			
			if (viejo.getId() != nuevo.getId())
				fail(mensaje);
			if (!viejo.getTitulo().equals(nuevo.getTitulo()))
				fail(mensaje);
			if (viejo.getPaginas() != nuevo.getPaginas())
				fail(mensaje);
			if (!viejo.getEditorial().equals(nuevo.getEditorial()))
				fail(mensaje);
			if (!viejo.getEdicion().equals(nuevo.getEdicion()))
				fail(mensaje);
			checkEqualAutores(mensaje, viejo.getAutores(),nuevo.getAutores(), nivel);
			checkEqualCategorias(mensaje, viejo.getCategorias(),nuevo.getCategorias(), nivel);
			checkEqualPrestamos(mensaje, viejo.getPrestamos(),nuevo.getPrestamos(), nivel);
		}
	}
	
	static public void checkEqualPersona(String mensaje, Persona viejo, Persona nuevo, int nivel){
		nivel--;
		if(nivel != 0){
			if((viejo == null) & (nuevo == null)) return;
			
			if (viejo.getId() != nuevo.getId())
				fail(mensaje);
			if (!viejo.getNombre().equals(nuevo.getNombre()))
				fail(mensaje);
			if (!viejo.getDni().equals(nuevo.getDni()))
				fail(mensaje);
			if (!viejo.getFechaNacimiento().equals(nuevo.getFechaNacimiento()))
				fail(mensaje);
			if (!viejo.getDireccion().equals(nuevo.getDireccion()))
				fail(mensaje);
			if (!viejo.getTelefono().equals(nuevo.getTelefono()))
				fail(mensaje);
			if (!viejo.getPais().equals(nuevo.getPais()))
				fail(mensaje);
			if (!viejo.getProvincia().equals(nuevo.getProvincia()))
				fail(mensaje);
			if (!viejo.getCiudad().equals(nuevo.getCiudad()))
				fail(mensaje);
			if (!viejo.getCodigoPostal().equals(nuevo.getCodigoPostal()))
				fail(mensaje);
			checkEqualPrestamos(mensaje, viejo.getPrestamos(),nuevo.getPrestamos(), nivel);
		}
	}
	
	static public  void checkEqualCategorias(String mensaje, List<Categoria> oldList, List<Categoria> newList, int nivel){
		nivel--;
		if(nivel != 0){
			if(oldList != null && newList!= null){
				if(oldList.size() != newList.size())
					fail(mensaje);
				for(int i=0; i < oldList.size();i++)
					checkEqualCategoria(mensaje, oldList.get(i), newList.get(i), nivel);
			}
		}
	}
	
	public static void checkEqualPrestamos(String mensaje, List<Prestamo> oldList, List<Prestamo> newList, int nivel){
		nivel--;
		if(nivel != 0){
			if(oldList != null && newList!= null){
				if(oldList.size() != newList.size())
					fail(mensaje);
				for(int i=0; i < oldList.size();i++)
					checkEqualPrestamo(mensaje, oldList.get(i), newList.get(i), nivel);
			}
		}
	}
	
	static public void checkEqualCategoria(String mensaje, Categoria viejo, Categoria nuevo, int nivel){
		nivel--;
		if(nivel != 0){
			if((viejo == null) & (nuevo == null)) return;
			
			if (viejo.getId() != nuevo.getId())
				fail(mensaje);
			if (!viejo.getNombre().equals(nuevo.getNombre()))
				fail(mensaje);
			checkEqualLibros(mensaje, viejo.getLibros(), nuevo.getLibros(), nivel);
		}
	}
	
	static public void checkEqualLibros(String mensaje, List<Libro> oldList, List<Libro> newList, int nivel){
		nivel--;
		if(nivel != 0){
			if(oldList != null && newList!= null){
				if(oldList.size() != newList.size())
					fail(mensaje);
				for(int i=0; i < oldList.size();i++)
					checkEqualLibro(mensaje, oldList.get(i), newList.get(i), nivel);
			}
		}
	}
	
	static public  void checkEqualPrestamo(String mensaje, Prestamo viejo, Prestamo nuevo, int nivel){
		nivel--;
		if(nivel != 0){
			if((viejo == null) & (nuevo == null)) return;
	
			if (viejo.getId() != nuevo.getId())
				fail(mensaje);
			if (!viejo.getFechaInicio().equals(nuevo.getFechaInicio()))
				fail(mensaje);
			if (!viejo.getFechaFin().equals(nuevo.getFechaFin()))
				fail(mensaje);
			if (viejo.isDevuelto() != nuevo.isDevuelto())
				fail(mensaje);
			checkEqualLibro(mensaje, viejo.getLibro(), nuevo.getLibro(), nivel);
			checkEqualPersona(mensaje, viejo.getPersona(), nuevo.getPersona(), nivel);
		}
	}
	
	static public void checkEqualAutores(String mensaje,List<Autor> oldList,List<Autor> newList, int nivel){
		nivel--;
		if(nivel != 0){
			if(oldList != null && newList!= null){
				if(oldList.size() != newList.size())
					fail(mensaje);
				for(int i=0; i < oldList.size();i++)
					checkEqualAutor(mensaje, oldList.get(i), newList.get(i), nivel);
			}
		}
	}
	
	static public void checkEqualAutor(String mensaje,Autor viejo,Autor nuevo, int nivel){
		nivel--;
		if(nivel != 0){
			if((viejo == null) & (nuevo == null)) return;
	
			if (viejo.getId() != nuevo.getId())
				fail(mensaje);
			if (!viejo.getNombre().equals(nuevo.getNombre()))
				fail(mensaje);
			checkEqualLibros(mensaje, viejo.getLibros(), nuevo.getLibros(), nivel);
		}
	}
}
