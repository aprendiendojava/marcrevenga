package com.wpsnetwork.dao.memoria;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Categoria;
import com.wpsnetwork.dao.interfaces.DaoCategorias;

public class RepositorioCategoriasMemoriaDao implements DaoCategorias {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(RepositorioCategoriasMemoriaDao.class.getName());

	static private List<Categoria> categorias = new ArrayList<>();
	static private RepositorioCategoriasMemoriaDao instancia = new RepositorioCategoriasMemoriaDao();
	
	static{
		categorias.add(new Categoria(1, "Categoria 1"));
		categorias.add(new Categoria(2, "Categoria 2"));
	}
	
	private RepositorioCategoriasMemoriaDao() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioCategoriasMemoriaDao() - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated constructor stub

		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioCategoriasMemoriaDao() - end"); //$NON-NLS-1$
		}
	}
	
	public static RepositorioCategoriasMemoriaDao getInstance(){
		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - end - return value={}", instancia); //$NON-NLS-1$
		}
		return instancia;
	}

	@Override
	public Categoria get(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - start", id); //$NON-NLS-1$
		}

		Categoria returnCategoria = categorias.stream().filter(cat -> cat.getId() == id).findFirst().orElse(null);
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - end - return value={}", id, returnCategoria); //$NON-NLS-1$
		}
		return returnCategoria;
	}

	@Override
	public void insert(Categoria elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(Categoria elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && !existe(elemento))
			categorias.add(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("insert(Categoria elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void update(Categoria elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(Categoria elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && existe(elemento)){
			Categoria c = get(elemento.getId());
			c.setNombre(elemento.getNombre());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(Categoria elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void delete(Categoria elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(Categoria elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null)
			categorias.remove(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("delete(Categoria elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public List<Categoria> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - start"); //$NON-NLS-1$
		}

		List<Categoria> returnList = new ArrayList<>(categorias);
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - end - return value={}", returnList); //$NON-NLS-1$
		}
		return returnList;
	}
	
	private boolean existe(Categoria elemento){
		if (logger.isDebugEnabled()) {
			logger.debug("existe(Categoria elemento={}) - start", elemento); //$NON-NLS-1$
		}

		boolean returnboolean = get(elemento.getId()) != null;
		if (logger.isDebugEnabled()) {
			logger.debug("existe(Categoria elemento={}) - end - return value={}", elemento, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}