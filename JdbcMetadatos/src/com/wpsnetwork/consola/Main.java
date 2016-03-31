package com.wpsnetwork.consola;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Main {
	private static String url;
	private static String usuario;
	private static String password;
	private static DataSource datasource;

	public static void main(String[] args) throws IOException,  
												InstantiationException, 
												IllegalAccessException, 
												ClassNotFoundException,  
												SQLException {
		
		Properties recurso = new Properties();
		recurso.load(Main.class.getResourceAsStream("../../../configuracionBD.properties"));
		
		Class.forName(recurso.getProperty("DRIVER")).newInstance();

		//Obtengo los parámetros de conexión
		url = recurso.getProperty("URL");
		usuario = recurso.getProperty("USUARIO");
		password = recurso.getProperty("PASSWORD");
		
		OracleDataSource ds = new OracleDataSource();
		ds.setURL(url);
		ds.setUser(usuario);
		ds.setPassword(password);
		
		datasource = ds; 
		
		try(Connection conexion = getConnection()){
			
			//Obtener datos de la base de datos
			DatabaseMetaData metadatos = conexion.getMetaData();
			System.out.println("Base de datos: " + metadatos.getDatabaseProductName());
			System.out.println("Versión base de datos: " + metadatos.getDatabaseProductVersion());
			
			//Obetener esquemas de la BD
			ResultSet esquemas = metadatos.getSchemas();
			while(esquemas.next()){
				System.out.println("Esquema: " + esquemas.getString("TABLE_SCHEM")); //Pos 1
			}
			
			//Obtener las tablas del esquema WPS
			ResultSet tablas = metadatos.getTables(null, "WPS", "%", null);
			while(tablas.next()){
				System.out.println("Nombre de la tabla: " + tablas.getString("TABLE_NAME") + //Pos 3
									" Esquema: " + tablas.getString("TABLE_SCHEM") +		 //Pos 2
									" Tipo: " + tablas.getString("TABLE_TYPE"));			//Pos 4 
			}
			
			//Obtener las funciones del esquema WPS
			ResultSet funciones = metadatos.getFunctions(null, "WPS", "%");
			while(funciones.next()){
				System.out.println("Nombre de la función: " + funciones.getString("FUNCTION_NAME") + //Pos 3
									" Esquema: " + funciones.getString("FUNCTION_SCHEM") +		 //Pos 2
									" Tipo: " + funciones.getString("FUNCTION_TYPE") +			//Pos 5
									" Nombre específico: " + funciones.getString("SPECIFIC_NAME"));	//Pos 6
			}
			
			//Obtener el nombre de usuario
			System.out.println(metadatos.getUserName());
			
			//Obtener información sobre las columnas de una tabla
			ResultSet columnas = metadatos.getColumns(null, "WPS", "CLIENTE", "%");
			while(columnas.next()){
				String nombreTabla = columnas.getString("TABLE_NAME");			//Pos 3
				String nombreEsquemaTabla = columnas.getString("TABLE_SCHEM");	//Pos 2
				String nombreColumna = columnas.getString("COLUMN_NAME");		//Pos 4
				String tipoColumna = columnas.getString("DATA_TYPE");			//Pos 5
				String nombreTipoColumna = columnas.getString("TYPE_NAME");		//Pos 6
				String tamanoColumna = columnas.getString("COLUMN_SIZE");		//Pos 7
				String decimalesColumna = columnas.getString("DECIMAL_DIGITS");	//Pos 9
				String precisionColumna = columnas.getString("NUM_PREC_RADIX");	//Pos 10
				String nullableColumna = columnas.getString("NULLABLE");		//Pos 11
				String posicionColumna = columnas.getString("ORDINAL_POSITION");//Pos 17
				String autoincrementoColumna = columnas.getString("IS_AUTOINCREMENT");	//Pos 23
				
				System.out.println( "Tabla: " + nombreTabla +
									" Esquema: " + nombreEsquemaTabla +
									" Nombre columna: " + nombreColumna +
									" Tipo SQL columna: " + tipoColumna + 
									" Tipo columna: " + nombreTipoColumna +
									" Tamaño columna: " + tamanoColumna + 
									" Decimales columna: " + decimalesColumna + 
									" Precision columna: " + precisionColumna +
									" Permite valor nulo: " + nullableColumna +
									" Posición columna en la tabla: " + posicionColumna +
									" Columna autoincremental: " + autoincrementoColumna);
				
				
			}
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	private static Connection getConnection() throws SQLException{
		return datasource.getConnection();
	}

}











