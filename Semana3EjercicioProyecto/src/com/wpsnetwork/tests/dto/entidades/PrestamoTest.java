package com.wpsnetwork.tests.dto.entidades;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dto.entidades.*;
import com.wpsnetwork.tests.AllTests;

public class PrestamoTest {
	private Prestamo prestamoDto;
	
	@Before
	public void setUp() throws Exception {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libro = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libro);
		autores.add(autor);
		librosCategoria.add(libro);
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
		prestamoDto = new Prestamo(1, 
				LocalDate.now(), 
				LocalDate.now().plusMonths(1), 
				false, 
				libro, 
				persona1,
				AllTests.tipoAcceso);
		
		prestamos.add(prestamoDto);
		
		autor.setLibros(libros);
		libro.setAutores(autores);
		libro.setCategorias(categorias);
		libro.setPrestamos(prestamos);
	}

	@Test
	public void testGetId() {
		if(prestamoDto.getId() != 1)
			fail("El Get del id no va bien");
	}

	@Test
	public void testSetId() {
		prestamoDto.setId(10);
		if(prestamoDto.getId() != 10)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetFechaInicio() {
		if(!prestamoDto.getFechaInicio().equals(LocalDate.now()))
			fail("El Get de la fecha de inicio no va bien");
	}

	@Test
	public void testSetFechaInicio() {
		prestamoDto.setFechaInicio(LocalDate.of(1999, Month.JANUARY, 1));
		if(!prestamoDto.getFechaInicio().equals(LocalDate.of(1999, Month.JANUARY, 1)))
			fail("El Set de la fecha de inicio no va bien");
	}

	@Test
	public void testGetFechaFin() {
		if(!prestamoDto.getFechaFin().equals(LocalDate.now().plusMonths(1)))
			fail("El Get de la fecha de fin no va bien");
	}

	@Test
	public void testSetFechaFin() {
		prestamoDto.setFechaFin(LocalDate.of(1999, Month.JANUARY, 1));
		if(!prestamoDto.getFechaFin().equals(LocalDate.of(1999, Month.JANUARY, 1)))
			fail("El Set de la fecha de fin no va bien");
	}

	@Test
	public void testIsDevuelto() {
		if(!prestamoDto.isDevuelto() == false)
			fail("El Get de devuelto no va bien");
	}

	@Test
	public void testSetDevuelto() {
		prestamoDto.setDevuelto(true);
		if(!prestamoDto.isDevuelto() == true)
			fail("El Set de devuelto no va bien");
	}

	@Test
	public void testGetLibro() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libro = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libro);
		autores.add(autor);
		librosCategoria.add(libro);
		categorias.add(new Categoria(1, "Categoria1", librosCategoria,AllTests.tipoAcceso));
		
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
		prestamoDto = new Prestamo(1, 
				LocalDate.now(), 
				LocalDate.now().plusMonths(1), 
				false, 
				libro, 
				persona1,
				AllTests.tipoAcceso);
		
		prestamos.add(prestamoDto);
		
		autor.setLibros(libros);
		libro.setAutores(autores);
		libro.setCategorias(categorias);
		libro.setPrestamos(prestamos);
		
		Util.checkEqualLibro("El Get del libro no va bien", prestamoDto.getLibro(), libro, AllTests.nivelDto);
	}

	@Test
	public void testSetLibro() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libro = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libro);
		autores.add(autor);
		librosCategoria.add(libro);
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
		prestamoDto = new Prestamo(1, 
				LocalDate.now(), 
				LocalDate.now().plusMonths(1), 
				false, 
				libro, 
				persona1,
				AllTests.tipoAcceso);
		
		prestamos.add(prestamoDto);
		
		autor.setLibros(libros);
		libro.setAutores(autores);
		libro.setCategorias(categorias);
		libro.setPrestamos(prestamos);
		
		prestamoDto.setLibro(libro);

		Util.checkEqualLibro("El Set del libro no va bien", prestamoDto.getLibro(), libro, AllTests.nivelDto);
	}

	@Test
	public void testGetPersona() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null,AllTests.tipoAcceso);
		
		Libro libro = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libro);
		autores.add(autor);
		librosCategoria.add(libro);
		categorias.add(new Categoria(1, "Categoria1", librosCategoria, AllTests.tipoAcceso));
		
		Persona persona = new Persona(1, 
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
		Prestamo prestamoDto2 = new Prestamo(1, 
				LocalDate.now(), 
				LocalDate.now().plusMonths(1), 
				false, 
				libro, 
				persona,
				AllTests.tipoAcceso);
		
		prestamos.add(prestamoDto2);
		
		autor.setLibros(libros);
		libro.setAutores(autores);
		libro.setCategorias(categorias);
		libro.setPrestamos(prestamos);
		
		Util.checkEqualPersona("El Get de la persona no va bien", prestamoDto.getPersona(), persona, AllTests.nivelDto);
	}

	@Test
	public void testSetPersona() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libro = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libro);
		autores.add(autor);
		librosCategoria.add(libro);
		categorias.add(new Categoria(1, "Categoria1", librosCategoria, AllTests.tipoAcceso));
		
		Persona persona = new Persona(2, 
										"Persona2", 
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
		Prestamo prestamoDto2 = new Prestamo(1, 
				LocalDate.now(), 
				LocalDate.now().plusMonths(1), 
				false, 
				libro, 
				persona,
				AllTests.tipoAcceso);
		
		prestamos.add(prestamoDto2);
		
		autor.setLibros(libros);
		libro.setAutores(autores);
		libro.setCategorias(categorias);
		libro.setPrestamos(prestamos);
		
		prestamoDto.setPersona(persona);
		
		Util.checkEqualPersona("El Get de la persona no va bien", prestamoDto.getPersona(), persona, AllTests.nivelDto);
	}

}
