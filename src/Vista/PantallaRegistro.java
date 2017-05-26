package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import Controlador.ControladorRegistro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.Color;

public class PantallaRegistro extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JTextField txtTarjeta;
    private JTextField txtPayPal;
    private JTextField txtUsuario;
    
    String miEnglish[] = {"Register", "User(e-mail)", "Name", "LastName", "Password",
    		"Retype password", "Credit card", "Confirm", "Cancel",
    		"Registered user successfully", "This user already exists, check the data",
    		"Problem connecting to BBDD", "You must enter correct values", 
    		"La contraseña no coincide"};
    
    JLabel lblTitulo, lblUsuario, lblNombre, lblApellido, lblCheckPassword, lblTarjeta,
    		lblContrasenya, lblPayPal;
    
    JButton btnConfirmar, btnCancelar;
    
    public PantallaRegistro() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(72, 162, 172));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        
        if(Inici.idioma == 0){
        lblTitulo = new JLabel("Registro");
        }else {
        lblTitulo = new JLabel(miEnglish[0]);	
        }
        lblTitulo.setForeground(new Color(240, 238, 201));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setFont(new Font("AR CENA", Font.BOLD, 30));
        contentPane.add(lblTitulo);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(72, 162, 172));
        FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
        contentPane.add(panel_1);
        if(Inici.idioma == 0){
        lblUsuario = new JLabel("Usuario (e-mail):");
        }else{
        lblUsuario = new JLabel(miEnglish[1]);	
        }
        lblUsuario.setForeground(new Color(240, 238, 201));
        panel_1.add(lblUsuario);
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        txtUsuario = new JTextField();
        panel_1.add(txtUsuario);
        txtUsuario.setColumns(20);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(72, 162, 172));
        FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
        contentPane.add(panel_2);
        
        if(Inici.idioma == 0){
        lblNombre = new JLabel("Nombre:");
        }else{
        lblNombre = new JLabel(miEnglish[2]);	
        }
        lblNombre.setForeground(new Color(240, 238, 201));
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_2.add(lblNombre);
        
        txtNombre = new JTextField();
        panel_2.add(txtNombre);
        txtNombre.setColumns(20);
        
        if(Inici.idioma == 0){
        lblApellido = new JLabel("Apellido:");
        }else{
        lblApellido = new JLabel(miEnglish[3]);	
        }
        lblApellido.setForeground(new Color(240, 238, 201));
        lblApellido.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_2.add(lblApellido);
        
        txtApellido = new JTextField();
        panel_2.add(txtApellido);
        txtApellido.setColumns(20);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(72, 162, 172));
        FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
        contentPane.add(panel_3);
        
        if(Inici.idioma == 0){
        lblContrasenya = new JLabel("Contrase\u00F1a:");
        }else{
        lblContrasenya = new JLabel(miEnglish[4]);	
        }
        lblContrasenya.setForeground(new Color(240, 238, 201));
        lblContrasenya.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_3.add(lblContrasenya);
        
        passwordField = new JPasswordField();
        passwordField.setColumns(20);
        panel_3.add(passwordField);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(72, 162, 172));
        FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
        contentPane.add(panel_4);
        
        if(Inici.idioma == 0){
        lblCheckPassword = new JLabel("Escribe otra vez la contrase\u00F1a:");
        }else{
        	lblCheckPassword = new JLabel(miEnglish[5]);	
        }
        lblCheckPassword.setForeground(new Color(240, 238, 201));
        lblCheckPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_4.add(lblCheckPassword);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setColumns(20);
        panel_4.add(passwordField_1);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(72, 162, 172));
        FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
        contentPane.add(panel_5);
        
        if(Inici.idioma == 0){
        lblTarjeta = new JLabel("Tarjeta: ");
        }else{
        	lblTarjeta = new JLabel(miEnglish[6]);	
        }
        lblTarjeta.setForeground(new Color(240, 238, 201));
        lblTarjeta.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_5.add(lblTarjeta);
        
        txtTarjeta = new JTextField();
        txtTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_5.add(txtTarjeta);
        txtTarjeta.setColumns(20);
        
        lblPayPal = new JLabel("PayPal: ");
        lblPayPal.setForeground(new Color(240, 238, 201));
        lblPayPal.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_5.add(lblPayPal);
        
        txtPayPal = new JTextField();
        panel_5.add(txtPayPal);
        txtPayPal.setColumns(20);
        
        JPanel panel = new JPanel();
        panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        panel.setBackground(new Color(72, 162, 172));
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.TRAILING);
        contentPane.add(panel);
        
        if(Inici.idioma == 0){
        btnConfirmar = new JButton("Confirmar");
        }else{
        	btnConfirmar = new JButton(miEnglish[7]);	
        }
        btnConfirmar.setBackground(new Color(133, 188, 195));
        btnConfirmar.setForeground(new Color(240, 238, 201));
        btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnConfirmar.addActionListener(this);
        btnConfirmar.setActionCommand("Confirmar");
        panel.add(btnConfirmar);
        
        if(Inici.idioma == 0){
        btnCancelar = new JButton("Cancelar");
        }else{
        	btnCancelar = new JButton(miEnglish[8]);	
        }
        btnCancelar.setBackground(new Color(133, 188, 195));
        btnCancelar.setForeground(new Color(240, 238, 201));
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnCancelar.addActionListener(this);
        btnCancelar.setActionCommand("Cancelar");
        panel.add(btnCancelar);
        setSize(700,600);
        setTitle("Register");
        
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        int width = (pantalla.width - ventana.width) / 2;
        int height = (pantalla.height - ventana.height) / 2;
        this.setLocation(width, height);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        switch (arg0.getActionCommand()){
        case "Confirmar":     if (passwordField.getText().equals(passwordField_1.getText())){
                                if (compruebaDatos()){
                                    ControladorRegistro cr = new ControladorRegistro();
                                    try {
                                        cr.insertarUsuario(txtUsuario.getText(), txtNombre.getText(), txtApellido.getText(), passwordField.getText(), txtTarjeta.getText(), txtPayPal.getText());
                                        JOptionPane jop = new JOptionPane();
                                        if(Inici.idioma == 0){
                                        jop.showMessageDialog(this, "Usuario registrado con exito!");
                                        }else{
                                        	jop.showMessageDialog(this, miEnglish[9]);	
                                        }
                                        dispose();
                                    } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
                                        JOptionPane jop = new JOptionPane();
                                        if(Inici.idioma == 0){
                                        jop.showMessageDialog(this, "Este usuario ya existe, comprueba los datos!");
                                        }else{
                                        	jop.showMessageDialog(this, miEnglish[10]);	
                                        }
                                    } catch (HeadlessException e) {
                                        JOptionPane jop = new JOptionPane();
                                        if(Inici.idioma == 0){
                                        jop.showMessageDialog(this, "Problema al conectar con la BBDD: "+e);
                                        }else{
                                        	jop.showMessageDialog(this, miEnglish[11]+":"+e);	
                                        }
                                        dispose();
                                    } catch (SQLException e) {
                                        JOptionPane jop = new JOptionPane();
                                        if(Inici.idioma == 0){
                                        jop.showMessageDialog(this, "Problema al conectar con la BBDD: "+e);
                                        }else{
                                        	jop.showMessageDialog(this, miEnglish[12]+e);	
                                        }
                                        dispose();
                                    }
                                } else {
                                    JOptionPane jp = new JOptionPane();
                                    if(Inici.idioma == 0){
                                    jp.showMessageDialog(this, "Debes introducir valores correctos.");
                                    }else{
                                    	jp.showMessageDialog(this, miEnglish[13]);	
                                    }
                                }
                            } else {
                                JOptionPane jop = new JOptionPane();
                                if(Inici.idioma == 0){
                                jop.showMessageDialog(this, "La contraseña no coincide");
                                }else{
                                	jop.showMessageDialog(this, miEnglish[14]);	
                                }
                            }
                          break;
        case "Cancelar": dispose();
                        break;
            // llamamos al metodo del controlador que inserte el usuario
        }
        
    }
    
    public boolean compruebaDatos(){
        boolean flag = false;
        Pattern patronUsuario = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Pattern patronNombreApellido = Pattern.compile("[A-Za-z0-9\\s]{1,20}");
        Pattern patronPassword = Pattern.compile("[A-Za-z0-9]{1,20}"); // aqui podriamos definir una regla mas estricta para las contraseñas
        String email = txtUsuario.getText();
        String usuario = txtNombre.getText();
        String pass = passwordField.getText();
        String apellido = txtApellido.getText();
        Matcher o = patronUsuario.matcher(email);
        Matcher p = patronPassword.matcher(pass);
        Matcher q = patronNombreApellido.matcher(usuario);
        Matcher a = patronNombreApellido.matcher(apellido);
        if ((o.matches())&&(p.matches())&&(q.matches())&&(a.matches())){
            flag=true;
        }
        return flag;
    }
}