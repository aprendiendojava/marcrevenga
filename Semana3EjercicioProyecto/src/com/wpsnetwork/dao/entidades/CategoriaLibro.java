package com.wpsnetwork.dao.entidades;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CategoriaLibro {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(CategoriaLibro.class.getName());

	private int id;
	private int categoria;
	private int libro;
	
	public CategoriaLibro() {
		this(1,0,0);
		if (logger.isDebugEnabled()) {
			logger.debug("CategoriaLibro() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("CategoriaLibro() - end"); //$NON-NLS-1$
		}
	}
	
	public CategoriaLibro(int id, int categoria, int libro) {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("CategoriaLibro(int id={}, int categoria={}, int libro={}) - start", id, categoria, libro); //$NON-NLS-1$
		}

		setId(id);
		setCategoria(categoria);
		setLibro(libro);

		if (logger.isDebugEnabled()) {
			logger.debug("CategoriaLibro(int id={}, int categoria={}, int libro={}) - end", id, categoria, libro); //$NON-NLS-1$
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

	public int getCategoria() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCategoria() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getCategoria() - end - return value={}", categoria); //$NON-NLS-1$
		}
		return categoria;
	}

	public void setCategoria(int categoria) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCategoria(int categoria={}) - start", categoria); //$NON-NLS-1$
		}

		this.categoria = categoria;

		if (logger.isDebugEnabled()) {
			logger.debug("setCategoria(int categoria={}) - end", categoria); //$NON-NLS-1$
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

	@Override
	public String toString() {
		if (logger.isDebugEnabled()) {
			logger.debug("toString() - start"); //$NON-NLS-1$
		}

		String returnString = "CategoriaLibro [id=" + id + ", categoria=" + categoria + ", libro=" + libro + "]";
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

		boolean returnboolean = this.id == ((CategoriaLibro) obj).id;
		if (logger.isDebugEnabled()) {
			logger.debug("equals(Object obj={}) - end - return value={}", obj, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}
