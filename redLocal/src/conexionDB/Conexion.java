package conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	private Connection miConexion = null;
	private ResultSet miResultSet = null;
	private Statement miStatement = null;
	
	
	public Conexion() {
		
    	//Parametro de conexion
		String sURL = "jdbc:mysql://192.168.1.230:3306/redlocal?serverTimezone=UTC";
		String user = "redlocal";
		String password= "wifiseguro";
		try {
			
				miConexion = DriverManager.getConnection(sURL,user,password);
				miStatement = miConexion.createStatement();
				
		}catch (SQLException sqle) { 
			System.out.println("[ERROR] conexion con el servidor: " 
				    + sqle.getErrorCode() + " " + sqle.getMessage());  
		}	
		
		System.out.println("###CONEXION REALIZADA###"); 
	}
	
	public void buscarNombre(String nombre) {
		String con;
		
		if(nombre!=null){
			con="SELECT tipoequipo.tipo, equipo.nombre, `descripcion` "+
				"FROM `equipo` "+
				"LEFT JOIN tipoequipo ON equipo.idtipo = tipoequipo.id "+
				"WHERE equipo.nombre = "+ nombre + ";";
			try {
				miResultSet = miStatement.executeQuery (con);
				
				while (miResultSet.next())
				{
				    System.out.println ("Grupo:"+miResultSet.getString(1) + "  Nombre:" + miResultSet.getString(2)+ " Descripcion:" + miResultSet.getString(3));
				}
				
			}catch(Exception e){
			   e.printStackTrace();
			}
		}
	}	
	
	public void buscarMAC(String mac) {
		String con;
		
		if(mac!=null){
			con="SELECT tipoequipo.tipo, equipo.nombre, equipo.descripcion, tipoconexion.conexion, tipoconexion.mac "+
				"FROM `tipoconexion`, `equipo` "+
				"LEFT JOIN tipoequipo ON tipoequipo.id = equipo.idtipo "+
				"WHERE tipoconexion.mac = '"+ mac +"' AND tipoconexion.idequipo = equipo.id";
			try {
				miResultSet = miStatement.executeQuery(con);
				
				while (miResultSet.next())
				{
				    System.out.println ("Grupo:"+miResultSet.getString(1) + "  Nombre:" + miResultSet.getString(2)+ "  Descripcion:" + miResultSet.getString(3)+ "  T.Conexion:" + miResultSet.getString(4)+ " MAC:" + miResultSet.getString(5));
				}
			}catch(Exception e){
			   e.printStackTrace();
			}
		}
	}
	
	public void buscarConexionEquipo(int id) {
		String con;
		
		if(id!=0){
			con="SELECT tipoconexion.conexion, tipoconexion.mac "+
				"FROM `tipoconexion` "+
				"WHERE tipoconexion.idequipo = '"+ id +"'";
			try {
				miResultSet = miStatement.executeQuery(con);
				
				while (miResultSet.next())
				{
				    System.out.println ("T.conexion:" + miResultSet.getString(1) + "  MAC:" + miResultSet.getString(2));
				}
			}catch(Exception e){
			   e.printStackTrace();
			}
		}
		
		
	}

}
