package com.wpsnetwork.patrones.singleton;

public class ClienteSingleton {
	private static ClienteSingleton instancia = new ClienteSingleton();

	private ClienteSingleton() {
		super();
	}
	
	public static ClienteSingleton getInstance(){
		return instancia;
	}

}
