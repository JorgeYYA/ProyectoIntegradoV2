package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.sql.Time;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;

public class PantallaCargaView extends JFrame {

	private JPanel contentPane;


	
	public PantallaCargaView() throws InterruptedException {
		
		
		try {
			this.setIconImage(ImageIO.read(new File("src/img/Icono.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblLableFondo = new JLabel("");
		lblLableFondo.setIcon(new ImageIcon("./src/img/gifFondo.gif"));		
		
		
		setBounds(350, 100, 610, 500);//aqui especificamos tamaño
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);//aqui le ponemos el color de fondo
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		
		
		lblLableFondo.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblLableFondo);//aqui le pasamos al contentPane la imagen de fondo
		
	}

}