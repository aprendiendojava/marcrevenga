package com.wpsnetwork.consola;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.wpsnetwork.entidades.Cliente;
import com.wpsnetwork.entidades.Pedido;

public class App {
    public static void main( String[] args ){
        /*
         		Creamos secuencias de BBDD para los ids de pedido y cliente
         		
         		CREATE SEQUENCE CLIENTE_ID_SEQ START WITH 100 INCREMENT BY 1;
         		CREATE SEQUENCE PEDIDO_ID_SEQ START WITH 100 INCREMENT BY 1;
         */
    	
    	//Le decimos que sistem de log debe usar Hibernate
    	System.setProperty("org.jboss.logging.provider", "log4j2");
    	
    	//Guardar datos
    	Session sesion = HibernateUtil.getSession();
    	sesion.beginTransaction();
    	
    	Cliente c1 = new Cliente(0, "Cliente 1000",null);
    	Set<Pedido> pedidos = new HashSet<>();
    	Pedido p1 = new Pedido(0, c1, LocalDate.now(), "Info pedido 1000");
    	pedidos.add(p1);
    	c1.setPedidos(pedidos);
    	
    	sesion.save(c1);
    	
    	sesion.getTransaction().commit();
    	sesion.close();
    	
    	//Actualizar datos
    	sesion = HibernateUtil.getSession();
    	sesion.beginTransaction();
    	
    	c1.setNombre("Nombre modificado");
    	sesion.merge(c1);
    	
    	sesion.getTransaction().commit();
    	sesion.close();
        
    	//Eliminar
    	//Actualizar datos
    	sesion = HibernateUtil.getSession();
    	sesion.beginTransaction();
    	
    	sesion.delete(c1);
    	
    	sesion.getTransaction().commit();
    	sesion.close();
    	
    	//Mostrar resultados
    	sesion = HibernateUtil.getSession();
    	
    	List<Cliente> resultado = HibernateUtil.listAndCast(sesion.createQuery("from Cliente"));
    	System.out.println(resultado);
    	
    	sesion.close();
        
        HibernateUtil.setDown();
    }
}
