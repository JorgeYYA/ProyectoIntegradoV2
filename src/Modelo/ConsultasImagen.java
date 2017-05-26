package Modelo;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class ConsultasImagen {
	
	public ConsultasImagen() {
		
	}

//	public static void guardarLocal(Connection conexion, int idProducto, String nombreImagen) {
//		
//		try {
//			
//			PreparedStatement statement = conexion.prepareStatement("SELECT Imagen FROM producto WHERE IdProducto = ?");
//			statement.setInt(1, idProducto);
//			ResultSet resultset = statement.executeQuery();
//			
//			resultset.next();
//			File imgrec = new File(nombreImagen);
//			
//			Blob imgBlob = resultset.getBlob("imag");
//			byte[] imgByte = imgBlob.getBytes(1L,(int)imgBlob.length());
//			FileOutputStream fos = new FileOutputStream(imgrec);
//			fos.write(imgByte);
//			//NO hace falta
//			fos.close();
//			conexion.close();
//			
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	  public static Image[] selectImageIcon(Connection conexion, String tipo) {
	       
	        Image imagen[] = new Image[12];
	        int contador = 0;
	        try {
	            PreparedStatement statement = conexion.prepareStatement("SELECT Imagen FROM Producto where tipo = '"+tipo+"'");
	            //statement.setString(1, tipo);
	            ResultSet resultset = statement.executeQuery();
	           
	            while(resultset.next()){
	               
	               
	                String imgurl = resultset.getString("Imagen");
	                if (imgurl!=null){
	                   
	                    URL url = new URL(imgurl);
	                    BufferedImage bufimg = ImageIO.read(url);
	                   
	                    imagen[contador] = bufimg;
	               
	                }
	                contador++;
	               
	            }
	 
	            //conexion.close();
	        } catch (SQLException | IOException e) {
	            e.printStackTrace();
	        }
	       
	        return imagen;
	    }
	  

	public static void insertarImagen(Connection conexion, File imagen, int idProducto, String tipo) {
		
		try {
			
			//Crea un FileInputStream con la imagan
			FileInputStream fis = new FileInputStream(imagen);
			//Insert
			String sql = "UPDATE Producto SET Imagen = ? WHERE IdProducto = "+idProducto+" AND tipo = '"+tipo+"'";
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setBlob(1, fis);
			statement.executeUpdate();
			//conexion.close();
			
		} catch (FileNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
