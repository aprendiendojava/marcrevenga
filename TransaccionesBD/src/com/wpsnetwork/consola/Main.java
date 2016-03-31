package com.wpsnetwork.consola;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Main {
	private static DataSource ds;
	
	static{
		
		try{
		Properties prop = new Properties();
		prop.load(Main.class.getResourceAsStream("../../../configuracionDB.properties"));
		
		String url = prop.getProperty("URL"); 
		String driver = prop.getProperty("DRIVER");
		String usuario = prop.getProperty("USUARIO");
		String password = prop.getProperty("PASSWORD");
		
		//Cargamos el driver en la MV
		Class.forName(driver).newInstance();
		
		//Creamos un datasource
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setURL(url);
		dataSource.setUser(usuario);
		dataSource.setPassword(password);
		
		ds = dataSource;
		}catch(Exception ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static void main(String[] args) {
		
//		Savepoint savepoint1 = null;
//		Connection conexion = null;
//		
//		try{
//			conexion = getConexion();
//					
//			//Por defecto las conexiones de SQL tienen el AutoCommit a true
//			conexion.setAutoCommit(false); 	//Activamos las transacciones
//			
//			Statement comando = conexion.createStatement();
//			comando.executeUpdate("INSERT INTO CLIENTE VALUES(5,'Cliente 5')");
//			
//			//conexion.rollback(); 		//Deshace la transacción
//			savepoint1 = conexion.setSavepoint();
//			
//			PreparedStatement comando2 = conexion.prepareStatement(
//											"INSERT INTO PEDIDO VALUES(5,?,'PEDIDO', 5)");
//			
//			comando2.setDate(1, new java.sql.Date(new Date().getTime()));
//			comando2.executeUpdate();
//			
//			conexion.commit();		//Confirma la transacción
//					
//			
//			
//		} catch (SQLException e) {
//			try {
//				if((conexion!=null) && (savepoint1!= null)){
//					conexion.rollback(savepoint1);
//				}
//			} catch (SQLException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//		}finally{
//			try {
//				
//				if(conexion!=null)
//					conexion.close();
//				
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
		
		Thread hilo1 = new Thread(()->{
			Connection con = null;
			
			try {
				
				con = getConexion();
				con.setAutoCommit(false);
				Statement comando = con.createStatement();
				comando.executeUpdate("INSERT INTO CLIENTE VALUES(10,'Cliente 10')");
				con.commit();
				
				//Bloqueamos una fila de la base de datos
				comando.executeUpdate("UPDATE CLIENTE SET " +
											"nombre='Cliente 10 modificado' " +
											"WHERE id=10"
										);
				Thread.sleep(2000);	//Esperamos para dejar que otro hilo me 
									//  bloquee en la base de datos una fila 
									//  distinta
				
				comando.executeUpdate("UPDATE CLIENTE SET " +
						"nombre='Cliente 11 modificado' " +
						"WHERE id=11"
					);
				
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				System.out.println("Hilo 1 parado");
			}finally{
				try {
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread hilo2 = new Thread(()->{
			Connection con = null;
			
			try {
				
				con = getConexion();
				con.setAutoCommit(false);
				Statement comando = con.createStatement();
				comando.executeUpdate("INSERT INTO CLIENTE VALUES(11,'Cliente 11')");
				con.commit();
				
				//Bloqueamos una fila de la base de datos
				comando.executeUpdate("UPDATE CLIENTE SET " +
											"nombre='Cliente 11 modificado' " +
											"WHERE id=11"
										);
				Thread.sleep(2000);	//Esperamos para dejar que otro hilo me 
									//  bloquee en la base de datos una fila 
									//  distinta
				
				comando.executeUpdate("UPDATE CLIENTE SET " +
						"nombre='Cliente 10 modificado' " +
						"WHERE id=10"
					);
				
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				System.out.println("Hilo 2 parado");
				
			}finally{
				try {
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		hilo1.start();
		hilo2.start();
		
	}
	
	private static Connection getConexion() throws SQLException{
		return ds.getConnection();
	}

}
