package com.wpsnetwork.consola;

import com.wpsnetwork.entidades.Cliente;

public class App 
{
    public static void main( String[] args )
    {
        Cliente c = new Cliente(1, "Juanito");
        
        System.out.println(c);
    }
}
