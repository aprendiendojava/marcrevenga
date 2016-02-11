package com.wpsnetwork.entidades.empresa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Empresa {
	private int codigo;
	private String nombre;
	
	private static final Logger logger = LogManager.getLogger(Empresa.class.getName());

	public Empresa(int codigo, String nombre) {
		super();

		if(logger.isTraceEnabled())
			logger.trace("Entramos en el constructor de la Empresa");
		this.codigo = codigo;
		this.nombre = nombre;
		
		if(logger.isDebugEnabled()){
			logger.debug("Parametro codigo: " + codigo);
			logger.debug("Parametro nombre: " + nombre);
		}
		
		if(logger.isTraceEnabled())
			logger.trace("Salimos del constructor de la Empresa");
	}

	
}
