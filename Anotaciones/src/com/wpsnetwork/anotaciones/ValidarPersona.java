package com.wpsnetwork.anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( {
			ElementType.TYPE			//Solo en las clases
		})
@Retention( RetentionPolicy.RUNTIME)	//Accesible en tiempo de ejecución
@Repeatable(ValidacionesPersona.class)	//Donde almacenar la lista de anotaciones de este tipo
										//Para permitir usar más una vez esta anotacion
										//  en un sitio
public @interface ValidarPersona {
	int minCodigo() default 1;
	int maxCodigo();
	String patronNombre();
}
