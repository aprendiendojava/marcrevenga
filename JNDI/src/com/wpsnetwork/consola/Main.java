package com.wpsnetwork.consola;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Main {

	private static String driver;
	private static String url;
	private static String usuario;
	private static String password;
	
	private static final String DATASOURCE_NAME = "DSWps";
	
	static{
		try{
			
			Properties prop = new Properties();
			prop.load(Main.class.getResourceAsStream("../../../configuracionBD.properties"));
			
			driver = prop.getProperty("DRIVER");
			url = prop.getProperty("URL");
			usuario = prop.getProperty("USUARIO");
			password = prop.getProperty("PASSWORD");
			
			Class.forName(driver).newInstance();
			
			//Si no existe en el JNDI lo creamos
			crearGuardarDataSource();
			
		}catch(Exception ex){
			throw new ExceptionInInitializerError(ex);
		}
		
	}
	
	public static void main(String[] args) {
		//Nos conectamos al JNDI en cuestion
		//Cada fabricante del JNDI nos tiene que indicar como
		//  configurar su JNDI

		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
				"com.sun.jndi.fscontext.RefFSContextFactory");

		props.setProperty(Context.PROVIDER_URL, "file:///c:/fscontext");

		InitialContext ctx = null;

		try{
			ctx = new InitialContext(props);

			DataSource ds = (DataSource) ctx.lookup(DATASOURCE_NAME); 	//Si no existe lanza una
																		//  excepción
			
			try(Connection con = ds.getConnection()){
				
				Statement comando = con.createStatement();
				ResultSet resultado = comando.executeQuery("SELECT COUNT(*) FROM CLIENTE");
				resultado.next();
				System.out.println("Número de clientes: " + resultado.getInt(1));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}catch(NamingException ex){
			ex.getStackTrace();
		}finally{
			try {
				
				ctx.close();
			
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void crearGuardarDataSource() {
		//Nos conectamos al JNDI en cuestion
		//Cada fabricante del JNDI nos tiene que indicar como
		//  configurar su JNDI
		
		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
							"com.sun.jndi.fscontext.RefFSContextFactory");
		
		props.setProperty(Context.PROVIDER_URL, "file:///c:/fscontext");
		
		InitialContext ctx = null;
		
		try{
			ctx = new InitialContext(props);
			
			Object obj = ctx.lookup(DATASOURCE_NAME); 	//Si no existe lanza una
														//  excepción
		}catch(NamingException ex){
			try{
				OracleDataSource ds = new OracleDataSource();
				ds.setURL(url);
				ds.setUser(usuario);
				ds.setPassword(password);
				
				ctx.bind(DATASOURCE_NAME, ds); 		//Añadimos el datasource
													// al JNDI
			}catch(SQLException | NamingException ex2){
				ex2.getStackTrace();
			}
		}finally{
			try {
				
				ctx.close();
			
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}













