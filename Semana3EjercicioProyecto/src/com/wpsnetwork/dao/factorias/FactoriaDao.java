package com.wpsnetwork.dao.factorias;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.memoria.*;

public class FactoriaDao {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(FactoriaDao.class.getName());

	public enum TIPO_REPOSITORIO{AUTORES, CATEGORIAS_LIBROS, CATEGORIAS, LIBROS_AUTORES, LIBROS, PERSONAS, PRESTAMOS};
	
	static public Dao getDao(String tipoAcceso, TIPO_REPOSITORIO repositorio){
		if (logger.isDebugEnabled()) {
			logger.debug("getDao(String tipoAcceso={}, TIPO_REPOSITORIO repositorio={}) - start", tipoAcceso, repositorio); //$NON-NLS-1$
		}

		Dao repo=null;
		
		switch(tipoAcceso){
		case "MEMORIA":
			repo = getMemoriaDao(repositorio);
			break;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getDao(String tipoAcceso={}, TIPO_REPOSITORIO repositorio={}) - end - return value={}", tipoAcceso, repositorio, repo); //$NON-NLS-1$
		}
		return repo;
	}
	
	static private Dao getMemoriaDao(TIPO_REPOSITORIO repositorio){
		if (logger.isDebugEnabled()) {
			logger.debug("getMemoriaDao(TIPO_REPOSITORIO repositorio={}) - start", repositorio); //$NON-NLS-1$
		}

		Dao repo=null;
		
		switch(repositorio){
			case AUTORES:
				repo = RepositorioAutoresMemoriaDao.getInstance();
				break;
			case CATEGORIAS_LIBROS:
				repo = RepositorioCategoriasLibrosMemoriaDao.getInstance();
				break;
			case CATEGORIAS:
				repo = RepositorioCategoriasMemoriaDao.getInstance();
				break;
			case LIBROS_AUTORES:
				repo = RepositorioLibrosAutoresMemoriaDao.getInstance();
				break;
			case LIBROS:
				repo = RepositorioLibrosMemoriaDao.getInstance();
				break;
			case PERSONAS:
				repo = RepositorioPersonasMemoriaDao.getInstance();
				break;
			case PRESTAMOS:
				repo = RepositorioPrestamosMemoriaDao.getInstance();
				break;
			}

		if (logger.isDebugEnabled()) {
			logger.debug("getMemoriaDao(TIPO_REPOSITORIO repositorio={}) - end - return value={}", repositorio, repo); //$NON-NLS-1$
		}
		return repo;
	}
}
