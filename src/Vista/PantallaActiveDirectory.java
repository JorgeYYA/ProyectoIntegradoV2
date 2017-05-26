package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorActiveDirectory;
import Controlador.ControladorVentanas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PantallaActiveDirectory extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textUsuario;
    private JTextField textDominio;
    private JPasswordField textContrasena;

    public PantallaActiveDirectory() {
    	
    	
    	
    	try {
			this.setIconImage(ImageIO.read(new File("src/img/Icono.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 280, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JLabel lblTitulo = new JLabel("Registro Active Directory");
        lblTitulo.setForeground(SystemColor.textHighlight);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblTitulo, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        
        JLabel lblNombre = new JLabel("Usuario: ");
        panel.add(lblNombre);
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        textUsuario = new JTextField();
        panel.add(textUsuario);
        textUsuario.setColumns(10);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        panel.add(horizontalGlue);
        
        JLabel lblDominio = new JLabel("Dominio: ");
        lblDominio.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(lblDominio);
        
        textDominio = new JTextField();
        panel.add(textDominio);
        textDominio.setColumns(10);
            
        JLabel lblContrasena = new JLabel("Contrase\u00F1a: ");
        lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(lblContrasena);
        
        textContrasena = new JPasswordField();
        panel.add(textContrasena);
        textContrasena.setColumns(10);
        
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(btnEntrar);
        btnEntrar.setActionCommand("Entrar");
        btnEntrar.addActionListener(this);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCancelar.setActionCommand("Cancelar");
        btnCancelar.addActionListener(this);
        panel.add(btnCancelar);
        
        
        btnCancelar.addActionListener(this);
        

        setTitle("Active Directory Login Screen");
        setVisible(true);
        setResizable(false);    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
        case "Cancelar": ControladorVentanas.mostrarLogin();
                        this.dispose();
                        break;
        case "Entrar":     if ((textUsuario.getText().length() > 0)&&(textDominio.getText().length() > 0)&&(textContrasena.getText().length() > 0)){
                            ControladorActiveDirectory cad = new ControladorActiveDirectory("ldap://10.2.72.198", textUsuario.getText(), textDominio.getText(), textContrasena.getText());
                            if (cad.existeUsuario()) {
                                PantallaBienvenida.lblNombreUser.setText(textUsuario.getText()+"@"+textDominio.getText());
                                ControladorVentanas.mostrarPantallaBienvenida();
                                this.dispose();
                            } else {
                                JOptionPane jop = new JOptionPane();
                                jop.showMessageDialog(this, "Usuario, contraseña o dominio no validos.");
                            } 
                        } else {
                            JOptionPane jp = new JOptionPane();
                            jp.showMessageDialog(this, "Faltan valores.");
                        }
                        break;
        default: break;
        }
        
    }

}