package com.wpsnetwork.dao.memoria;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.CategoriaLibro;
import com.wpsnetwork.dao.interfaces.DaoCategoriasLibros;

public class RepositorioCategoriasLibrosMemoriaDao implements DaoCategoriasLibros {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(RepositorioCategoriasLibrosMemoriaDao.class.getName());

	static private List<CategoriaLibro> categoriasLibros = new ArrayList<>();
	static private RepositorioCategoriasLibrosMemoriaDao instancia = new RepositorioCategoriasLibrosMemoriaDao();
	
	static{
		categoriasLibros.add(new CategoriaLibro(1, 1, 1));
		categoriasLibros.add(new CategoriaLibro(2, 2, 2));
		categoriasLibros.add(new CategoriaLibro(3, 2, 1));
		categoriasLibros.add(new CategoriaLibro(4, 1, 3));
		categoriasLibros.add(new CategoriaLibro(5, 2, 4));
	}
	
	private RepositorioCategoriasLibrosMemoriaDao() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioCategoriasLibrosMemoriaDao() - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated constructor stub

		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioCategoriasLibrosMemoriaDao() - end"); //$NON-NLS-1$
		}
	}
	
	public static RepositorioCategoriasLibrosMemoriaDao getInstance(){
		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - end - return value={}", instancia); //$NON-NLS-1$
		}
		return instancia;
	}

	@Override
	public CategoriaLibro get(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - start", id); //$NON-NLS-1$
		}

		CategoriaLibro returnCategoriaLibro = categoriasLibros.stream().filter(cat -> cat.getId() == id).findFirst().orElse(null);
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - end - return value={}", id, returnCategoriaLibro); //$NON-NLS-1$
		}
		return returnCategoriaLibro;
	}

	@Override
	public void insert(CategoriaLibro elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(CategoriaLibro elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && !existe(elemento))
			categoriasLibros.add(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("insert(CategoriaLibro elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void update(CategoriaLibro elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(CategoriaLibro elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && existe(elemento)){
			CategoriaLibro c = get(elemento.getId());
			c.setCategoria(elemento.getCategoria());
			c.setLibro(elemento.getLibro());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(CategoriaLibro elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void delete(CategoriaLibro elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(CategoriaLibro elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null)
			categoriasLibros.remove(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("delete(CategoriaLibro elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public List<CategoriaLibro> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - start"); //$NON-NLS-1$
		}

		List<CategoriaLibro> returnList = new ArrayList<>(categoriasLibros);
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - end - return value={}", returnList); //$NON-NLS-1$
		}
		return returnList;
	}
	
	private boolean existe(CategoriaLibro elemento){
		if (logger.isDebugEnabled()) {
			logger.debug("existe(CategoriaLibro elemento={}) - start", elemento); //$NON-NLS-1$
		}

		boolean returnboolean = get(elemento.getId()) != null;
		if (logger.isDebugEnabled()) {
			logger.debug("existe(CategoriaLibro elemento={}) - end - return value={}", elemento, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}