package com.wpsnetwork.entidades.personal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.consola.Main;

public class Cliente {
	private int codigo;
	private String nombre;
	
	private static final Logger logger = LogManager.getLogger(Cliente.class.getName());

	public Cliente(int codigo, String nombre) {
		super();
		
		if(logger.isTraceEnabled())
			logger.trace("Entramos en el constructor de Cliente");
		this.codigo = codigo;
		this.nombre = nombre;
		
		if(logger.isDebugEnabled()){
			logger.debug("Parametro codigo: " + codigo);
			logger.debug("Parametro nombre: " + nombre);
		}
		
		if(logger.isTraceEnabled())
			logger.trace("Salimos del constructor de Cliente");
	}
	
	
}
