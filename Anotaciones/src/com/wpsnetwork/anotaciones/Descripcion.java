package com.wpsnetwork.anotaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( {									//Donde se puede poner la anotacion
			ElementType.FIELD,				//Propiedad
			ElementType.METHOD,				//M�todo
			ElementType.TYPE				//Clase
		} )

@Retention( RetentionPolicy.RUNTIME)
//					Tenemos 3 posibles valores:
//							-CLASS -> Valor por defecto. Se guarda en los .class
//										pero no est�n disponibles en tiempo de ejecuci�n
//							-RUNTIME -> Accesibles en tiempo de ejecuci�n
//							-SOURCE   -> Eliminados por el compilador (no est�n en los .class)

@Inherited				//Esta anotaci�n est� accesible para el objeto donde se coloca y sus
						//  subclases. Por defecto la anotaci�n no se hereda
@Documented				//Para que se a�ada la anotaci�n en JavaDoc
public @interface Descripcion {
	String value();
}
