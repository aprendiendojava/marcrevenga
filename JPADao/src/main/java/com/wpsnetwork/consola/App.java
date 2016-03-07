package com.wpsnetwork.consola;

import java.util.ArrayList;

import com.wpsnetwork.dao.Clientes;
import com.wpsnetwork.jpa.entidades.Cliente;

public class App 
{
    public static void main( String[] args ){
        Clientes repoClientes = new Clientes();
        
        //Insertar
        Cliente c1 = new Cliente(1000, "Pepito", new ArrayList<>());
        repoClientes.insert(c1);
        
        //Obtener el cliente
        c1 = repoClientes.get(Cliente.class, 1000);
        System.out.println(c1);
        
        //Modificar un cliente
        c1.setNombre("nombre modificado");
        repoClientes.update(c1);
        c1 = repoClientes.get(Cliente.class, 1000);
        System.out.println(c1);
        
        //Eliminamos el cliente
        repoClientes.delete(Cliente.class, 1000);
        
    }
}
