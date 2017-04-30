package Tienda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Tienda extends JFrame{
	
	private JFrame ventanaañadir,ventanamodificar,ventanaborrar;
	private JPanel contentPane;
	private JTextField añadircodigopieza;
	private JTextField añadirnombrepieza;
	private JTextField añadiridproveedores;
	private JTextField añadirnombreproveedores;
	private JButton b1,b2,b3,b4; 


	private JFrame frame;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda window = new Tienda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tienda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 500, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.foreground"));
		panel.setBounds(0, 21, 65, 272);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setHorizontalAlignment(SwingConstants.LEFT);
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSelect.setBounds(0, 34, 65, 52);
		panel.add(btnSelect);
		
		JButton btnSelectwhere = new JButton("Where");
		btnSelectwhere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSelectwhere.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSelectwhere.setBounds(0, 114, 65, 53);
		panel.add(btnSelectwhere);
		
		JButton btnAVG = new JButton("AVG");
		btnAVG.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAVG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAVG.setBounds(0, 197, 65, 52);
		panel.add(btnAVG);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 521, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu InfomeWeb = new JMenu("Informe/Web");
		menuBar.add(InfomeWeb);
		
		JMenuItem MIProveedores = new JMenuItem("Proveedores");
		InfomeWeb.add(MIProveedores);
		
		JMenuItem MIPiezas = new JMenuItem("Piezas");
		InfomeWeb.add(MIPiezas);
		
		JSeparator separator = new JSeparator();
		InfomeWeb.add(separator);
		
		JMenuItem MISalir = new JMenuItem("Salir");
		MISalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "¿Quieres salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(resp==JOptionPane.YES_OPTION)
					System.exit(0);
				else
					JOptionPane.showMessageDialog(null, "OK");
			}
		});
		InfomeWeb.add(MISalir);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem MITamaño = new JMenuItem("Tama\u00F1o");
		mnView.add(MITamaño);
		
		JMenuItem MIColor = new JMenuItem("Color");
		
		MIColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c=JColorChooser.showDialog(null, "Mis Colores", Color.red);
				frame.getContentPane().setBackground(c);
				panel_1.setBackground(c);
			}
		});
		
		 
		mnView.add(MIColor);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem MIAbout = new JMenuItem("About");
		mnHelp.add(MIAbout);
		
		JMenuItem MIAyudaDeConsultas = new JMenuItem("Ayuda de consultas");
		mnHelp.add(MIAyudaDeConsultas);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.white);
		panel_1.setBounds(75, 119, 405, 161);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 405, 161);
		panel_1.add(tabbedPane);
		
		JPanel Piezas = new JPanel();
		tabbedPane.addTab("Piezas", null, Piezas, null);
		
		JPanel proveedores = new JPanel();
		tabbedPane.addTab("Proveedores", null, proveedores, null);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAñadir();
			}
		});
		btnAadir.setBounds(75, 85, 89, 23);
		frame.getContentPane().add(btnAadir);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaModificar();
			}
		});
		btnModificar.setBounds(229, 85, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaBorrar();
			}
		});
		btnBorrar.setBounds(391, 85, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(110, 28, 322, 34);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Base de datos de la empresa");
		lblTitulo.setFont(new Font("Perpetua", Font.ITALIC, 30));
		lblTitulo.setBounds(10, 0, 302, 34);
		panel_2.add(lblTitulo);
	}
	
	
	
	public void VentanaAñadir(){
		
			ventanaañadir=new JFrame();
		
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setBounds(100, 100, 330, 222);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(22, 63, 271, 109);
			contentPane.add(tabbedPane);
			
			JPanel Piezas = new JPanel();
			tabbedPane.addTab("Piezas", null, Piezas, null);
			Piezas.setLayout(null);
			
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setBounds(10, 11, 62, 14);
			Piezas.add(lblCodigo);
			
			añadircodigopieza = new JTextField();
			añadircodigopieza.setBounds(58, 8, 142, 20);
			Piezas.add(añadircodigopieza);
			añadircodigopieza.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(10, 44, 46, 14);
			Piezas.add(lblNombre);
			
			añadirnombrepieza = new JTextField();
			añadirnombrepieza.setBounds(58, 41, 142, 20);
			Piezas.add(añadirnombrepieza);
			añadirnombrepieza.setColumns(10);
			
			JPanel Proveedores = new JPanel();
			tabbedPane.addTab("Proveedores", null, Proveedores, null);
			Proveedores.setLayout(null);
			
			JLabel lblId = new JLabel("ID");
			lblId.setBounds(10, 11, 46, 14);
			Proveedores.add(lblId);
			
			añadiridproveedores = new JTextField();
			añadiridproveedores.setBounds(55, 8, 165, 20);
			Proveedores.add(añadiridproveedores);
			añadiridproveedores.setColumns(10);
			
			JLabel lblNombre_1 = new JLabel("Nombre");
			lblNombre_1.setBounds(10, 39, 46, 14);
			Proveedores.add(lblNombre_1);
			
			añadirnombreproveedores = new JTextField();
			añadirnombreproveedores.setBounds(55, 36, 165, 20);
			Proveedores.add(añadirnombreproveedores);
			añadirnombreproveedores.setColumns(10);
			
			JButton btnAadir = new JButton("A\u00F1adir");
			btnAadir.setBounds(41, 29, 89, 23);
			contentPane.add(btnAadir);
			
			JButton btnVolver = new JButton("Volver");
			btnVolver.setBounds(175, 29, 89, 23);
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ventanaañadir.setVisible(false);
				}
			});
			contentPane.add(btnVolver);
			ventanaañadir.getContentPane().add(contentPane);
			
			ventanaañadir.setResizable(false);
			ventanaañadir.setTitle("Añadir elementos");
			ventanaañadir.setBounds(100, 100, 330, 222);
			ventanaañadir.setVisible(true);
			
			
		
	}
	
	public void VentanaModificar(){
		ventanamodificar=new JFrame();
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 330, 222);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 63, 271, 109);
		contentPane.add(tabbedPane);
		
		JPanel Piezas = new JPanel();
		tabbedPane.addTab("Piezas", null, Piezas, null);
		Piezas.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 62, 14);
		Piezas.add(lblCodigo);
		
		añadircodigopieza = new JTextField();
		añadircodigopieza.setBounds(58, 8, 142, 20);
		Piezas.add(añadircodigopieza);
		añadircodigopieza.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 44, 46, 14);
		Piezas.add(lblNombre);
		
		añadirnombrepieza = new JTextField();
		añadirnombrepieza.setBounds(58, 41, 142, 20);
		Piezas.add(añadirnombrepieza);
		añadirnombrepieza.setColumns(10);
		
		JPanel Proveedores = new JPanel();
		tabbedPane.addTab("Proveedores", null, Proveedores, null);
		Proveedores.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		Proveedores.add(lblId);
		
		añadiridproveedores = new JTextField();
		añadiridproveedores.setBounds(55, 8, 165, 20);
		Proveedores.add(añadiridproveedores);
		añadiridproveedores.setColumns(10);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 39, 46, 14);
		Proveedores.add(lblNombre_1);
		
		añadirnombreproveedores = new JTextField();
		añadirnombreproveedores.setBounds(55, 36, 165, 20);
		Proveedores.add(añadirnombreproveedores);
		añadirnombreproveedores.setColumns(10);
		
		JButton btnAadir = new JButton("Modificar");
		btnAadir.setBounds(41, 29, 89, 23);
		contentPane.add(btnAadir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(175, 29, 89, 23);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanamodificar.setVisible(false);
			}
		});
		contentPane.add(btnVolver);
		
		
		
		b1=new JButton("<<");
		b2=new JButton("<");
		b3=new JButton(">");
		b4=new JButton(">>");
		
		b1.setBounds(10, 200, 50, 30);
		b2.setBounds(80, 200, 50, 30);
		b3.setBounds(170, 200, 50, 30);
		b4.setBounds(240, 200, 50, 30);
		
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		contentPane.add(b4);
		
		ventanamodificar.getContentPane().add(contentPane);

		ventanamodificar.setResizable(false);
		ventanamodificar.setTitle("Modificar elementos");
		ventanamodificar.setBounds(100, 100, 330, 282);
		ventanamodificar.setVisible(true);
	}
	
	public void VentanaBorrar(){
		ventanaborrar=new JFrame();
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 330, 222);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 63, 271, 109);
		contentPane.add(tabbedPane);
		
		JPanel Piezas = new JPanel();
		tabbedPane.addTab("Piezas", null, Piezas, null);
		Piezas.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 62, 14);
		Piezas.add(lblCodigo);
		
		añadircodigopieza = new JTextField();
		añadircodigopieza.setBounds(58, 8, 142, 20);
		Piezas.add(añadircodigopieza);
		añadircodigopieza.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 44, 46, 14);
		Piezas.add(lblNombre);
		
		añadirnombrepieza = new JTextField();
		añadirnombrepieza.setBounds(58, 41, 142, 20);
		Piezas.add(añadirnombrepieza);
		añadirnombrepieza.setColumns(10);
		
		JPanel Proveedores = new JPanel();
		tabbedPane.addTab("Proveedores", null, Proveedores, null);
		Proveedores.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		Proveedores.add(lblId);
		
		añadiridproveedores = new JTextField();
		añadiridproveedores.setBounds(55, 8, 165, 20);
		Proveedores.add(añadiridproveedores);
		añadiridproveedores.setColumns(10);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 39, 46, 14);
		Proveedores.add(lblNombre_1);
		
		añadirnombreproveedores = new JTextField();
		añadirnombreproveedores.setBounds(55, 36, 165, 20);
		Proveedores.add(añadirnombreproveedores);
		añadirnombreproveedores.setColumns(10);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(41, 29, 89, 23);
		contentPane.add(btnBorrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(175, 29, 89, 23);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaborrar.setVisible(false);
			}
		});
		contentPane.add(btnVolver);
		
		
		
		b1=new JButton("<<");
		b2=new JButton("<");
		b3=new JButton(">");
		b4=new JButton(">>");
		
		b1.setBounds(10, 200, 50, 30);
		b2.setBounds(80, 200, 50, 30);
		b3.setBounds(170, 200, 50, 30);
		b4.setBounds(240, 200, 50, 30);
		
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		contentPane.add(b4);
		
		ventanaborrar.getContentPane().add(contentPane);

		ventanaborrar.setResizable(false);
		ventanaborrar.setTitle("Borrar elementos");
		ventanaborrar.setBounds(100, 100, 330, 282);
		ventanaborrar.setVisible(true);
	}
	
}
