package com.wpsnetwork.dto.entidades;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Libro.class.getName());

	private com.wpsnetwork.dao.entidades.Libro libroDao;
	private List<Autor> autores;
	private List<Categoria> categorias;
	private List<Prestamo> prestamos;
	private String tipoAcceso;
	
	public Libro(String tipoAcceso) {
		this(0, "", 0, "", "", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), tipoAcceso);
		if (logger.isDebugEnabled()) {
			logger.debug("Libro() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Libro() - end"); //$NON-NLS-1$
		}
	}
	public Libro(int id, String titulo, int paginas, String editorial, String edicion,
			List<Autor> autores, List<Categoria> categorias, List<Prestamo> prestamos, String tipoAcceso) {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("Libro(int id={}, String titulo={}, int paginas={}, String editorial={}, String edicion={}, List<Autor> autores={}, List<Categoria> categorias={}, List<Prestamo> prestamos={}) - start", id, titulo, paginas, editorial, edicion, autores, categorias, prestamos); //$NON-NLS-1$
		}

		libroDao = new com.wpsnetwork.dao.entidades.Libro(); 
		setId(id);
		setTitulo(titulo);
		setPaginas(paginas);
		setEditorial(editorial);
		setEdicion(edicion);
		setAutores(autores);
		setCategorias(categorias);
		setPrestamos(prestamos);
		this.tipoAcceso = tipoAcceso;

		if (logger.isDebugEnabled()) {
			logger.debug("Libro(int id={}, String titulo={}, int paginas={}, String editorial={}, String edicion={}, List<Autor> autores={}, List<Categoria> categorias={}, List<Prestamo> prestamos={}) - end", id, titulo, paginas, editorial, edicion, autores, categorias, prestamos); //$NON-NLS-1$
		}
	}
	public int getId() {
		if (logger.isDebugEnabled()) {
			logger.debug("getId() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getId() - end - return value={}", libroDao.getId()); //$NON-NLS-1$
		}
		return libroDao.getId();
	}
	public void setId(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("setId(int id={}) - start", id); //$NON-NLS-1$
		}

		libroDao.setId(id);

		if (logger.isDebugEnabled()) {
			logger.debug("setId(int id={}) - end", id); //$NON-NLS-1$
		}
	}
	public String getTitulo() {
		if (logger.isDebugEnabled()) {
			logger.debug("getTitulo() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getTitulo() - end - return value={}", libroDao.getTitulo()); //$NON-NLS-1$
		}
		return libroDao.getTitulo();
	}
	public void setTitulo(String titulo) {
		if (logger.isDebugEnabled()) {
			logger.debug("setTitulo(String titulo={}) - start", titulo); //$NON-NLS-1$
		}

		libroDao.setTitulo(titulo);

		if (logger.isDebugEnabled()) {
			logger.debug("setTitulo(String titulo={}) - end", titulo); //$NON-NLS-1$
		}
	}
	public int getPaginas() {
		if (logger.isDebugEnabled()) {
			logger.debug("getPaginas() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getPaginas() - end - return value={}", libroDao.getPaginas()); //$NON-NLS-1$
		}
		return libroDao.getPaginas();
	}
	public void setPaginas(int paginas) {
		if (logger.isDebugEnabled()) {
			logger.debug("setPaginas(int paginas={}) - start", paginas); //$NON-NLS-1$
		}

		libroDao.setPaginas(paginas);

		if (logger.isDebugEnabled()) {
			logger.debug("setPaginas(int paginas={}) - end", paginas); //$NON-NLS-1$
		}
	}
	public String getEditorial() {
		if (logger.isDebugEnabled()) {
			logger.debug("getEditorial() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getEditorial() - end - return value={}", libroDao.getEditorial()); //$NON-NLS-1$
		}
		return libroDao.getEditorial();
	}
	public void setEditorial(String editorial) {
		if (logger.isDebugEnabled()) {
			logger.debug("setEditorial(String editorial={}) - start", editorial); //$NON-NLS-1$
		}

		libroDao.setEditorial(editorial);

		if (logger.isDebugEnabled()) {
			logger.debug("setEditorial(String editorial={}) - end", editorial); //$NON-NLS-1$
		}
	}
	public String getEdicion() {
		if (logger.isDebugEnabled()) {
			logger.debug("getEdicion() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getEdicion() - end - return value={}", libroDao.getEdicion()); //$NON-NLS-1$
		}
		return libroDao.getEdicion();
	}
	public void setEdicion(String edicion) {
		if (logger.isDebugEnabled()) {
			logger.debug("setEdicion(String edicion={}) - start", edicion); //$NON-NLS-1$
		}

		libroDao.setEdicion(edicion);

		if (logger.isDebugEnabled()) {
			logger.debug("setEdicion(String edicion={}) - end", edicion); //$NON-NLS-1$
		}
	}
	public List<Autor> getAutores() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAutores() - start"); //$NON-NLS-1$
		}
		
		if(autores == null)
			autores = Util.getAutoresLibro(libroDao, tipoAcceso);

		if (logger.isDebugEnabled()) {
			logger.debug("getAutores() - end - return value={}", autores); //$NON-NLS-1$
		}
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		if (logger.isDebugEnabled()) {
			logger.debug("setAutores(List<Autor> autores={}) - start", autores); //$NON-NLS-1$
		}

		this.autores = autores;

		if (logger.isDebugEnabled()) {
			logger.debug("setAutores(List<Autor> autores={}) - end", autores); //$NON-NLS-1$
		}
	}
	public List<Categoria> getCategorias() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCategorias() - start"); //$NON-NLS-1$
		}

		if(categorias == null)
			categorias = Util.getCategoriasLibro(libroDao, tipoAcceso);
		
		if (logger.isDebugEnabled()) {
			logger.debug("getCategorias() - end - return value={}", categorias); //$NON-NLS-1$
		}
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCategorias(List<Categoria> categorias={}) - start", categorias); //$NON-NLS-1$
		}

		this.categorias = categorias;

		if (logger.isDebugEnabled()) {
			logger.debug("setCategorias(List<Categoria> categorias={}) - end", categorias); //$NON-NLS-1$
		}
	}
	public List<Prestamo> getPrestamos() {
		if (logger.isDebugEnabled()) {
			logger.debug("getPrestamos() - start"); //$NON-NLS-1$
		}
		
		if(prestamos == null)
			prestamos= Util.getPrestamosLibro(libroDao, tipoAcceso);

		if (logger.isDebugEnabled()) {
			logger.debug("getPrestamos() - end - return value={}", prestamos); //$NON-NLS-1$
		}
		return prestamos;
	}
	public void setPrestamos(List<Prestamo> prestamos) {
		if (logger.isDebugEnabled()) {
			logger.debug("setPrestamos(List<Prestamo> prestamos={}) - start", prestamos); //$NON-NLS-1$
		}

		this.prestamos = prestamos;

		if (logger.isDebugEnabled()) {
			logger.debug("setPrestamos(List<Prestamo> prestamos={}) - end", prestamos); //$NON-NLS-1$
		}
	}
}
