package com.wpsnetwork.tests.dao.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.LibroAutor;

public class LibroAutorTest {
	private LibroAutor librosAutoresDao;
	
	@Before
	public void setUp() throws Exception {
		librosAutoresDao = new LibroAutor(1, 2, 3);
	}

	@Test
	public void testLibrosAutoresIntIntInt() {
		if(librosAutoresDao.getId() != 1)
			fail("El Id del constructor no va bien");
	}

	@Test
	public void testGetId() {
		if(librosAutoresDao.getId() != 1)
			fail("El Get del id no va bien");
	}

	@Test
	public void testSetId() {
		librosAutoresDao.setId(10);
		if(librosAutoresDao.getId() != 10)
			fail("El Set del id no va bien");
	}

	@Test
	public void testSetIdMalo() {
		
		boolean fallo = false;
		try{
			librosAutoresDao.setId(0);
		}
		catch(RuntimeException ex){
			fallo = true;
		}

		if(fallo != true)
			fail("El Set del id no va bien");
	}
	
	@Test
	public void testGetLibro() {
		if(librosAutoresDao.getLibro() != 2)
			fail("El Get del libro no va bien");
	}

	@Test
	public void testSetLibro() {
		librosAutoresDao.setLibro(10);
		if(librosAutoresDao.getLibro() != 10)
			fail("El Set del libro no va bien");
	}

	@Test
	public void testGetAutor() {
		if(librosAutoresDao.getAutor() != 3)
			fail("El Get del autor no va bien");
	}

	@Test
	public void testSetAutor() {
		librosAutoresDao.setAutor(10);
		if(librosAutoresDao.getAutor() != 10)
			fail("El Set del autor no va bien");
	}

}
