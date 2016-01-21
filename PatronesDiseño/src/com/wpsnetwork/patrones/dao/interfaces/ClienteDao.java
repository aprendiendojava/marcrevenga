package com.wpsnetwork.patrones.dao.interfaces;

import java.util.List;

import com.wpsnetwork.patrones.dao.Cliente;

public interface ClienteDao {
	List<Cliente> getAll();
	boolean update(Cliente c);
	boolean add(Cliente c);
	boolean delete(int id);
	Cliente get(int id);
}
