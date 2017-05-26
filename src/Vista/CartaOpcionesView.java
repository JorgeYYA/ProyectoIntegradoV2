package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorTotal;
import Controlador.ControladorVentanas;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CartaOpcionesView extends JFrame {

	private JPanel contentPane;
	
	ImageIcon restaurante = new ImageIcon(CartaOpcionesView.class.getResource("/img/restaurante.png"));
	
	String[] nombreOpcion = {"PLATOS","BEBIDAS","BOCADILLOS","TAPAS","CAFES",
	   "POSTRES"};
	String miEnglish[] = {"CHOICE OF OPTIONS","Return", "Checkout Order"};
	ImageIcon[] miArrayImagenes = {new ImageIcon(CartaOpcionesView.class.getResource("/img/platos.png")), 
	new ImageIcon(CartaOpcionesView.class.getResource("/img/bebidas.jpg")),
	new ImageIcon(CartaOpcionesView.class.getResource("/img/segundoPlato.jpg")),
	new ImageIcon(CartaOpcionesView.class.getResource("/img/cafes.jpg")),
	new ImageIcon(CartaOpcionesView.class.getResource("/img/postres.jpg")),
	new ImageIcon(CartaOpcionesView.class.getResource("/img/restaurante.png"))};
	
	ImageIcon n;
	JButton JbtnNewButton0, JbtnNewButton1, JbtnNewButton2, JbtnNewButton3, JbtnNewButton4,
	btnVolver, btnFinalizarPedido;

	JPanel panel;
	Image miImagen;
	Graphics g;
	Component c;
	JLabel lblFloridaRestaurante, lblCartaDeOpciones;
	public CartaOpcionesView() {
		
		
		
		try {
			this.setIconImage(ImageIO.read(new File("src/img/Icono.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 224));
		contentPane.setBackground(new Color(72, 162, 172));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		if(Inici.idioma == 0){
		lblCartaDeOpciones = new JLabel("CARTA DE OPCIONES");
		}else{
			lblCartaDeOpciones = new JLabel(miEnglish[0]);	
		}
		lblCartaDeOpciones.setFont(new Font("AR CENA", Font.BOLD, 30));
		lblCartaDeOpciones.setForeground(new Color(240, 238, 201));
		lblCartaDeOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCartaDeOpciones, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 162, 172));
		panel.setForeground(Color.CYAN);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 15, 5));
		
		JbtnNewButton0 = new JButton("PRIMEROS PLATOS");
		JbtnNewButton0.setBackground(new Color(133, 188, 195));
		JbtnNewButton0.setForeground(new Color(240, 238, 201));
		JbtnNewButton0.setFont(new Font("Tahoma", Font.BOLD, 13));
		JbtnNewButton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				ControladorVentanas.mostrarPrimerosPlatos();
				
			}
		});
		JbtnNewButton0.setIcon(new ImageIcon(CartaOpcionesView.class.getResource("/img/platos.png")));
		panel.add(JbtnNewButton0);
		
		JbtnNewButton1 = new JButton("BEBIDAS");
		JbtnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControladorVentanas.mostrarBebidas();
				
			}
		});
		JbtnNewButton1.setBackground(new Color(133, 188, 195));
		JbtnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 13));
		JbtnNewButton1.setForeground(new Color(240, 238, 201));
		JbtnNewButton1.setIcon(new ImageIcon(CartaOpcionesView.class.getResource("/img/bebidas.jpg")));
		panel.add(JbtnNewButton1);
		
		JbtnNewButton2 = new JButton("SEGUNDOS PLATOS");
		JbtnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControladorVentanas.mostrarSegundosPlatos();
				
			}
		});
		JbtnNewButton2.setBackground(new Color(133, 188, 195));
		JbtnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 13));
		JbtnNewButton2.setForeground(new Color(240, 238, 201));
		JbtnNewButton2.setIcon(new ImageIcon(CartaOpcionesView.class.getResource("/img/segundoPLato.jpg")));
		panel.add(JbtnNewButton2);
		
		JbtnNewButton3 = new JButton("CAFES");
		JbtnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControladorVentanas.mostrarCafes();
				
			}
		});
		JbtnNewButton3.setBackground(new Color(133, 188, 195));
		JbtnNewButton3.setFont(new Font("Tahoma", Font.BOLD, 13));
		JbtnNewButton3.setForeground(new Color(240, 238, 201));
		JbtnNewButton3.setIcon(new ImageIcon(CartaOpcionesView.class.getResource("/img/cafes.jpg")));
		panel.add(JbtnNewButton3);
		
		JbtnNewButton4 = new JButton("POSTRES");
		JbtnNewButton4.setBackground(new Color(133, 188, 195));
		JbtnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ControladorVentanas.mostrarPostres();
				
			}
		});
		
		lblFloridaRestaurante = new JLabel("");
		
		lblFloridaRestaurante.setIcon(restaurante);
		lblFloridaRestaurante.setForeground(new Color(240, 238, 201));
		lblFloridaRestaurante.setFont(new Font("AR CENA", Font.PLAIN, 25));
		lblFloridaRestaurante.setHorizontalAlignment(SwingConstants.CENTER);
		lblFloridaRestaurante.setIcon(new ImageIcon(CartaOpcionesView.class.getResource("/img/restaurante.png")));
		panel.add(lblFloridaRestaurante);
		JbtnNewButton4.setFont(new Font("Tahoma", Font.BOLD, 13));
		JbtnNewButton4.setForeground(new Color(240, 238, 201));
		JbtnNewButton4.setIcon(new ImageIcon(CartaOpcionesView.class.getResource("/img/postres.jpg")));
		panel.add(JbtnNewButton4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(72, 162, 172));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		if(Inici.idioma == 0){
		btnVolver = new JButton("VOLVER");
		}else{
			btnVolver = new JButton(miEnglish[1]);	
		}
		btnVolver.setBackground(new Color(133, 188, 195));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVolver.setForeground(new Color(240, 238, 201));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();//si pulsa volver se cierra
				
				ControladorVentanas.mostrarLogin();
				
				
			}
		});
		panel_1.add(btnVolver);
		
		if(Inici.idioma == 0){
		btnFinalizarPedido = new JButton("Finalizar Pedido");
		}else{
			btnFinalizarPedido = new JButton(miEnglish[2]);	
		}
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorTotal ct = new ControladorTotal();
				dispose();
				
				//ControladorVentanas.mostrarRecibo();
				Total to = new Total();
				//to.textField.setText(ct.ticket+"defwedvf");
				//System.out.println(ct.ticket+"qwsacd");
				to.setVisible(true);
				to.setLocationRelativeTo(null);	
				
			}
		});
		btnFinalizarPedido.setBackground(new Color(133, 188, 195));
		btnFinalizarPedido.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFinalizarPedido.setForeground(new Color(240, 238, 201));
		panel_1.add(btnFinalizarPedido);
		
		//addComponentListener(this);//para redimensionar
		//this.setVisible(true);
	}
	
	private Image getScaledImage(Image imagencita, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(imagencita, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	public void paint (Graphics g)
	 {
		 for(int i = 0; i<miArrayImagenes.length; i++){
		 Image imgRedimensionada;
		 ImageIcon imgRedimIcon;
		 
		 switch(i){
		 case 0:
			 imgRedimensionada = getScaledImage(miArrayImagenes[i].getImage(),JbtnNewButton0.getWidth(),JbtnNewButton0.getHeight());
			 imgRedimIcon = new ImageIcon(imgRedimensionada);
			 JbtnNewButton0.setIcon(imgRedimIcon);
			 break;
		 case 1:
			 imgRedimensionada = getScaledImage(miArrayImagenes[i].getImage(),JbtnNewButton1.getWidth(),JbtnNewButton1.getHeight());
			 imgRedimIcon = new ImageIcon(imgRedimensionada);
			 JbtnNewButton1.setIcon(imgRedimIcon);
			 break;
		 case 2:
			 imgRedimensionada = getScaledImage(miArrayImagenes[i].getImage(),JbtnNewButton2.getWidth(),JbtnNewButton2.getHeight());
			 imgRedimIcon = new ImageIcon(imgRedimensionada);
			 JbtnNewButton2.setIcon(imgRedimIcon);
			 break;
		 case 3:
			 imgRedimensionada = getScaledImage(miArrayImagenes[i].getImage(),JbtnNewButton3.getWidth(),JbtnNewButton3.getHeight());
			 imgRedimIcon = new ImageIcon(imgRedimensionada);
			 JbtnNewButton3.setIcon(imgRedimIcon);
			 break;
		 case 4:
			 imgRedimensionada = getScaledImage(miArrayImagenes[i].getImage(),JbtnNewButton4.getWidth(),JbtnNewButton4.getHeight());
			 imgRedimIcon = new ImageIcon(imgRedimensionada);
			 JbtnNewButton4.setIcon(imgRedimIcon);
			 break;
		 case 5:
			 imgRedimensionada = getScaledImage(miArrayImagenes[i].getImage(),lblFloridaRestaurante.getWidth(),lblFloridaRestaurante.getHeight());
			 imgRedimIcon = new ImageIcon(imgRedimensionada);
			 lblFloridaRestaurante.setIcon(imgRedimIcon);
			 break;
		 }
		 }
		 super.paint(g);
}
}	
