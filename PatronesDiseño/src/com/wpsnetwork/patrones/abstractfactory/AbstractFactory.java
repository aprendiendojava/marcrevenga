package com.wpsnetwork.patrones.abstractfactory;

import com.wpsnetwork.patrones.abstractfactory.interfaces.Color;
import com.wpsnetwork.patrones.abstractfactory.interfaces.Forma;

public abstract class AbstractFactory {
	public abstract Forma getForma(String tipoForma);
	public abstract Color getColor(String tipoColor);
}
