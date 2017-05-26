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

public class Platos extends JFrame implements ComponentListener, ActionListener {

	//Los atributos sobre los que vamos a actuar
	ButtonGroup botones = new ButtonGroup();
	
	
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
	
	public Platos() {
		
		
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
		
		JLabel lblTitulo = new JLabel("PRIMEROS PLATOS");
		lblTitulo.setForeground(new Color(240, 238, 201));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("AR CENA", Font.PLAIN, 30));
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 162, 172));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 3, 10, 10));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(133, 188, 195));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[0] = new JLabel("");
		panel_1.add(imagenesLabel[0], BorderLayout.CENTER);
		
		JPanel panelBoton01 = new JPanel();
		panelBoton01.setBackground(new Color(133, 188, 195));
		panel_1.add(panelBoton01, BorderLayout.SOUTH);
		
		JRadioButton Boton01 = new JRadioButton(nombrePlato[0]);		
		Boton01.setForeground(new Color(240, 238, 201));
		Boton01.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		Boton01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				lblDescripcion.setText(precio[0]+"€  "+descripcion[0]);
				int laClave = clave[0];
				
				cp.cambiaPedido(laClave);
				
				//System.out.println(Inici.ped.getpPlato()+" "+Inici.ped.getsPlato()+" "+Inici.ped.getBebida()+" "+Inici.ped.getPostre()+" "+Inici.ped.getInfusion());
				
			}
		});
		Boton01.setBackground(new Color(133, 188, 195));
		panelBoton01.add(Boton01);
		
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[1] = new JLabel("");
		panel_2.add(imagenesLabel[1], BorderLayout.CENTER);
		
		JPanel panelBoton02 = new JPanel();
		panelBoton02.setBackground(new Color(133, 188, 195));
		panel_2.add(panelBoton02, BorderLayout.SOUTH);
		
		JRadioButton Boton02 = new JRadioButton(nombrePlato[1]);
		Boton02.setForeground(new Color(240, 238, 201));
		Boton02.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton02.setBackground(new Color(133, 188, 195));
		panelBoton02.add(Boton02);
		Boton02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				lblDescripcion.setText(precio[1]+"€  "+descripcion[1]);
				int laClave = clave[1];
				
				cp.cambiaPedido(laClave);
				

			}
		
		});
		
		
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[2] = new JLabel("");
		panel_3.add(imagenesLabel[2], BorderLayout.CENTER);
		
		JPanel panelBoton03 = new JPanel();
		panelBoton03.setBackground(new Color(133, 188, 195));
		panel_3.add(panelBoton03, BorderLayout.SOUTH);
		
		JRadioButton Boton03 = new JRadioButton(nombrePlato[2]);
		Boton03.setForeground(new Color(240, 238, 201));
		Boton03.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton03.setBackground(new Color(133, 188, 195));
		panelBoton03.add(Boton03);
		Boton03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblDescripcion.setText(precio[2]+"€  "+descripcion[2]);
				int laClave = clave[2];
				
				cp.cambiaPedido(laClave);
				
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[3] = new JLabel("");
		panel_4.add(imagenesLabel[3], BorderLayout.CENTER);
		
		JPanel panelBoton04 = new JPanel();
		panelBoton04.setBackground(new Color(133, 188, 195));
		panel_4.add(panelBoton04, BorderLayout.SOUTH);
		
		JRadioButton Boton04 = new JRadioButton(nombrePlato[3]);
		Boton04.setForeground(new Color(240, 238, 201));
		Boton04.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton04.setBackground(new Color(133, 188, 195));
		panelBoton04.add(Boton04);
		Boton04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblDescripcion.setText(precio[3]+"€  "+descripcion[3]);
				int laClave = clave[3];
				
				cp.cambiaPedido(laClave);
				
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[4] = new JLabel("");
		panel_5.add(imagenesLabel[4], BorderLayout.CENTER);
		
		JPanel panelBoton05 = new JPanel();
		panelBoton05.setBackground(new Color(133, 188, 195));
		panel_5.add(panelBoton05, BorderLayout.SOUTH);
		
		JRadioButton Boton05 = new JRadioButton(nombrePlato[4]);
		Boton05.setForeground(new Color(240, 238, 201));
		Boton05.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton05.setBackground(new Color(133, 188, 195));
		panelBoton05.add(Boton05);
		Boton05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblDescripcion.setText(precio[4]+"€  "+descripcion[4]);
				int laClave = clave[4];
				
				cp.cambiaPedido(laClave);
				
			}
		});
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[5] = new JLabel("");
		panel_6.add(imagenesLabel[5], BorderLayout.CENTER);
		
		JPanel panelBoton06 = new JPanel();
		panelBoton06.setBackground(new Color(133, 188, 195));
		panel_6.add(panelBoton06, BorderLayout.SOUTH);
		
		JRadioButton Boton06 = new JRadioButton(nombrePlato[5]);
		Boton06.setForeground(new Color(240, 238, 201));
		Boton06.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton06.setBackground(new Color(133, 188, 195));
		panelBoton06.add(Boton06);
		Boton06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblDescripcion.setText(precio[5]+"€  "+descripcion[5]);
				int laClave = clave[5];
				
				cp.cambiaPedido(laClave);
				
			}
		});
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[6] = new JLabel("");
		panel_7.add(imagenesLabel[06], BorderLayout.CENTER);
		
		JPanel panelBoton07 = new JPanel();
		panelBoton07.setBackground(new Color(133, 188, 195));
		panel_7.add(panelBoton07, BorderLayout.SOUTH);
		
		JRadioButton Boton07 = new JRadioButton(nombrePlato[6]);
		Boton07.setForeground(new Color(240, 238, 201));
		Boton07.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton07.setBackground(new Color(133, 188, 195));
		panelBoton07.add(Boton07);
		Boton07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblDescripcion.setText(precio[6]+"€  "+descripcion[6]);
				int laClave = clave[6];
				
				cp.cambiaPedido(laClave);
				
				
			}
		});
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[7] = new JLabel("");
		panel_8.add(imagenesLabel[7], BorderLayout.CENTER);
		
		JPanel panelBoton08 = new JPanel();
		panelBoton08.setBackground(new Color(133, 188, 195));
		panel_8.add(panelBoton08, BorderLayout.SOUTH);
		
		JRadioButton Boton08 = new JRadioButton(nombrePlato[7]);
		Boton08.setForeground(new Color(240, 238, 201));
		Boton08.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton08.setBackground(new Color(133, 188, 195));
		panelBoton08.add(Boton08);
		Boton08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblDescripcion.setText(precio[7]+"€  "+descripcion[7]);
				int laClave = clave[7];
				
				cp.cambiaPedido(laClave);
				
			}
		});
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[8] = new JLabel("");
		panel_9.add(imagenesLabel[8], BorderLayout.CENTER);
		
		JPanel panelBoton09 = new JPanel();
		panelBoton09.setBackground(new Color(133, 188, 195));
		panel_9.add(panelBoton09, BorderLayout.SOUTH);
		
		JRadioButton Boton09 = new JRadioButton(nombrePlato[8]);
		Boton09.setForeground(new Color(240, 238, 201));
		Boton09.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton09.setBackground(new Color(133, 188, 195));
		panelBoton09.add(Boton09);
		Boton09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblDescripcion.setText(precio[8]+"€  "+descripcion[8]);
				int laClave = clave[8];
				
				cp.cambiaPedido(laClave);
				
			}
		});
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[9] = new JLabel("");
		panel_10.add(imagenesLabel[9], BorderLayout.CENTER);
		
		JPanel panelBoton10 = new JPanel();
		panelBoton10.setBackground(new Color(133, 188, 195));
		panel_10.add(panelBoton10, BorderLayout.SOUTH);
		
		JRadioButton Boton10 = new JRadioButton(nombrePlato[9]);
		Boton10.setForeground(new Color(240, 238, 201));
		Boton10.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton10.setBackground(new Color(133, 188, 195));
		panelBoton10.add(Boton10);
		Boton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblDescripcion.setText(precio[9]+"€  "+descripcion[9]);
				int laClave = clave[9];
				
				cp.cambiaPedido(laClave);
				
			}
		});
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[10] = new JLabel("");
		panel_11.add(imagenesLabel[10], BorderLayout.CENTER);
		
		JPanel panelBoton11 = new JPanel();
		panelBoton11.setBackground(new Color(133, 188, 195));
		panel_11.add(panelBoton11, BorderLayout.SOUTH);
		
		JRadioButton Boton11 = new JRadioButton(nombrePlato[10]);
		Boton11.setForeground(new Color(240, 238, 201));
		Boton11.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton11.setBackground(new Color(133, 188, 195));
		panelBoton11.add(Boton11);
		Boton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblDescripcion.setText(precio[10]+"€  "+descripcion[10]);
				int laClave = clave[10];
				
				cp.cambiaPedido(laClave);
				
			}
		});
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		imagenesLabel[11] = new JLabel("");
		panel_12.add(imagenesLabel[11], BorderLayout.CENTER);
		
		JPanel panelBoton12 = new JPanel();
		panelBoton12.setBackground(new Color(133, 188, 195));
		panel_12.add(panelBoton12, BorderLayout.SOUTH);
		
		JRadioButton Boton12 = new JRadioButton(nombrePlato[11]);
		Boton12.setForeground(new Color(240, 238, 201));
		Boton12.setFont(new Font("Tahoma", Font.BOLD, 13));
		Boton12.setBackground(new Color(133, 188, 195));
		panelBoton12.add(Boton12);
		Boton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblDescripcion.setText(precio[11]+"€  "+descripcion[11]);
				int laClave = clave[11];
				
				cp.cambiaPedido(laClave);
				
				
				
			}
		});
		
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
		panelDown.setLayout(new BorderLayout(0, 0));
		
		lblDescripcion = new JLabel(" ");
		lblDescripcion.setForeground(new Color(240, 238, 201));
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelDown.add(lblDescripcion);
		
		JButton btnNewButton = new JButton("Aplicar");
		btnNewButton.setForeground(new Color(240, 238, 201));
		btnNewButton.setBackground(new Color(133, 188, 195));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ControladorVentanas.ocultarPrimerosPlatos();
				
			}
		});
		panelDown.add(btnNewButton, BorderLayout.EAST);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int laClave = 0;
				
				cp.cambiaPedido(laClave);
				
				botones.clearSelection();
				lblDescripcion.setText("");
			}
		});
		btnCancelar.setForeground(new Color(240, 238, 201));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBackground(new Color(133, 188, 195));
		panelDown.add(btnCancelar, BorderLayout.WEST);
		
		
		
		for(int i=0;i<11;i++){
			
			if(imagenes[i]!=null)
		
		imagenesLabel[i].setIcon(new ImageIcon(imagenes[i]));
		
		}
		
		
		botones.add(Boton01);
		botones.add(Boton02);
		botones.add(Boton03);
		botones.add(Boton04);
		botones.add(Boton05);
		botones.add(Boton06);
		botones.add(Boton07);
		botones.add(Boton08);
		botones.add(Boton09);
		botones.add(Boton10);
		botones.add(Boton11);
		botones.add(Boton12);
		
		
		
		
		
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
		
		if(Inici.idioma==0){
			
			while(consulta.next()){			
				
				descripcion[num]=consulta.getString("descripcionCastellano");
				num++;
			}		
		
		}else{			
			
			while(consulta.next()){			
				
				descripcion[num]=consulta.getString("descripcionIngles");
				num++;
			}
			
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
	@Override
	public void componentResized(ComponentEvent e) {  
	       
        if(tope==0){
            tope++;           
        }else{
        for(int i=0;i<imagenes.length;i++){
           
            if(imagenes[i]!=null){
                imagenes[i] = imagenes[i].getScaledInstance(imagenesLabel[i].getWidth(), imagenesLabel[i].getHeight(), Image.SCALE_SMOOTH);
                imagenesLabel[i].setIcon(new ImageIcon(imagenes[i]));
            }
        }
        }       
    }

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}





	
}

	