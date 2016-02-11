package com.wpsnetwork.tests.dao.entidades;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.Prestamo;

public class PrestamoTest {
	private Prestamo prestamoDao;
	
	@Before
	public void setUp() throws Exception {
		prestamoDao = new Prestamo(1, 
									LocalDate.of(2000, Month.JANUARY, 1), 
									LocalDate.of(2010, Month.JANUARY, 1), 
									true, 
									2, 
									3);
	}

	@Test
	public void testPrestamoIntLocalDateLocalDateBooleanIntInt() {
		if(prestamoDao.getId() != 1)
			fail("El Id del constructor no va bien");
		if(!prestamoDao.getFechaInicio().equals(LocalDate.of(2000, Month.JANUARY, 1)))
			fail("La fecha de inicio del constructor no va bien");
		if(!prestamoDao.getFechaFin().equals(LocalDate.of(2010, Month.JANUARY, 1)))
			fail("La fecha de fin del constructor no va bien");
		if(!prestamoDao.isDevuelto()==true)
			fail("Devuelto del constructor no va bien");
		if(prestamoDao.getLibro() != 2)
			fail("El libro del constructor no va bien");
		if(prestamoDao.getPersona() != 3)
			fail("La persona del constructor no va bien");
	}

	@Test
	public void testGetId() {
		if(prestamoDao.getId() != 1)
			fail("El Get del id no va bien");
	}

	@Test
	public void testSetId() {
		prestamoDao.setId(10);
		if(prestamoDao.getId() != 10)
			fail("El Set del id no va bien");
	}
	
	@Test
	public void testSetIdMalo() {
		
		boolean fallo = false;
		try{
			prestamoDao.setId(0);
		}
		catch(RuntimeException ex){
			fallo = true;
		}

		if(fallo != true)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetFechaInicio() {
		if(!prestamoDao.getFechaInicio().equals(LocalDate.of(2000, Month.JANUARY, 1)))
			fail("El Get de la fecha de inicio no va bien");
	}

	@Test
	public void testSetFechaInicio() {
		prestamoDao.setFechaInicio(LocalDate.of(1999, Month.JANUARY, 1));
		if(!prestamoDao.getFechaInicio().equals(LocalDate.of(1999, Month.JANUARY, 1)))
			fail("El Set de la fecha de inicio no va bien");
	}

	@Test
	public void testGetFechaFin() {
		if(!prestamoDao.getFechaFin().equals(LocalDate.of(2010, Month.JANUARY, 1)))
			fail("El Get de la fecha de fin no va bien");
	}

	@Test
	public void testSetFechaFin() {
		prestamoDao.setFechaFin(LocalDate.of(1999, Month.JANUARY, 1));
		if(!prestamoDao.getFechaFin().equals(LocalDate.of(1999, Month.JANUARY, 1)))
			fail("El Set de la fecha de fin no va bien");
	}

	@Test
	public void testIsDevuelto() {
		if(!prestamoDao.isDevuelto() == true)
			fail("El Get de devuelto no va bien");
	}

	@Test
	public void testSetDevuelto() {
		prestamoDao.setDevuelto(false);
		if(!prestamoDao.isDevuelto() == false)
			fail("El Set de devuelto no va bien");
	}

	@Test
	public void testGetLibro() {
		if(prestamoDao.getLibro() != 2)
			fail("El Get del libro no va bien");
	}

	@Test
	public void testSetLibro() {
		prestamoDao.setLibro(10);
		if(prestamoDao.getLibro() != 10)
			fail("El Set del libro no va bien");
	}

	@Test
	public void testGetPersona() {
		if(prestamoDao.getPersona() != 3)
			fail("El Get de la persona no va bien");
	}

	@Test
	public void testSetPersona() {
		prestamoDao.setPersona(10);
		if(prestamoDao.getPersona() != 10)
			fail("El Set de la persona no va bien");
	}

}
