package Controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;



import Modelo.BD;
import Modelo.ConsultasImagen;
import Modelo.Pedido;
import Vista.Inici;

public class ControladorBebidas extends Controlador{

	
	ConsultasImagen ci = new ConsultasImagen();	
	
//	BD bd;
//	
//	public ControladorBebidas(String server,String dbase, String user, String pwd){
//		bd=new BD(server,dbase,user,pwd);
//	}

	
	@SuppressWarnings("finally")
	public ResultSet mostrarLasBebidas(){	
		ResultSet resultadoConsulta=null;
		try {
			PreparedStatement prStmt=bd.getConnection().prepareStatement("SELECT * FROM Producto where tipo = 'bebida'");
			
			resultadoConsulta = prStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return resultadoConsulta;
		}
	}
	
	public Image[] sacaImagenes(){
		
		
		Image[] imagenes = ci.selectImageIcon(bd.getConnection(), "bebida");
		
		
		return imagenes;
	
	}
	
	public void cambiaPedido(int clave){
		
		
		Inici.ped.setBebida(clave);
		
	}
	
	
}
