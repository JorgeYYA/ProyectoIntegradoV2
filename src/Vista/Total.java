package Vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorTotal;
import Controlador.ControladorVentanas;
import Modelo.importarCuentaPDF;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Total extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton botonVolver;
	private JButton botonPagar;
	private JRadioButton radioTarjeta;
	private JRadioButton radioEfectivo;
	private Component horizontalStrut;
	private Component verticalStrut;
	static public JTable table;
	
	ControladorTotal ct = new ControladorTotal();
	private JButton btnExportarAPdf;


	public Total() {
		
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
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(72, 162, 172));
		setContentPane(contentPane);
		
		JLabel lblLaCuenta = new JLabel("La cuenta");
		lblLaCuenta.setForeground(new Color(240, 238, 201));
		lblLaCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaCuenta.setFont(new Font("AR CENA", Font.PLAIN, 40));
		contentPane.add(lblLaCuenta, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.setBackground(new Color(72, 162, 172));
		
		btnExportarAPdf = new JButton("Exportar a PDF");
		btnExportarAPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showSaveDialog(null);
				importarCuentaPDF icp = new importarCuentaPDF();
				icp.creaCuenta(chooser.getSelectedFile().getAbsolutePath(), table);

			}
		});
		btnExportarAPdf.setForeground(new Color(240, 238, 201));
		btnExportarAPdf.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExportarAPdf.setBackground(new Color(133, 188, 195));
		panel.add(btnExportarAPdf);
		
		verticalStrut = Box.createVerticalStrut(35);
		panel.add(verticalStrut);
		
		botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				ControladorVentanas.mostrarOpciones();
				
			}
		});
		botonVolver.setForeground(new Color(240, 238, 201));
		botonVolver.setBackground(new Color(133, 188, 195));
		botonVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(botonVolver);
		
		botonPagar = new JButton("Pagar");
		botonPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				ControladorVentanas.mostrarGracias();
				
			}
		});
		botonPagar.setForeground(new Color(240, 238, 201));
		botonPagar.setBackground(new Color(133, 188, 195));
		botonPagar.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(botonPagar);
		
		horizontalStrut = Box.createHorizontalStrut(150);
		panel.add(horizontalStrut);
		
		radioTarjeta = new JRadioButton("Tarjeta");
		radioTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioTarjeta.setBackground(new Color(72, 162, 172));
		panel.add(radioTarjeta);
		
		radioEfectivo = new JRadioButton("Efectivo");
		radioEfectivo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioEfectivo.setBackground(new Color(72, 162, 172));
		panel.add(radioEfectivo);
		
		//Grupo de botones tipo radio
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioEfectivo);
		group.add(radioTarjeta);
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Arial", Font.PLAIN, 25));
		contentPane.add(table, BorderLayout.CENTER);
		ct.getTicket();
		table.setRowHeight(28);
		this.setSize(800, 600);
		//this.setVisible(true);
	}
}