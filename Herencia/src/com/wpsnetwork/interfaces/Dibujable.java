package com.wpsnetwork.interfaces;

public interface Dibujable {
	//Todos los métodos son implícitamente public y abstract.
	//Las propiedades son public static y final
	
	double PI = 3.14;
	void dibujar();
	
	//En JDK 8
	
	default String hola(){
		return "Hola";
	}
}
