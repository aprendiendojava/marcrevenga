package com.wpsnetwork.consola;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		//Usando la clase Thread
		int x = 10;
		
		Thread hilo = new Thread(){
			@Override
			public void run(){
				//En este método poner el código que tiene que ejecutar el hilo
				System.out.println("Desde un proceso asíncrono " + x);
			}
			
		};
		
		//hilo.run(); 				//Llamada síncrona al método
		hilo.start(); 				//Lanzamos el hilo
		
		//Usando un Runnable
//		Runnable tarea = () -> {
//									System.out.println("Hilo con Runnable");
//								};
//		Thread hilo2 = new Thread(tarea);
//		hilo2.start();
		
		new Thread(()->System.out.println("Hilo con Runnable")).start();
		
		Thread hiloInfinito = new Thread(()->{
			for(;;){
				try {
					
					Thread.sleep(1000);
					System.out.println("Hilo con bucle infinito");	//Duerme el hilo 1s
					
				} catch (InterruptedException e) {
					//Se lanza cuando matamos el hilo mientras espera
					break;	//Rompe el bucle
				} 		
			}
		});
		hiloInfinito.start();
		
		Thread.sleep(10000);
		hiloInfinito.interrupt(); 	//Para el hilo
		System.out.println("main finalizado");

	}

}













