package com.wpsnetwork.patrones.builder;

public class Comensal {
	private String[] platos = new String[2];
	
	public void setPlato(int posicion, String plato){
		if(posicion >= 0 && posicion < 2)
			platos[posicion] = plato;
	}

}
