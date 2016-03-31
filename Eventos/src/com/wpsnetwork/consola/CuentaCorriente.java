package com.wpsnetwork.consola;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;

public class CuentaCorriente extends Observable {
	private double saldo;
	private String nombre;
	
	private static final String PROP_SALDO = "Saldo";
	private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public CuentaCorriente(double saldo, String nombre) {
		super();
		this.saldo = saldo;
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	private void setSaldo(double saldo) {
		double old = this.saldo;
		this.saldo = saldo;
		propertyChangeSupport.firePropertyChange(PROP_SALDO, old, saldo);
				//Solo lanza el evento si el valor cambia
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void addCantidad(double dinero){
		setSaldo(getSaldo() + dinero);
		if(getSaldo() <= 0){
			setChanged();					//Avisamos al Observable que hemos cambiado
			notifyObservers(getSaldo());	//Avisamos a los oyentes y le pasamos el
										 	//  valor del saldo
		}
	}
	
	public void addPropertyChangeListener(PropertyChangeListener oyente){
		propertyChangeSupport.addPropertyChangeListener(oyente);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener oyente){
		propertyChangeSupport.removePropertyChangeListener(oyente);
	}
}






