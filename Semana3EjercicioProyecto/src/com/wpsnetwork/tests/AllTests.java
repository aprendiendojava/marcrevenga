package com.wpsnetwork.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
		{
			com.wpsnetwork.tests.dao.entidades.AutorTest.class,
			com.wpsnetwork.tests.dao.entidades.CategoriaTest.class,
			com.wpsnetwork.tests.dao.entidades.CategoriaLibroTest.class,
			com.wpsnetwork.tests.dao.entidades.LibroTest.class,
			com.wpsnetwork.tests.dao.entidades.LibroAutorTest.class,
			com.wpsnetwork.tests.dao.entidades.PersonaTest.class,
			com.wpsnetwork.tests.dao.entidades.PrestamoTest.class,
			
			com.wpsnetwork.tests.dao.memoria.RepositorioAutoresMemoriaDaoTest.class,
			com.wpsnetwork.tests.dao.memoria.RepositorioCategoriasLibrosMemoriaDaoTest.class,
			com.wpsnetwork.tests.dao.memoria.RepositorioCategoriasMemoriaDaoTest.class,
			com.wpsnetwork.tests.dao.memoria.RepositorioLibrosMemoriaDaoTest.class,
			com.wpsnetwork.tests.dao.memoria.RepositorioPersonasMemoriaDaoTest.class,
			com.wpsnetwork.tests.dao.memoria.RepositorioPrestamosMemoriaDaoTest.class,
			
			com.wpsnetwork.tests.dto.entidades.AutorTest.class,
			com.wpsnetwork.tests.dto.entidades.CategoriaTest.class,
			com.wpsnetwork.tests.dto.entidades.LibroTest.class,
			com.wpsnetwork.tests.dto.entidades.PersonaTest.class,
			com.wpsnetwork.tests.dto.entidades.PrestamoTest.class
		})
public class AllTests {
	public static final String tipoAcceso="MEMORIA";
	public static final int nivelDto=3;
}
