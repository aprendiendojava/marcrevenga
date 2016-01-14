package com.wpsnetwork.entidades;

public class Rectangulo extends Figura {
	private int base;
	private int altura;
	
	
	public Rectangulo(int x, int y, int base, int altura) {
		super(x, y);
		this.base = base;
		this.altura = altura;
	}


	@Override
	public double getArea() {
		return base * altura;
	}
	
	@Override
	public String toString(){
		return "Soy un rectangulo";
	}


	public int getBase() {
		return base;
	}


	public void setBase(int base) {
		this.base = base;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}
	
	

}
