package Vista;

import Controlador.*;
import Modelo.Pedido;

public class Inici {
	
	Controlador c;	
	public static String idUser = "invitado";
	public static int idioma = -1;
	public static Pedido ped = new Pedido();
	
	public static String servidor = "52.38.13.79";
	public static String nomBBDD = "restaurante";
	public static String user = "root";
	public static String pass = "caguera";
	
	
	public Inici(){
		// podemos modificar las variables del controlador
		c = new Controlador();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		/*
		PantallaCargaView frame = new PantallaCargaView();
		frame.setUndecorated(true);//con esto le quitamos los bordes
		frame.setVisible(true);					
		frame.setLocationRelativeTo(null);	
		ControlerPantallaCarga frame2 = new ControlerPantallaCarga();
	    frame2.cierroVentan(frame); //Esto es para lanzar la pantalla de carga(no borrar )
		*/
	    //PantallaRegistro pr = new PantallaRegistro();
		/*
		Platos p = new Platos();
		Inici i = new Inici();
		Total t = new Total();
		*/

		//PantallaLogin pl = new PantallaLogin();


		//PantallaRegistro pr = new PantallaRegistro();
		
		/*CartaOpcionesView cov = new CartaOpcionesView();
		
		Platos2 p2 = new Platos2();
		Cafes ca = new Cafes();
		Postres po = new Postres();
	    Bebidas b = new Bebidas();
		Platos p = new Platos();
		Inici i = new Inici();
		*/
		//Total t = new Total();
		VistaIdiomas vi = new VistaIdiomas();
		vi.setVisible(true);
		
		while(idioma == -1) {
			System.out.println();
		}
		
		vi.setVisible(false);
		
		try {
			PantallaCargaView frame = new PantallaCargaView();
			frame.setUndecorated(true);//con esto le quitamos los bordes
			frame.setVisible(true);					
			frame.setLocationRelativeTo(null);	
			ControlerPantallaCarga frame2 = new ControlerPantallaCarga();
		    frame2.cierroVentan(frame); //Esto es para lanzar la pantalla de carga(no borrar )
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

