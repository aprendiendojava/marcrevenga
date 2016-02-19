package com.wpsnetwork.tests.dto.entidades;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dto.entidades.*;
import com.wpsnetwork.tests.AllTests;

public class AutorTest {
	private Autor autorDto;
	
	@Before
	public void antesTest(){
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		autorDto = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libro1 = new Libro(1, 
								"Titulo 1", 
								1, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libro1);
		autores.add(autorDto);
		librosCategoria.add(libro1);
		categorias.add(new Categoria(1, "Categoria1", librosCategoria, AllTests.tipoAcceso));
		
		Persona persona1 = new Persona(1, 
										"Persona1", 
										"DNI1", 
										LocalDate.now(), 
										"DIR1", 
										"TEL1", 
										"PAIS1", 
										"PROV1", 
										"CIU1", 
										"CP1", 
										prestamos,
										AllTests.tipoAcceso);
		prestamos.add(new Prestamo(1, 
								LocalDate.now(), 
								LocalDate.now().plusMonths(1), 
								false, 
								libro1, 
								persona1,
								AllTests.tipoAcceso));
		
		autorDto.setLibros(libros);
		libro1.setAutores(autores);
		libro1.setCategorias(categorias);
		libro1.setPrestamos(prestamos);
	}

	@Test
	public void testGetId() {
		if(autorDto.getId() != 1)
			fail("El Get del id no va bien");
	}

	@Test
	public void testSetId() {
		autorDto.setId(2);
		if(autorDto.getId() != 2)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetNombre() {
		if(!autorDto.getNombre().equals("A"))
			fail("El Get del nombre no va bien");
	}

	@Test
	public void testSetNombre() {
		autorDto.setNombre("B");
		if(!autorDto.getNombre().equals("B"))
			fail("El Set del nombre no va bien");
	}
	
	@Test
	public void testGetLibros() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autorDto2 = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libro1 = new Libro(1, 
								"Titulo 1", 
								1, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libro1);
		autores.add(autorDto2);
		librosCategoria.add(libro1);
		categorias.add(new Categoria(1, "Categoria1", librosCategoria, AllTests.tipoAcceso));
		
		Persona persona1 = new Persona(1, 
										"Persona1", 
										"DNI1", 
										LocalDate.now(), 
										"DIR1", 
										"TEL1", 
										"PAIS1", 
										"PROV1", 
										"CIU1", 
										"CP1", 
										prestamos,
										AllTests.tipoAcceso);
		prestamos.add(new Prestamo(1, 
								LocalDate.now(), 
								LocalDate.now().plusMonths(1), 
								false, 
								libro1, 
								persona1,
								AllTests.tipoAcceso));
		
		autorDto2.setLibros(libros);
		libro1.setAutores(autores);
		libro1.setCategorias(categorias);
		libro1.setPrestamos(prestamos);
		
		Util.checkEqualLibros("El Get de los libros no va bien", 
				autorDto2.getLibros(),libros, AllTests.nivelDto);
	}

	@Test
	public void testSetLibros() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autorDto2 = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libro1 = new Libro(2, 
								"Titulo 1", 
								1, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libro1);
		autores.add(autorDto2);
		librosCategoria.add(libro1);
		categorias.add(new Categoria(1, "Categoria1", librosCategoria, AllTests.tipoAcceso));
		
		Persona persona1 = new Persona(1, 
										"Persona1", 
										"DNI1", 
										LocalDate.now(), 
										"DIR1", 
										"TEL1", 
										"PAIS1", 
										"PROV1", 
										"CIU1", 
										"CP1", 
										prestamos,
										AllTests.tipoAcceso);
		prestamos.add(new Prestamo(1, 
								LocalDate.now(), 
								LocalDate.now().plusMonths(1), 
								false, 
								libro1, 
								persona1,
								AllTests.tipoAcceso));
		
		autorDto2.setLibros(libros);
		libro1.setAutores(autores);
		libro1.setCategorias(categorias);
		libro1.setPrestamos(prestamos);
		
		autorDto.setLibros(libros);
		
		Util.checkEqualLibros("El Set de los libros no va bien", 
				autorDto2.getLibros(),libros, AllTests.nivelDto);
	}

}
