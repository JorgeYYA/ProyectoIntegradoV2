package Vista;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorPlatos;
import Controlador.ControladorVentanas;
import Modelo.Pedido;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;

public class GraciasPorVenir extends JFrame implements ComponentListener, ActionListener {

	//Los atributos sobre los que vamos a actuar
	ButtonGroup botones = new ButtonGroup();
	JLabel lblTitulo;
	JButton btnNewButton;
	
	JLabel[] imagenesLabel = new JLabel[12];
	
	
	
	ControladorPlatos cp = new ControladorPlatos();
	//ControladorPlatos cp = new ControladorPlatos("127.0.0.1","restaurante","root","");
	private JPanel contentPane;
	
	
	int tope = 0;
	String[] nombrePlato = new String[12];
	
	float[] precio = new float[12];
	
	String[] descripcion = new String[12];
	
	int[] clave = new int[12];
	
	Image[] imagenes = cp.sacaImagenes();
	
	JPanel panelDown;
	JLabel lblDescripcion;
	private JButton btnSalir;
	private Component horizontalStrut;
	
	public GraciasPorVenir() {
		
		
		
		try {
			this.setIconImage(ImageIO.read(new File("src/img/Icono.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			nombrePlatos();
			descripcionPlatos();
			precio();
			cp();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 224));
		contentPane.setBackground(new Color(72, 162, 172));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//anadimos el ComponentListener para modificar el tamano de las imagenes cuando la pantalla se redimensione
		addComponentListener(this);
		
		if(Inici.idioma == 0){
		lblTitulo = new JLabel("GRACIAS POR VENIR");
		}else{
			lblTitulo = new JLabel("THANKS FOR COMING");
		}
		lblTitulo.setForeground(new Color(240, 238, 201));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("AR CENA", Font.PLAIN, 60));
		contentPane.add(lblTitulo, BorderLayout.CENTER);
		
		imagenesLabel[0] = new JLabel("");
		
		imagenesLabel[1] = new JLabel("");
		
		imagenesLabel[2] = new JLabel("");
		
		imagenesLabel[3] = new JLabel("");
		
		imagenesLabel[4] = new JLabel("");
		
		imagenesLabel[5] = new JLabel("");
		
		imagenesLabel[6] = new JLabel("");
		
		imagenesLabel[7] = new JLabel("");
		
		imagenesLabel[8] = new JLabel("");
		
		imagenesLabel[9] = new JLabel("");
		
		imagenesLabel[10] = new JLabel("");
		
		imagenesLabel[11] = new JLabel("");
		
		// Para centrar el app en medio de nuestra pantalla
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getSize();
		int width = (pantalla.width - ventana.width) / 2;
		int height = (pantalla.height - ventana.height) / 2;
		this.setLocation(width, height);
		//Seleccionamos una imagen para el boton de la ruta relativa
		
		
		
		
		//Hacemos visible el frame y le asignamos un tamaño por defecto de 800x600 pixeles
		this.setSize(800, 600);
		//this.setVisible(true);
		
		panelDown = new JPanel();
		panelDown.setForeground(new Color(240, 238, 201));
		panelDown.setBackground(new Color(72, 162, 172));
		contentPane.add(panelDown, BorderLayout.SOUTH);
		panelDown.setLayout(new BoxLayout(panelDown, BoxLayout.X_AXIS));
		
		lblDescripcion = new JLabel(" ");
		lblDescripcion.setForeground(new Color(240, 238, 201));
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelDown.add(lblDescripcion);
		
		if(Inici.idioma == 0){
		btnNewButton = new JButton("Hacer otro pedido");
		}else{
			btnNewButton = new JButton("Make another order");
		}
		btnNewButton.setForeground(new Color(240, 238, 201));
		btnNewButton.setBackground(new Color(133, 188, 195));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				ControladorVentanas.mostrarOpciones();
				
			}
		});
		panelDown.add(btnNewButton);
		
		horizontalStrut = Box.createHorizontalStrut(80);
		panelDown.add(horizontalStrut);
		
		if(Inici.idioma == 0){
		btnSalir = new JButton("Salir");
		}else{
			btnSalir = new JButton("Exit");	
		}
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				System.exit(0);
				
			}
		});
		btnSalir.setForeground(new Color(240, 238, 201));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalir.setBackground(new Color(133, 188, 195));
		panelDown.add(btnSalir);
		
		
		
		for(int i=0;i<11;i++){
			
			if(imagenes[i]!=null)
		
		imagenesLabel[i].setIcon(new ImageIcon(imagenes[i]));
		
		}
		
		
		
		
		
	}
	
	
	
	public void nombrePlatos() throws SQLException{
		
		int num = 0;
		ResultSet consulta = cp.mostrarLosPlatos();
		
		while(consulta.next()){
			nombrePlato[num]=consulta.getString("Nombre");
			num++;
		}		
		
	}
	
	public void descripcionPlatos() throws SQLException{
		
		int num = 0;
		ResultSet consulta = cp.mostrarLosPlatos();
		
		while(consulta.next()){
			
			
			descripcion[num]=consulta.getString("descripcionCastellano");
			num++;
		}		
		
	}
	
	
	public void precio() throws SQLException{
		
		int num = 0;
		ResultSet consulta = cp.mostrarLosPlatos();
		
		while(consulta.next()){
			
			
			precio[num]=consulta.getFloat("Precio");
			num++;
		}		
		
	}
	
	public void cp() throws SQLException{
		
		int num = 0;
		ResultSet consulta = cp.mostrarLosPlatos();
		
		while(consulta.next()){
			
			
			clave[num]=consulta.getInt("IdProducto");
			num++;
		}		
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	// componentResized es un metodo del componentListener que ejecutara el codigo que redimensiona 
	// la imagen cada vez que modificamos su tamano
	
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	
}

	