package com.wpsnetwork.entidades;

public final class Circulo extends Figura{
	//Con final evitamos que tenga hijos
	private int radio; 

	
	public Circulo(int x, int y, int radio) {
		super(x, y);
		this.radio = radio;
	}

	@Override
	public double getArea() {
		return Math.PI * radio * radio;
	}
	
	@Override
	public String toString(){
		return "Soy un círculo";
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public void A(){
		
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}
}
