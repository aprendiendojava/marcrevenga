package com.wpsnetwork.dao.entidades;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Autor {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Autor.class.getName());

	private int id;
	private String nombre;
	
	public Autor() {
		this(1,"");
		if (logger.isDebugEnabled()) {
			logger.debug("Autor() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Autor() - end"); //$NON-NLS-1$
		}
	}

	public Autor(int id, String nombre) {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("Autor(int id={}, String nombre={}) - start", id, nombre); //$NON-NLS-1$
		}

		setId(id);
		setNombre(nombre);

		if (logger.isDebugEnabled()) {
			logger.debug("Autor(int id={}, String nombre={}) - end", id, nombre); //$NON-NLS-1$
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

	public String getNombre() {
		if (logger.isDebugEnabled()) {
			logger.debug("getNombre() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getNombre() - end - return value={}", nombre); //$NON-NLS-1$
		}
		return nombre;
	}

	public void setNombre(String nombre) {
		if (logger.isDebugEnabled()) {
			logger.debug("setNombre(String nombre={}) - start", nombre); //$NON-NLS-1$
		}

		this.nombre = nombre;

		if (logger.isDebugEnabled()) {
			logger.debug("setNombre(String nombre={}) - end", nombre); //$NON-NLS-1$
		}
	}

	@Override
	public String toString() {
		if (logger.isDebugEnabled()) {
			logger.debug("toString() - start"); //$NON-NLS-1$
		}

		String returnString = "Autor [id=" + id + ", nombre=" + nombre + "]";
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

		boolean returnboolean = this.id == ((Autor) obj).id;
		if (logger.isDebugEnabled()) {
			logger.debug("equals(Object obj={}) - end - return value={}", obj, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
	
	
}
