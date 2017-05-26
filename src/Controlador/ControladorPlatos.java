package Controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.PreparedStatement;



import Modelo.BD;
import Modelo.ConsultasImagen;
import Modelo.Pedido;
import Vista.Inici;

public class ControladorPlatos extends Controlador{

	ConsultasImagen ci = new ConsultasImagen();	
	
	
	
	public ControladorPlatos(){
	
		
		//insertarImagen();
	}

	
	@SuppressWarnings("finally")
	public ResultSet mostrarLosPlatos(){	
		ResultSet resultadoConsulta=null;
		try {
			//PreparedStatement prStmt=bd.getConnection().prepareStatement("SELECT * FROM producto WHERE tipo = 'primer_plato' OR tipo = 'segundo_plato'");
			PreparedStatement prStmt=bd.getConnection().prepareStatement("SELECT * FROM Producto where tipo = 'primer_plato'");
			resultadoConsulta = prStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return resultadoConsulta;
		}
	}
	
	
	public Image[] sacaImagenes(){
		
		
		Image[] imagenes = ci.selectImageIcon(bd.getConnection(), "primer_plato");
		
		
		return imagenes;
	
	}
	
	public void insertarImagen(){
		Connection con=bd.getConnection();
		File img = new File("src/img/Gofreproceduralli1.png");
		ci.insertarImagen(con, img, 7,"postre");
		
	}
	
	public void cambiaPedido(int clave){
		
		
		Inici.ped.setpPlato(clave);
		
	}
	
	
	
}