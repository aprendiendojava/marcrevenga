package com.wpsnetwork.consola;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.entidades.empresa.Empresa;
import com.wpsnetwork.entidades.personal.Cliente;

public class Main {

	private static final Logger logger = LogManager.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		 //Escribir varios mensajes
		logger.trace("Este es un mensaje de trace");
		logger.debug("Este es un mensaje de debug");
		logger.info("Este es un mensaje de info");
		logger.warn("Este es un mensaje de warning");
		logger.error("Este es un mensaje de error");
		logger.fatal("Este es un mensaje fatal");
		
		Cliente c1 = new Cliente(1, "Pepito");
		Empresa e1 = new Empresa(1, "ACME SA");
		
		
	}

}
