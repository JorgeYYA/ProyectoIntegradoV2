package Controlador;

import javax.swing.Timer;

import Vista.PantallaCargaView;

public class ControlerPantallaCarga {
	private static  Timer timer;
	static long tiempoSistema;
	static long tiempoSistemaFinal;
	
	
	public static void cierroVentan(PantallaCargaView frame){
		tiempoSistema = System.currentTimeMillis();//aqui recogemos el tiempo del sistema en milisegundos
		ControladorVentanas cv = new ControladorVentanas();
		while(tiempoSistemaFinal-tiempoSistema < 20){
			tiempoSistemaFinal = System.currentTimeMillis();//cuando tengamos 6 segundos de diferencia
			
			//System.out.println(tiempoSistemaFinal);
			
		
		}
			
			frame.dispose();//cerraremos la ventana
			ControladorVentanas.mostrarLogin();
		
	}

}
