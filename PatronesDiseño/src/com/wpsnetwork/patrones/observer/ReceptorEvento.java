package com.wpsnetwork.patrones.observer;

public class ReceptorEvento implements Observer {

	@Override
	public void update() {
		System.out.println("Evento sin parámetros recibido");
	}

	@Override
	public void update(String mensaje) {
		System.out.println("Evento con parámetros recibido. Parámetro: " + mensaje);
	}

}
