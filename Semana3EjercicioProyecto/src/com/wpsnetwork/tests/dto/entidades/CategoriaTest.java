package com.wpsnetwork.tests.dto.entidades;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dto.entidades.*;
import com.wpsnetwork.tests.AllTests;

public class CategoriaTest {
	private Categoria categoriaDto;
	
	@Before
	public void setUp() throws Exception {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
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
		autores.add(autor);
		librosCategoria.add(libro1);
		
		categoriaDto = new Categoria(1, "Categoria1", librosCategoria, AllTests.tipoAcceso);
		
		categorias.add(categoriaDto);
		
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
		
		autor.setLibros(libros);
		libro1.setAutores(autores);
		libro1.setCategorias(categorias);
		libro1.setPrestamos(prestamos);
	}

	@Test
	public void testGetId() {
		if(categoriaDto.getId() != 1)
			fail("El Get del id no va bien");
	}

	@Test
	public void testSetId() {
		categoriaDto.setId(2);
		if(categoriaDto.getId() != 2)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetNombre() {
		if(!categoriaDto.getNombre().equals("Categoria1"))
			fail("El Get del nombre no va bien");
	}

	@Test
	public void testSetNombre() {
		categoriaDto.setNombre("B");
		if(!categoriaDto.getNombre().equals("B"))
			fail("El Set del nombre no va bien");
	}
	@Test
	public void testGetLibros() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
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
		autores.add(autor);
		librosCategoria.add(libro1);
		
		Categoria categoriaDto2 = new Categoria(1, "Categoria1", librosCategoria,AllTests.tipoAcceso);
		
		categorias.add(categoriaDto2);
		
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
		
		autor.setLibros(libros);
		libro1.setAutores(autores);
		libro1.setCategorias(categorias);
		libro1.setPrestamos(prestamos);
				
		Util.checkEqualLibros("El Get de los libros no va bien", 
				categoriaDto.getLibros(),librosCategoria, AllTests.nivelDto);
	}

	@Test
	public void testSetLibros() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
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
		autores.add(autor);
		librosCategoria.add(libro1);
		
		Categoria categoriaDto2 = new Categoria(1, "Categoria1", librosCategoria, AllTests.tipoAcceso);
		
		categorias.add(categoriaDto2);
		
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
		
		autor.setLibros(libros);
		libro1.setAutores(autores);
		libro1.setCategorias(categorias);
		libro1.setPrestamos(prestamos);
		
		categoriaDto.setLibros(librosCategoria);
		
		Util.checkEqualLibros("El Set de los libros no va bien", 
				categoriaDto.getLibros(),librosCategoria, AllTests.nivelDto);
	}

}