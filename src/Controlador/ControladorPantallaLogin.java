package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.BD;
import Modelo.ConsultasImagen;

public class ControladorPantallaLogin extends Controlador{

    
    ConsultasImagen ci = new ConsultasImagen();    
    
    
    
    public ControladorPantallaLogin(){
       
    }

    
    @SuppressWarnings("finally")
    public int existeUsuario(String nom, String password){    
        ResultSet resultadoConsulta=null;
        int existe=0;
        try {
            PreparedStatement prStmt=bd.getConnection().prepareStatement("SELECT * FROM Usuario WHERE Correo = ? AND Contrasena = ?;");
            prStmt.setString(1, nom);
            prStmt.setString(2, password);
            resultadoConsulta = prStmt.executeQuery();
            resultadoConsulta.next();
            if (resultadoConsulta.getRow()==0){
                existe=-1;
            } else {
                existe=1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }
    
}