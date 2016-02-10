package com.wpsnetwork.dao.interfaces;

import java.util.List;

public interface Dao<T> {
	T get(int id);
	void insert(T elemento);
	void update(T elemento);
	void delete(T elemento);
	List<T> getAll();
}
