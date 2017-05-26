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

public class PantallaLogin extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	String [] english = {"Welcome", "Restaurant Florida", "User", "Password", "Log in"
			, "Register", "Skip", "Active Directory", 
			"Invalid user or password", "You must enter correct values"};
	JLabel lblBenvingut, lblNewLabel, lblUsuari, lblContrasenya;
	JButton btnEntrar, btnRegistrar, btnOmitir, btnAD;

	public PantallaLogin() {
		
		
		try {
			this.setIconImage(ImageIO.read(new File("src/img/Icono.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 162, 172));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		if(Inici.idioma == 0){
		lblBenvingut = new JLabel("Benvingut");
		} else {
			lblBenvingut = new JLabel(english[0]);
		}
		lblBenvingut.setForeground(new Color(240, 238, 201));
		lblBenvingut.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblBenvingut.setVerticalAlignment(SwingConstants.TOP);
		lblBenvingut.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvingut.setFont(new Font("AR CENA", Font.BOLD, 40));
		contentPane.add(lblBenvingut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(72, 162, 172));
		contentPane.add(panel_1);
		
		if(Inici.idioma == 0){
		lblNewLabel = new JLabel("RESTAURANTE FLORIDA");
		} else{
			lblNewLabel = new JLabel(english[1]);	
		}
		lblNewLabel.setFont(new Font("AR CENA", Font.BOLD, 60));
		lblNewLabel.setForeground(new Color(240, 238, 201));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(150);
		panel_1.add(verticalStrut);
		
		Component verticalStrut_3 = Box.createVerticalStrut(30);
		contentPane.add(verticalStrut_3);
		
		if(Inici.idioma == 0){
		lblUsuari = new JLabel("Usuari:");
		} else{
			lblUsuari = new JLabel(english[2]);
		}
		lblUsuari.setForeground(new Color(240, 238, 201));
		lblUsuari.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuari.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblUsuari);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(72, 162, 172));
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtUsername = new JTextField();
		panel_2.add(txtUsername);
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.addActionListener(this);
		txtUsername.setActionCommand("Entrar");
		
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtUsername.setColumns(10);
		
		Component verticalStrut_2 = Box.createVerticalStrut(50);
		contentPane.add(verticalStrut_2);
		
		if(Inici.idioma == 0){
		lblContrasenya = new JLabel("Contrasenya:");
		}else{
			lblContrasenya = new JLabel(english[3]);	
		}
		lblContrasenya.setForeground(new Color(240, 238, 201));
		lblContrasenya.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasenya.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblContrasenya);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(72, 162, 172));
		contentPane.add(panel_3);
		
		passwordField = new JPasswordField();
		panel_3.add(passwordField);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setColumns(10);
		passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordField.addActionListener(this);
		passwordField.setActionCommand("Entrar");
		
		Component verticalStrut_1 = Box.createVerticalStrut(110);
		contentPane.add(verticalStrut_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(72, 162, 172));
		contentPane.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_4.add(panel, BorderLayout.SOUTH);
		panel.setBackground(new Color(72, 162, 172));
		
		if(Inici.idioma == 0){
		btnEntrar = new JButton("Entrar");
		} else{
		btnEntrar = new JButton(english[4]);	
		}
		btnEntrar.setBackground(new Color(133, 188, 195));
		btnEntrar.setForeground(new Color(240, 238, 201));
		panel.add(btnEntrar);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEntrar.addActionListener(this);
		btnEntrar.setActionCommand("Entrar");
		
		if(Inici.idioma == 0){
		btnRegistrar = new JButton("Registrate!");
		}else{
		btnRegistrar = new JButton(english[5]);	
		}
		btnRegistrar.setBackground(new Color(133, 188, 195));
		btnRegistrar.setForeground(new Color(240, 238, 201));
		panel.add(btnRegistrar);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("Registrar");
		
		if(Inici.idioma == 0){
		btnOmitir = new JButton("Omitir");
		}else{
			btnOmitir = new JButton(english[6]);	
		}
		btnOmitir.setBackground(new Color(133, 188, 195));
		btnOmitir.setForeground(new Color(240, 238, 201));
		panel.add(btnOmitir);
		btnOmitir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOmitir.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnOmitir.addActionListener(this);
		btnOmitir.setActionCommand("Omitir");
		
		
		btnAD = new JButton("Active Directory");
        btnAD.setBackground(new Color(133, 188, 195));
        btnAD.setForeground(new Color(240, 238, 201));
        panel.add(btnAD);
        btnAD.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAD.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAD.addActionListener(this);
        btnAD.setActionCommand("Active");
        
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

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (arg0.getActionCommand()){
		case "Entrar": if (compruebaDatos()) {
							ControladorPantallaLogin cpl = new ControladorPantallaLogin();
							if (cpl.existeUsuario(txtUsername.getText(),passwordField.getText())==1){
								ControladorVentanas.mostrarPantallaBienvenida();
								ControladorVentanas.ocultarLogin();
								String userId = txtUsername.getText();
								Inici.idUser = userId;
								//System.out.println("Funciona ");
								PantallaBienvenida.lblNombreUser.setText(userId);
								dispose();
							} else {
								JOptionPane jp = new JOptionPane();
								if(Inici.idioma == 0){
								jp.showMessageDialog(this, "Usuario o contraseña no validos");
								}else{
								jp.showMessageDialog(this, english[8]);	
								}
							}
						} else {
							JOptionPane jp = new JOptionPane();
							if(Inici.idioma == 0){
							jp.showMessageDialog(this, "Debes introducir valores correctos.");
							}else{
							jp.showMessageDialog(this, english[9]);
							}
						}
						break;
		case "Registrar": PantallaRegistro pr = new PantallaRegistro();
						  break;
		case "Omitir": ControladorVentanas.mostrarPantallaBienvenida();
						ControladorVentanas.ocultarLogin();
		break;
		 case "Active": PantallaActiveDirectory pad = new PantallaActiveDirectory();
         this.dispose();
          break;
		default: break;
		}
		
	}
	
	public boolean compruebaDatos(){
		boolean flag = false;
		Pattern patronUsuario = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Pattern patronPassword = Pattern.compile("[A-Za-z0-9]{1,20}"); // aqui podriamos definir una regla mas estricta para las contraseñas
		String usuario = txtUsername.getText();
		String pass = passwordField.getText();
		Matcher n = patronUsuario.matcher(usuario);
		Matcher p = patronPassword.matcher(pass);
		if ((n.matches())&&(p.matches())){
			flag=true;
		}
		return flag;
	}
	
}