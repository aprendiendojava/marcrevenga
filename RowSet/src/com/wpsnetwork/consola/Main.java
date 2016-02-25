package com.wpsnetwork.consola;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

import com.wpsnetwork.entidades.Cliente;
import com.wpsnetwork.entidades.Pedido;

public class Main {

	private static String driver;
	private static String url;
	private static String usuario;
	private static String password;
	
	public static void main(String[] args) throws 	IOException, 
													InstantiationException, 
													IllegalAccessException, 
													ClassNotFoundException, 
													SQLException {
		
		Properties prop = new Properties();
		prop.load(Main.class.getResourceAsStream("../../../configuracionBD.properties"));
		
		driver = prop.getProperty("DRIVER");
		url = prop.getProperty("URL");
		usuario = prop.getProperty("USUARIO");
		password = prop.getProperty("PASSWORD");
		
		Class.forName(driver).newInstance();
		
		//Para crear todos los tipos de RowSet tenemos una factoria que es
		//  la clase RowSetProvider
		
		RowSetFactory fabricador = RowSetProvider.newFactory();	//Factoria de rowsets
		
//		//JdbcRowSet
//		JdbcRowSet rowSet = fabricador.createJdbcRowSet();		//Configuramos la conexion del RowSet
//		rowSet.setUrl(url);
//		rowSet.setUsername(usuario);
//		rowSet.setPassword(password);
//		
//		rowSet.setCommand("SELECT ID, NOMBRE FROM CLIENTE");
//		rowSet.execute();
//		
//		//Nos tenemos que posicionar en la posicion antes de la primera posición
//		List<Cliente> clientes = new ArrayList<>();
//		rowSet.beforeFirst();
//		
//		while(rowSet.next()){
//			clientes.add(new Cliente(rowSet.getInt("id"), rowSet.getString("nombre")));
//		}
//		System.out.println(clientes);
//		
//		//Insertar una fila
//		rowSet.moveToInsertRow();	//Fila especial para insertar
//		rowSet.updateInt("id", 50);
//		rowSet.updateString("nombre", "Cliente 50");
//		rowSet.insertRow(); 		//Inserta la fila
//		
//		rowSet.moveToCurrentRow(); //Vuelve a la posición donde estaba del rowset
//		
//		//Para eliminar nos posicionamos en la fila que queremos y luego hacemos
//		//   .deleteRow()
//		
//		rowSet.close();
		
		//WebRowSet
//		WebRowSet rowSet = fabricador.createWebRowSet();		//Configuramos la conexion del RowSet
//		rowSet.setUrl(url);
//		rowSet.setUsername(usuario);
//		rowSet.setPassword(password);
//		
//		rowSet.setCommand("SELECT ID, NOMBRE FROM CLIENTE");
//		rowSet.execute();
//		
//		rowSet.writeXml(new FileOutputStream("clientes.xml"));
		
		//FilteredRowSet
		//Permite sobre un mismo resultado, ir aplicando filtros para obtener diferentes
		//  resultados parciales
		FilteredRowSet rowSet = fabricador.createFilteredRowSet();		//Configuramos la conexion del RowSet
		rowSet.setUrl(url);
		rowSet.setUsername(usuario);
		rowSet.setPassword(password);
		rowSet.setKeyColumns(new int[]{1});
		
		rowSet.setCommand("SELECT ID, FECHA, INFO, IDCLIENTE FROM PEDIDO");
		rowSet.execute();
		
		rowSet.setFilter(new FiltroRangoYear(2014, 2015));
		
		//Nos tenemos que posicionar en la posicion antes de la primera posición
		List<Pedido> pedidos = new ArrayList<>();
		rowSet.beforeFirst();
		
		while(rowSet.next()){
			pedidos.add(new Pedido(	rowSet.getInt("id"), 
									rowSet.getDate("fecha"), 
									rowSet.getString("info"),
									rowSet.getInt("idcliente")));
		}
		System.out.println(pedidos);
		
	}

}

class FiltroRangoYear implements Predicate{

	private int minYear, maxYear;
	
	public FiltroRangoYear(int minYear, int maxYear) {
		super();
		this.minYear = minYear;
		this.maxYear = maxYear;
	}

	@Override
	public boolean evaluate(RowSet rs) {
		boolean retorno = false;
		try {
			
			retorno = evaluate(rs.getDate("FECHA"), "FECHA");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno;
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		boolean retorno = false;
		if(column==2){
			retorno = evaluate(value, "FECHA");
		}
		
		return retorno;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		//Devuelve cierto si la fila tiene que pasar el filtro
		
		java.sql.Date fecha = (java.sql.Date) value;
		int year = fecha.toLocalDate().getYear();
		
		return year >= minYear && year <= maxYear;
	}
	
}
























