package Controlador;

import java.sql.*;
import java.util.ArrayList;

import Modelo.BD;
import Modelo.ConsultasImagen;
import Modelo.Menu;

public class ControladorPantallaMenu extends Controlador{

    
    ConsultasImagen ci = new ConsultasImagen();    
    
    public ControladorPantallaMenu(){
      
    }

    @SuppressWarnings("finally")
    public ArrayList<String> consultaMenus(){    
        ResultSet resultadoConsulta=null;
        ArrayList<String> al = new ArrayList<String>();
        ArrayList<String> resultado = new ArrayList<String>();
        
        ArrayList<Menu> menus = new ArrayList<Menu>();
        try {
            java.sql.Statement stmt = bd.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `Productos-Menus`.`idMenu` idMenu, `Menu`.`Precio` precio, `Menu`.`Nombre` nombre_menu, `Producto`.`Nombre` nombre_producto FROM `Productos-Menus` INNER JOIN `Menu` ON `Productos-Menus`.idMenu = `Menu`.IdMenu INNER JOIN `Producto` ON `Productos-Menus`.`idProducto` = `Producto`.`IdProducto` ORDER BY `Productos-Menus`.`idMenu`;");
            while (rs.next()){                
                al.add("Menu numero: "+">"+rs.getInt(1)+">"+rs.getString(3)+">"+rs.getString(4)+">"+"Precio:"+">"+rs.getDouble(2));
            }
            String matriu_auxiliar[][] = new String[al.size()][6];
            for (int i=0; i<al.size();i++){
                String auxiliar[] = al.get(i).split(">");
                for (int j=0; j<auxiliar.length;j++){
                    matriu_auxiliar[i][j]=auxiliar[j];
                }
            }
                       
            String cadena=matriu_auxiliar[0][2]+":"+matriu_auxiliar[0][3];
            
            int idMenu = Integer.parseInt(matriu_auxiliar[0][1]);
            int i = 1;
            int cont=1;
            int j = 1;
           
            do{
                for (i = cont; i < matriu_auxiliar.length; i++) {
                    if (Integer.parseInt(matriu_auxiliar[i][1]) == idMenu) {
                        cadena = cadena + ":" + matriu_auxiliar[i][3];
                    } else {
                        break;
                    }
                }
                resultado.add(cadena+":"+matriu_auxiliar[i-1][5]);
                if (i<matriu_auxiliar.length){
                    idMenu = Integer.parseInt(matriu_auxiliar[i][1]);
                    cadena = matriu_auxiliar[i][2];
                } else {
                    break;
                }
                cont = i;
            } while(true);


            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}