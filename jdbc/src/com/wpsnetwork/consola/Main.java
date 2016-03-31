package com.wpsnetwork.consola;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.entidades.Cliente;

public class Main {

	private static final String CADENA_CONEXION = "jdbc:oracle:thin:@localhost:1521:pcarrier";
	private static final String USUARIO = "wps";
	private static final String PASSWORD = "usuario";
	
	public static void main(String[] args) throws SQLException {
		
		//1.- Añadir el driver de la BD en el proyecto
		//			ojdbc7.jar
		
		//2.-Registrar el driver en la MV por código
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		//Class.forName("oracle.jdbc.OracleDriver").newInstance();	//Método alternativo
		
		//Abrimos una conexión a la BD
		try(Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD)){
			//Realizar las operaciones con la base de datos
			
			Statement comando = conexion.createStatement();	//Creamos un comando
			
			String sql = "CREATE TABLE CLIENTE(" +
							"ID NUMBER(5) PRIMARY KEY," +
							"NOMBRE VARCHAR2(100) NOT NULL" +
							")";
			
			//comando.executeUpdate(sql);
			
//			comando.executeUpdate("INSERT INTO CLIENTE(ID, NOMBRE) VALUES(1, 'Cliente 1')");
//			comando.executeUpdate("INSERT INTO CLIENTE(ID, NOMBRE) VALUES(2, 'Cliente 2')");
//			comando.executeUpdate("INSERT INTO CLIENTE(ID, NOMBRE) VALUES(3, 'Cliente 3')");
//			comando.executeUpdate("INSERT INTO CLIENTE(ID, NOMBRE) VALUES(4, 'Cliente 4')");
			
			sql = "CREATE TABLE PEDIDO(" +
					"ID NUMBER(5) PRIMARY KEY," +
					"FECHA DATE NOT NULL," +
					"INFO VARCHAR2(100) NOT NULL," +
					"IDCLIENTE NUMBER(5) REFERENCES CLIENTE(ID) NOT NULL" +
					")";
			
			//comando.executeUpdate(sql);
			
//			comando.executeUpdate("INSERT INTO PEDIDO(ID, FECHA, INFO, IDCLIENTE) VALUES(1, '1/5/2013', 'Pedido 1', 1)");
//			comando.executeUpdate("INSERT INTO PEDIDO(ID, FECHA, INFO, IDCLIENTE) VALUES(2, '2/5/2015', 'Pedido 2', 1)");
			
			
			//Obtener datos de la BBDD
			sql = "SELECT ID, NOMBRE FROM CLIENTE";
			ResultSet resultado = comando.executeQuery(sql);
			
			List<Cliente> clientes = new ArrayList<>();
			while(resultado.next()){
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				clientes.add(new Cliente(id, nombre));
			}
			
			System.out.println(clientes); 	//Mostramos los datos recuperados
			
			//Evitar SQL Injection
			int codigo = 4;
			sql = "SELECT * FROM CLIENTE WHERE ID = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, codigo);	//Para cada comodín le ponemos el valor
			
			resultado = ps.executeQuery();

			while(resultado.next()){
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				System.out.println(new Cliente(id, nombre));
			}
			
			
			
			//Automáticamente se cierra la conexión
		}catch(SQLException ex){
			System.out.println("Mensaje BBDD: " + ex.getMessage());
			System.out.println("Número de error de la BBDD: " + ex.getErrorCode());
		}

	}

}















