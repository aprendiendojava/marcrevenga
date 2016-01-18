package com.wpsnetwork.patrones.iterator;

import com.wpsnetwork.patrones.iterator.interfaces.Coleccion;
import com.wpsnetwork.patrones.iterator.interfaces.Iterator;

public class ColeccionArray implements Coleccion {
	private int[] contenido;

	public ColeccionArray(int ... contenido) {
		super();
		this.contenido = contenido;
	}


	@Override
	public Iterator getIterator() {
		return new IteratorArray();
	}
	
	private class IteratorArray implements Iterator{
		private int pos;
		
		@Override
		public boolean hasNext() {
			boolean retorno = false;
			
			if(pos < contenido.length) retorno = true;
			
			return retorno;
		}

		@Override
		public Object next() {
			Object valor = null;
			
			if(this.hasNext()) valor = contenido[pos++];
			
			return valor;
		}
		
	}

}
