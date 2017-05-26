package Controlador;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import Modelo.BD;
import Modelo.Pedido;
import Vista.Inici;
import Vista.Total;
 
public class ControladorTotal extends Controlador{
 
    
    public static String ticket = "";
    static DefaultTableModel dtm = new DefaultTableModel();
    static float total = 0;
    public ControladorTotal() {
       
    }

    public void getTicketMenu(String nombre, String precio) {
    	this.dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Precio");
        dtm.addRow(new Object[]{nombre,precio+"€"});
        Total.table.setModel(dtm);
    }
    
    public String getTicket() {
    	dtm = new DefaultTableModel();
        Pedido pedido = Inici.ped;
        dtm.addColumn("Nombre");
        dtm.addColumn("Precio");
        selectProducto(pedido.getpPlato());
        selectProducto(pedido.getsPlato());
        selectProducto(pedido.getBebida());
        selectProducto(pedido.getInfusion());
        selectProducto(pedido.getPostre());
        dtm.addRow(new Object[]{"TOTAL:",total+"€"});
        Total.table.setModel(dtm);
        return this.ticket;
    }
   
    private void selectProducto(int id) {
        PreparedStatement statement;
        try {
            statement = bd.getConnection().prepareStatement("SELECT Nombre, Precio FROM Producto where idProducto = '"+id+"'");
            ResultSet resultset = statement.executeQuery();

                while(resultset.next()) {
                    dtm.addRow(new Object[]{resultset.getString("Nombre"),resultset.getFloat("Precio")+"€"});
                  
                    total = total + resultset.getFloat("Precio");
                    insertPedido(Inici.idUser,id);
                   
                }
                
                
               
 
            } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
    
    private void insertPedido(String correo, int idProducto) {
    	try {
			PreparedStatement preparedStmt = bd.getConnection().prepareStatement("INSERT INTO Pedidos (Correo, idProducto) VALUES (?, ?)");
			preparedStmt.setString(1, correo);
			preparedStmt.setInt(2, idProducto);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}