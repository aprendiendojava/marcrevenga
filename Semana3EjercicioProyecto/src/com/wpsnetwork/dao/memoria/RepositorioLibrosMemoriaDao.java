package com.wpsnetwork.dao.memoria;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Libro;
import com.wpsnetwork.dao.interfaces.DaoLibros;

public class RepositorioLibrosMemoriaDao  implements DaoLibros {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(RepositorioLibrosMemoriaDao.class.getName());

	static private List<Libro> libros = new ArrayList<>();
	static private RepositorioLibrosMemoriaDao instancia = new RepositorioLibrosMemoriaDao();
	
	static{
		libros.add(new Libro(1, "Libro 1 Autor 1", 100, "Editorial 1", "Primera edición"));
		libros.add(new Libro(2, "Libro 2 Autor 1", 200, "Editorial 2", "Segunda edición"));
		libros.add(new Libro(3, "Libro 1 Autor 2", 300, "Editorial 3", "Tercera edición"));
		libros.add(new Libro(4, "Libro 1 Autor 3", 400, "Editorial 4", "Cuarta edición"));
	}
	
	
	
	private RepositorioLibrosMemoriaDao() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioLibrosMemoriaDao() - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated constructor stub

		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioLibrosMemoriaDao() - end"); //$NON-NLS-1$
		}
	}
	
	public static RepositorioLibrosMemoriaDao getInstance(){
		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - end - return value={}", instancia); //$NON-NLS-1$
		}
		return instancia;
	}

	@Override
	public Libro get(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - start", id); //$NON-NLS-1$
		}

		Libro returnLibro = libros.stream().filter(libro -> libro.getId() == id).findFirst().orElse(null);
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - end - return value={}", id, returnLibro); //$NON-NLS-1$
		}
		return returnLibro;
	}

	@Override
	public void insert(Libro elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(Libro elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && !existe(elemento))
			libros.add(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("insert(Libro elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void update(Libro elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(Libro elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && existe(elemento)){
			Libro l = get(elemento.getId());
			l.setTitulo(elemento.getTitulo());
			l.setPaginas(elemento.getPaginas());
			l.setEditorial(elemento.getEditorial());
			l.setEdicion(elemento.getEdicion());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(Libro elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void delete(Libro elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(Libro elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null)
			libros.remove(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("delete(Libro elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public List<Libro> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - start"); //$NON-NLS-1$
		}

		List<Libro> returnList = new ArrayList<>(libros);
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - end - return value={}", returnList); //$NON-NLS-1$
		}
		return returnList;
	}
	
	private boolean existe(Libro elemento){
		if (logger.isDebugEnabled()) {
			logger.debug("existe(Libro elemento={}) - start", elemento); //$NON-NLS-1$
		}

		boolean returnboolean = get(elemento.getId()) != null;
		if (logger.isDebugEnabled()) {
			logger.debug("existe(Libro elemento={}) - end - return value={}", elemento, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}