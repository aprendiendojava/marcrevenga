package com.wpsnetwork.consola;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	/*
	 * 	En JDK 5 se introdujo la nueva API de concurrencia. Introduce clases
	 * 		en el paquete java.util.concurrent.
	 * 	La clase principal es Executors y de está obtendremos los diferentes 
	 * 		elementos. Usa un patrón Factory.
	 * 	La interfaz Callable es la alternativa a la interfaz Runnable. Este 
	 * 		callable encapsula código.
	 * 	La interfaz ExecutorService permite lanzar hilos. Tiene diferentes clases
	 * 		que implementan esta interfaz:
	 * 
	 * 			- SingleThreadExecutor				-> Los hilos se ejecutan en el mismo
	 * 													orden que se van añadiendo. Uno a uno.
	 * 
	 * 			- SingleThreadScheduledExecutor		->Ejecuta una única tarea con un retardo o 
	 * 													intervalo definido
	 * 
	 * 			- CachedThreadPool					-> Es capaz de reutilizar hilos creados
	 * 													anteriormente si existen
	 * 
	 * 			- FixedThreadPool					->Ejecuta a la vez un número determinado
	 * 													de hilos
	 * 
	 * 			- ScheduledThreadPool				-> Crea un pool para ejecutar tareas con un
	 * 													retardo o a intervalos definidos
	 */

	public static void main(String[] args) throws InterruptedException {
	
		//Crear un Callable
		Callable<Integer> tarea = ()-> 67+34;
		Callable<Integer> tarea2 = Executors.callable(
										()->System.out.println("Fin de la tarea") //Tarea a realizar
										, 67);		//Resultado a devolver
		
		
		try {
			
			//Si lo que quiero es ejecutar síncrónamente el código (sin hilos)
			System.out.println("Resultado de la operación: " + tarea.call());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Crear un hilo clásico Thread
		Thread t = Executors.defaultThreadFactory()
							.newThread(()->System.out.println("Desde Thread"));
		t.start();
		
		//SingleThreadExecutor
		ExecutorService ste = Executors.newSingleThreadExecutor();
		Future<Integer> valor= ste.submit(tarea);
		
		try {
			
			System.out.println(valor.get());		//El hilo se para en este punto 
													//  hasta que tarea finaliza y
													//  obtenemos su valor de retorno
			ste.shutdown();
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		
		
		//FixedThreadPool
		ExecutorService ftp = Executors.newFixedThreadPool(5);	//Ejecuta 5 hilos a la vez
		
		for(int i=0; i<20; i++){
			final int id = i;
			Callable<Object> tarea_nueva = ()->{
					System.out.println("Tarea " + id);
					Thread.sleep(2000);
					return null;
			};
			
			Future<Object> resultado = ftp.submit(tarea_nueva);
		}
		
		try {
			
			ftp.awaitTermination(2000, TimeUnit.MILLISECONDS);	//Espera a que acaben todas las
																//  tareas en el tiempo establecido
			
			//ftp.shutdown(); 		//No accepta más tareas pero los que están en la cola
									//  los ejecuta
			
			ftp.shutdownNow();		//Para todos hilos
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		//SingleThreadScheduledExecutor
		ScheduledExecutorService sts = Executors.newSingleThreadScheduledExecutor();
		
		//sts.scheduleWithFixedDelay(command, initialDelay, delay, unit);
		sts.scheduleAtFixedRate(()->System.out.println(LocalTime.now()), 
								0,				//Tiempo de espera para iniciar la tarea 
								1, 				//Cada cuánto hay que ejecutar la tarea
								TimeUnit.SECONDS);
		
		sts.awaitTermination(2000, TimeUnit.MILLISECONDS);	//Esperamos
		
		sts.shutdown();										//Paramos el temposizador
		
		
		//Lanzar muchas tareas a la vez
		List<Callable<Object>> tareas = new ArrayList<>();
		
		tareas.add(Executors.callable(
					()->System.out.println("Hilo 1")
				,
				null));
		tareas.add(Executors.callable(
				()->System.out.println("Hilo 2")
			,
			null));
		tareas.add(Executors.callable(
				()->System.out.println("Hilo 3")
			,
			null));
		
		ExecutorService ejecutor = Executors.newFixedThreadPool(Runtime.getRuntime()	//Obtengo los procesadores
																		.availableProcessors());
		
		List<Future<Object>> resultados = ejecutor.invokeAll(tareas);
		
		ejecutor.shutdown();
		ejecutor.awaitTermination(1, TimeUnit.MINUTES);
		
		
		System.out.println("Acaba la app");
	}

}














