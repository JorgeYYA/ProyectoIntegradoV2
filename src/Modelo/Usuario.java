package Modelo;

public class Usuario {
	String correo, nombre, apellidos, contrase�a, tarjeta, paypal;
	int numMenus;
	boolean esAdmin;
	
	public Usuario(String correo, String nombre, String apellidos, String contrase�a, String tarjeta, String paypal,
			int numMenus, boolean esAdmin) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrase�a = contrase�a;
		this.tarjeta = tarjeta;
		this.paypal = paypal;
		this.numMenus = numMenus;
		this.esAdmin = esAdmin;
	}

	public Usuario(String correo, String nombre, String apellidos, String contrase�a, int numMenus, boolean esAdmin) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
