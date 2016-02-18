package com.wpsnetwork.consola;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
	static private CountDownLatch latch = new CountDownLatch(2);
	static private CyclicBarrier barrera = new CyclicBarrier(3);
	
	static private Future<Integer> resultado1;
	static private Future<Integer> resultado2;
	static private Future<Integer> resultado3;
	static private Future<Integer> resultado4;
	
	static private Callable<Integer> tarea1 = ()->{
		Thread.sleep(2000);		//Esperamos 2 segundos
		int valor = new Random().nextInt();
		latch.countDown(); 							//Desbloqueamos un elemento del latch
													//Restamos uno al contador interno del latch
		System.out.println("Tarea 1: " + valor);
		return valor;
	};
	
	static private Callable<Integer> tarea2 = ()->{
		Thread.sleep(3000);		//Esperamos 3 segundos
		int valor = new Random().nextInt();
		latch.countDown(); 							//Desbloqueamos un elemento del latch
													//Restamos uno al contador interno del latch
		System.out.println("Tarea 2: " + valor);
		return valor;
	};
	
	static private Callable<Integer> tarea3 = ()->{
		Thread.sleep(6000);		//Esperamos 6 segundos
		int valor = new Random().nextInt();
		
		barrera.await();					//Decrementa el contador interno del cyclicBarrier
		System.out.println("Tarea 3: " + valor);
		return valor;
	};
	
	static private Callable<Integer> tarea4 = ()->{
		latch.await(); 						//Espera a la que la tarea 1 y la tarea 2 acaben
		int v1 = resultado1.get();			//Obtenemos resultados de las tareas
		int v2 = resultado2.get();
		int valor = v1 + v2;
		
		System.out.println("Tarea 4: " + valor);
		barrera.await();				 	//Decrementamos en uno el valor interno de la barrera
		return valor;
	};
	
	static private Callable<Long> tarea5 = ()->{
		barrera.await(); 						//Decrementamos en uno la barrera
		int v3 = resultado3.get();			
		int v4 = resultado4.get();
		long valor = v3 * v4;
		
		return valor;
	};

	public static void main(String[] args) throws ExecutionException {
		try {
			
			semaforo.acquire(); 			//Cogemos el bloqueo
			
			//semaforo.acquire();			//Se para porque estamos bloqueados
											//No puedo obtener un segundo bloqueo
			
			//trozo de código a ejecutar
			
			semaforo.release();				//Liberamos el bloqueo
			
			ExecutorService pool = Executors.newFixedThreadPool(5);
			resultado1 = pool.submit(tarea1);
			resultado2 = pool.submit(tarea2);
			resultado3 = pool.submit(tarea3);
			resultado4 = pool.submit(tarea4);
			Future<Long> resultado5 = pool.submit(tarea5);
			
			System.out.println("tarea 5: " + resultado5.get());
			
			
			
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
