package com.wpsnetwork.dao.entidades;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Libro {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Libro.class.getName());

	private int id;
	private String titulo;
	private int paginas;
	private String editorial;
	private String edicion;
	
	public Libro() {
		this(1, "", 0, "", "");
		if (logger.isDebugEnabled()) {
			logger.debug("Libro() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Libro() - end"); //$NON-NLS-1$
		}
	}
	public Libro(int id, String titulo, int paginas, String editorial, String edicion) {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("Libro(int id={}, String titulo={}, int paginas={}, String editorial={}, String edicion={}) - start", id, titulo, paginas, editorial, edicion); //$NON-NLS-1$
		}

		setId(id);
		setTitulo(titulo);
		setPaginas(paginas);
		setEditorial(editorial);
		setEdicion(edicion);

		if (logger.isDebugEnabled()) {
			logger.debug("Libro(int id={}, String titulo={}, int paginas={}, String editorial={}, String edicion={}) - end", id, titulo, paginas, editorial, edicion); //$NON-NLS-1$
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
	public String getTitulo() {
		if (logger.isDebugEnabled()) {
			logger.debug("getTitulo() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getTitulo() - end - return value={}", titulo); //$NON-NLS-1$
		}
		return titulo;
	}
	public void setTitulo(String titulo) {
		if (logger.isDebugEnabled()) {
			logger.debug("setTitulo(String titulo={}) - start", titulo); //$NON-NLS-1$
		}

		this.titulo = titulo;

		if (logger.isDebugEnabled()) {
			logger.debug("setTitulo(String titulo={}) - end", titulo); //$NON-NLS-1$
		}
	}
	public int getPaginas() {
		if (logger.isDebugEnabled()) {
			logger.debug("getPaginas() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getPaginas() - end - return value={}", paginas); //$NON-NLS-1$
		}
		return paginas;
	}
	public void setPaginas(int paginas) {
		if (logger.isDebugEnabled()) {
			logger.debug("setPaginas(int paginas={}) - start", paginas); //$NON-NLS-1$
		}

		this.paginas = paginas;

		if (logger.isDebugEnabled()) {
			logger.debug("setPaginas(int paginas={}) - end", paginas); //$NON-NLS-1$
		}
	}
	public String getEditorial() {
		if (logger.isDebugEnabled()) {
			logger.debug("getEditorial() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getEditorial() - end - return value={}", editorial); //$NON-NLS-1$
		}
		return editorial;
	}
	public void setEditorial(String editorial) {
		if (logger.isDebugEnabled()) {
			logger.debug("setEditorial(String editorial={}) - start", editorial); //$NON-NLS-1$
		}

		this.editorial = editorial;

		if (logger.isDebugEnabled()) {
			logger.debug("setEditorial(String editorial={}) - end", editorial); //$NON-NLS-1$
		}
	}
	public String getEdicion() {
		if (logger.isDebugEnabled()) {
			logger.debug("getEdicion() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getEdicion() - end - return value={}", edicion); //$NON-NLS-1$
		}
		return edicion;
	}
	public void setEdicion(String edicion) {
		if (logger.isDebugEnabled()) {
			logger.debug("setEdicion(String edicion={}) - start", edicion); //$NON-NLS-1$
		}

		this.edicion = edicion;

		if (logger.isDebugEnabled()) {
			logger.debug("setEdicion(String edicion={}) - end", edicion); //$NON-NLS-1$
		}
	}
	@Override
	public String toString() {
		if (logger.isDebugEnabled()) {
			logger.debug("toString() - start"); //$NON-NLS-1$
		}

		String returnString = "Libro [id=" + id + ", titulo=" + titulo + ", paginas=" + paginas + ", editorial=" + editorial + ", edicion=" + edicion + "]";
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

		boolean returnboolean = this.id == ((Libro) obj).id;
		if (logger.isDebugEnabled()) {
			logger.debug("equals(Object obj={}) - end - return value={}", obj, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}
