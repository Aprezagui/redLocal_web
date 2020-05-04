package com.seguridad;

import conexionDB.Conexion;

public class PersonaDAO implements Validar {
	
	Conexion con = new Conexion();
	private Persona usuario; 
	private boolean user_validado = false;
	
	@Override
	public int validar(Persona per) {
		//String consulta;
		usuario = con.getUsuario(per.getUser());
		
		if(usuario != null) {
			if(usuario.getPass().equals(per.getPass()) && usuario.getUser().equals(per.getUser()) && usuario.getActivo() == 1) {
				user_validado=true;
				return 1;
			}
		}	
		return 0;
	}

	/*USUARIO: si el usuario no es validado los datos que se devolveran carecen de valor
	 * -Si un usuario esta inactivo aparecera como inexistente
	 * 
	 */
			
	
	public String getNombre() {
		if(user_validado==true) {
			return usuario.getNombre();
		}
		return null;
	}
	
	public String getApellido1() {
		if(user_validado==true) {
			return usuario.getApellido1();
		}
		return null;
	}
	
	public String getApellido2() {
		if(user_validado==true) {
			return usuario.getApellido2();
		}
		return null;
	}
	
	public String getEmail() {
		if(user_validado==true) {
			return usuario.getEmail();
		}
		return null;
	}
	
	public java.sql.Timestamp getFecha() {
		if(user_validado==true) {
			return usuario.getFecha();
		}
		return null;
	}	
}
