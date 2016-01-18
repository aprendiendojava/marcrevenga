package com.wpsnetwork.patrones.builder;

public class ComensalBuilder {
	public Comensal prepareMenu1(){
		Comensal c = new Comensal();
		
		c.setPlato(0, "Sopa de pescado");
		c.setPlato(1, "Filete de pollo");
		
		return c;
	}
	
public Comensal prepareMenu2(){
	Comensal c = new Comensal();
	
	c.setPlato(0, "Gazpacho");
	c.setPlato(1, "Lenguado a la plancha");
	
	return c;
	}
}
