package com.wpsnetwork.consola;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	
	//Método para arrancar Hibernate
	private static SessionFactory setUp() throws Exception{
		SessionFactory sessionFactory = null;
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
													.configure()
													.build();
		
		try{
			sessionFactory = new MetadataSources(registry).buildMetadata()
															.buildSessionFactory();
		}catch(HibernateException e){
			StandardServiceRegistryBuilder.destroy(registry); //Destruimos Hibernate
			throw e;
		}
		return sessionFactory;
	}
	
	public static Session getSession(){
		if(sessionFactory == null)
			try{
				sessionFactory = setUp();
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return sessionFactory.openSession();	//Devuelve una conexión a la BBDD
	}
	
	public static void setDown(){
		sessionFactory.close(); 				//Paramos el session Factory
	}
	
	public static <T> List<T> listAndCast(Query q){
		@SuppressWarnings("unchecked")
		List<T> lista = q.list();
		return lista;
	}
}













