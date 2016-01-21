package com.wpsnetwork.consola;

public class Main {

	public static void main(String[] args) {
		Contador c = new Contador();
		c.contar();
		System.out.println("Hemos contado " + c.getResultado());
	}

}
