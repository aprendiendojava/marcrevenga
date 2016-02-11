package com.wpsnetwork.tests.dao.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.Libro;

public class LibroTest {
	private Libro libroDao;
	
	@Before
	public void setUp() throws Exception {
		libroDao = new Libro(1, "A", 100, "B", "C");
	}

	@Test
	public void testLibroIntStringIntStringString() {
		if(libroDao.getId() != 1)
			fail("El Id del constructor no va bien");
		if(!libroDao.getTitulo().equals("A"))
			fail("El título del constructor no va bien");
		if(libroDao.getPaginas() != 100)
			fail("Las páginas del constructor no va bien");
		if(!libroDao.getEditorial().equals("B"))
			fail("La editorial del constructor no va bien");
		if(!libroDao.getEdicion().equals("C"))
			fail("La edición del constructor no va bien");
	}

	@Test
	public void testGetId() {
		if(libroDao.getId() != 1)
			fail("El Get del id no va bien");
	}

	@Test
	public void testSetId() {
		libroDao.setId(10);
		if(libroDao.getId() != 10)
			fail("El Set del id no va bien");
	}
	
	@Test
	public void testSetIdMalo() {
		
		boolean fallo = false;
		try{
			libroDao.setId(0);
		}
		catch(RuntimeException ex){
			fallo = true;
		}

		if(fallo != true)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetTitulo() {
		if(!libroDao.getTitulo().equals("A"))
			fail("El Get del título no va bien");
	}

	@Test
	public void testSetTitulo() {
		libroDao.setTitulo("B");
		if(!libroDao.getTitulo().equals("B"))
			fail("El Set del título no va bien");
	}

	@Test
	public void testGetPaginas() {
		if(libroDao.getPaginas() != 100)
			fail("El Get de las páginas no va bien");
	}

	@Test
	public void testSetPaginas() {
		libroDao.setPaginas(10);
		if(libroDao.getPaginas() != 10)
			fail("El Set de las páginas no va bien");
	}

	@Test
	public void testGetEditorial() {
		if(!libroDao.getEditorial().equals("B"))
			fail("El Get de la editorial no va bien");
	}

	@Test
	public void testSetEditorial() {
		libroDao.setEditorial("A");
		if(!libroDao.getEditorial().equals("A"))
			fail("El Set de la editorial no va bien");
	}

	@Test
	public void testGetEdicion() {
		if(!libroDao.getEdicion().equals("C"))
			fail("El Get de la edición no va bien");
	}

	@Test
	public void testSetEdicion() {
		libroDao.setEdicion("A");
		if(!libroDao.getEdicion().equals("A"))
			fail("El Set de la edición no va bien");
	}

}
