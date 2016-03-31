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

public class PersonaTest {
	private Persona personaDto;
	
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
		
		personaDto = new Persona(1, 
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
								libro, 
								personaDto,
								AllTests.tipoAcceso));
		
		autor.setLibros(libros);
		libro.setAutores(autores);
		libro.setCategorias(categorias);
		libro.setPrestamos(prestamos);
	}

	@Test
	public void testGetId() {
		if(personaDto.getId() != 1)
			fail("El Get del id no va bien");
		
	}

	@Test
	public void testSetId() {
		personaDto.setId(10);
		if(personaDto.getId() != 10)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetNombre() {
		if(!personaDto.getNombre().equals("Persona1"))
			fail("El Get del nombre no va bien");
		
	}

	@Test
	public void testSetNombre() {
		personaDto.setNombre("A");
		if(!personaDto.getNombre().equals("A"))
			fail("El Set del dni no va bien");
	}

	@Test
	public void testGetDni() {
		if(!personaDto.getDni().equals("DNI1"))
			fail("El Get del dni no va bien");
		
	}

	@Test
	public void testSetDni() {
		personaDto.setDni("A");
		if(!personaDto.getDni().equals("A"))
			fail("El Set del dni no va bien");
	}

	@Test
	public void testGetFechaNacimiento() {
		if(!personaDto.getFechaNacimiento().equals(LocalDate.now()))
			fail("El Get de la fecha de nacimiento no va bien");
		
	}

	@Test
	public void testSetFechaNacimiento() {
		personaDto.setFechaNacimiento(LocalDate.of(2012, Month.FEBRUARY, 10));
		if(!personaDto.getFechaNacimiento().equals(LocalDate.of(2012, Month.FEBRUARY, 10)))
			fail("El Set de la fecha de nacimiento no va bien");
	}

	@Test
	public void testGetDireccion() {
		if(!personaDto.getDireccion().equals("DIR1"))
			fail("El Get de la dirección no va bien");
		
	}

	@Test
	public void testSetDireccion() {
		personaDto.setDireccion("A");
		if(!personaDto.getDireccion().equals("A"))
			fail("El Set de la dirección no va bien");
	}

	@Test
	public void testGetTelefono() {
		if(!personaDto.getTelefono().equals("TEL1"))
			fail("El Get del teléfono no va bien");
		
	}

	@Test
	public void testSetTelefono() {
		personaDto.setTelefono("A");
		if(!personaDto.getTelefono().equals("A"))
			fail("El Set del teléfono no va bien");
	}

	@Test
	public void testGetPais() {
		if(!personaDto.getPais().equals("PAIS1"))
			fail("El Get del país no va bien");
		
	}

	@Test
	public void testSetPais() {
		personaDto.setPais("A");
		if(!personaDto.getPais().equals("A"))
			fail("El Set del país no va bien");
	}

	@Test
	public void testGetProvincia() {
		if(!personaDto.getProvincia().equals("PROV1"))
			fail("El Get de la provincia no va bien");
		
	}

	@Test
	public void testSetProvincia() {
		personaDto.setProvincia("A");
		if(!personaDto.getProvincia().equals("A"))
			fail("El Set de la provincia no va bien");
	}

	@Test
	public void testGetCiudad() {
		if(!personaDto.getCiudad().equals("CIU1"))
			fail("El Get de la ciudad no va bien");
		
	}

	@Test
	public void testSetCiudad() {
		personaDto.setCiudad("A");
		if(!personaDto.getCiudad().equals("A"))
			fail("El Set de la ciudad no va bien");
	}

	@Test
	public void testGetCodigoPostal() {
		if(!personaDto.getCodigoPostal().equals("CP1"))
			fail("El Get del código postal no va bien");
	}

	@Test
	public void testSetCodigoPostal() {
		personaDto.setCodigoPostal("22222");
		if(!personaDto.getCodigoPostal().equals("22222"))
			fail("El Set del código postal no va bien");
	}

	@Test
	public void testGetPrestamos() {
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
		
		Persona personaDto2 = new Persona(1, 
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
								libro, 
								personaDto2,
								AllTests.tipoAcceso));
		
		autor.setLibros(libros);
		libro.setAutores(autores);
		libro.setCategorias(categorias);
		libro.setPrestamos(prestamos);
		
		Util.checkEqualPrestamos("El Get de los prestamos no va bien", personaDto.getPrestamos(), prestamos, AllTests.nivelDto);
	}

	@Test
	public void testSetPrestamos() {
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
		
		Persona personaDto2 = new Persona(1, 
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
								libro, 
								personaDto2,
								AllTests.tipoAcceso));
		
		autor.setLibros(libros);
		libro.setAutores(autores);
		libro.setCategorias(categorias);
		libro.setPrestamos(prestamos);
		
		personaDto.setPrestamos(prestamos);
		
		Util.checkEqualPrestamos("El Set de los prestamos no va bien", personaDto.getPrestamos(), prestamos, AllTests.nivelDto);
	}
}
