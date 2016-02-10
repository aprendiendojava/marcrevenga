package com.wpsnetwork.tests.dao.memoria;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.Prestamo;
import com.wpsnetwork.dao.memoria.RepositorioPrestamosMemoriaDao;

public class RepositorioPrestamosMemoriaDaoTest {
	private RepositorioPrestamosMemoriaDao prestamosDao;

	@Before
	public void setUp() throws Exception {
		prestamosDao =  RepositorioPrestamosMemoriaDao.getInstance(); 
	}

	@Test
	public void testGetInstance() {
		assertEquals("getInstance() no devuelve el mismo objeto", 
				prestamosDao, 
				RepositorioPrestamosMemoriaDao.getInstance());
	}

	@Test
	public void testGet() {
		Prestamo prestamoDao = new Prestamo(100, 
										LocalDate.now(), 
										LocalDate.now(), 
										false, 
										100, 
										200);
				
		prestamosDao.insert(prestamoDao);
		Prestamo prestamoDao2 = prestamosDao.get(100);

		checkEqual("Get() no funciona", 
				prestamoDao, 
				prestamoDao2);
	}

	@Test
	public void testInsert() {
		Prestamo prestamoDao = new Prestamo(200, 
											LocalDate.now(), 
											LocalDate.now(), 
											false, 
											100, 
											200);
		prestamosDao.insert(prestamoDao);
		Prestamo prestamoDao2 = prestamosDao.get(200);

		checkEqual("Insert() no funciona", 
				prestamoDao, 
				prestamoDao2);
	}

	@Test
	public void testUpdate() {
		Prestamo prestamoDaoInsert = new Prestamo(50, 
												LocalDate.now(), 
												LocalDate.now(), 
												false, 
												100, 
												200);
		prestamosDao.insert(prestamoDaoInsert);
		Prestamo prestamoDao = new Prestamo(50, 
												LocalDate.now(), 
												LocalDate.now(), 
												false, 
												200, 
												300);
		prestamosDao.update(prestamoDao);
		Prestamo prestamoDao2 = prestamosDao.get(50);

		checkEqual("Update() no funciona", 
				prestamoDao, 
				prestamoDao2);
	}

	@Test
	public void testDelete() {
		Prestamo prestamoDao = new Prestamo(100, 
											LocalDate.now(), 
											LocalDate.now(), 
											false, 
											100, 
											200);
		prestamosDao.delete(prestamoDao);
		Prestamo prestamoDao2 = prestamosDao.get(100);

		checkEqual("Delete() no funciona", prestamoDao2,null);
	}

	@Test
	public void testGetAll() {
		int tamañoIni = prestamosDao.getAll().size();
		prestamosDao.insert(new Prestamo(1000, 
										LocalDate.now(), 
										LocalDate.now(), 
										false, 
										100, 
										200));
		int tamañoFin =	prestamosDao.getAll().size();

		assertEquals("GetAll() no funciona", 
				tamañoFin, 
				tamañoIni+1);
	}

	private void checkEqual(String mensaje, Prestamo viejo, Prestamo nuevo){
		if((viejo == null) & (nuevo == null)) return;

		if (viejo.getId() != nuevo.getId())
			fail(mensaje);
		if (!viejo.getFechaInicio().equals(nuevo.getFechaInicio()))
			fail(mensaje);
		if (!viejo.getFechaFin().equals(nuevo.getFechaFin()))
			fail(mensaje);
		if (viejo.isDevuelto() != nuevo.isDevuelto())
			fail(mensaje);
		if (viejo.getLibro() != nuevo.getLibro())
			fail(mensaje);
		if (viejo.getPersona() != nuevo.getPersona())
			fail(mensaje);
	}
}
