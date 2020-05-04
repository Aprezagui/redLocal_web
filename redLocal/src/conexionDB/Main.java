package conexionDB;

public class Main {
	public static void main(String[] args) {
	
		Conexion cx = new Conexion();
		cx.buscarMAC("D8:D3:85:CB:69:2B");
		cx.buscarMAC("2C:6E:85:CB:EB:C5");
		cx.buscarConexionEquipo(1);
		
		cx.setUsuario("nombre_", "Papellido_", "Sapellido_", "username_", "email_", "pass_");
		
		cx.close();
	
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}