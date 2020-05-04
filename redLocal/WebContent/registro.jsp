<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="conexionDB.*" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Insert title here</title>
</head>
<body>
	<%
	Conexion miConexion = new Conexion();	

	
	//Recojo datos 
	String nombre=request.getParameter("nombre");
	String apellido1=request.getParameter("apellido1");
	String apellido2=request.getParameter("apellido2");
	String username=request.getParameter("username");
	String email=request.getParameter("email");
	String pass=request.getParameter("pass1");
	
	
	miConexion.setUsuario(nombre, apellido1, apellido2, username, email, pass);
			//Parametro de conexion
	
			
	%>
	
	<h1>Usuario registro</h1>
	
	
</body>
</html>
	