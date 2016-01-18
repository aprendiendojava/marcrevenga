package com.wpsnetwork.patrones.iterator;

import com.wpsnetwork.patrones.iterator.interfaces.Iterator;

public class Cliente {
	private int codigo;
	private String nombre;
	private int edad;
	
	
	
	public Cliente(int codigo, String nombre, int edad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
	}



	public Iterator getIterator(){
		return new ClienteIterator();
	}
	
	private class ClienteIterator implements Iterator{
		private int modo;		//Modo 0 : codigo
								//Modo 1:  nombre
								//Modo 2:  edad

		@Override
		public boolean hasNext() {
			return modo < 3;
		}

		@Override
		public Object next() {
			Object valor = null;
			
			switch(modo){
				case 0:
					valor = codigo;
					break;
				case 1:
					valor = nombre;
					break;
				case 2:
					valor = edad;
			}
			modo++;
			return valor;
		}
		
	}
}
