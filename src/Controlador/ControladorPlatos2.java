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
import Vista.Inici;

public class ControladorPlatos2 extends Controlador{

	
	ConsultasImagen ci = new ConsultasImagen();	
	
	
	
	public ControladorPlatos2(){
		
	}

	
	@SuppressWarnings("finally")
	public ResultSet mostrarLosPlatos(){	
		ResultSet resultadoConsulta=null;
		try {
			PreparedStatement prStmt=bd.getConnection().prepareStatement("SELECT * FROM Producto where tipo = 'segundo_plato'");
			
			resultadoConsulta = prStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return resultadoConsulta;
		}
	}
	
	public Image[] sacaImagenes(){
		
		
		Image[] imagenes = ci.selectImageIcon(bd.getConnection(), "segundo_plato");
		
		
		return imagenes;
	
	}
	
	public void cambiaPedido(int clave){
		
		
		Inici.ped.setsPlato(clave);
		
	}
	
	
}
