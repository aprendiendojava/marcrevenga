package com.wpsnetwork.dto.entidades;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wpsnetwork.dao.factorias.FactoriaDao;
import com.wpsnetwork.dao.interfaces.*;
import com.wpsnetwork.dto.entidades.*;

public class Util {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Util.class.getName());
	
	static public Autor getAutor(com.wpsnetwork.dao.entidades.Autor autorDao, String tipoAcceso){
		Autor autorDto = new Autor(autorDao.getId(), 
									autorDao.getNombre(), 
									null, 
									tipoAcceso);
		
		return autorDto;
	}
	
	static private Libro getLibro(com.wpsnetwork.dao.entidades.Libro libroDao, String tipoAcceso){
		
		Libro libroDto = new Libro(libroDao.getId(), 
									libroDao.getTitulo(), 
									libroDao.getPaginas(),
									libroDao.getEditorial(),
									libroDao.getEdicion(), 
									null, 
									null, 
									null,
									tipoAcceso);
		
		return libroDto;
	}
	
	static public Categoria getCategoria(com.wpsnetwork.dao.entidades.Categoria categoriaDao, String tipoAcceso){
		
		Categoria categoriaDto = new Categoria(categoriaDao.getId(), 
												categoriaDao.getNombre(), 
												null,
												tipoAcceso);
		
		return categoriaDto;
	}
	
	static private Prestamo getPrestamo(com.wpsnetwork.dao.entidades.Prestamo prestamoDao, String tipoAcceso){
		
		Prestamo prestamoDto = new Prestamo(prestamoDao.getId(), 
											prestamoDao.getFechaInicio(), 
											prestamoDao.getFechaFin(), 
											prestamoDao.isDevuelto(), 
											null, 
											null,
											tipoAcceso);
		
		return prestamoDto;
	}
	
	static private Persona getPersona(com.wpsnetwork.dao.entidades.Persona personaDao, String tipoAcceso){
		
		Persona personaDto = new Persona(personaDao.getId(), 
										personaDao.getNombre(), 
										personaDao.getDni(), 
										personaDao.getFechaNacimiento(), 
										personaDao.getDireccion(), 
										personaDao.getTelefono(), 
										personaDao.getPais(), 
										personaDao.getProvincia(), 
										personaDao.getCiudad(), 
										personaDao.getCodigoPostal(), 
										null,
										tipoAcceso);
		
		return personaDto;
	}

	static private List<Libro> getLibros(List<com.wpsnetwork.dao.entidades.Libro> librosDao, String tipoAcceso){
		List<Libro> librosDto = new ArrayList<>();
		
		for(com.wpsnetwork.dao.entidades.Libro libroDao : librosDao)
			librosDto.add(getLibro(libroDao, tipoAcceso));
		
		return librosDto;
	}
	
	static private List<Autor> getAutores(List<com.wpsnetwork.dao.entidades.Autor> autoresDao, String tipoAcceso){
		List<Autor> autoresDto = new ArrayList<>();
		
		for(com.wpsnetwork.dao.entidades.Autor autorDao : autoresDao){
			autoresDto.add(getAutor(autorDao, tipoAcceso));
		}
		
		return autoresDto;
	}
	
	static private List<Categoria> getCategorias(List<com.wpsnetwork.dao.entidades.Categoria> categoriasDao, String tipoAcceso){
		List<Categoria> categoriasDto = new ArrayList<>();
		
		for(com.wpsnetwork.dao.entidades.Categoria categoriaDao : categoriasDao){
			categoriasDto.add(getCategoria(categoriaDao, tipoAcceso));
		}
		
		return categoriasDto;
	}
	
	static private List<Prestamo> getPrestamos(List<com.wpsnetwork.dao.entidades.Prestamo> prestamosDao, String tipoAcceso){
		List<Prestamo> prestamosDto = new ArrayList<>();
		
		for(com.wpsnetwork.dao.entidades.Prestamo prestamoDao : prestamosDao){
			prestamosDto.add(getPrestamo(prestamoDao, tipoAcceso));
		}
		
		return prestamosDto;
	}
	
	static public List<Libro> getLibrosAutor(com.wpsnetwork.dao.entidades.Autor autorDao, String tipoAcceso){
		
			DaoLibros librosDao = (DaoLibros) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.LIBROS);
			DaoLibrosAutores LibrosAutoresDao = (DaoLibrosAutores) FactoriaDao.getDao(tipoAcceso, 
							FactoriaDao.TIPO_REPOSITORIO.LIBROS_AUTORES);
			
			List<com.wpsnetwork.dao.entidades.LibroAutor> listaLibrosAutores = 
					LibrosAutoresDao.getAll()
									.parallelStream()
									.filter(la -> la.getAutor() == autorDao.getId())
									.collect(Collectors.toList());
			
			List<com.wpsnetwork.dao.entidades.Libro> listaLibros = new ArrayList<>();
			
			for(com.wpsnetwork.dao.entidades.LibroAutor librosAutores : listaLibrosAutores)
				listaLibros.add(librosDao.get(librosAutores.getLibro()));
			
			return getLibros(listaLibros, tipoAcceso);
	}
	
	static public List<Libro> getLibrosCategoria(com.wpsnetwork.dao.entidades.Categoria categoriaDao, String tipoAcceso){
		DaoLibros librosDao = (DaoLibros) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.LIBROS);
		DaoCategoriasLibros categoriasLibrosDao = (DaoCategoriasLibros) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.CATEGORIAS_LIBROS);
		
		List<com.wpsnetwork.dao.entidades.CategoriaLibro> listaCategoriasLibros = 
				categoriasLibrosDao.getAll()
								.parallelStream()
								.filter(ca -> ca.getCategoria() == categoriaDao.getId())
								.collect(Collectors.toList());
		
		List<com.wpsnetwork.dao.entidades.Libro> listaLibros = new ArrayList<>();
		
		for(com.wpsnetwork.dao.entidades.CategoriaLibro categoriaLibro : listaCategoriasLibros)
			listaLibros.add(librosDao.get(categoriaLibro.getLibro()));
		
		return getLibros(listaLibros, tipoAcceso);
	}
	
	static public List<Autor> getAutoresLibro(com.wpsnetwork.dao.entidades.Libro libroDao, String tipoAcceso){
		DaoAutores autoresDao = (DaoAutores) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.AUTORES);
		DaoLibrosAutores librosAutoresDao = (DaoLibrosAutores) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.LIBROS_AUTORES);
		
		List<com.wpsnetwork.dao.entidades.LibroAutor> listaLibrosAutores = 
				librosAutoresDao.getAll()
								.parallelStream()
								.filter(la -> la.getLibro() == libroDao.getId())
								.collect(Collectors.toList());
		
		List<com.wpsnetwork.dao.entidades.Autor> listaAutores = new ArrayList<>();
		
		for(com.wpsnetwork.dao.entidades.LibroAutor librosAutores : listaLibrosAutores)
			listaAutores.add(autoresDao.get(librosAutores.getAutor()));
				
		return getAutores(listaAutores,tipoAcceso);
	}
	
	static public List<Categoria> getCategoriasLibro(com.wpsnetwork.dao.entidades.Libro libroDao, String tipoAcceso){
		DaoCategoriasLibros categoriasLibrosDao = (DaoCategoriasLibros) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.CATEGORIAS_LIBROS);
		DaoCategorias categoriasDao = (DaoCategorias) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.CATEGORIAS);
		
		List<com.wpsnetwork.dao.entidades.CategoriaLibro> listaCategoriasLibros = 
				categoriasLibrosDao.getAll()
								.parallelStream()
								.filter(cl -> cl.getLibro() == libroDao.getId())
								.collect(Collectors.toList());
		
		List<com.wpsnetwork.dao.entidades.Categoria> listaCategorias = new ArrayList<>();
		
		for(com.wpsnetwork.dao.entidades.CategoriaLibro categoriasLibro : listaCategoriasLibros)
			listaCategorias.add(categoriasDao.get(categoriasLibro.getCategoria()));
		
		return getCategorias(listaCategorias, tipoAcceso);
	}
	
	static public List<Prestamo> getPrestamosLibro(com.wpsnetwork.dao.entidades.Libro libroDao, String tipoAcceso){
		DaoPrestamos prestamosDao = (DaoPrestamos) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.PRESTAMOS);
		
		List<com.wpsnetwork.dao.entidades.Prestamo> listaPrestamosDao = prestamosDao.getAll()
												.parallelStream()
												.filter(p -> p.getLibro() == libroDao.getId())
												.collect(Collectors.toList());
		
		return getPrestamos(listaPrestamosDao, tipoAcceso);
	}
	
	static public List<Prestamo> getPrestamosPersona(com.wpsnetwork.dao.entidades.Persona personaDao, String tipoAcceso){
		DaoPrestamos prestamosDao = (DaoPrestamos) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.PRESTAMOS);
		
		List<com.wpsnetwork.dao.entidades.Prestamo> listaPrestamosDao = prestamosDao.getAll()
												.parallelStream()
												.filter(p -> p.getPersona() == personaDao.getId())
												.collect(Collectors.toList());
		
		return getPrestamos(listaPrestamosDao, tipoAcceso);
	}
	
	static public Libro getLibroPrestamo(com.wpsnetwork.dao.entidades.Prestamo prestamoDao, String tipoAcceso){
		DaoLibros librosDao = (DaoLibros) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.LIBROS);
		
		com.wpsnetwork.dao.entidades.Libro libroDaoPrestamo = 
				librosDao.getAll().parallelStream()
									 .filter(l -> l.getId() == prestamoDao.getLibro())
									 .findFirst()
									 .orElse(null);
		
		return getLibro(libroDaoPrestamo,tipoAcceso);
	}
	
	static public Persona getPersonaPrestamo(com.wpsnetwork.dao.entidades.Prestamo prestamoDao, String tipoAcceso){
		DaoPersonas personasDao = (DaoPersonas) FactoriaDao.getDao(tipoAcceso, 
				FactoriaDao.TIPO_REPOSITORIO.PERSONAS);
		
		com.wpsnetwork.dao.entidades.Persona personaDaoPrestamo = 
				personasDao.getAll().parallelStream()
									 .filter(p -> p.getId() == prestamoDao.getPersona())
									 .findFirst()
									 .orElse(null);
		
		return getPersona(personaDaoPrestamo, tipoAcceso);
	}
}
