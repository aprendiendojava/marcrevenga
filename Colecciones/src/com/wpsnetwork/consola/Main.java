package com.wpsnetwork.consola;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.wpsnetwork.entidades.Cliente;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException{
		List<String> lista = new ArrayList<>();
		
		lista.add("Juanito");
		lista.add("Pepito");
		
		System.out.println("Tamaño de la lista: " + lista.size());
		
		for(int i=0;i<lista.size();i++){
			System.out.println(lista.get(i));
		}
		
		//A partir de JDK 5
		for(String s : lista)
			System.out.println(s);
		
		Set<Cliente> clientes = new TreeSet<>();
		clientes.add(new Cliente(3, "ACliente 3", 10));
		clientes.add(new Cliente(1, "CCliente 1", 20));
		clientes.add(new Cliente(2, "BCliente 2", 30));
		clientes.add(new Cliente(1, "XCliente 1", 50));
		
		for(Cliente c : clientes)
			System.out.println(c);
		
		Cliente c1 = new Cliente(1,"A", 10);
		Cliente c2 = new Cliente(1,"B", 20);
		
		System.out.println(c1 == c2); 	//Compara las posiciones de memoria
		System.out.println(c1.equals(c2)); 	//Compara el contenido por un criterio
		
		Cliente c3 = (Cliente) c1.clone();
		System.out.println(c3);
		
		//Pasar de un conjunto a una lista
		List<Cliente> listaClientes = new ArrayList<>(clientes);
		
		Collections.shuffle(listaClientes);		//Desordenamos
		
		for(Cliente c : listaClientes)
			System.out.println(c);
		
		listaClientes.sort(new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				return Integer.compare(o1.getCodigo(), o2.getCodigo());
			}
			
		});
		
		for(Cliente c : listaClientes)
			System.out.println(c);
		
		//Un mapa
		Map<Integer, String> diccionario = new HashMap<>();
		
		diccionario.put(1, "Valor 1");
		diccionario.put(3, "Valor 3");
		diccionario.put(2, "Valor 2");
		
		for(String s : diccionario.values())
			System.out.println(s);
		
		for(Integer k : diccionario.keySet())
			System.out.println(k);
		
		System.out.println("Elemento con la clave 2: " + diccionario.get(2));
	}

}






























