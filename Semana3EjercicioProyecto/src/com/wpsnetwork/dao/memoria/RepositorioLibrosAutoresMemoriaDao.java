package com.wpsnetwork.dao.memoria;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.LibroAutor;
import com.wpsnetwork.dao.interfaces.DaoLibrosAutores;

public class RepositorioLibrosAutoresMemoriaDao implements DaoLibrosAutores {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(RepositorioLibrosAutoresMemoriaDao.class.getName());

	static private List<LibroAutor> librosAutores = new ArrayList<>();
	static private RepositorioLibrosAutoresMemoriaDao instancia = new RepositorioLibrosAutoresMemoriaDao();
	
	static{
		librosAutores.add(new LibroAutor(1, 1, 1));
		librosAutores.add(new LibroAutor(2, 2, 1));
		librosAutores.add(new LibroAutor(3, 3, 2));
		librosAutores.add(new LibroAutor(4, 4, 3));
	}
	
	private RepositorioLibrosAutoresMemoriaDao() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioLibrosAutoresMemoriaDao() - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated constructor stub

		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioLibrosAutoresMemoriaDao() - end"); //$NON-NLS-1$
		}
	}
	
	public static RepositorioLibrosAutoresMemoriaDao getInstance(){
		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - end - return value={}", instancia); //$NON-NLS-1$
		}
		return instancia;
	}

	@Override
	public LibroAutor get(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - start", id); //$NON-NLS-1$
		}

		LibroAutor returnLibroAutor = librosAutores.stream().filter(cat -> cat.getId() == id).findFirst().orElse(null);
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - end - return value={}", id, returnLibroAutor); //$NON-NLS-1$
		}
		return returnLibroAutor;
	}

	@Override
	public void insert(LibroAutor elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(LibroAutor elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && !existe(elemento))
			librosAutores.add(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("insert(LibroAutor elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void update(LibroAutor elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(LibroAutor elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && existe(elemento)){
			LibroAutor la = get(elemento.getId());
			la.setAutor(elemento.getAutor());
			la.setLibro(elemento.getLibro());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(LibroAutor elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void delete(LibroAutor elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(LibroAutor elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null)
			librosAutores.remove(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("delete(LibroAutor elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public List<LibroAutor> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - start"); //$NON-NLS-1$
		}

		List<LibroAutor> returnList = new ArrayList<>(librosAutores);
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - end - return value={}", returnList); //$NON-NLS-1$
		}
		return returnList;
	}
	
	private boolean existe(LibroAutor elemento){
		if (logger.isDebugEnabled()) {
			logger.debug("existe(LibroAutor elemento={}) - start", elemento); //$NON-NLS-1$
		}

		boolean returnboolean = get(elemento.getId()) != null;
		if (logger.isDebugEnabled()) {
			logger.debug("existe(LibroAutor elemento={}) - end - return value={}", elemento, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}