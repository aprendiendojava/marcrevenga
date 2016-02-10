package com.wpsnetwork.dao.memoria;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Prestamo;
import com.wpsnetwork.dao.interfaces.DaoPrestamos;

public class RepositorioPrestamosMemoriaDao implements DaoPrestamos {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(RepositorioPrestamosMemoriaDao.class.getName());

	static private List<Prestamo> prestamos = new ArrayList<>();
	static private RepositorioPrestamosMemoriaDao instancia = new RepositorioPrestamosMemoriaDao();
	
	static{
		prestamos.add(new Prestamo(1,LocalDate.of(2001, Month.JANUARY, 1), LocalDate.of(2001, Month.JANUARY, 20),true, 1,1));
		prestamos.add(new Prestamo(2,LocalDate.of(2002, Month.JANUARY, 2), LocalDate.of(2002, Month.JANUARY, 20),false, 2,1));
		prestamos.add(new Prestamo(3,LocalDate.of(2003, Month.JANUARY, 3), LocalDate.of(2003, Month.JANUARY, 20),true, 3,1));
		prestamos.add(new Prestamo(4,LocalDate.of(2004, Month.JANUARY, 4), LocalDate.of(2004, Month.JANUARY, 20),false, 4,2));
		prestamos.add(new Prestamo(5,LocalDate.of(2005, Month.JANUARY, 5), LocalDate.of(2005, Month.JANUARY, 20),true, 1,2));
		prestamos.add(new Prestamo(6,LocalDate.of(2006, Month.JANUARY, 6), LocalDate.of(2006, Month.JANUARY, 20),true, 3,1));
		prestamos.add(new Prestamo(7,LocalDate.of(2007, Month.JANUARY, 7), LocalDate.of(2007, Month.JANUARY, 20),false, 1,1));
	}
	
	private RepositorioPrestamosMemoriaDao() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioPrestamosMemoriaDao() - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated constructor stub

		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioPrestamosMemoriaDao() - end"); //$NON-NLS-1$
		}
	}
	
	public static RepositorioPrestamosMemoriaDao getInstance(){
		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - end - return value={}", instancia); //$NON-NLS-1$
		}
		return instancia;
	}

	@Override
	public Prestamo get(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - start", id); //$NON-NLS-1$
		}

		Prestamo returnPrestamo = prestamos.stream().filter(prestamo -> prestamo.getId() == id).findFirst().orElse(null);
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - end - return value={}", id, returnPrestamo); //$NON-NLS-1$
		}
		return returnPrestamo;
	}

	@Override
	public void insert(Prestamo elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(Prestamo elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && !existe(elemento))
			prestamos.add(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("insert(Prestamo elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void update(Prestamo elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(Prestamo elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && existe(elemento)){
			Prestamo p = get(elemento.getId());
			p.setFechaInicio(elemento.getFechaInicio());
			p.setFechaFin(elemento.getFechaFin());
			p.setDevuelto(elemento.isDevuelto());
			p.setLibro(elemento.getLibro());
			p.setPersona(elemento.getPersona());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(Prestamo elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void delete(Prestamo elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(Prestamo elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null)
			prestamos.remove(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("delete(Prestamo elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public List<Prestamo> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - start"); //$NON-NLS-1$
		}

		List<Prestamo> returnList = new ArrayList<>(prestamos);
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - end - return value={}", returnList); //$NON-NLS-1$
		}
		return returnList;
	}
	
	private boolean existe(Prestamo elemento){
		if (logger.isDebugEnabled()) {
			logger.debug("existe(Prestamo elemento={}) - start", elemento); //$NON-NLS-1$
		}

		boolean returnboolean = get(elemento.getId()) != null;
		if (logger.isDebugEnabled()) {
			logger.debug("existe(Prestamo elemento={}) - end - return value={}", elemento, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}