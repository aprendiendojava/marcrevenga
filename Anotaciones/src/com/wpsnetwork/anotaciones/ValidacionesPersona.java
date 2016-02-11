package com.wpsnetwork.anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( {
	ElementType.TYPE			//Solo en las clases
})
@Retention( RetentionPolicy.RUNTIME)	//Accesible en tiempo de ejecución
public @interface ValidacionesPersona {
	ValidarPersona[] value();
}
