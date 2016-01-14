package com.wpsnetwork.entidades.enumerados;

public enum TipoTriangulo {	
	EQUILATER("Equilater"), ISOCELES("Isoceles"), RECTANGULO("Rectangulo"); 
	
	private String cadena;
	
	private TipoTriangulo(String cadena){
		this.cadena = cadena;
	}
	
	@Override
	public String toString(){
		return cadena;
	}
}
