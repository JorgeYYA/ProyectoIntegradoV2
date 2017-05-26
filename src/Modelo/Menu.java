package Modelo;

import java.util.ArrayList;

public class Menu {
	
	int idMenu;
	float precio;
	String nombre;
	ArrayList<Producto> productos;
	
	public Menu(int idMenu, float precio, String nombre, ArrayList<Producto> productos) {
		super();
		this.idMenu = idMenu;
		this.precio = precio;
		this.nombre = nombre;
		this.productos = productos;
	}
	
	
	
	public Menu(float precio, String nombre, ArrayList<Producto> productos) {
		super();
		this.precio = precio;
		this.nombre = nombre;
		this.productos = productos;
	}



	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
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

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
	
}
