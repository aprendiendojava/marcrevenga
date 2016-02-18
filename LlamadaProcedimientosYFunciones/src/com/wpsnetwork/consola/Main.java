package com.wpsnetwork.consola;

import java.io.IOException;
import java.util.Properties;

/*
CREAMOS PROCEDIMIENTOS  (desde el SQL Plus*)
================================

CREATE OR REPLACE PROCEDURE 
    INSERTA_PEDIDO(NOMBRE_CLIENTE VARCHAR2, 
                                PFECHA DATE, PINFO VARCHAR2 ) 
IS
BEGIN
    INSERT INTO PEDIDO(ID, FECHA,INFO,IDCLIENTE)
    VALUES
    (
        (SELECT NVL(MAX(ID),0)+1 FROM PEDIDO),
        PFECHA,
        PINFO,
        (SELECT ID FROM CLIENTE WHERE NOMBRE = NOMBRE_CLIENTE)
    );
END;
/

CREATE OR REPLACE FUNCTION 
    NOMBRE_DE_CLIENTE(ID_CLIENTE NUMBER)
RETURN VARCHAR2
IS 
    VNOMBRE CLIENTE.NOMBRE%TYPE;
BEGIN
    SELECT NOMBRE 
        INTO VNOMBRE 
        FROM CLIENTE 
        WHERE ID = ID_CLIENTE;

    RETURN VNOMBRE;
END;
/
*/


public class Main {
	private static String url;
	private static String usuario;
	private static String driver;
	private static String password;

	public static void main(String[] args) throws IOException {
		
		Properties recurso = new Properties();
		recurso.load(Main.class.getResourceAsStream("../../../configuracionBD.properties"));
		
		url = (String) recurso.get("URL");
		driver = (String) recurso.get("DRIVER");
		usuario = (String) recurso.get("USUARIO");
		password = (String) recurso.get("PASSWORD");
		
		//Cargamos el driver
		Class.forName(driver).newInstance();
		
		//Crearemos un datasource
		
	}

}





















