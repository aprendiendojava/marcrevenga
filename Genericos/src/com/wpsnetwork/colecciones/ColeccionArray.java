package com.wpsnetwork.colecciones;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import com.wpsnetwork.colecciones.interfaces.Evaluable;
import com.wpsnetwork.colecciones.interfaces.Transformable;

public class ColeccionArray<T, V> implements Iterable<T>{
	private static final int TAMAÑO_INICIAL = 10;
	private T[] elementos;
	
	public ColeccionArray() {
		elementos = (T[]) new Object[TAMAÑO_INICIAL];
	}
	
	public void add(int posicion, T valor){
		if(posicion >= elementos.length) throw new ArrayIndexOutOfBoundsException();
		
		elementos[posicion] = valor;
	}
	
	public T get(int posicion){
		if(posicion >= elementos.length) throw new ArrayIndexOutOfBoundsException();
			
		return elementos[posicion];
	}

	@Override
	public Iterator<T> iterator() {
		return Arrays.asList(elementos).iterator();
	}

	public void remove(Evaluable<T> criterioEliminacion){
		for(int i=0; i<elementos.length;i++){
			if( (elementos[i] != null) && (criterioEliminacion.cumple(elementos[i])))
				elementos[i]=null;
		}
			
	}
	
	public V[] tranforma(Class<V> tipoRetorno, Transformable<T, V> transformadora){
		V[] resultado = (V[]) Array.newInstance(tipoRetorno, elementos.length);
		
		for(int i=0; i<elementos.length; i++)
			resultado[i] = elementos[i] != null? transformadora.transforma(elementos[i]): null;
			
		return resultado;
	}
	
	public static <M extends Number> double suma(M ... valores){
		double resultado = 0.0;
		
		for(M x : valores)
			resultado += x.doubleValue();
		
		return resultado;
	}

}
