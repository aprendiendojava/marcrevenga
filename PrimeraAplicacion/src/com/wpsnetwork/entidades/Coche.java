package com.wpsnetwork.entidades;

public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	private int puertas;
	private final double PI = 3.14;		//Constante
										//Hay que asignarle un valor al declararla
										//  o en el constructor
	private static int numCoches = 0;
	
	public Coche(){
		this("0000AAA", "", "", 0);
	}
	
	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", puertas=" + puertas
				+ "]";
	}

	public Coche(String matricula, String marca, String modelo, int puertas) {
		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setPuertas(puertas);
		numCoches++;
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

	public static int getNumCoches() {
		//Solo pueden acceder a propiedades estáticas
		return numCoches;
	}
	
	
}
