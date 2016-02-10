package com.wpsnetwork.dao.entidades;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDate;

public class Prestamo {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Prestamo.class.getName());

	private int id;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private boolean devuelto;
	private int libro;
	private int persona;
	
	public Prestamo() {
		this(1, LocalDate.now(), LocalDate.now(), false, 0, 0);
		if (logger.isDebugEnabled()) {
			logger.debug("Prestamo() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Prestamo() - end"); //$NON-NLS-1$
		}
	}

	public Prestamo(int id, LocalDate fechaInicio, LocalDate fechaFin, boolean devuelto, int libro, int persona) {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("Prestamo(int id={}, LocalDate fechaInicio={}, LocalDate fechaFin={}, boolean devuelto={}, int libro={}, int persona={}) - start", id, fechaInicio, fechaFin, devuelto, libro, persona); //$NON-NLS-1$
		}

		setId(id);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setDevuelto(devuelto);
		setLibro(libro);
		setPersona(persona);

		if (logger.isDebugEnabled()) {
			logger.debug("Prestamo(int id={}, LocalDate fechaInicio={}, LocalDate fechaFin={}, boolean devuelto={}, int libro={}, int persona={}) - end", id, fechaInicio, fechaFin, devuelto, libro, persona); //$NON-NLS-1$
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

	public LocalDate getFechaInicio() {
		if (logger.isDebugEnabled()) {
			logger.debug("getFechaInicio() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getFechaInicio() - end - return value={}", fechaInicio); //$NON-NLS-1$
		}
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		if (logger.isDebugEnabled()) {
			logger.debug("setFechaInicio(LocalDate fechaInicio={}) - start", fechaInicio); //$NON-NLS-1$
		}

		this.fechaInicio = fechaInicio;

		if (logger.isDebugEnabled()) {
			logger.debug("setFechaInicio(LocalDate fechaInicio={}) - end", fechaInicio); //$NON-NLS-1$
		}
	}

	public LocalDate getFechaFin() {
		if (logger.isDebugEnabled()) {
			logger.debug("getFechaFin() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getFechaFin() - end - return value={}", fechaFin); //$NON-NLS-1$
		}
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		if (logger.isDebugEnabled()) {
			logger.debug("setFechaFin(LocalDate fechaFin={}) - start", fechaFin); //$NON-NLS-1$
		}

		this.fechaFin = fechaFin;

		if (logger.isDebugEnabled()) {
			logger.debug("setFechaFin(LocalDate fechaFin={}) - end", fechaFin); //$NON-NLS-1$
		}
	}

	public boolean isDevuelto() {
		if (logger.isDebugEnabled()) {
			logger.debug("isDevuelto() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("isDevuelto() - end - return value={}", devuelto); //$NON-NLS-1$
		}
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		if (logger.isDebugEnabled()) {
			logger.debug("setDevuelto(boolean devuelto={}) - start", devuelto); //$NON-NLS-1$
		}

		this.devuelto = devuelto;

		if (logger.isDebugEnabled()) {
			logger.debug("setDevuelto(boolean devuelto={}) - end", devuelto); //$NON-NLS-1$
		}
	}

	public int getLibro() {
		if (logger.isDebugEnabled()) {
			logger.debug("getLibro() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getLibro() - end - return value={}", libro); //$NON-NLS-1$
		}
		return libro;
	}

	public void setLibro(int libro) {
		if (logger.isDebugEnabled()) {
			logger.debug("setLibro(int libro={}) - start", libro); //$NON-NLS-1$
		}

		this.libro = libro;

		if (logger.isDebugEnabled()) {
			logger.debug("setLibro(int libro={}) - end", libro); //$NON-NLS-1$
		}
	}

	public int getPersona() {
		if (logger.isDebugEnabled()) {
			logger.debug("getPersona() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getPersona() - end - return value={}", persona); //$NON-NLS-1$
		}
		return persona;
	}

	public void setPersona(int persona) {
		if (logger.isDebugEnabled()) {
			logger.debug("setPersona(int persona={}) - start", persona); //$NON-NLS-1$
		}

		this.persona = persona;

		if (logger.isDebugEnabled()) {
			logger.debug("setPersona(int persona={}) - end", persona); //$NON-NLS-1$
		}
	}

	@Override
	public String toString() {
		if (logger.isDebugEnabled()) {
			logger.debug("toString() - start"); //$NON-NLS-1$
		}

		String returnString = "Prestamo [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", devuelto=" + devuelto + ", libro=" + libro + ", persona=" + persona + "]";
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

		boolean returnboolean = this.id == ((Prestamo) obj).id;
		if (logger.isDebugEnabled()) {
			logger.debug("equals(Object obj={}) - end - return value={}", obj, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}
