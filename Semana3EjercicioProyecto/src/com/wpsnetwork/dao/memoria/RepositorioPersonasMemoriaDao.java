package com.wpsnetwork.dao.memoria;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Persona;
import com.wpsnetwork.dao.interfaces.DaoPersonas;

public class RepositorioPersonasMemoriaDao implements DaoPersonas {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(RepositorioPersonasMemoriaDao.class.getName());

	static private List<Persona> personas = new ArrayList<>();
	static private RepositorioPersonasMemoriaDao instancia = new RepositorioPersonasMemoriaDao();
	
	static{
		personas.add(new Persona(1, "Persona 1", "11111111X", LocalDate.of(1981, Month.SEPTEMBER, 11), "Calle 1", "11111111", "Pais persona 1", "Provincia persona 1", "Ciudad persona 1", "11111"));
		personas.add(new Persona(2, "Persona 2", "22222222X", LocalDate.of(1982, Month.OCTOBER, 22), "Calle 2", "222222222", "Pais persona 2", "Provincia persona 2", "Ciudad persona 2", "22222"));
	}
	
	private RepositorioPersonasMemoriaDao() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioPersonasMemoria() - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated constructor stub

		if (logger.isDebugEnabled()) {
			logger.debug("RepositorioPersonasMemoria() - end"); //$NON-NLS-1$
		}
	}
	
	public static RepositorioPersonasMemoriaDao getInstance(){
		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - start"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getInstance() - end - return value={}", instancia); //$NON-NLS-1$
		}
		return instancia;
	}

	@Override
	public Persona get(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - start", id); //$NON-NLS-1$
		}

		Persona returnPersona = personas.stream().filter(persona -> persona.getId() == id).findFirst().orElse(null);
		if (logger.isDebugEnabled()) {
			logger.debug("get(int id={}) - end - return value={}", id, returnPersona); //$NON-NLS-1$
		}
		return returnPersona;
	}

	@Override
	public void insert(Persona elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(Persona elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && !existe(elemento))
			personas.add(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("insert(Persona elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void update(Persona elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(Persona elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null && existe(elemento)){
			Persona p = get(elemento.getId());
			p.setNombre(elemento.getNombre());
			p.setDni(elemento.getDni());
			p.setFechaNacimiento(elemento.getFechaNacimiento());
			p.setTelefono(elemento.getTelefono());
			p.setDireccion(elemento.getDireccion());
			p.setPais(elemento.getPais());
			p.setProvincia(elemento.getProvincia());
			p.setCiudad(elemento.getCiudad());
			p.setCodigoPostal(elemento.getCodigoPostal());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(Persona elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public void delete(Persona elemento) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(Persona elemento={}) - start", elemento); //$NON-NLS-1$
		}

		if(elemento != null)
			personas.remove(elemento);

		if (logger.isDebugEnabled()) {
			logger.debug("delete(Persona elemento={}) - end", elemento); //$NON-NLS-1$
		}
	}

	@Override
	public List<Persona> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - start"); //$NON-NLS-1$
		}

		List<Persona> returnList = new ArrayList<>(personas);
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - end - return value={}", returnList); //$NON-NLS-1$
		}
		return returnList;
	}
	
	private boolean existe(Persona elemento){
		if (logger.isDebugEnabled()) {
			logger.debug("existe(Persona elemento={}) - start", elemento); //$NON-NLS-1$
		}

		boolean returnboolean = get(elemento.getId()) != null;
		if (logger.isDebugEnabled()) {
			logger.debug("existe(Persona elemento={}) - end - return value={}", elemento, returnboolean); //$NON-NLS-1$
		}
		return returnboolean;
	}
}