package com.wpsnetwork.jpa.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
@NamedQueries({
	@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c"),
	@NamedQuery(name="Cliente.findById", query="SELECT c FROM Cliente c WHERE c.id = :id")
})
public class Cliente implements Serializable{

	private static final long serialVersionUID = 7940395430829372755L;
	
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="NOMBRE")
	private String nombre;
	@OneToMany(	cascade=CascadeType.ALL,
				fetch=FetchType.LAZY,
				mappedBy="idcliente")
	private List<Pedido> pedidos;
	
	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, List<Pedido> pedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pedidos = pedidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", pedidos=" + pedidos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
