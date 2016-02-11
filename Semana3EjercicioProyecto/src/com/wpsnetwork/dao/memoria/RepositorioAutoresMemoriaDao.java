package com.wpsnetwork.dao.memoria;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Autor;
import com.wpsnetwork.dao.interfaces.DaoAutores;

public class RepositorioAutoresMemoriaDao implements DaoAutores {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(RepositorioAutoresMemoriaDao.class.getName());

	static private List<Autor> autores = new ArrayList<>();
	static private RepositorioAutoresMemoriaDao instancia = new RepositorioAutoresMemoriaDao();
	
	static{
		autores.add(new Autor(1, "Autor 1"));
		autores.add(new Autor(2, "Autor 2"));
		autores.add(new Autor(3, "Autor 3"));
	}
	
	
	
	private RepositorioAutoresMemoriaDao() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioAutoresMemoriaDao() - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated constructor stub

		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioAutoresMemoriaDao() - end"); //$NON-NLS-1$
		}
	}
	
	public static RepositorioAutoresMemoriaDao getInstance(){
		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - end - return value={}", instancia); //$NON-NLS-1$
		}
		return instancia;
	}

	@Override
	public Autor get(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - start", id); //$NON-NLS-1$
		}

		Autor returnAutor = autores.stream().filter(autor -> autor.getId() == id).findFirst().orElse(null);
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - end - return value={}", id, returnAutor); //$NON-NLS-1$
		}
		return returnAutor;
	}

	@Override
	public void insert(Autor elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(Autor elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && !existe(elemento))
			autores.add(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("insert(Autor elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void update(Autor elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(Autor elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && existe(elemento)){
			Autor a = get(elemento.getId());
			a.setNombre(elemento.getNombre());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(Autor elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void delete(Autor elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(Autor elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null)
			autores.remove(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("delete(Autor elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public List<Autor> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - start"); //$NON-NLS-1$
		}

		List<Autor> returnList = new ArrayList<>(autores);
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - end - return value={}", returnList); //$NON-NLS-1$
		}
		return returnList;
	}
	
	private boolean existe(Autor elemento){
		if (logger.isDebugEnabled()) {
			logger.debug("existe(Autor elemento={}) - start", elemento); //$NON-NLS-1$
		}

		boolean returnboolean = (get(elemento.getId()) != null);
		if (logger.isDebugEnabled()) {
			logger.debug("existe(Autor elemento={}) - end - return value={}", elemento, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}
