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
        
    	
    	//Guardar datos
//    	Session sesion = HibernateUtil.getSession();
//    	sesion.beginTransaction();
//    	
    	Cliente c1 = new Cliente(1000, "Cliente 1000",null);
    	Set<Pedido> pedidos = new HashSet<>();
    	pedidos.add(new Pedido(1000, c1, LocalDate.now(), "Info pedido 1000"));
    	c1.setPedidos(pedidos);
//    	
//    	sesion.persist(c1);
//    	
//    	sesion.getTransaction().commit();
//    	sesion.close();
    	
    	//Actualizar datos
//    	Session sesion = HibernateUtil.getSession();
//    	sesion.beginTransaction();
//    	
//    	c1.setNombre("Nombre modificado");
//    	sesion.merge(c1);
//    	
//    	sesion.getTransaction().commit();
//    	sesion.close();
        
    	//Eliminar
    	//Actualizar datos
//    	Session sesion = HibernateUtil.getSession();
//    	sesion.beginTransaction();
//    	
//    	sesion.delete(c1);
//    	
//    	sesion.getTransaction().commit();
//    	sesion.close();
    	
    	//Mostrar resultados
    	Session sesion = HibernateUtil.getSession();
    	
    	List<Cliente> resultado = HibernateUtil.listAndCast(sesion.createQuery("from Cliente"));
    	System.out.println(resultado);
    	
    	sesion.close();
        
        HibernateUtil.setDown();
    }
}
