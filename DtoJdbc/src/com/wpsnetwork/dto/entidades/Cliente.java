package com.wpsnetwork.dto.entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.RepositorioPedidosDao;
import com.wpsnetwork.dao.interfaces.Dao;

public class Cliente {
	private com.wpsnetwork.dao.entidades.Cliente clienteDao;
	private List<Pedido> pedidos;
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cliente(int id, String nombre, List<Pedido> pedidos){
		clienteDao = new com.wpsnetwork.dao.entidades.Cliente(id, nombre);
		this.pedidos = pedidos;
	}
	
	public int getId(){
		return clienteDao.getId();
	}
	
	public void setId(int id){
		clienteDao.setId(id);
	}
	
	public String getNombre(){
		return clienteDao.getNombre();
	}
	
	public void setNombre(String nombre){
		clienteDao.setNombre(nombre);
	}
	
	public void setPedido(List<Pedido> pedidos){
		this.pedidos = pedidos;
	}
	
	public List<Pedido> getPedidos(){
		if(pedidos == null){
			pedidos = buscarPedidos(); 
		}
		return pedidos;
	}


	@Override
	public String toString() {
		return "Cliente [Id: " + clienteDao.getId() +
						" Nombre: " + clienteDao.getNombre() +
						" Pedidos: " + this.pedidos + "]";
	}	
	
	private List<Pedido> buscarPedidos() throws SQLException{
		Dao<com.wpsnetwork.dao.entidades.Pedido> dao= new RepositorioPedidosDao();
		List<com.wpsnetwork.dao.entidades.Pedido> pedidosDao = dao.getAll();
		List<Pedido> listaDto = new ArrayList<>();
		for(com.wpsnetwork.dao.entidades.Pedido p : pedidosDao){
			if(p.getCliente() == getId())
				listaDto.add(RepositorioPedidosDto.convertirDaoDto(p));
		}
			
		return listaDto;
	}
}









