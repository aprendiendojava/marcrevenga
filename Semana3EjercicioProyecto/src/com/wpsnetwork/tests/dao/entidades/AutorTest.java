package com.wpsnetwork.tests.dao.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.Autor;

public class AutorTest {
	private Autor autorDao;
	
	@Before
	public void antesTest(){
		autorDao = new Autor(1, "A");
	}

	@Test
	public void testAutorIntString() {
		if(autorDao.getId() != 1)
			fail("El Id del constructor no va bien");
		if(!autorDao.getNombre().equals("A"))
			fail("El Nombre del constructor no va bien");
	}

	@Test
	public void testGetId() {
		if(autorDao.getId() != 1)
			fail("El Get del id no va bien");
	}

	@Test
	public void testSetId() {
		autorDao.setId(2);
		if(autorDao.getId() != 2)
			fail("El Set del id no va bien");
	}
	
	@Test
	public void testSetIdMalo() {
		
		boolean fallo = false;
		try{
			autorDao.setId(0);
		}
		catch(RuntimeException ex){
			fallo = true;
		}

		if(fallo != true)
			fail("El Set del id no va bien");
	}

	@Test
	public void testGetNombre() {
		if(!autorDao.getNombre().equals("A"))
			fail("El Get del nombre no va bien");
	}

	@Test
	public void testSetNombre() {
		autorDao.setNombre("B");
		if(!autorDao.getNombre().equals("B"))
			fail("El Set del nombre no va bien");
	}

}
