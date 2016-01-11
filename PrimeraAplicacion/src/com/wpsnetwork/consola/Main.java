package com.wpsnetwork.consola;

import com.wpsnetwork.entidades.Coche;

public class Main {

	public static void main(String[] args){
		System.out.println("Hola, mundo !!"); 
		
		//Este es un comentario de fila
		/*
		   Esto es un bloque de comentario
		 */
		
		//Tipos de datos
		//===============
		
//			Númericos:
//					byte  -> (-128, 127)    2^8
//					short -> (-32768, 32767)   2^16
//					int   -> (-2000000000, +2000000000) 2^32
//					long  -> 					  2^64
//					
//		    Reales:
//		    		float
//		    		double
//
//			Caracter:
//					char			//Un único carácter -- UNICODE  2^16
//
//			Boolaeano:
//
//				cierto --> true
//				falso --> false
		
		int numeroRuedas = 3;				//Establecer un valor en la declaración
		numeroRuedas = 10;
		long numeroLong = 100L;
		int numeroLargo = 2_000_000;		//A partir de JDK 7
		
		byte valorByte;
		valorByte = (byte) numeroRuedas;    //Casting (moldeo)
		System.out.println(numeroRuedas);
		
		double pi = 3.14;
		float piFloat = 3.14f;
		    		
//		La clase String
//		===============
//			Una cadena de caracteres sin tamaño.
//			Es immutable
			
			
		String cadena = "Esto es una cadena de caracteres";
		cadena = cadena.toUpperCase();
			
			
		/*
		 * Sentencias de control
		 * 
		 * Condicionales:
		 * 		IF:
		 * 				if(condicion){
		 * 					//Si la condición es cierta
		 * 				} else {
		 * 					//En caso de falso
		 * 				}
		 * 		SWITCH:
		 * 
		 * 				switch(valor){
		 * 					case valor1:
		 * 									break;
		 * 					case valor2:
		 * 									break;
		 * 					default:
		 * 				}
		 * 
		 *		IF TERCIARIO:
		 *				condicion?Instrucción si certo: Instrucción si falso;
		 */
		
		boolean condicion = true;
		
		if (condicion) System.out.println("Es cierto");
		
		if (condicion) 
			System.out.println("Es cierto");
		else 
			System.out.println("Es falso");
		
		if (condicion) {
			System.out.println("Es cierto - primera línea");
			System.out.println("Es cierto - segunda línea");
		}
		else 
			System.out.println("Es falso");
		
		if ( 2==1 )
			System.out.println("2 es igual a 1");
		else if( 2==3) 
			System.out.println("2 es igual a 3");
		else if (3==3)
			System.out.println("3 es igual a 3");
		
		
		int valor = 3;
		switch(valor){
		case 1:
			System.out.println("Es uno");
			break;
		case 2:
		case 3:
			System.out.println("Dos o tres");
			break;
		default:
			System.out.println("No es ni uno, ni dos ni tres");
		}
		
		boolean resultado = (2==3)?true:false;
		
//		Iterativas
//		----------
//		
//			WHILE:
//				while(condición){
//					//Conjunto de instracciones a ejecutar mientras la condición sea cierta
//				}
		
//			FOR:
//				for(inicializacion;condicion;incremento){
//					//Código a ejecutar
//				}
//			DO...WHILE:
//				do{
//					//Instrucciones a ejecutar
//				}while(condicion);

			int i = 0;
			while(i<9){
				System.out.println(i++);
			}
			
			for(int j=0; j<10;j++){
				System.out.println(j);
			}
			
//			int opcion = 0;
//			do {
//				System.out.println("1.- Opcion 1");
//				System.out.println("2.- Opcion 2");
//				//Lectura teclado
//			}while(opcion == 0);
			
//			Arrays
//			========
			
			int[] array1D = new int[5];
			int[][] array2D = new int[3][2];
			
			int[][] array = { {1,2} , {3,4, 10, 11}, {5,6}};
			
			System.out.println(array[0][1]);
			
			for(int x=0; x<array.length;x++){
				for(int y=0; y<array[x].length; y++){
					System.out.println(array[x][y]);
				}
			}
			
			//For ampliado   //JDK 6
//				for(declaracion_variable : elemento_a_recorrer ){
//					//instrucciones a ejecutar por la cada elemento
//				}
			
			int[] arrayA = {1,2,3};
			for(int a : arrayA){
					System.out.println(a);
			}
			
			for(int[] a : array){
				for(int b : a){
					System.out.println(b);
				}
			}
			
			
			Coche c1 = new Coche();		//Un objeto coche
		
			System.out.println(c1.getMarca());
			
			Coche c2 = new Coche("1111BBB", "Peugeot", "307", 5);
			System.out.println(c2.getMarca());
			
	}
}
