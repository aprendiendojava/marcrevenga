package com.wpsnetwork.tests.dao.memoria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.Categoria;
import com.wpsnetwork.dao.memoria.RepositorioCategoriasMemoriaDao;

public class RepositorioCategoriasMemoriaDaoTest {
	private RepositorioCategoriasMemoriaDao categoriasDao;
	
	@Before
	public void setUp() throws Exception {
		categoriasDao =  RepositorioCategoriasMemoriaDao.getInstance(); 
	}

	@Test
	public void testGetInstance() {
		assertEquals("getInstance() no devuelve el mismo objeto", 
					categoriasDao, 
					RepositorioCategoriasMemoriaDao.getInstance());
	}

	@Test
	public void testGet() {
		Categoria categoriaDao = new Categoria(100, "CONTROL");
		categoriasDao.insert(categoriaDao);
		Categoria categoriaDao2 = categoriasDao.get(100);
		
		checkEqual("Get() no funciona", 
				categoriaDao, 
				categoriaDao2);
	}

	@Test
	public void testInsert() {
		Categoria categoriaDao = new Categoria(200, "CONTROL");
		categoriasDao.insert(categoriaDao);
		Categoria categoriaDao2 = categoriasDao.get(200);
		
		checkEqual("Insert() no funciona", 
				categoriaDao, 
				categoriaDao2);
	}

	@Test
	public void testUpdate() {
		Categoria categoriaDaoInsert = new Categoria(50, "CONTROL_VIEJO");
		categoriasDao.insert(categoriaDaoInsert);
		Categoria categoriaDao = new Categoria(50, "CONTROL_UPDATE");
		categoriasDao.update(categoriaDao);
		Categoria categoriaDao2 = categoriasDao.get(50);
		
		checkEqual("Update() no funciona", 
				categoriaDao, 
				categoriaDao2);
	}

	@Test
	public void testDelete() {
		Categoria categoriaDao = new Categoria(100, "CONTROL");
		categoriasDao.delete(categoriaDao);
		Categoria categoriaDao2 = categoriasDao.get(100);
		
		checkEqual("Delete() no funciona", categoriaDao2,null);
	}

	@Test
	public void testGetAll() {
		int tamañoIni = categoriasDao.getAll().size();
		categoriasDao.insert(new Categoria(1000, "A"));
		int tamañoFin =	categoriasDao.getAll().size();
		
		assertEquals("GetAll() no funciona", 
				tamañoFin, 
				tamañoIni+1);
	}
	
	private void checkEqual(String mensaje, Categoria viejo, Categoria nuevo){
		if((viejo == null) & (nuevo == null)) return;
		
		if (viejo.getId() != nuevo.getId())
			fail(mensaje);
		if (!viejo.getNombre().equals(nuevo.getNombre()))
			fail(mensaje);
	}
}
