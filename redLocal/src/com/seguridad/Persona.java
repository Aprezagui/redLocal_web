package com.seguridad;

public class Persona {
	private String pass;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String user;
	private String email;
	private int activo;
	private java.sql.Timestamp fecha;
	
	
	public Persona(){}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getActivo() {
		return activo;
	}


	public void setActivo(int activo) {
		this.activo = activo;
	}


	public java.sql.Timestamp getFecha() {
		return fecha;
	}


	public void setFecha(java.sql.Timestamp fecha) {
		this.fecha = fecha;
	}


}
