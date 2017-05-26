package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorPantallaLogin;
import Controlador.ControladorVentanas;
import Controlador.ControlerPantallaCarga;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class VistaIdiomas extends JFrame{

	private JPanel contentPane;
	private VistaIdiomas vi;

	public VistaIdiomas() {
		
		
		try {
			this.setIconImage(ImageIO.read(new File("src/img/Icono.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 162, 172));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBenvingut = new JLabel("Select Language");
		lblBenvingut.setForeground(new Color(240, 238, 201));
		lblBenvingut.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblBenvingut.setVerticalAlignment(SwingConstants.TOP);
		lblBenvingut.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvingut.setFont(new Font("AR CENA", Font.BOLD, 40));
		contentPane.add(lblBenvingut, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnEspaol = new JButton("ESPA\u00D1OL");
		btnEspaol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inici.idioma = 0;
			
				
				
			}
		});
		btnEspaol.setForeground(new Color(240, 238, 201));
		btnEspaol.setFont(new Font("AR CENA", Font.BOLD, 99));
		btnEspaol.setBackground(new Color(133, 188, 195));
		panel.add(btnEspaol);
		
		JButton btnEnglish = new JButton("ENGLISH");
		btnEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inici.idioma = 1;
				
				
			}
		});
		btnEnglish.setForeground(new Color(240, 238, 201));
		btnEnglish.setFont(new Font("AR CENA", Font.BOLD, 99));
		btnEnglish.setBackground(new Color(133, 188, 195));
		panel.add(btnEnglish);
        
		// Para centrar el app en medio de nuestra pantalla
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getSize();
		int width = (pantalla.width - ventana.width) / 2;
		int height = (pantalla.height - ventana.height) / 2;
		this.setLocation(width, height);
		
		this.setSize(700, 600);
		//setVisible(true);
		setTitle("Login Screen");
		setLocationRelativeTo(null);
		vi=this;
		
	}
	
}