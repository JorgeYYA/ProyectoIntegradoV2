package Vista; 
 
import java.awt.BorderLayout; 
import java.awt.EventQueue; 
 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JTable; 
import javax.swing.border.EmptyBorder; 
import javax.swing.table.DefaultTableModel; 
 
import Controlador.ControladorPantallaMenu; 
import Controlador.ControladorVentanas; 
 
import javax.swing.JLabel; 
import java.awt.Font; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.Vector; 
 
import javax.swing.SwingConstants; 
import java.awt.Color; 
import javax.swing.JList; 
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton; 
 
public class PantallaMenu extends JFrame implements ActionListener { 
	
	private JPanel contentPane; 
    private JTable listMenus; 
    private ArrayList<String> al;  
    private JPanel panel; 
    private JButton btnCancelar; 
     
    public PantallaMenu() { 
    	
    	try {
			this.setIconImage(ImageIO.read(new File("src/img/Icono.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setBounds(100, 100, 450, 300); 
        contentPane = new JPanel(); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
        setContentPane(contentPane); 
        contentPane.setLayout(new BorderLayout(0, 0)); 
         
        JLabel lblNewLabel = new JLabel("Selecciona un men\u00FA:"); 
        lblNewLabel.setForeground(Color.RED); 
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32)); 
        contentPane.add(lblNewLabel, BorderLayout.NORTH); 
         
 
        listMenus = new JTable(); 
        contentPane.add(listMenus, BorderLayout.CENTER); 
        listMenus.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        setSize(800,600); 
                 
         
        ControladorPantallaMenu cpm = new ControladorPantallaMenu(); 
        al = cpm.consultaMenus(); 
        DefaultTableModel dtm = new DefaultTableModel(); 
        dtm.addColumn("1"); 
        dtm.addColumn("2"); 
        dtm.addColumn("3"); 
        dtm.addColumn("4"); 
        dtm.addColumn("5"); 
        dtm.addColumn("6"); 
        dtm.addColumn("7"); 
        dtm.setRowCount(0); 
        for (int i = 0; i < al.size(); i++){ 
            dtm.addRow(al.get(i).split(":")); 
        } 
         
        listMenus.setModel(dtm); 
                 
        panel = new JPanel(); 
        contentPane.add(panel, BorderLayout.SOUTH); 
         
          
         JButton btnConfirmar = new JButton("Confirmar"); 
         panel.add(btnConfirmar); 
         btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
         btnConfirmar.addActionListener(this); 
         btnConfirmar.setActionCommand("Confirmar"); 
          
         btnCancelar = new JButton("Cancelar"); 
         btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
         btnCancelar.addActionListener(this); 
         btnCancelar.setActionCommand("Cancelar"); 
         panel.add(btnCancelar); 
         //setVisible(true); 
    } 
 
    @Override 
    public void actionPerformed(ActionEvent arg0) { 
        switch (arg0.getActionCommand()) { 
        case "Confirmar": int posicion = listMenus.getSelectedRow(); 
                          if (posicion != -1){ 
                              //Le pasamos esto a la cuenta para que lo muestre con el precio
                        	  dispose();
                              System.out.println(al.get(posicion));
                              String menus[] = al.get(0).split(":");
                              
              					String NombreMenu = menus[0];
              					String PrecioMenu = menus[menus.length-1];
              					
              					
              					
              					Total to = new Total();
              					to.ct.getTicketMenu(NombreMenu, PrecioMenu);
              					to.setVisible(true);
              					to.setLocationRelativeTo(null);
              					
              					
              					
              					
                          } else { 
                              JOptionPane jo = new JOptionPane(); 
                              jo.showMessageDialog(this, "Debes seleccionar un menu");
                              

                          } 
                          break; 
        case "Cancelar": ControladorVentanas.mostrarPantallaBienvenida(); 
                         this.dispose(); 
        default: break; 
        } 
    } 
 
}