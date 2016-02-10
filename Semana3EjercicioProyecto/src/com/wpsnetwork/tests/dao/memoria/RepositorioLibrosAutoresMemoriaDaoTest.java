package com.wpsnetwork.tests.dao.memoria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.LibroAutor;
import com.wpsnetwork.dao.memoria.RepositorioLibrosAutoresMemoriaDao;

public class RepositorioLibrosAutoresMemoriaDaoTest {

private RepositorioLibrosAutoresMemoriaDao librosAutoresDao;
	
	@Before
	public void setUp() throws Exception {
		librosAutoresDao =  RepositorioLibrosAutoresMemoriaDao
											.getInstance(); 
	}

	@Test
	public void testGetInstance() {
		assertEquals("getInstance() no devuelve el mismo objeto", 
				librosAutoresDao, 
				RepositorioLibrosAutoresMemoriaDao.getInstance());
	}

	@Test
	public void testGet() {
		LibroAutor libroAutorDao = new LibroAutor(100,100,100);
		librosAutoresDao.insert(libroAutorDao);
		LibroAutor libroAutorDao2 = librosAutoresDao.get(100);
		
		checkEqual("Get() no funciona", 
				libroAutorDao, 
				libroAutorDao2);
	}

	@Test
	public void testInsert() {
		LibroAutor libroAutorDao = new LibroAutor(200,200,200);
		librosAutoresDao.insert(libroAutorDao);
		LibroAutor libroAutorDao2 = librosAutoresDao.get(200);
		
		checkEqual("Insert() no funciona", 
				libroAutorDao, 
				libroAutorDao2);
	}

	@Test
	public void testUpdate() {
		LibroAutor libroAutorDaoInsert = new LibroAutor(300,300,300);
		librosAutoresDao.insert(libroAutorDaoInsert);
		LibroAutor libroAutorDao = new LibroAutor(300,400,400);
		librosAutoresDao.update(libroAutorDao);
		LibroAutor libroAutorDao2 = librosAutoresDao.get(300);
		
		checkEqual("Update() no funciona", 
				libroAutorDao, 
				libroAutorDao2);
	}

	@Test
	public void testDelete() {
		LibroAutor libroAutorDao = new LibroAutor(400,400,400);
		librosAutoresDao.delete(libroAutorDao);
		LibroAutor libroAutorDao2 = librosAutoresDao.get(400);
		
		checkEqual("Delete() no funciona", libroAutorDao2,null);
	}

	@Test
	public void testGetAll() {
		int tamañoIni = librosAutoresDao.getAll().size();
		librosAutoresDao.insert(new LibroAutor(500,500,500));
		int tamañoFin =	librosAutoresDao.getAll().size();
		
		assertEquals("GetAll() no funciona", 
				tamañoFin, 
				tamañoIni+1);
	}
	
	private void checkEqual(String mensaje, LibroAutor viejo, LibroAutor nuevo){
		if((viejo == null) & (nuevo == null)) return;
		
		if (viejo.getId() != nuevo.getId())
			fail(mensaje);
		if (viejo.getLibro()!=nuevo.getLibro())
			fail(mensaje);
		if (viejo.getAutor()!=nuevo.getAutor())
			fail(mensaje);
	}

}