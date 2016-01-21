package com.wpsnetwork.consola;

import java.nio.file.AccessDeniedException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try{
			int x = 10/0;
			System.out.println("Después de la división");
		}
		catch(ArithmeticException e){
			System.out.println("Dentro del catch");
			//e.printStackTrace();
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Dentro del catch 2");
		}
		catch(Exception e){
			System.out.println("Cualquier otra excepción");
		}
		finally{
			System.out.println("Código que se ejecuta tanto si hay error como si no");
		}
		System.out.println("Final aplicación");
		
		boolean continuar;
		int opcion;
		do{
			continuar = false;
			
			//Mostramos el Menú
			System.out.println("1.- Opción 1");
			System.out.println("2.- Opción 2");
			System.out.println("0.- Salir");
			
			try{
				opcion = leerTeclado();
			}catch(NumeroNoValidoException e){
				continuar = true;
			}
		}while(continuar);
		
		System.out.println("Hemos salido");
	}
	
	private static int leerTeclado() throws NumeroNoValidoException{
		Scanner teclado = new Scanner(System.in);
		String linea = teclado.nextLine();
		int valor = Integer.parseInt(linea);
		
		if(valor < 0 || valor > 2) throw new NumeroNoValidoException("La opción no es válida");
		
		return valor;
	}

}




























