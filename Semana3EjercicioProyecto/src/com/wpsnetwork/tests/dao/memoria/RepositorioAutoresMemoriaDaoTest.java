package com.wpsnetwork.tests.dao.memoria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.Autor;
import com.wpsnetwork.dao.memoria.RepositorioAutoresMemoriaDao;

public class RepositorioAutoresMemoriaDaoTest {
	private RepositorioAutoresMemoriaDao autoresDao;
	
	@Before
	public void setUp() throws Exception {
		autoresDao =  RepositorioAutoresMemoriaDao.getInstance(); 
	}

	@Test
	public void testGetInstance() {
		assertEquals("getInstance() no devuelve el mismo objeto", 
					autoresDao, 
					RepositorioAutoresMemoriaDao.getInstance());
	}

	@Test
	public void testGet() {
		Autor autorDao = new Autor(100, "CONTROL");
		autoresDao.insert(autorDao);
		Autor autorDao2 = autoresDao.get(100);
		
		checkEqual("Get() no funciona", 
				autorDao, 
				autorDao2);
	}

	@Test
	public void testInsert() {
		Autor autorDao = new Autor(200, "CONTROL");
		autoresDao.insert(autorDao);
		Autor autorDao2 = autoresDao.get(200);
		
		checkEqual("Insert() no funciona", 
				autorDao, 
				autorDao2);
	}

	@Test
	public void testUpdate() {
		Autor autorDaoInsert = new Autor(50, "CONTROL_VIEJO");
		autoresDao.insert(autorDaoInsert);
		Autor autorDao = new Autor(50, "CONTROL_UPDATE");
		autoresDao.update(autorDao);
		Autor autorDao2 = autoresDao.get(50);
		
		checkEqual("Update() no funciona", 
				autorDao, 
				autorDao2);
	}

	@Test
	public void testDelete() {
		Autor autorDao = new Autor(100, "CONTROL");
		autoresDao.delete(autorDao);
		Autor autorDao2 = autoresDao.get(100);
		
		checkEqual("Delete() no funciona", autorDao2,null);
	}

	@Test
	public void testGetAll() {
		int tamañoIni = autoresDao.getAll().size();
		autoresDao.insert(new Autor(1000, "A"));
		int tamañoFin =	autoresDao.getAll().size();
		
		assertEquals("GetAll() no funciona", 
				tamañoFin, 
				tamañoIni+1);
	}
	
	private void checkEqual(String mensaje, Autor viejo, Autor nuevo){
		if((viejo == null) & (nuevo == null)) return;
		
		if (viejo.getId() != nuevo.getId())
			fail(mensaje);
		if (!viejo.getNombre().equals(nuevo.getNombre()))
			fail(mensaje);
	}

}
