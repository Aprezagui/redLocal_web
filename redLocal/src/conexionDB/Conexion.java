package conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	private Connection miConexion  = null;
	private ResultSet miResultSet  = null;
	private Statement miStatement  = null;
	private PreparedStatement miPStatement = null;
	
	
	public Conexion() {
		
    	//Parametro de conexion
		String sURL = "jdbc:mysql://192.168.1.230:3306/redlocal?serverTimezone=UTC";
		String user = "redlocal";
		String password= "wifiseguro";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			
			Class.forName(driver);
				miConexion = DriverManager.getConnection(sURL,user,password);
				miStatement = miConexion.createStatement();
				
		}catch (SQLException | ClassNotFoundException sqle) { 
			System.out.println("[ERROR] conexion con el servidor: " 
				    + ((SQLException) sqle).getErrorCode() + " " + sqle.getMessage());  
		}	
		
		System.out.println("###CONEXION REALIZADA###"); 
	}

	public void close() {
		try {
			miConexion.close();
		}catch(Exception e){
			   e.printStackTrace();
		}
	}
	
 	public void buscarNombre(String nombre) {
		String con;
		
		System.out.println ("Busqueda por Nombre:");
		
		if(nombre!=null){
			con="SELECT tipoequipo.tipo, equipo.nombre, `descripcion` "+
				"FROM `equipo` "+
				"LEFT JOIN tipoequipo ON equipo.idtipo = tipoequipo.id "+
				"WHERE equipo.nombre = "+ nombre + ";";
			try {
				miResultSet = miStatement.executeQuery (con);
				
				while (miResultSet.next())
				{
				    System.out.println ("	Grupo:"+miResultSet.getString(1) + "  Nombre:" + miResultSet.getString(2)+ " Descripcion:" + miResultSet.getString(3));
				}
				
			}catch(Exception e){
			   e.printStackTrace();
			}
		}
	}	
	
	public void buscarMAC(String mac) {
		String con;
		
		System.out.println ("Busqueda por MAC:");
		
		if(mac!=null){
			con="SELECT tipoequipo.tipo, equipo.nombre, equipo.descripcion, tipoconexion.conexion, tipoconexion.mac "+
				"FROM `tipoconexion`, `equipo` "+
				"LEFT JOIN tipoequipo ON tipoequipo.id = equipo.idtipo "+
				"WHERE tipoconexion.mac = '"+ mac +"' AND tipoconexion.idequipo = equipo.id";
			try {
				miResultSet = miStatement.executeQuery(con);
				
				while (miResultSet.next())
				{
				    System.out.println ("	Grupo:"+miResultSet.getString(1) + "  Nombre:" + miResultSet.getString(2)+ "  Descripcion:" + miResultSet.getString(3)+ "  T.Conexion:" + miResultSet.getString(4)+ " MAC:" + miResultSet.getString(5));
				}
			}catch(Exception e){
			   e.printStackTrace();
			}
		}
	}
	
	public void buscarConexionEquipo(int id) {
		String con;
		
		System.out.println ("Busqueda por Id:/n");
		
		if(id!=0){
			con="SELECT tipoconexion.conexion, tipoconexion.mac "+
				"FROM `tipoconexion` "+
				"WHERE tipoconexion.idequipo = '"+ id +"'";
			try {
				miResultSet = miStatement.executeQuery(con);
				
				while (miResultSet.next())
				{
				    System.out.println ("	T.conexion:" + miResultSet.getString(1) + "  MAC:" + miResultSet.getString(2));
				}
			}catch(Exception e){
			   e.printStackTrace();
			}
		}
		
		
	}

	
	public void getUserName(String username) {
		
String con;
		
		System.out.println ("Busqueda de usuario por usuario:/n");
		
		if(username!=null){
			con="SELECT `nombre_user`, `apellido1_user`, `apellido2_user`, `user`, `email_user`, `activo_user` "
				+"FROM `user` "
				+"WHERE user.user = '"+ username +"'";
			try {
				miResultSet = miStatement.executeQuery(con);
				
				while (miResultSet.next())
				{
				    System.out.println (miResultSet.getString(1) +" "+ miResultSet.getString(2) + " " + miResultSet.getString(3) +" "+ miResultSet.getString(4));
				}
			}catch(Exception e){
			   e.printStackTrace();
			}
		}
		
	}
	public void setUsuario(String nombre,String apellido1,String apellido2,String username,String email,String pass) {

		try {
			miPStatement=miConexion.prepareStatement("INSERT INTO `user`(`nombre_user`, `apellido1_user`, `apellido2_user`, `user`, `email_user`, `password` ) VALUES (?,?,?,?,?,?)"); 
		
			//miPStatement.setInt(0,);
			miPStatement.setString(1,nombre);
			miPStatement.setString(2,apellido1);
			miPStatement.setString(3,apellido2);
			miPStatement.setString(4,username);
			miPStatement.setString(5,email);
			miPStatement.setString(6,pass);
			
			miPStatement.executeLargeUpdate();

		}catch(Exception e){
		   e.printStackTrace();
		}
		
		
		//INSERT INTO `user`(`id_user`, `nombre_user`, `apellido1_user`, `apellido2_user`, `user`, `password`, `email_user`, `activo_user`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8])
		
	}
}
