package Modelo;

import java.sql.*;

import Vista.Inici;

public class BD {
	Connection con;
	String nomservidor;
	String nombbdd;
	String nomusuari;
	String pwdusuari;
	private static BD instance = null;
	
	protected BD() {
		this.nomservidor = nomservidor;
		this.nombbdd = nombbdd;
		this.nomusuari = nomusuari;
		this.pwdusuari = pwdusuari;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://"+Inici.servidor+":3306/"+Inici.nomBBDD+"?user="+Inici.user+"&password="+Inici.pass+"&useSSL=false");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static BD getInstance() {
		      if(instance == null) {
		         instance = new BD();
		      }
		      return instance;
	}
		
	
	public Connection getConnection(){
		return con;
	}
	
	   

	
}
