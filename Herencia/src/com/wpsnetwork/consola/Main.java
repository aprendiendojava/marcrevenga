package com.wpsnetwork.consola;

import java.util.ArrayList;

import com.wpsnetwork.entidades.Circulo;
import com.wpsnetwork.entidades.Figura;
import com.wpsnetwork.entidades.Triangulo;
import com.wpsnetwork.entidades.enumerados.TipoTriangulo;
import com.wpsnetwork.interfaces.OperacionBinaria;

public class Main {
	public static void main(String[] args){
		
		Circulo c1 = new Circulo(1, 2, 3);
		System.out.println(c1);
		System.out.println(c1.getArea());
		
		Triangulo t1 = new Triangulo(10, 11, 20, 30, TipoTriangulo.EQUILATER);
		System.out.println(t1);
		System.out.println(t1.getArea());
		
		//Casting implícito
		Figura[] figuras = new Figura[2];
		figuras[0] = c1;		//Lo convierte a Figura
		figuras[1] = t1;
		
		System.out.println(figuras[0].toString());
		//figuras[0].A();			//No se puede acceder a él
		
		//Casting explicito
		
		c1 = (Circulo) figuras[0];
		c1.A();
		
		//(x,y) -> x+y;
		
		System.out.println(operar((x,y) -> x-y, 2, 3));
		ArrayList<Figura> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(t1);
		
		lista.parallelStream()
			.filter(e-> e.getArea() > 10)
			.count();
		
	}
	
	private static int operar(OperacionBinaria op, int a, int b){
		return op.operacion(a, b);
	}

}



























