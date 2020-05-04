package com.seguridad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conexionDB.Conexion;


/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
		PersonaDAO dao= new PersonaDAO();
		Persona p=new Persona();
			    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    		response.setContentType("text/html"); 
	    		PrintWriter out = response.getWriter();
	    		
	    		
		    	//System.out.println("dentro");
		    	String accion=request.getParameter("acction");
				String username=request.getParameter("username");
	    		String pass=request.getParameter("pass1");
	    		
	    		p.setUser(username);
	    		p.setPass(pass);
		    	
		    	if(accion.equals("Ingresar")) { 
	    			//Si la validacion a sido positiva:
		    		if(dao.validar(p)==1) {
		    			HttpSession s=request.getSession();  			
		    			s.setAttribute("Nombre",dao.getNombre());
		    			s.setAttribute("Apellido1",dao.getApellido1());
		    			if(dao.getApellido2()!=null)
		    			s.setAttribute("Apellido2",dao.getApellido2());
		    			
		    			request.getRequestDispatcher("principal.jsp").forward(request, response);
		    		}else {
		    			out.print("Usuario o contraseña incorrectos!"); 
		    			request.getRequestDispatcher("login.jsp").forward(request, response);
		    		}		
		    	}else if(accion.equals("Enviar")){
		    	
		    		Conexion miConexion = new Conexion();	
		    		
		    		//Recojo datos 
		    		String nombre=request.getParameter("nombre");
		    		String apellido1=request.getParameter("apellido1");
		    		String apellido2=request.getParameter("apellido2");
		    		String email=request.getParameter("email");
		    		
		    		//Si el registro del usuario a sido correcto:
		    		if(miConexion.setUsuario(nombre, apellido1, apellido2, username, email, pass) == true) {
		    			//Si la validacion a sido positiva:
		    			if(dao.validar(p)==1) {
				    			HttpSession s=request.getSession();  			
				    			s.setAttribute("Nombre",dao.getNombre());
				    			s.setAttribute("Apellido1",dao.getApellido1());
				    			if(dao.getApellido2()!=null)
				    			s.setAttribute("Apellido2",dao.getApellido2());
				    			request.getRequestDispatcher("principal.jsp").forward(request, response);
				    	}else {
				    			out.print("Usuario o contraseña incorrectos!"); 
				    			request.getRequestDispatcher("login.jsp").forward(request, response);
				    		}		
		    		}
		    						    	
		    }
		    	out.close();
	    }
	        
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html"); 
    		PrintWriter out = response.getWriter();
    		
    		
	    	//System.out.println("dentro");
	    	String accion=request.getParameter("acction");
			String username=request.getParameter("username");
    		String pass=request.getParameter("pass1");
    		
    		if(accion==null) {
    			accion=request.getParameter("acction2");
    		}
    		
    		p.setUser(username);
    		p.setPass(pass);
	    	
	    	if(accion.equals("Ingresar")) { 
    			//Si la validacion a sido positiva:
	    		if(dao.validar(p)==1) {
	    			HttpSession s=request.getSession();  			
	    			s.setAttribute("Nombre",dao.getNombre());
	    			s.setAttribute("Apellido1",dao.getApellido1());
	    			if(dao.getApellido2()!=null)
	    			s.setAttribute("Apellido2",dao.getApellido2());
	    			
	    			request.getRequestDispatcher("principal.jsp").forward(request, response);
	    		}else {
	    			out.print("Usuario o contraseña incorrectos!"); 
	    			request.getRequestDispatcher("login.jsp").forward(request, response);
	    		}		
	    	}else if(accion.equals("Enviar")){
	    	
	    		Conexion miConexion = new Conexion();	
	    		
	    		//Recojo datos 
	    		String nombre=request.getParameter("nombre");
	    		String apellido1=request.getParameter("apellido1");
	    		String apellido2=request.getParameter("apellido2");
	    		String email=request.getParameter("email");
	    		
	    		//Si el registro del usuario a sido correcto:
	    		if(miConexion.setUsuario(nombre, apellido1, apellido2, username, email, pass) == true) {
	    			//Si la validacion a sido positiva:
	    			if(dao.validar(p)==1) {
			    			HttpSession s=request.getSession();  			
			    			s.setAttribute("Nombre",dao.getNombre());
			    			s.setAttribute("Apellido1",dao.getApellido1());
			    			if(dao.getApellido2()!=null)
			    			s.setAttribute("Apellido2",dao.getApellido2());
			    			request.getRequestDispatcher("principal.jsp").forward(request, response);
			    	}else {
			    			out.print("Usuario o contraseña incorrectos!"); 
			    			request.getRequestDispatcher("login.jsp").forward(request, response);
			    		}		
	    	
	    		}
	    						    	
	    }else {
	    	request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	    	out.close();
	     
	}
	    
}

