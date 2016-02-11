package com.wpsnetwork.tests.dao.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.Categoria;

public class CategoriaTest {
	private Categoria categoriaDao;
	
	@Before
	public void setUp() throws Exception {
		categoriaDao = new Categoria(1, "A");
	}

	@Test
	public void testCategoriaIntString() {
		if(categoriaDao.getId() != 1)
			fail("El Id del constructor no va bien");
		if(!categoriaDao.getNombre().equals("A"))
			fail("El Nombre del constructor no va bien");
	}

	@Test
	public void testGetId() {
		if(categoriaDao.getId() != 1)
			fail("El Get del id no va bien");
	}

	@Test
	public void testSetId() {
		categoriaDao.setId(2);
		if(categoriaDao.getId() != 2)
			fail("El Set del id no va bien");
	}
	
	@Test
	public void testSetIdMalo() {
		
		boolean fallo = false;
		try{
			categoriaDao.setId(0);
		}
		catch(RuntimeException ex){
			fallo = true;
		}

		if(fallo != true)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetNombre() {
		if(!categoriaDao.getNombre().equals("A"))
			fail("El Get del nombre no va bien");
	}

	@Test
	public void testSetNombre() {
		categoriaDao.setNombre("B");
		if(!categoriaDao.getNombre().equals("B"))
			fail("El Set del nombre no va bien");
	}

}
