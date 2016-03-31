package com.wpsnetwork.consola;

public class Main {
	
	private static Object bandera = new Object();

	public static void main(String[] args) throws InterruptedException {
		
//		Runnable tarea1 = ()->{
//			for(int i=0; i<10; i++){
//				//synchronized(bandera){
//				synchronized(System.out){
//					escribir("Tarea 1:");
//					escribir(i + "\n");
//				}
//			}
//		};
//		
//		
//		
//		Runnable tarea2 = ()->{
//			for(int i=0; i<10; i++){
//				//synchronized(bandera){
//				synchronized(System.out){
//					escribir("Tarea 2:");
//					escribir(i + "\n");
//				}
//			}
//		};
//		
//		new Thread(tarea1).start(); //Arrancamos el hilo
//		new Thread(tarea2).start(); //Arrancamos el hilo
		
		Thread hiloGuardarFichero = new Thread(()->{
			try {
			
				Thread.sleep(5000); 	//Simula el guardado del fichero
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		});
		hiloGuardarFichero.start();
		System.out.println("Guardando fichero ...");
		
		hiloGuardarFichero.join(); 			//El hilo principal se bloquea
											//  en este punto hasta que finaliza
											//  el hilo al que hemos hecho join()
		System.out.println("Fichero guardado");
	}
	
	static synchronized private void escribir(String mensaje){
		System.out.print(mensaje);
		System.out.flush(); 			//Forzar que el canal se escriba
	}
}


