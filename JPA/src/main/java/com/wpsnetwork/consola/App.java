package com.wpsnetwork.consola;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.wpsnetwork.jpa.EntityManagerUtil;
import com.wpsnetwork.jpa.entidades.Cliente;
import com.wpsnetwork.jpa.entidades.Dato;
import com.wpsnetwork.jpa.entidades.Pedido;

public class App 
{
    public static void main( String[] args ){
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        //El JPA permite hacer consultas a la base de datos usando en 
        // lenguaje JPQL
        
//        List<Dato> lista = em.createQuery("select new com.wpsnetwork.jpa.entidades.Dato(c.nombre, p.info) from Cliente c join Pedido p", 
//        									Dato.class)
//        					  .getResultList();
        
//        List<Cliente> listaClientes = em.createNamedQuery("Cliente.findAll",Cliente.class)
//        					.getResultList();
//        System.out.println(listaClientes);
//        
//        Cliente c = em.createNamedQuery("Cliente.findById",Cliente.class)
//        				.setParameter("id", 1)
//        				.getSingleResult();
//        System.out.println(c);
        
        //Insertar
        
        Cliente c1 = new Cliente(150, "Cliente 100", null);
        Pedido p1 = new Pedido(150, new Date(), "Info pedido 150", c1);
        Pedido p2 = new Pedido(151, new Date(), "Info pedido 151", c1);
        List<Pedido> pedidos = new ArrayList<Pedido>();
        pedidos.add(p1);
        pedidos.add(p2);
        c1.setPedidos(pedidos);
        
        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();
        
    }
}

















