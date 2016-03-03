package com.wpsnetwork.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	Cliente c = null;
	@Before
	public void setUp() throws Exception {
		c = new Cliente(1, "Pepito"); 
	}

	@Test
	public void testGetCodigo() {
		assertEquals("El getter del código falla", 1, c.getCodigo());
	}

	@Test
	public void testSetCodigo() {
		c.setCodigo(2);
		assertEquals("El setter del código falla", 2, c.getCodigo());
	}

	@Test
	public void testGetNombre() {
		assertEquals("El getter del nombre falla", "Pepito", c.getNombre());
	}

	@Test
	public void testSetNombre() {
		c.setNombre("Menganito");
		assertEquals("El setter del nombre falla", "Menganito", c.getNombre());
	}

}
