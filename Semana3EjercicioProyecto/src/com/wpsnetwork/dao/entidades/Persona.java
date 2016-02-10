package com.wpsnetwork.dao.entidades;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDate;

public class Persona {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Persona.class.getName());

	private int id;
	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private String direccion;
	private String telefono;
	private String pais;
	private String provincia;
	private String ciudad;
	private String codigoPostal;
	
	public Persona() {
		this(1, "", "", LocalDate.now(), "", "", "", "", "", "");
		if (logger.isDebugEnabled()) {
			logger.debug("Persona() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Persona() - end"); //$NON-NLS-1$
		}
	}

	public Persona(int id, String nombre, String dni, LocalDate fechaNacimiento, String direccion, String telefono,
			String pais, String provincia, String ciudad, String codigoPostal) {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("Persona(int id={}, String nombre={}, String dni={}, LocalDate fechaNacimiento={}, String direccion={}, String telefono={}, String pais={}, String provincia={}, String ciudad={}, String codigoPostal={}) - start", id, nombre, dni, fechaNacimiento, direccion, telefono, pais, provincia, ciudad, codigoPostal); //$NON-NLS-1$
		}

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

		if (logger.isDebugEnabled()) {
			logger.debug("Persona(int id={}, String nombre={}, String dni={}, LocalDate fechaNacimiento={}, String direccion={}, String telefono={}, String pais={}, String provincia={}, String ciudad={}, String codigoPostal={}) - end", id, nombre, dni, fechaNacimiento, direccion, telefono, pais, provincia, ciudad, codigoPostal); //$NON-NLS-1$
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

	public String getNombre() {
		if (logger.isDebugEnabled()) {
			logger.debug("getNombre() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getNombre() - end - return value={}", nombre); //$NON-NLS-1$
		}
		return nombre;
	}

	public void setNombre(String nombre) {
		if (logger.isDebugEnabled()) {
			logger.debug("setNombre(String nombre={}) - start", nombre); //$NON-NLS-1$
		}

		this.nombre = nombre;

		if (logger.isDebugEnabled()) {
			logger.debug("setNombre(String nombre={}) - end", nombre); //$NON-NLS-1$
		}
	}

	public String getDni() {
		if (logger.isDebugEnabled()) {
			logger.debug("getDni() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getDni() - end - return value={}", dni); //$NON-NLS-1$
		}
		return dni;
	}

	public void setDni(String dni) {
		if (logger.isDebugEnabled()) {
			logger.debug("setDni(String dni={}) - start", dni); //$NON-NLS-1$
		}

		this.dni = dni;

		if (logger.isDebugEnabled()) {
			logger.debug("setDni(String dni={}) - end", dni); //$NON-NLS-1$
		}
	}

	public LocalDate getFechaNacimiento() {
		if (logger.isDebugEnabled()) {
			logger.debug("getFechaNacimiento() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getFechaNacimiento() - end - return value={}", fechaNacimiento); //$NON-NLS-1$
		}
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (logger.isDebugEnabled()) {
			logger.debug("setFechaNacimiento(LocalDate fechaNacimiento={}) - start", fechaNacimiento); //$NON-NLS-1$
		}

		this.fechaNacimiento = fechaNacimiento;

		if (logger.isDebugEnabled()) {
			logger.debug("setFechaNacimiento(LocalDate fechaNacimiento={}) - end", fechaNacimiento); //$NON-NLS-1$
		}
	}

	public String getDireccion() {
		if (logger.isDebugEnabled()) {
			logger.debug("getDireccion() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getDireccion() - end - return value={}", direccion); //$NON-NLS-1$
		}
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (logger.isDebugEnabled()) {
			logger.debug("setDireccion(String direccion={}) - start", direccion); //$NON-NLS-1$
		}

		this.direccion = direccion;

		if (logger.isDebugEnabled()) {
			logger.debug("setDireccion(String direccion={}) - end", direccion); //$NON-NLS-1$
		}
	}

	public String getTelefono() {
		if (logger.isDebugEnabled()) {
			logger.debug("getTelefono() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getTelefono() - end - return value={}", telefono); //$NON-NLS-1$
		}
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (logger.isDebugEnabled()) {
			logger.debug("setTelefono(String telefono={}) - start", telefono); //$NON-NLS-1$
		}

		this.telefono = telefono;

		if (logger.isDebugEnabled()) {
			logger.debug("setTelefono(String telefono={}) - end", telefono); //$NON-NLS-1$
		}
	}

	public String getPais() {
		if (logger.isDebugEnabled()) {
			logger.debug("getPais() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getPais() - end - return value={}", pais); //$NON-NLS-1$
		}
		return pais;
	}

	public void setPais(String pais) {
		if (logger.isDebugEnabled()) {
			logger.debug("setPais(String pais={}) - start", pais); //$NON-NLS-1$
		}

		this.pais = pais;

		if (logger.isDebugEnabled()) {
			logger.debug("setPais(String pais={}) - end", pais); //$NON-NLS-1$
		}
	}

	public String getProvincia() {
		if (logger.isDebugEnabled()) {
			logger.debug("getProvincia() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getProvincia() - end - return value={}", provincia); //$NON-NLS-1$
		}
		return provincia;
	}

	public void setProvincia(String provincia) {
		if (logger.isDebugEnabled()) {
			logger.debug("setProvincia(String provincia={}) - start", provincia); //$NON-NLS-1$
		}

		this.provincia = provincia;

		if (logger.isDebugEnabled()) {
			logger.debug("setProvincia(String provincia={}) - end", provincia); //$NON-NLS-1$
		}
	}

	public String getCiudad() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCiudad() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getCiudad() - end - return value={}", ciudad); //$NON-NLS-1$
		}
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCiudad(String ciudad={}) - start", ciudad); //$NON-NLS-1$
		}

		this.ciudad = ciudad;

		if (logger.isDebugEnabled()) {
			logger.debug("setCiudad(String ciudad={}) - end", ciudad); //$NON-NLS-1$
		}
	}

	public String getCodigoPostal() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodigoPostal() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getCodigoPostal() - end - return value={}", codigoPostal); //$NON-NLS-1$
		}
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCodigoPostal(String codigoPostal={}) - start", codigoPostal); //$NON-NLS-1$
		}

		this.codigoPostal = codigoPostal;

		if (logger.isDebugEnabled()) {
			logger.debug("setCodigoPostal(String codigoPostal={}) - end", codigoPostal); //$NON-NLS-1$
		}
	}

	@Override
	public String toString() {
		if (logger.isDebugEnabled()) {
			logger.debug("toString() - start"); //$NON-NLS-1$
		}

		String returnString = "Persona [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", telefono=" + telefono + ", pais=" + pais + ", provincia=" + provincia + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + "]";
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

		boolean returnboolean = this.id == ((Persona) obj).id;
		if (logger.isDebugEnabled()) {
			logger.debug("equals(Object obj={}) - end - return value={}", obj, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}
