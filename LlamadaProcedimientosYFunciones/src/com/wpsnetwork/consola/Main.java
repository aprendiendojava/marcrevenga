package com.wpsnetwork.consola;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

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
	private static DataSource datasource;

	public static void main(String[] args) throws 	IOException, 
													InstantiationException, 
													IllegalAccessException, 
													ClassNotFoundException, 
													SQLException {
		
		Properties recurso = new Properties();
		recurso.load(Main.class.getResourceAsStream("../../../configuracionBD.properties"));
		
		url = (String) recurso.get("URL");
		driver = (String) recurso.get("DRIVER");
		usuario = (String) recurso.get("USUARIO");
		password = (String) recurso.get("PASSWORD");
		
		//Cargamos el driver
		Class.forName(driver).newInstance();
		
		//Crearemos un datasource
		OracleDataSource ds = new OracleDataSource();
		ds.setUser(usuario);
		ds.setPassword(password);
		ds.setURL(url);
		datasource = ds;
		
		try(Connection conexion = getConnection()){
			//Llamada al procedimiento
			CallableStatement comando = conexion.prepareCall("{call INSERTA_PEDIDO(?,?,?)}");
			comando.setString(1, "Cliente 1");
			long milis = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
			comando.setDate(2, new Date(milis));
			comando.setString(3, "Pedido nuevo");
			comando.execute();
			
			//Llamada a la función
			comando = conexion.prepareCall("{?=call NOMBRE_DE_CLIENTE(?)}");
			comando.setInt(2, 1);  		//Queremos obtener el nombre del cliente con id = 1
			comando.registerOutParameter(1, java.sql.Types.VARCHAR);
			comando.execute();
			System.out.println( comando.getString(1) );
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	private static Connection getConnection() throws SQLException{
		return datasource.getConnection();
	}

}
