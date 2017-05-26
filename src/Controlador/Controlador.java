package Controlador;

import Modelo.BD;

public class Controlador {
	BD bd;
	
	public Controlador() {
		bd = BD.getInstance();
	}
	
	
//	public Controlador(String nomservidor, String nombbdd, String nomusuari, String pwdusuari) {
//		bd = new BD(nomservidor, nombbdd, nomusuari, pwdusuari);
//	}
}
