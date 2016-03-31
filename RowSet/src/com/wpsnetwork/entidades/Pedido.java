package com.wpsnetwork.entidades;

import java.util.Date;

public class Pedido {
	private int id;
	private Date fecha;
	private String info;
	private int cliente;
	
	public Pedido(int id, Date fecha, String info, int cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.info = info;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", info=" + info + ", cliente=" + cliente + "]";
	}
	
	

}
