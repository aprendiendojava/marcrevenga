package com.wpsnetwork.tests.dao.entidades;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.Persona;

public class PersonaTest {
	private Persona personaDao;
	
	@Before
	public void setUp() throws Exception {
		personaDao = new Persona(1, 
				"A", 
				"11111111X", 
				LocalDate.of(2000, Month.JANUARY, 1), 
				"B", 
				"111111111", 
				"C", 
				"D", 
				"E", 
				"11111");
	}

	@Test
	public void testPersonaIntStringStringLocalDateStringStringStringStringStringString() {
		if(personaDao.getId() != 1)
			fail("El Id del constructor no va bien");
		if(!personaDao.getNombre().equals("A"))
			fail("El nombre del constructor no va bien");
		if(!personaDao.getDni().equals("11111111X"))
			fail("El dni del constructor no va bien");
		if(!personaDao.getFechaNacimiento().equals(LocalDate.of(2000, Month.JANUARY, 1)))
			fail("la fecha de nacimiento del constructor no va bien");
		if(!personaDao.getDireccion().equals("B"))
			fail("La dirección del constructor no va bien");
		if(!personaDao.getTelefono().equals("111111111"))
			fail("El telefono del constructor no va bien");
		if(!personaDao.getPais().equals("C"))
			fail("El pais del constructor no va bien");
		if(!personaDao.getProvincia().equals("D"))
			fail("La provincia del constructor no va bien");
		if(!personaDao.getCiudad().equals("E"))
			fail("La ciudad del constructor no va bien");
		if(!personaDao.getCodigoPostal().equals("11111"))
			fail("El dni del constructor no va bien");
	}

	@Test
	public void testGetId() {
		if(personaDao.getId() != 1)
			fail("El Get del id no va bien");
		
	}

	@Test
	public void testSetId() {
		personaDao.setId(10);
		if(personaDao.getId() != 10)
			fail("El Set del id no va bien");
	}
	
	@Test
	public void testSetIdMalo() {
		
		boolean fallo = false;
		try{
			personaDao.setId(0);
		}
		catch(RuntimeException ex){
			fallo = true;
		}

		if(fallo != true)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetNombre() {
		if(!personaDao.getNombre().equals("A"))
			fail("El Get del nombre no va bien");
		
	}

	@Test
	public void testSetNombre() {
		personaDao.setNombre("A");
		if(!personaDao.getNombre().equals("A"))
			fail("El Set del dni no va bien");
	}

	@Test
	public void testGetDni() {
		if(!personaDao.getDni().equals("11111111X"))
			fail("El Get del dni no va bien");
		
	}

	@Test
	public void testSetDni() {
		personaDao.setDni("A");
		if(!personaDao.getDni().equals("A"))
			fail("El Set del dni no va bien");
	}

	@Test
	public void testGetFechaNacimiento() {
		if(!personaDao.getFechaNacimiento().equals(LocalDate.of(2000, Month.JANUARY, 1)))
			fail("El Get de la fecha de nacimiento no va bien");
		
	}

	@Test
	public void testSetFechaNacimiento() {
		personaDao.setFechaNacimiento(LocalDate.of(2012, Month.FEBRUARY, 10));
		if(!personaDao.getFechaNacimiento().equals(LocalDate.of(2012, Month.FEBRUARY, 10)))
			fail("El Set de la fecha de nacimiento no va bien");
	}

	@Test
	public void testGetDireccion() {
		if(!personaDao.getDireccion().equals("B"))
			fail("El Get de la dirección no va bien");
		
	}

	@Test
	public void testSetDireccion() {
		personaDao.setDireccion("A");
		if(!personaDao.getDireccion().equals("A"))
			fail("El Set de la dirección no va bien");
	}

	@Test
	public void testGetTelefono() {
		if(!personaDao.getTelefono().equals("111111111"))
			fail("El Get del teléfono no va bien");
		
	}

	@Test
	public void testSetTelefono() {
		personaDao.setTelefono("A");
		if(!personaDao.getTelefono().equals("A"))
			fail("El Set del teléfono no va bien");
	}

	@Test
	public void testGetPais() {
		if(!personaDao.getPais().equals("C"))
			fail("El Get del país no va bien");
		
	}

	@Test
	public void testSetPais() {
		personaDao.setPais("A");
		if(!personaDao.getPais().equals("A"))
			fail("El Set del país no va bien");
	}

	@Test
	public void testGetProvincia() {
		if(!personaDao.getProvincia().equals("D"))
			fail("El Get de la provincia no va bien");
		
	}

	@Test
	public void testSetProvincia() {
		personaDao.setProvincia("A");
		if(!personaDao.getProvincia().equals("A"))
			fail("El Set de la provincia no va bien");
	}

	@Test
	public void testGetCiudad() {
		if(!personaDao.getCiudad().equals("E"))
			fail("El Get de la ciudad no va bien");
		
	}

	@Test
	public void testSetCiudad() {
		personaDao.setCiudad("A");
		if(!personaDao.getCiudad().equals("A"))
			fail("El Set de la ciudad no va bien");
	}

	@Test
	public void testGetCodigoPostal() {
		if(!personaDao.getCodigoPostal().equals("11111"))
			fail("El Get del código postal no va bien");
	}

	@Test
	public void testSetCodigoPostal() {
		personaDao.setCodigoPostal("22222");
		if(!personaDao.getCodigoPostal().equals("22222"))
			fail("El Set del código postal no va bien");
	}

}
