package Controlador;
import java.sql.*;
import Modelo.BD;
 


public class ControladorRegistro extends Controlador{
  
    
    public ControladorRegistro() {
    }
      
    
    //Metodo para registrar una cuenta
    public boolean insertarUsuario(String correo, String nombre, String apellidos, String contrasena, String tarjeta, String paypal) throws SQLException{
        String sql = "INSERT INTO `Usuario`(`Correo`,`Nombre`,`Apellidos`,`Contrasena`,`Tarjeta`,`Paypal`,`Num_menus`,`Es_admin`) VALUES (?, ?, ?, ?, ?, ?, 0, 0)";
        PreparedStatement ps = bd.getConnection().prepareStatement(sql);
        ps.setString(1, correo);
        ps.setString(2, nombre);
        ps.setString(3, apellidos);
        ps.setString(4, contrasena);
        ps.setString(5, tarjeta);
        ps.setString(6, paypal);
        int num_rows=0;
        if (ps.execute()){
            ps.close();
            return true;
        } else {
            ps.close();
            return false;
        }
    }
}