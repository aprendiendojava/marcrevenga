package com.wpsnetwork.dao.interfaces;

import javax.persistence.EntityManager;

import com.wpsnetwork.jpa.EntityManagerUtil;

public interface Dao<T> {
	@SuppressWarnings("unchecked")
	default public T get(Class metadato, int clave){
		EntityManager entityManager = null;
		T objeto = null;
		
		try{
			entityManager = EntityManagerUtil.getEntityManager();
			objeto = (T) entityManager.find(metadato, clave);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
		
		return objeto;
	}
	default public void insert(T objeto){
		EntityManager entityManager = null;
		try{
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(objeto);
			entityManager.getTransaction().commit();
		}catch(Exception ex){
			entityManager.getTransaction().rollback();
			throw new RuntimeException(ex);
		}
	}
	default public void update(T objeto){
		EntityManager entityManager = null;
		try{
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(objeto);
			entityManager.getTransaction().commit();
		}catch(Exception ex){
			entityManager.getTransaction().rollback();
			throw new RuntimeException(ex);
		}
	}
	default public void delete(Class metadato, int clave){
		EntityManager entityManager = null;
		try{
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			T objeto = (T) entityManager.find(metadato, clave);
			entityManager.remove(objeto);
			entityManager.getTransaction().commit();
		}catch(Exception ex){
			entityManager.getTransaction().rollback();
			throw new RuntimeException(ex);
		}
	}
}
