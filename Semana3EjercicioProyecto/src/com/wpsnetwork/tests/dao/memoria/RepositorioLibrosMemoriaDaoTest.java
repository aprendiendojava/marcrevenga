package com.wpsnetwork.tests.dao.memoria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.Libro;
import com.wpsnetwork.dao.memoria.RepositorioLibrosMemoriaDao;

public class RepositorioLibrosMemoriaDaoTest {
	private RepositorioLibrosMemoriaDao librosDao;

	@Before
	public void setUp() throws Exception {
		librosDao =  RepositorioLibrosMemoriaDao.getInstance(); 
	}

	@Test
	public void testGetInstance() {
		assertEquals("getInstance() no devuelve el mismo objeto", 
				librosDao, 
				RepositorioLibrosMemoriaDao.getInstance());
	}

	@Test
	public void testGet() {
		Libro libroDao = new Libro(100, "CONTROL", 100, "Ed", "Edicion");
		librosDao.insert(libroDao);
		Libro libroDao2 = librosDao.get(100);

		checkEqual("Get() no funciona", 
				libroDao, 
				libroDao2);
	}

	@Test
	public void testInsert() {
		Libro libroDao = new Libro(200, "CONTROL", 100, "Ed", "Edicion");
		librosDao.insert(libroDao);
		Libro libroDao2 = librosDao.get(200);

		checkEqual("Insert() no funciona", 
				libroDao, 
				libroDao2);
	}

	@Test
	public void testUpdate() {
		Libro libroDaoInsert = new Libro(50, "CONTROL_VIEJO",100, "Ed", "Edicion");
		librosDao.insert(libroDaoInsert);
		Libro libroDao = new Libro(50, "CONTROL_UPDATE",100, "Ed", "Edicion");
		librosDao.update(libroDao);
		Libro libroDao2 = librosDao.get(50);

		checkEqual("Update() no funciona", 
				libroDao, 
				libroDao2);
	}

	@Test
	public void testDelete() {
		Libro libroDao = new Libro(100, "CONTROL",100, "Ed", "Edicion");
		librosDao.delete(libroDao);
		Libro libroDao2 = librosDao.get(100);

		checkEqual("Delete() no funciona", libroDao2,null);
	}

	@Test
	public void testGetAll() {
		int tamañoIni = librosDao.getAll().size();
		librosDao.insert(new Libro(1000, "A",100, "Ed", "Edicion"));
		int tamañoFin =	librosDao.getAll().size();

		assertEquals("GetAll() no funciona", 
				tamañoFin, 
				tamañoIni+1);
	}

	private void checkEqual(String mensaje, Libro viejo, Libro nuevo){
		if((viejo == null) & (nuevo == null)) return;

		if (viejo.getId() != nuevo.getId())
			fail(mensaje);
		if (!viejo.getTitulo().equals(nuevo.getTitulo()))
			fail(mensaje);
		if (viejo.getPaginas() != nuevo.getPaginas())
			fail(mensaje);
		if (!viejo.getEditorial().equals(nuevo.getEditorial()))
			fail(mensaje);
		if (!viejo.getEdicion().equals(nuevo.getEdicion()))
			fail(mensaje);
	}
}
