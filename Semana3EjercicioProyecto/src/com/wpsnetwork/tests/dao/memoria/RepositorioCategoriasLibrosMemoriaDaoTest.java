package com.wpsnetwork.tests.dao.memoria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.CategoriaLibro;
import com.wpsnetwork.dao.memoria.RepositorioCategoriasLibrosMemoriaDao;

public class RepositorioCategoriasLibrosMemoriaDaoTest {

	private RepositorioCategoriasLibrosMemoriaDao categoriasLibrosDao;
	
	@Before
	public void setUp() throws Exception {
		categoriasLibrosDao =  RepositorioCategoriasLibrosMemoriaDao
											.getInstance(); 
	}

	@Test
	public void testGetInstance() {
		assertEquals("getInstance() no devuelve el mismo objeto", 
				categoriasLibrosDao, 
				RepositorioCategoriasLibrosMemoriaDao.getInstance());
	}

	@Test
	public void testGet() {
		CategoriaLibro categoriaLibroDao = new CategoriaLibro(100,100,100);
		categoriasLibrosDao.insert(categoriaLibroDao);
		CategoriaLibro categoriaLibroDao2 = categoriasLibrosDao.get(100);
		
		checkEqual("Get() no funciona", 
				categoriaLibroDao, 
				categoriaLibroDao2);
	}

	@Test
	public void testInsert() {
		CategoriaLibro categoriaLibroDao = new CategoriaLibro(200,200,200);
		categoriasLibrosDao.insert(categoriaLibroDao);
		CategoriaLibro categoriaLibroDao2 = categoriasLibrosDao.get(200);
		
		checkEqual("Insert() no funciona", 
				categoriaLibroDao, 
				categoriaLibroDao2);
	}

	@Test
	public void testUpdate() {
		CategoriaLibro categoriaLibroDaoInsert = new CategoriaLibro(300,300,300);
		categoriasLibrosDao.insert(categoriaLibroDaoInsert);
		CategoriaLibro categoriaLibroDao = new CategoriaLibro(300,400,400);
		categoriasLibrosDao.update(categoriaLibroDao);
		CategoriaLibro categoriaLibroDao2 = categoriasLibrosDao.get(300);
		
		checkEqual("Update() no funciona", 
				categoriaLibroDao, 
				categoriaLibroDao2);
	}

	@Test
	public void testDelete() {
		CategoriaLibro categoriaLibroDao = new CategoriaLibro(400,400,400);
		categoriasLibrosDao.delete(categoriaLibroDao);
		CategoriaLibro categoriaLibroDao2 = categoriasLibrosDao.get(400);
		
		checkEqual("Delete() no funciona", categoriaLibroDao2,null);
	}

	@Test
	public void testGetAll() {
		int tamañoIni = categoriasLibrosDao.getAll().size();
		categoriasLibrosDao.insert(new CategoriaLibro(500,500,500));
		int tamañoFin =	categoriasLibrosDao.getAll().size();
		
		assertEquals("GetAll() no funciona", 
				tamañoFin, 
				tamañoIni+1);
	}
	
	private void checkEqual(String mensaje, CategoriaLibro viejo, CategoriaLibro nuevo){
		if((viejo == null) & (nuevo == null)) return;
		
		if (viejo.getId() != nuevo.getId())
			fail(mensaje);
		if (viejo.getLibro()!=nuevo.getLibro())
			fail(mensaje);
		if (viejo.getCategoria()!=nuevo.getCategoria())
			fail(mensaje);
	}

}