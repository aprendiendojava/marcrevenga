package com.wpsnetwork.patrones.wrapper;

public class ClaseWrapper {
	//Tiene un HAS-A de la clase que queremos envolver
	//Tiene que tener la misma funcionalidad que la original
	//Se añade funcionalidad nueva
	
	private ClaseBase original = new ClaseBase();
	private int nuevoValor;
	private boolean modificado = false;
	
	public int getValor(){
		int ret;
		
		if(modificado)
			ret = nuevoValor;
		else
			ret = original.getValor();
			
		return ret;
	}

	public void setValor(int valor){
		nuevoValor = valor;
		modificado = true;
	}
}
