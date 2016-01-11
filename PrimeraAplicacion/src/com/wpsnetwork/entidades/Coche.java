package com.wpsnetwork.entidades;

public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	private int puertas;
	
	
	public Coche(){
		this("0000AAA", "", "", 0);
	}
	
	public Coche(String matricula, String marca, String modelo, int puertas) {
		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setPuertas(puertas);
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getPuertas() {
		return puertas;
	}
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	
	
}
