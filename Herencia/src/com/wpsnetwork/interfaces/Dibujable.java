package com.wpsnetwork.interfaces;

public interface Dibujable {
	//Todos los m�todos son impl�citamente public y abstract.
	//Las propiedades son public static y final
	
	double PI = 3.14;
	void dibujar();
	
	//En JDK 8
	
	default String hola(){
		return "Hola";
	}
}
