package consola;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, 
													NoSuchMethodException, 
													SecurityException, 
													InstantiationException, 
													IllegalAccessException, 
													IllegalArgumentException, 
													InvocationTargetException {
		Class metadatos = Class.forName("java.lang.StringBuffer");
		
		//Forma alternativa
		StringBuffer buffer = new StringBuffer("Cadena inicial");
		Class metadatos2 = buffer.getClass();
		
		//Forma alternativa
		Class metadatos3 = StringBuffer.class;
		
		//Obtenemos el constructor
		Constructor constructor = metadatos.getConstructor(String.class);
		//Ejecutamos el contructor
		StringBuffer buffer2 = (StringBuffer) constructor.newInstance("Cadena inicial");
		
		System.out.println(buffer2.toString());
		
		//Acceso una propiedad de una clase a través de su getter
		LocalDate fecha = LocalDate.now();
		Class metadatoFecha = fecha.getClass();
		Method metodo = metodoGet(metadatoFecha, "year");
		
		//Llamamos al método
		int anho = (int)metodo.invoke(fecha);
		
		System.out.println(anho);
		
	}
	
	static private Method metodoGet(Class metadato, String atributo){
		Method metodo = null;
		
		String trozo = Character.toUpperCase(atributo.charAt(0)) + atributo.substring(1);
		
		try {
			
			metodo = metadato.getMethod("get" + trozo);
			
		} catch (NoSuchMethodException e) {
			
			try {
				
				metodo = metadato.getMethod("is" + trozo);
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return metodo;
	}

}
















