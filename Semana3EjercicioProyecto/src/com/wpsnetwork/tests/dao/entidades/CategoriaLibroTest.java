package com.wpsnetwork.tests.dao.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.CategoriaLibro;

public class CategoriaLibroTest {
	private CategoriaLibro categoriaLibroDao;

	@Before
	public void setUp() throws Exception {
		categoriaLibroDao = new CategoriaLibro(1, 2, 3);
	}

		@Test
	public void testCategoriaLibroIntIntInt() {
			if(categoriaLibroDao.getId() != 1)
				fail("El Id del constructor no va bien");
			if(categoriaLibroDao.getCategoria() != 2)
				fail("La categoria del constructor no va bien");
			if(categoriaLibroDao.getLibro() != 3)
				fail("El libro del constructor no va bien");
	}

	@Test
	public void testGetId() {
		if(categoriaLibroDao.getId() != 1)
			fail("El Get del id no va bien");
	}

	@Test
	public void testSetId() {
		categoriaLibroDao.setId(10);
		if(categoriaLibroDao.getId() != 10)
			fail("El Set del id no va bien");
	}
	
	@Test
	public void testSetIdMalo() {
		
		boolean fallo = false;
		try{
			categoriaLibroDao.setId(0);
		}
		catch(RuntimeException ex){
			fallo = true;
		}

		if(fallo != true)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetCategoria() {
		if(categoriaLibroDao.getCategoria() != 2)
			fail("El Get de la categoria no va bien");
	}

	@Test
	public void testSetCategoria() {
		categoriaLibroDao.setCategoria(10);
		if(categoriaLibroDao.getCategoria() != 10)
			fail("El Set de la categoria no va bien");
	}

	@Test
	public void testGetLibro() {
		if(categoriaLibroDao.getLibro() != 3)
			fail("El Get del libro no va bien");
	}

	@Test
	public void testSetLibro() {
		categoriaLibroDao.setLibro(10);
		if(categoriaLibroDao.getLibro() != 10)
			fail("El Set del libro no va bien");
	}

}
