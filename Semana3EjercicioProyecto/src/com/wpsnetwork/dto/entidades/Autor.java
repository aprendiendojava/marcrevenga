package com.wpsnetwork.dto.entidades;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class Autor {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Autor.class.getName());

	private com.wpsnetwork.dao.entidades.Autor autorDao;
	private List<Libro> libros;
	private String tipoAcceso;

	public Autor(String tipoAcceso) {
		this(0,"", new ArrayList<>(), tipoAcceso);
		if (logger.isDebugEnabled()) {
			logger.debug("Autor() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Autor() - end"); //$NON-NLS-1$
		}
	}

	public Autor(int id, String nombre, List<Libro> libros, String tipoAcceso) {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("Autor(int id={}, String nombre={}, List<Libro> libros={}) - start", id, nombre, libros); //$NON-NLS-1$
		}
		autorDao = new com.wpsnetwork.dao.entidades.Autor();
		setId(id);
		setNombre(nombre);
		setLibros(libros);
		this.tipoAcceso = tipoAcceso;

		if (logger.isDebugEnabled()) {
			logger.debug("Autor(int id={}, String nombre={}, List<Libro> libros={}) - end", id, nombre, libros); //$NON-NLS-1$
		}
	}

	public int getId() {
		if (logger.isDebugEnabled()) {
			logger.debug("getId() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getId() - end - return value={}", autorDao.getId()); //$NON-NLS-1$
		}
		return autorDao.getId();
	}

	public void setId(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("setId(int id={}) - start", id); //$NON-NLS-1$
		}

		autorDao.setId(id);

		if (logger.isDebugEnabled()) {
			logger.debug("setId(int id={}) - end", id); //$NON-NLS-1$
		}
	}

	public String getNombre() {
		if (logger.isDebugEnabled()) {
			logger.debug("getNombre() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getNombre() - end - return value={}", autorDao.getNombre()); //$NON-NLS-1$
		}
		return autorDao.getNombre();
	}

	public void setNombre(String nombre) {
		if (logger.isDebugEnabled()) {
			logger.debug("setNombre(String nombre={}) - start", nombre); //$NON-NLS-1$
		}

		autorDao.setNombre(nombre);

		if (logger.isDebugEnabled()) {
			logger.debug("setNombre(String nombre={}) - end", nombre); //$NON-NLS-1$
		}
	}

	public List<Libro> getLibros() {
		if (logger.isDebugEnabled()) {
			logger.debug("getLibros() - start"); //$NON-NLS-1$
		}
		
		if(libros == null)
			libros = Util.getLibrosAutor(autorDao, tipoAcceso);

		if (logger.isDebugEnabled()) {
			logger.debug("getLibros() - end - return value={}", libros); //$NON-NLS-1$
		}
		return libros; 
	}

	public void setLibros(List<Libro> libros) {
		if (logger.isDebugEnabled()) {
			logger.debug("setLibros(List<Libro> libros={}) - start", libros); //$NON-NLS-1$
		}

		this.libros = libros;

		if (logger.isDebugEnabled()) {
			logger.debug("setLibros(List<Libro> libros={}) - end", libros); //$NON-NLS-1$
		}
	}
}
