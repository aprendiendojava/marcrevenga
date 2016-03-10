package com.wpsnetwork.consola;

import java.math.BigDecimal;

import org.hibernate.Session;

import com.wpsnetwork.entidades.unoAuno.Direccion;
import com.wpsnetwork.entidades.unoAuno.Persona;

public class App {
    public static void main( String[] args ){
        
    	
    	/*
    	  Relación 1-1 Unidireccional
    	  ===========================
    	  
    	  	CREATE TABLE DIRECCIONES(
    	  		id INTEGER PRIMARY KEY,
    	  		calle VARCHAR2(50),
    	  		codigopostal VARCHAR2(50)
    	  	);
    	  	
    	  	CREATE TABLE PERSONAS(
    	  		id INTEGER PRIMARY KEY,
    	  		nombre VARCHAR2(50),
    	  		direccion INTEGER,
    	  		CONSTRAINT fk_direccion FOREIGN KEY (direccion) REFERENCES direcciones(id)
    	  	);
    	 */
    	
    	Session sesion = HibernateUtil.getSession();
    	sesion.beginTransaction();
    	
    	Direccion dir = new Direccion(BigDecimal.valueOf(1), "Calle 1", "1111");
    	Persona p = new Persona(BigDecimal.valueOf(1), dir, "Persona 1");
    	
    	sesion.persist(p);
    	
    	
    	sesion.getTransaction().commit();
    	sesion.close();
    	
    	HibernateUtil.setDown();
    }
}
