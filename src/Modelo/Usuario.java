package Modelo;

public class Usuario {
	String correo, nombre, apellidos, contraseña, tarjeta, paypal;
	int numMenus;
	boolean esAdmin;
	
	public Usuario(String correo, String nombre, String apellidos, String contraseña, String tarjeta, String paypal,
			int numMenus, boolean esAdmin) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contraseña = contraseña;
		this.tarjeta = tarjeta;
		this.paypal = paypal;
		this.numMenus = numMenus;
		this.esAdmin = esAdmin;
	}

	public Usuario(String correo, String nombre, String apellidos, String contraseña, int numMenus, boolean esAdmin) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contraseña = contraseña;
		this.numMenus = numMenus;
		this.esAdmin = esAdmin;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getPaypal() {
		return paypal;
	}

	public void setPaypal(String paypal) {
		this.paypal = paypal;
	}

	public int getNumMenus() {
		return numMenus;
	}

	public void setNumMenus(int numMenus) {
		this.numMenus = numMenus;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	
	
	
}
