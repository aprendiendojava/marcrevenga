package com.wpsnetwork.dao.entidades;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LibroAutor {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(LibroAutor.class.getName());

	private int id;
	private int libro;
	private int autor;
	
	public LibroAutor() {
		this(1,0,0);
		if (logger.isDebugEnabled()) {
			logger.debug("LibroAutor() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("LibroAutor() - end"); //$NON-NLS-1$
		}
	}
	
	public LibroAutor(int id, int libro, int autor) {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("LibroAutor(int id={}, int libro={}, int autor={}) - start", id, libro, autor); //$NON-NLS-1$
		}

		setId(id);
		setLibro(libro);
		setAutor(autor);

		if (logger.isDebugEnabled()) {
			logger.debug("LibroAutor(int id={}, int libro={}, int autor={}) - end", id, libro, autor); //$NON-NLS-1$
		}
	}

	public int getId() {
		if (logger.isDebugEnabled()) {
			logger.debug("getId() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getId() - end - return value={}", id); //$NON-NLS-1$
		}
		return id;
	}

	public void setId(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("setId(int id={}) - start", id); //$NON-NLS-1$
		}

		if(id < 1) {
			if (logger.isErrorEnabled()) logger.error("El id no tiene un valor válido: setId(int id={})",id);
			throw new RuntimeException("El id no tiene un valor válido");
		}
		
		this.id = id;

		if (logger.isDebugEnabled()) {
			logger.debug("setId(int id={}) - end", id); //$NON-NLS-1$
		}
	}

	public int getLibro() {
		if (logger.isDebugEnabled()) {
			logger.debug("getLibro() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getLibro() - end - return value={}", libro); //$NON-NLS-1$
		}
		return libro;
	}

	public void setLibro(int libro) {
		if (logger.isDebugEnabled()) {
			logger.debug("setLibro(int libro={}) - start", libro); //$NON-NLS-1$
		}

		this.libro = libro;

		if (logger.isDebugEnabled()) {
			logger.debug("setLibro(int libro={}) - end", libro); //$NON-NLS-1$
		}
	}

	public int getAutor() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAutor() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getAutor() - end - return value={}", autor); //$NON-NLS-1$
		}
		return autor;
	}

	public void setAutor(int autor) {
		if (logger.isDebugEnabled()) {
			logger.debug("setAutor(int autor={}) - start", autor); //$NON-NLS-1$
		}

		this.autor = autor;

		if (logger.isDebugEnabled()) {
			logger.debug("setAutor(int autor={}) - end", autor); //$NON-NLS-1$
		}
	}

	@Override
	public String toString() {
		if (logger.isDebugEnabled()) {
			logger.debug("toString() - start"); //$NON-NLS-1$
		}

		String returnString = "LibrosAutores [id=" + id + ", libro=" + libro + ", autor=" + autor + "]";
		if (logger.isDebugEnabled()) {
			logger.debug("toString() - end - return value={}", returnString); //$NON-NLS-1$
		}
		return returnString;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (logger.isDebugEnabled()) {
			logger.debug("equals(Object obj={}) - start", obj); //$NON-NLS-1$
		}

		boolean returnboolean = this.id == ((LibroAutor) obj).id;
		if (logger.isDebugEnabled()) {
			logger.debug("equals(Object obj={}) - end - return value={}", obj, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}
