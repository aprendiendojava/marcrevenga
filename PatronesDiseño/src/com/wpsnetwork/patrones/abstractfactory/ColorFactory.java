package com.wpsnetwork.patrones.abstractfactory;

import com.wpsnetwork.patrones.abstractfactory.interfaces.Color;
import com.wpsnetwork.patrones.abstractfactory.interfaces.Forma;

public class ColorFactory extends AbstractFactory {
	
	@Override
	public Color getColor(String tipoColor){
		Color color = null;
		
		if(tipoColor.equalsIgnoreCase("VERDE"))
			color = new Verde();
		else if (tipoColor.equalsIgnoreCase("ROJO"))
			color = new Rojo();
		
		return color;
	}

	@Override
	public Forma getForma(String tipoForma) {
		// TODO Auto-generated method stub
		return null;
	}
}
