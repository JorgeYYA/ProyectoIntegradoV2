package Controlador;

import Vista.Bebidas;
import Vista.Cafes;
import Vista.CartaOpcionesView;
import Vista.GraciasPorVenir;
import Vista.PantallaBienvenida;
import Vista.PantallaLogin;
import Vista.PantallaMenu;
import Vista.Platos;
import Vista.Platos2;
import Vista.Postres;
import Vista.Total;

public class ControladorVentanas {
	
	static CartaOpcionesView cov = new CartaOpcionesView();
	static Platos p = new Platos();
	static PantallaLogin pl = new PantallaLogin();
	static Platos2 p2 = new Platos2();
	static Cafes ca = new Cafes();
	static Postres po = new Postres();
	static Bebidas b = new Bebidas();
	static PantallaBienvenida pb = new PantallaBienvenida();
	static GraciasPorVenir gpr = new GraciasPorVenir();
	static PantallaMenu pm = new PantallaMenu();
	//static Total to = new Total();
	
	
	public static void mostrarLogin(){
		
		
		
		pl.setVisible(true);
		pl.setLocationRelativeTo(null);	
		
	}
	
	public static void ocultarLogin(){
		
		
		
		pl.setVisible(false);
		pl.setLocationRelativeTo(null);	
		
	}
	
	
	public static void mostrarOpciones(){
		
		
		
		cov.setVisible(true);
		cov.setLocationRelativeTo(null);	
		
	}
	
	
	public static void ocultarOpciones(){
		
		
		
		cov.setVisible(false);
		cov.setLocationRelativeTo(null);	
		
	}
	
	public static void mostrarPrimerosPlatos(){
		
	
		
		p.setVisible(true);
		p.setLocationRelativeTo(null);	
		
	}
	
	public static void ocultarPrimerosPlatos(){
		
		
		
		p.setVisible(false);
		p.setLocationRelativeTo(null);	
		
	}
	
	public static void mostrarSegundosPlatos(){
		
		
		p2.setVisible(true);
		p2.setLocationRelativeTo(null);	
		
	}
	
	public static void ocultarSegundosPlatos(){
		
		
		
		p2.setVisible(false);
		p2.setLocationRelativeTo(null);	
		
	}
	
	public static void mostrarCafes(){
		
		
		
		ca.setVisible(true);
		ca.setLocationRelativeTo(null);	
		
	}
	
	public static void ocultarCafes(){
		
		
		
		ca.setVisible(false);
		ca.setLocationRelativeTo(null);	
		
	}
	
	public static void mostrarPostres(){
		
		
		
		po.setVisible(true);
		po.setLocationRelativeTo(null);	
		
	}
	
	public static void ocultarPostres(){
		
		
		
		po.setVisible(false);
		po.setLocationRelativeTo(null);	
		
	}
	
	public static void mostrarBebidas(){
		
		
		
		b.setVisible(true);
		b.setLocationRelativeTo(null);	
		
	}
	
	public static void ocultarBebidas(){
		
		
		
		b.setVisible(false);
		b.setLocationRelativeTo(null);	
		
	}
	
	public static void mostrarPantallaBienvenida(){
		
		
		
		pb.setVisible(true);
		pb.setLocationRelativeTo(null);	
		
	}
	
	public static void ocultarPantallaBienvenida(){
		
		
		
		pb.setVisible(false);
		pb.setLocationRelativeTo(null);	
		
	}
	
	public static void mostrarGracias(){
		
		
		
		gpr.setVisible(true);
		gpr.setLocationRelativeTo(null);	
		
	}
	
	public static void mostrarMenus(){
		
		
		
		pm.setVisible(true);
		pm.setLocationRelativeTo(null);	
		
	}
	
	
	/*public static void mostrarRecibo(){		
		
		
		to.setVisible(true);
		
	}
	
	public static void ocultarRecibo(){		
		
		
		to.setVisible(false);
		
	}*/

}
