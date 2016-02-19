package com.wpsnetwork.dto.entidades;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Persona {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Persona.class.getName());

	private com.wpsnetwork.dao.entidades.Persona personaDao;
	private List<Prestamo> prestamos;
	private String tipoAcceso;
	
	public Persona(String tipoAcceso) {
		this(0, "", "", LocalDate.now(), "", "", "", "", "", "", new ArrayList<>(), tipoAcceso);
		if (logger.isDebugEnabled()) {
			logger.debug("Persona() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Persona() - end"); //$NON-NLS-1$
		}
	}

	public Persona(int id, String nombre, String dni, LocalDate fechaNacimiento, String direccion, String telefono,
			String pais, String provincia, String ciudad, String codigoPostal, List<Prestamo> prestamos, String tipoAcceso) {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("Persona(int id={}, String nombre={}, String dni={}, LocalDate fechaNacimiento={}, String direccion={}, String telefono={}, String pais={}, String provincia={}, String ciudad={}, String codigoPostal={}, List<Prestamo> prestamos={}) - start", id, nombre, dni, fechaNacimiento, direccion, telefono, pais, provincia, ciudad, codigoPostal, prestamos); //$NON-NLS-1$
		}

		personaDao = new com.wpsnetwork.dao.entidades.Persona(); 
		setId(id);
		setNombre(nombre);
		setDni(dni);
		setFechaNacimiento(fechaNacimiento);
		setDireccion(direccion);
		setTelefono(telefono);
		setPais(pais);
		setProvincia(provincia);
		setCiudad(ciudad);
		setCodigoPostal(codigoPostal);
		setPrestamos(prestamos);
		this.tipoAcceso = tipoAcceso;

		if (logger.isDebugEnabled()) {
			logger.debug("Persona(int id={}, String nombre={}, String dni={}, LocalDate fechaNacimiento={}, String direccion={}, String telefono={}, String pais={}, String provincia={}, String ciudad={}, String codigoPostal={}, List<Prestamo> prestamos={}) - end", id, nombre, dni, fechaNacimiento, direccion, telefono, pais, provincia, ciudad, codigoPostal, prestamos); //$NON-NLS-1$
		}
	}

	public int getId() {
		if (logger.isDebugEnabled()) {
			logger.debug("getId() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getId() - end - return value={}", personaDao.getId()); //$NON-NLS-1$
		}
		return personaDao.getId();
	}

	public void setId(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("setId(int id={}) - start", id); //$NON-NLS-1$
		}

		personaDao.setId(id);

		if (logger.isDebugEnabled()) {
			logger.debug("setId(int id={}) - end", id); //$NON-NLS-1$
		}
	}

	public String getNombre() {
		if (logger.isDebugEnabled()) {
			logger.debug("getNombre() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getNombre() - end - return value={}", personaDao.getNombre()); //$NON-NLS-1$
		}
		return personaDao.getNombre();
	}

	public void setNombre(String nombre) {
		if (logger.isDebugEnabled()) {
			logger.debug("setNombre(String nombre={}) - start", nombre); //$NON-NLS-1$
		}

		personaDao.setNombre(nombre);

		if (logger.isDebugEnabled()) {
			logger.debug("setNombre(String nombre={}) - end", nombre); //$NON-NLS-1$
		}
	}

	public String getDni() {
		if (logger.isDebugEnabled()) {
			logger.debug("getDni() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getDni() - end - return value={}", personaDao.getDni()); //$NON-NLS-1$
		}
		return personaDao.getDni();
	}

	public void setDni(String dni) {
		if (logger.isDebugEnabled()) {
			logger.debug("setDni(String dni={}) - start", dni); //$NON-NLS-1$
		}

		personaDao.setDni(dni);

		if (logger.isDebugEnabled()) {
			logger.debug("setDni(String dni={}) - end", dni); //$NON-NLS-1$
		}
	}

	public LocalDate getFechaNacimiento() {
		if (logger.isDebugEnabled()) {
			logger.debug("getFechaNacimiento() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getFechaNacimiento() - end - return value={}", personaDao.getFechaNacimiento()); //$NON-NLS-1$
		}
		return personaDao.getFechaNacimiento();
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (logger.isDebugEnabled()) {
			logger.debug("setFechaNacimiento(LocalDate fechaNacimiento={}) - start", fechaNacimiento); //$NON-NLS-1$
		}

		personaDao.setFechaNacimiento(fechaNacimiento);

		if (logger.isDebugEnabled()) {
			logger.debug("setFechaNacimiento(LocalDate fechaNacimiento={}) - end", fechaNacimiento); //$NON-NLS-1$
		}
	}

	public String getDireccion() {
		if (logger.isDebugEnabled()) {
			logger.debug("getDireccion() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getDireccion() - end - return value={}", personaDao.getDireccion()); //$NON-NLS-1$
		}
		return personaDao.getDireccion();
	}

	public void setDireccion(String direccion) {
		if (logger.isDebugEnabled()) {
			logger.debug("setDireccion(String direccion={}) - start", direccion); //$NON-NLS-1$
		}

		personaDao.setDireccion(direccion);

		if (logger.isDebugEnabled()) {
			logger.debug("setDireccion(String direccion={}) - end", direccion); //$NON-NLS-1$
		}
	}

	public String getTelefono() {
		if (logger.isDebugEnabled()) {
			logger.debug("getTelefono() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getTelefono() - end - return value={}", personaDao.getTelefono()); //$NON-NLS-1$
		}
		return personaDao.getTelefono();
	}

	public void setTelefono(String telefono) {
		if (logger.isDebugEnabled()) {
			logger.debug("setTelefono(String telefono={}) - start", telefono); //$NON-NLS-1$
		}

		personaDao.setTelefono(telefono);

		if (logger.isDebugEnabled()) {
			logger.debug("setTelefono(String telefono={}) - end", telefono); //$NON-NLS-1$
		}
	}

	public String getPais() {
		if (logger.isDebugEnabled()) {
			logger.debug("getPais() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getPais() - end - return value={}", personaDao.getPais()); //$NON-NLS-1$
		}
		return personaDao.getPais();
	}

	public void setPais(String pais) {
		if (logger.isDebugEnabled()) {
			logger.debug("setPais(String pais={}) - start", pais); //$NON-NLS-1$
		}

		personaDao.setPais(pais);

		if (logger.isDebugEnabled()) {
			logger.debug("setPais(String pais={}) - end", pais); //$NON-NLS-1$
		}
	}

	public String getProvincia() {
		if (logger.isDebugEnabled()) {
			logger.debug("getProvincia() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getProvincia() - end - return value={}", personaDao.getProvincia()); //$NON-NLS-1$
		}
		return personaDao.getProvincia();
	}

	public void setProvincia(String provincia) {
		if (logger.isDebugEnabled()) {
			logger.debug("setProvincia(String provincia={}) - start", provincia); //$NON-NLS-1$
		}

		personaDao.setProvincia(provincia);

		if (logger.isDebugEnabled()) {
			logger.debug("setProvincia(String provincia={}) - end", provincia); //$NON-NLS-1$
		}
	}

	public String getCiudad() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCiudad() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getCiudad() - end - return value={}", personaDao.getCiudad()); //$NON-NLS-1$
		}
		return personaDao.getCiudad();
	}

	public void setCiudad(String ciudad) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCiudad(String ciudad={}) - start", ciudad); //$NON-NLS-1$
		}

		personaDao.setCiudad(ciudad);

		if (logger.isDebugEnabled()) {
			logger.debug("setCiudad(String ciudad={}) - end", ciudad); //$NON-NLS-1$
		}
	}

	public String getCodigoPostal() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodigoPostal() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getCodigoPostal() - end - return value={}", personaDao.getCodigoPostal()); //$NON-NLS-1$
		}
		return personaDao.getCodigoPostal();
	}

	public void setCodigoPostal(String codigoPostal) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCodigoPostal(String codigoPostal={}) - start", codigoPostal); //$NON-NLS-1$
		}

		personaDao.setCodigoPostal(codigoPostal);

		if (logger.isDebugEnabled()) {
			logger.debug("setCodigoPostal(String codigoPostal={}) - end", codigoPostal); //$NON-NLS-1$
		}
	}

	public List<Prestamo> getPrestamos() {
		if (logger.isDebugEnabled()) {
			logger.debug("getPrestamos() - start"); //$NON-NLS-1$
		}

		if(prestamos == null)
			prestamos= Util.getPrestamosPersona(personaDao, tipoAcceso);
		
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
