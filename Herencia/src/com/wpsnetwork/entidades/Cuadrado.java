package com.wpsnetwork.entidades;

public class Cuadrado extends Rectangulo {
	
	public Cuadrado(int x, int y, int lado){
		super(x, y, lado, lado);
	}

	@Override
	public void setBase(int base){
		super.setBase(base);
		super.setAltura(base);
	}
	
	@Override
	public void setAltura(int base){
		super.setBase(base);
		super.setAltura(base);
		
	}
}
