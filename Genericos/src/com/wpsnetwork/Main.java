package com.wpsnetwork;

import com.wpsnetwork.colecciones.ColeccionArray;

public class Main {

	public static void main(String[] args) {
		ColeccionArray<Integer, Double> lista = new ColeccionArray<>();
		lista.add(0, 1);
		lista.add(1, 2);
		lista.add(2, 3);
		lista.add(3, 4);
		lista.add(4, 5);
		
		//ColeccionArray<String> listaString = new ColeccionArray<>();
		
		
		for(Integer v : lista)
			System.out.println(v);
		
		lista.remove(e -> e%2 == 0);
		
		for(Integer v : lista)
			System.out.println(v);
		
		Double[] listaDoubles = lista.tranforma(Double.class, e->e*10.0);
		
		for(Double v : listaDoubles)
			System.out.println(v);
		
		
		System.out.println(ColeccionArray.suma(1,2,3,4));
		

	}

}
