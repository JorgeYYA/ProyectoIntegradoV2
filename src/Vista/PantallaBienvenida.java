package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorVentanas;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

public class PantallaBienvenida extends JFrame {

	JLabel lblMenu;
	private JPanel contentPane;
	JLabel lblCarta;
	static JLabel lblNombreUser;
	
	public PantallaBienvenida() {
		
		
		try {
			this.setIconImage(ImageIO.read(new File("src/img/Icono.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel lblBienvenido = new JLabel("Bienvenido!");
		lblBienvenido.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblBienvenido);
		lblBienvenido.setForeground(new Color(95, 158, 160));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Comic Sans MS", Font.BOLD, 42));
		
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		
		JLabel lblOpcion = new JLabel("Elije una opcion:");
		lblOpcion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblOpcion.setForeground(new Color(0, 128, 128));
		lblOpcion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		panel_1.add(lblOpcion);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblMenu = new JLabel();
		File fMenu = new File("./src/img/menu-del-dia.jpg");
        BufferedImage rMenu = null;
		try {
			rMenu = ImageIO.read(fMenu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        Image siMenu = rMenu.getScaledInstance(300, 450, Image.SCALE_DEFAULT);
        lblMenu.setIcon(new ImageIcon(siMenu));
        
        lblMenu.addMouseListener((new MouseAdapter(){
        	public void mouseClicked(MouseEvent e)
        	{
        		//System.out.println("Has elejido Menu");
        		dispose();
        		ControladorVentanas.mostrarMenus();
        	}
        }));
		panel.add(lblMenu);

		lblCarta = new JLabel();
		File fCarta = new File("./src/img/carta.jpg");
        BufferedImage rCarta = null;
		try {
			rCarta = ImageIO.read(fCarta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblCarta.addMouseListener((new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				//System.out.println("Has elejido Carta");
				ControladorVentanas.ocultarPantallaBienvenida();
				ControladorVentanas.mostrarOpciones();
			}
		}));
		
        Image siCarta = rCarta.getScaledInstance(300, 450, Image.SCALE_DEFAULT);
        lblCarta.setIcon(new ImageIcon(siCarta));
		panel.add(lblCarta);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		
		JLabel lblNewLabel_1 = new JLabel("Usuario: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_1);
		
		lblNombreUser = new JLabel(Inici.idUser);
		lblNombreUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		panel_2.add(lblNombreUser);

		JLabel lblNewLabel_2 = new JLabel("Mesa: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		for(int i=1;i<=15;i++){
			
			String mesa = "MESA "+i;
			comboBox.addItem(mesa);
		}
		panel_2.add(comboBox);
		
		setTitle("Bienvenido");
		setSize(800,600);
		//setVisible(true);	
	}
	
	
	
	

}
