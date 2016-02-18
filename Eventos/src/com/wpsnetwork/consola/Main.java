package com.wpsnetwork.consola;

import java.util.ArrayList;
import java.util.List;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

public class Main {

	public static void main(String[] args) {
		LogCuenta log = new LogCuenta();
		CuentaCorriente ccc = new CuentaCorriente(100.0, "Cuenta 1");
		
		ccc.addObserver(log);
		ccc.addPropertyChangeListener(log);
		
		//Operamos con la cuenta
		ccc.addCantidad(-50);
		ccc.addCantidad(0);
		ccc.addCantidad(-70); 			//Estamos en números rojos
		
		//Collecciones Observables
		//Tienen implementato el PropertyChangeSupport
		List<CuentaCorriente> cuentas = new ArrayList<>();
		cuentas.add(new CuentaCorriente(100.0, "Cuenta 1"));
		cuentas.add(new CuentaCorriente(200.0, "Cuenta 2"));
		
		//Añadimos el observable
		List<CuentaCorriente> listaObservable = ObservableCollections.observableList(cuentas);
		
		//Para añadir el oyente
		ObservableList<CuentaCorriente> lista = (ObservableList) listaObservable;
		lista.addObservableListListener(log);
		
		listaObservable.add(new CuentaCorriente(300.0, "Cuenta 3"));
	}

}





















