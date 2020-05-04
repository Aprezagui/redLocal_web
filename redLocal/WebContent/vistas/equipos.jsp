<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="conexionDB.*" %>
<%@ page import="com.vistas.*" %>
<%@ page import="java.sql.*" %>  
<%@ page import = "java.util.LinkedList"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Equipos registrados</title>
</head>
<body>
	  <!-- Begin Page Content -->
        <div class="container-fluid">
        
      	  <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Equipos registrados</h1>
                  
      <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Lista de equipos</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Tipo</th>
                      <th>Nombre</th>
                      <th>Descripcion</th>
                      </tr>
                  </thead>
                  <tbody>
                  
    <%
		Conexion c = new Conexion();
		LinkedList<Equipo> lista = c.buscarEquipos();
		
		for (int i=0;i<lista.size();i++)
		{
		   out.println("<tr>");
		   out.println("<td>"+lista.get(i).getTipo()+"</td>");
		   out.println("<td>"+lista.get(i).getNombre()+"</td>");
		   out.println("<td>"+lista.get(i).getDescripcion()+"</td>");
		   out.println("</tr>");
		}
	%>
                                     
                  </tbody>
                </table>
              </div>
            </div>
          </div>
       </div>
	
	
	

</body>
</html>