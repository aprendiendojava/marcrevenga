package com.wpsnetwork.tests.dto.entidades;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dto.entidades.*;
import com.wpsnetwork.tests.AllTests;

public class LibroTest {
	private Libro libroDto;
	
	@Before
	public void setUp() throws Exception {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		libroDto = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libroDto);
		autores.add(autor);
		librosCategoria.add(libroDto);
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
								libroDto, 
								persona1,
								AllTests.tipoAcceso));
		
		autor.setLibros(libros);
		libroDto.setAutores(autores);
		libroDto.setCategorias(categorias);
		libroDto.setPrestamos(prestamos);
	}

	@Test
	public void testGetId() {
		if(libroDto.getId() != 1)
			fail("El Get del id no va bien");
	}

	@Test
	public void testSetId() {
		libroDto.setId(10);
		if(libroDto.getId() != 10)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetTitulo() {
		if(!libroDto.getTitulo().equals("Titulo 1"))
			fail("El Get del título no va bien");
	}

	@Test
	public void testSetTitulo() {
		libroDto.setTitulo("B");
		if(!libroDto.getTitulo().equals("B"))
			fail("El Set del título no va bien");
	}

	@Test
	public void testGetPaginas() {
		if(libroDto.getPaginas() != 100)
			fail("El Get de las páginas no va bien");
	}

	@Test
	public void testSetPaginas() {
		libroDto.setPaginas(10);
		if(libroDto.getPaginas() != 10)
			fail("El Set de las páginas no va bien");
	}

	@Test
	public void testGetEditorial() {
		if(!libroDto.getEditorial().equals("Ed1"))
			fail("El Get de la editorial no va bien");
	}

	@Test
	public void testSetEditorial() {
		libroDto.setEditorial("A");
		if(!libroDto.getEditorial().equals("A"))
			fail("El Set de la editorial no va bien");
	}

	@Test
	public void testGetEdicion() {
		if(!libroDto.getEdicion().equals("Edicion1"))
			fail("El Get de la edición no va bien");
	}

	@Test
	public void testSetEdicion() {
		libroDto.setEdicion("A");
		if(!libroDto.getEdicion().equals("A"))
			fail("El Set de la edición no va bien");
	}
	@Test
	public void testGetAutores() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libroDto2 = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libroDto2);
		autores.add(autor);
		librosCategoria.add(libroDto2);
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
								libroDto2, 
								persona1,
								AllTests.tipoAcceso));
		
		autor.setLibros(libros);
		libroDto2.setAutores(autores);
		libroDto2.setCategorias(categorias);
		libroDto2.setPrestamos(prestamos);
		
		Util.checkEqualAutores("El Get de los autores no va bien", libroDto.getAutores(), autores, AllTests.nivelDto);
	}

	@Test
	public void testSetAutores() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(2, "B", null, AllTests.tipoAcceso);
		
		Libro libroDto2 = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libroDto2);
		autores.add(autor);
		librosCategoria.add(libroDto2);
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
								libroDto2, 
								persona1,
								AllTests.tipoAcceso));
		
		autor.setLibros(libros);
		libroDto2.setAutores(autores);
		libroDto2.setCategorias(categorias);
		libroDto2.setPrestamos(prestamos);
		
		libroDto.setAutores(autores);
		
		Util.checkEqualAutores("El Set de los autores no va bien", libroDto.getAutores(), autores, AllTests.nivelDto);
	}
	
	@Test
	public void testGetCategorias() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libroDto2 = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libroDto2);
		autores.add(autor);
		librosCategoria.add(libroDto2);
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
								libroDto2, 
								persona1,
								AllTests.tipoAcceso));
		
		autor.setLibros(libros);
		libroDto2.setAutores(autores);
		libroDto2.setCategorias(categorias);
		libroDto2.setPrestamos(prestamos);
		
		Util.checkEqualCategorias("El Get de las categorias no va bien", libroDto.getCategorias(), categorias, AllTests.nivelDto);
	}

	@Test
	public void testSetCategorias() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libroDto2 = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libroDto2);
		autores.add(autor);
		librosCategoria.add(libroDto2);
		categorias.add(new Categoria(2, "Categoria2", librosCategoria, AllTests.tipoAcceso));
		
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
								libroDto2, 
								persona1,
								AllTests.tipoAcceso));
		
		autor.setLibros(libros);
		libroDto2.setAutores(autores);
		libroDto2.setCategorias(categorias);
		libroDto2.setPrestamos(prestamos);
		
		libroDto.setCategorias(categorias);
		
		Util.checkEqualCategorias("El Get de las categorias no va bien", libroDto.getCategorias(), categorias, AllTests.nivelDto);
	}
	
	@Test
	public void testGetPrestamos() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null, AllTests.tipoAcceso);
		
		Libro libroDto2 = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libroDto2);
		autores.add(autor);
		librosCategoria.add(libroDto2);
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
								libroDto2, 
								persona1,
								AllTests.tipoAcceso));
		
		autor.setLibros(libros);
		libroDto2.setAutores(autores);
		libroDto2.setCategorias(categorias);
		libroDto2.setPrestamos(prestamos);
		
		Util.checkEqualPrestamos("El Get de los prestamos no va bien", libroDto.getPrestamos(), prestamos, AllTests.nivelDto);
	}

	@Test
	public void testSetPrestamos() {
		List<Autor> autores = new ArrayList<>();
		List<Prestamo> prestamos = new ArrayList<>();
		List<Libro> libros = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		List<Libro> librosCategoria = new ArrayList<>();
		
		Autor autor = new Autor(1, "A", null,AllTests.tipoAcceso);
		
		Libro libroDto2 = new Libro(1, 
								"Titulo 1", 
								100, 
								"Ed1", 
								"Edicion1", 
								null, 
								null, 
								null,
								AllTests.tipoAcceso);
		libros.add(libroDto2);
		autores.add(autor);
		librosCategoria.add(libroDto2);
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
		prestamos.add(new Prestamo(2, 
								LocalDate.now(), 
								LocalDate.now().plusMonths(1), 
								false, 
								libroDto2, 
								persona1,
								AllTests.tipoAcceso));
		
		autor.setLibros(libros);
		libroDto2.setAutores(autores);
		libroDto2.setCategorias(categorias);
		libroDto2.setPrestamos(prestamos);
		
		libroDto.setPrestamos(prestamos);
		
		Util.checkEqualPrestamos("El Set de los prestamos no va bien", libroDto.getPrestamos(), prestamos, AllTests.nivelDto);
	}
}
