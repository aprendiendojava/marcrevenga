package com.wpsnetwork.consola;

import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/*
 * 		Semaphore   	-> Permite entrar dentro del bloqueo a un número limitado de accesos
 * 		CountDownLatch 	-> Se bloquea hasta que no finaliza un número determinado de hilos
 * 		CyclicBarrier 	-> Solo deja ejecutarse un número determinado de tareas	
 */

public class Main {
	
	static private Semaphore semaforo = new Semaphore(1);	//Permite bloquear a la vez esta cantidad
													//  de hilos
	static int contador = 0;

	public static void main(String[] args) {
		try {
			
			semaforo.acquire(); 			//Cogemos el bloqueo
			
			//semaforo.acquire();			//Se para porque estamos bloqueados
											//No puedo obtener un segundo bloqueo
			
			//trozo de código a ejecutar
			
			semaforo.release();				//Liberamos el bloqueo
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		//Obtiene bloqueo
		
		
		//LockSupport
		PriorityQueue<String> colaMensajes = new PriorityQueue<>();
		
		//Hilo que vacía la cola
		Runnable tareaConsumidor = ()->{
			while(true){
				LockSupport.park(); 		//Para la ejecución del hilo hasta que se desbloquee
				
				System.out.println("Mensaje: " + colaMensajes.poll()); //Obtenemos el primer mensaje
			}
		};
		
		Thread hiloConsumidor = new Thread(tareaConsumidor);
		
		
		
		//Hilo que llena la cola
		Runnable tareaProductora = ()->{
			colaMensajes.add("Mensaje " + ++contador);
			LockSupport.unpark(hiloConsumidor);
		};
		
		Executors.newSingleThreadScheduledExecutor()
				.scheduleAtFixedRate(tareaProductora, 0, 2, TimeUnit.SECONDS);
		
		hiloConsumidor.start();
		

	}

}
