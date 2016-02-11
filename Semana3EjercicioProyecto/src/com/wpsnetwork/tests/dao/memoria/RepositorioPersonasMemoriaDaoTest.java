package com.wpsnetwork.tests.dao.memoria;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.wpsnetwork.dao.entidades.Persona;
import com.wpsnetwork.dao.memoria.RepositorioPersonasMemoriaDao;

public class RepositorioPersonasMemoriaDaoTest {

	private RepositorioPersonasMemoriaDao personasDao;

	@Before
	public void setUp() throws Exception {
		personasDao =  RepositorioPersonasMemoriaDao.getInstance(); 
	}

	@Test
	public void testGetInstance() {
		assertEquals("getInstance() no devuelve el mismo objeto", 
				personasDao, 
				RepositorioPersonasMemoriaDao.getInstance());
	}

	@Test
	public void testGet() {
		Persona personaDao = new Persona(100, 
										"CONTROL", 
										"DNI", 
										LocalDate.now(), 
										"DIR", 
										"TLF", 
										"PAIS", 
										"PROV", 
										"CIUDAD", 
										"CP");
		personasDao.insert(personaDao);
		Persona personaDao2 = personasDao.get(100);

		checkEqual("Get() no funciona", 
				personaDao, 
				personaDao2);
	}

	@Test
	public void testInsert() {
		Persona personaDao = new Persona(200, 
										"CONTROL", 
										"DNI", 
										LocalDate.now(), 
										"DIR", 
										"TLF", 
										"PAIS", 
										"PROV", 
										"CIUDAD", 
										"CP");
		personasDao.insert(personaDao);
		Persona personaDao2 = personasDao.get(200);

		checkEqual("Insert() no funciona", 
				personaDao, 
				personaDao2);
	}

	@Test
	public void testUpdate() {
		Persona personaDaoInsert = new Persona(50, 
												"CONTROL_VIEJO",
												"DNI", 
												LocalDate.now(), 
												"DIR", 
												"TLF", 
												"PAIS", 
												"PROV", 
												"CIUDAD", 
												"CP");
		personasDao.insert(personaDaoInsert);
		Persona personaDao = new Persona(50, 
										"CONTROL_UPDATE",
										"DNI", 
										LocalDate.now(), 
										"DIR", 
										"TLF", 
										"PAIS", 
										"PROV", 
										"CIUDAD", 
										"CP");
		personasDao.update(personaDao);
		Persona personaDao2 = personasDao.get(50);

		checkEqual("Update() no funciona", 
				personaDao, 
				personaDao2);
	}

	@Test
	public void testDelete() {
		Persona personaDao = new Persona(100, 
										"CONTROL",
										"DNI", 
										LocalDate.now(), 
										"DIR", 
										"TLF", 
										"PAIS", 
										"PROV", 
										"CIUDAD", 
										"CP");
		personasDao.delete(personaDao);
		Persona personaDao2 = personasDao.get(100);

		checkEqual("Delete() no funciona", personaDao2,null);
	}

	@Test
	public void testGetAll() {
		int tamañoIni = personasDao.getAll().size();
		personasDao.insert(new Persona(1000, 
										"A",
										"DNI", 
										LocalDate.now(), 
										"DIR", 
										"TLF", 
										"PAIS", 
										"PROV", 
										"CIUDAD", 
										"CP"));
		int tamañoFin =	personasDao.getAll().size();

		assertEquals("GetAll() no funciona", 
				tamañoFin, 
				tamañoIni+1);
	}

	private void checkEqual(String mensaje, Persona viejo, Persona nuevo){
		if((viejo == null) & (nuevo == null)) return;

		if (viejo.getId() != nuevo.getId())
			fail(mensaje);
		if (!viejo.getNombre().equals(nuevo.getNombre()))
			fail(mensaje);
		if (!viejo.getDni().equals(nuevo.getDni()))
			fail(mensaje);
		if (!viejo.getFechaNacimiento().equals(nuevo.getFechaNacimiento()))
			fail(mensaje);
		if (!viejo.getDireccion().equals(nuevo.getDireccion()))
			fail(mensaje);
		if (!viejo.getTelefono().equals(nuevo.getTelefono()))
			fail(mensaje);
		if (!viejo.getPais().equals(nuevo.getPais()))
			fail(mensaje);
		if (!viejo.getProvincia().equals(nuevo.getProvincia()))
			fail(mensaje);
		if (!viejo.getCiudad().equals(nuevo.getCiudad()))
			fail(mensaje);
		if (!viejo.getCodigoPostal().equals(nuevo.getCodigoPostal()))
			fail(mensaje);
	}
}
