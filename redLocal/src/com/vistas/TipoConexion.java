package com.vistas;

public class TipoConexion {
	private int idequipo;
	private enum conex{WIFI,ETHERNET};
	private String mac;
	
	public int getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}
	
	/*
	public int getConexion() {
		return (int)conexion;
	}
	*/
	/*
	public void setConexion(int conexion) {
		this.conexion = conexion;
	}
	*/
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	

}
