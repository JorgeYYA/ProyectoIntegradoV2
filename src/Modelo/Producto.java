package Modelo;

import javax.swing.ImageIcon;

public class Producto {
	
	int idProducto, tipo;
	float precio;
	String nombre, descripcionCastellano, descripcionIngles, usuario_Correo;
	ImageIcon imagen;
	
	public Producto(int idProducto, int tipo, float precio, String nombre, String descripcionCastellano, String descripcionIngles, String usuario_Correo, ImageIcon imagen) {
		this.idProducto = idProducto;
		this.tipo = tipo;
		this.precio = precio;
		this.nombre = nombre;
		this.descripcionCastellano = descripcionCastellano;
		this.descripcionIngles = descripcionIngles;
		this.usuario_Correo = usuario_Correo;
		this.imagen = imagen;
	}
	
	public Producto(int tipo, float precio, String nombre, String descripcionCastellano, String descripcionIngles,
			ImageIcon imagen) {
		super();
		this.tipo = tipo;
		this.precio = precio;
		this.nombre = nombre;
		this.descripcionCastellano = descripcionCastellano;
		this.descripcionIngles = descripcionIngles;
		this.imagen = imagen;
	}

	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcionCastellano() {
		return descripcionCastellano;
	}
	public void setDescripcionCastellano(String descripcionCastellano) {
		this.descripcionCastellano = descripcionCastellano;
	}
	public String getDescripcionIngles() {
		return descripcionIngles;
	}
	public void setDescripcionIngles(String descripcionIngles) {
		this.descripcionIngles = descripcionIngles;
	}
	public String getUsuario_Correo() {
		return usuario_Correo;
	}
	public void setUsuario_Correo(String usuario_Correo) {
		this.usuario_Correo = usuario_Correo;
	}
	public ImageIcon getImagen() {
		return imagen;
	}
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	
}
