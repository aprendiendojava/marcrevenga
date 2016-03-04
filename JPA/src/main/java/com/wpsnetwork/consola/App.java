package com.wpsnetwork.consola;

import java.util.List;

import javax.persistence.EntityManager;

import com.wpsnetwork.jpa.EntityManagerUtil;
import com.wpsnetwork.jpa.entidades.Dato;

public class App 
{
    public static void main( String[] args ){
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        //El JPA permite hacer consultas a la base de datos usando en 
        // lenguaje JPQL
        
        List<Dato> lista = em.createQuery("select c.nombre, p.info from Cliente c join Pedido p", Dato.class).getResultList();
        
        System.out.println(lista);
    }
}
