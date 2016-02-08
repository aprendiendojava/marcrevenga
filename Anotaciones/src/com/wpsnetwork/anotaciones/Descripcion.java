package com.wpsnetwork.anotaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( {									//Donde se puede poner la anotacion
			ElementType.FIELD,				//Propiedad
			ElementType.METHOD,				//Método
			ElementType.TYPE				//Clase
		} )

@Retention( RetentionPolicy.RUNTIME)
//					Tenemos 3 posibles valores:
//							-CLASS -> Valor por defecto. Se guarda en los .class
//										pero no están disponibles en tiempo de ejecución
//							-RUNTIME -> Accesibles en tiempo de ejecución
//							-SOURCE   -> Eliminados por el compilador (no están en los .class)

@Inherited				//Esta anotación está accesible para el objeto donde se coloca y sus
						//  subclases. Por defecto la anotación no se hereda
@Documented				//Para que se añada la anotación en JavaDoc
public @interface Descripcion {
	String value();
}
