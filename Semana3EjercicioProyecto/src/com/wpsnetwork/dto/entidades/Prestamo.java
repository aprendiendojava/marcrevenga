package com.wpsnetwork.dto.entidades;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDate;

public class Prestamo {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Prestamo.class.getName());

	private com.wpsnetwork.dao.entidades.Prestamo prestamoDao;
	private Libro libro;
	private Persona persona;
	private String tipoAcceso;
	
	public Prestamo(String tipoAcceso) {
		this(0, LocalDate.now(), LocalDate.now(), false, null, null, tipoAcceso);
		if (logger.isDebugEnabled()) {
			logger.debug("Prestamo() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Prestamo() - end"); //$NON-NLS-1$
		}
	}

	public Prestamo(int id, LocalDate fechaInicio, LocalDate fechaFin, boolean devuelto, Libro libro, Persona persona, String tipoAcceso) {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("Prestamo(int id={}, LocalDate fechaInicio={}, LocalDate fechaFin={}, boolean devuelto={}, Libro libro={}, Persona persona={}) - start", id, fechaInicio, fechaFin, devuelto, libro, persona); //$NON-NLS-1$
		}

		prestamoDao = new com.wpsnetwork.dao.entidades.Prestamo();
		setId(id);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setDevuelto(devuelto);
		setLibro(libro);
		setPersona(persona);
		this.tipoAcceso = tipoAcceso;

		if (logger.isDebugEnabled()) {
			logger.debug("Prestamo(int id={}, LocalDate fechaInicio={}, LocalDate fechaFin={}, boolean devuelto={}, Libro libro={}, Persona persona={}) - end", id, fechaInicio, fechaFin, devuelto, libro, persona); //$NON-NLS-1$
		}
	}

	public int getId() {
		if (logger.isDebugEnabled()) {
			logger.debug("getId() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getId() - end - return value={}", prestamoDao.getId()); //$NON-NLS-1$
		}
		return prestamoDao.getId();
	}

	public void setId(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("setId(int id={}) - start", id); //$NON-NLS-1$
		}

		prestamoDao.setId(id);

		if (logger.isDebugEnabled()) {
			logger.debug("setId(int id={}) - end", id); //$NON-NLS-1$
		}
	}

	public LocalDate getFechaInicio() {
		if (logger.isDebugEnabled()) {
			logger.debug("getFechaInicio() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getFechaInicio() - end - return value={}", prestamoDao.getFechaInicio()); //$NON-NLS-1$
		}
		return prestamoDao.getFechaInicio();
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		if (logger.isDebugEnabled()) {
			logger.debug("setFechaInicio(LocalDate fechaInicio={}) - start", fechaInicio); //$NON-NLS-1$
		}

		prestamoDao.setFechaInicio(fechaInicio);

		if (logger.isDebugEnabled()) {
			logger.debug("setFechaInicio(LocalDate fechaInicio={}) - end", fechaInicio); //$NON-NLS-1$
		}
	}

	public LocalDate getFechaFin() {
		if (logger.isDebugEnabled()) {
			logger.debug("getFechaFin() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getFechaFin() - end - return value={}", prestamoDao.getFechaFin()); //$NON-NLS-1$
		}
		return prestamoDao.getFechaFin();
	}

	public void setFechaFin(LocalDate fechaFin) {
		if (logger.isDebugEnabled()) {
			logger.debug("setFechaFin(LocalDate fechaFin={}) - start", fechaFin); //$NON-NLS-1$
		}

		prestamoDao.setFechaFin(fechaFin);

		if (logger.isDebugEnabled()) {
			logger.debug("setFechaFin(LocalDate fechaFin={}) - end", fechaFin); //$NON-NLS-1$
		}
	}

	public boolean isDevuelto() {
		if (logger.isDebugEnabled()) {
			logger.debug("isDevuelto() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("isDevuelto() - end - return value={}", prestamoDao.isDevuelto()); //$NON-NLS-1$
		}
		return prestamoDao.isDevuelto();
	}

	public void setDevuelto(boolean devuelto) {
		if (logger.isDebugEnabled()) {
			logger.debug("setDevuelto(boolean devuelto={}) - start", devuelto); //$NON-NLS-1$
		}

		prestamoDao.setDevuelto(devuelto);

		if (logger.isDebugEnabled()) {
			logger.debug("setDevuelto(boolean devuelto={}) - end", devuelto); //$NON-NLS-1$
		}
	}

	public Libro getLibro() {
		if (logger.isDebugEnabled()) {
			logger.debug("getLibro() - start"); //$NON-NLS-1$
		}
		
		if(libro == null)
			libro = Util.getLibroPrestamo(prestamoDao, tipoAcceso);

		if (logger.isDebugEnabled()) {
			logger.debug("getLibro() - end - return value={}", libro); //$NON-NLS-1$
		}
		return libro;
	}

	public void setLibro(Libro libro) {
		if (logger.isDebugEnabled()) {
			logger.debug("setLibro(Libro libro={}) - start", libro); //$NON-NLS-1$
		}

		this.libro = libro;

		if (logger.isDebugEnabled()) {
			logger.debug("setLibro(Libro libro={}) - end", libro); //$NON-NLS-1$
		}
	}

	public Persona getPersona() {
		if (logger.isDebugEnabled()) {
			logger.debug("getPersona() - start"); //$NON-NLS-1$
		}
		
		if(persona == null)
			persona = Util.getPersonaPrestamo(prestamoDao, tipoAcceso);

		if (logger.isDebugEnabled()) {
			logger.debug("getPersona() - end - return value={}", persona); //$NON-NLS-1$
		}
		return persona;
	}

	public void setPersona(Persona persona) {
		if (logger.isDebugEnabled()) {
			logger.debug("setPersona(Persona persona={}) - start", persona); //$NON-NLS-1$
		}

		this.persona = persona;

		if (logger.isDebugEnabled()) {
			logger.debug("setPersona(Persona persona={}) - end", persona); //$NON-NLS-1$
		}
	}
}
