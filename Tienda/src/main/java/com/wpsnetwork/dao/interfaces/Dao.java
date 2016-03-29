package com.wpsnetwork.dao.interfaces;

import java.util.List;

import org.hibernate.Session;

public interface Dao<T> {
	public Session openCurrentSession();
	public Session openCurrentSessionwithTransaction();
	public void closeCurrentSession();
	public void closeCurrentSessionwithTransaction();
	public Session getCurrentSession();
	public void setCurrentSession(Session currentSession);
	
	default public void persist(T entity){
		getCurrentSession().persist(entity);
	};
	default public void update(T entity){
		getCurrentSession().merge(entity);
	};
	
	@SuppressWarnings("unchecked")
	default public T findById(String id){
		T result = (T) new Object();
		result = (T) getCurrentSession().get(result.getClass(), id);
		return result;
	};
	default public void delete(T entity){
		getCurrentSession().delete(entity);
	};
	@SuppressWarnings("unchecked")
	default public List<T> findAll(){
		T objeto = (T) new Object();
		String sql = "from " + objeto.getClass().getCanonicalName();
		System.out.println("sql");
		List<T> lista = (List<T>) getCurrentSession().createQuery(sql).list();
		return lista;
	};
	default public void deleteAll(){
		List<T> entityList = findAll();
		for (T entity : entityList) {
			delete(entity);
		}
	};
}
