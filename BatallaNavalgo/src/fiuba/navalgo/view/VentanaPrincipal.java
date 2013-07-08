package fiuba.navalgo.view;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import fiuba.navalgo.control.ControlJuego;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.view.disparos.VistaDisparo;
import fiuba.navalgo.view.naves.VistaNave;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;



public class VentanaPrincipal extends JFrame {
	private JFrame frame;
	private ControlJuego control;
	private JPanel panelTablero;
	private JButtonID mat[][];
	JLabel labelPuntaje;
	JLabel labelTurno;
	JRadioButton rdbtnDisparoPuntual;
	
	private ImageIcon agua;
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});	
	}
	
	public VentanaPrincipal(){
		try{
			initialize();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	private void initialize() throws IOException { 
		
		BufferedImage wagua= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/AGUA.png"));
		ImageIcon water = new ImageIcon(wagua);
		this.agua = (new ImageIcon(water.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		
		
		control = new ControlJuego();
		
		frame = new JFrame();
		frame.setForeground(new Color(0,0,0));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		panelTablero = new JPanel();
		panelTablero.setBounds(42, 106, 419, 354);
		panelTablero.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelTablero.setLayout(new GridLayout(10, 10));
		mat = new JButtonID[10][10];
		llenarArrayConLabels(mat);
		agregarLabels(mat);
		frame.getContentPane().add(panelTablero);
		
		
		
		
		rdbtnDisparoPuntual = new JRadioButton("Disparo directo");
		rdbtnDisparoPuntual.setSelected(true);
		rdbtnDisparoPuntual.setBounds(571, 167, 135, 23);
		rdbtnDisparoPuntual.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					control.cambiarDisparoEnCurso(new DisparoConvencional());
									}
			});
		frame.getContentPane().add(rdbtnDisparoPuntual);
		
		JRadioButton rdbtnMinaSubmarinaPuntual = new JRadioButton("Mina submarina Puntual");
		rdbtnMinaSubmarinaPuntual.setBounds(571, 207, 173, 23);
		rdbtnMinaSubmarinaPuntual.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Disparo disparo = new MinaSubmarinaPuntual();
				control.cambiarDisparoEnCurso(disparo);
				try {
					control.crearVistaDisparo(disparo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(rdbtnMinaSubmarinaPuntual);
		
		JRadioButton rdbtnMinaSubmarinaDoble = new JRadioButton("Mina submarina Doble");
		rdbtnMinaSubmarinaDoble.setBounds(571, 247, 173, 23);
		rdbtnMinaSubmarinaDoble.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Disparo disparo = new MinaSubmarinaDoble();
				control.cambiarDisparoEnCurso(disparo);
				try {
					control.crearVistaDisparo(disparo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
		frame.getContentPane().add(rdbtnMinaSubmarinaDoble);
		
		JRadioButton rdbtnMinaSubmarinaTriple = new JRadioButton("Mina submarina Triple");
		rdbtnMinaSubmarinaTriple.setBounds(571, 287, 173, 23);
		rdbtnMinaSubmarinaTriple.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Disparo disparo = new MinaSubmarinaTriple();
				control.cambiarDisparoEnCurso(disparo);
				try {
					control.crearVistaDisparo(disparo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(rdbtnMinaSubmarinaTriple);
		
		JRadioButton rdbtnMinaSubmarinaPor = new JRadioButton("Mina submarina por contacto");
		rdbtnMinaSubmarinaPor.setBounds(571, 327, 222, 23);
		rdbtnMinaSubmarinaPor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Disparo disparo = new MinaSubmarinaPorContacto();
				control.cambiarDisparoEnCurso(disparo);
				try {
					control.crearVistaDisparo(disparo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(rdbtnMinaSubmarinaPor);
		
		ButtonGroup grupoDisparos = new ButtonGroup();
		grupoDisparos.add(rdbtnDisparoPuntual);
		grupoDisparos.add(rdbtnMinaSubmarinaPuntual);
		grupoDisparos.add(rdbtnMinaSubmarinaDoble);
		grupoDisparos.add(rdbtnMinaSubmarinaTriple);
		grupoDisparos.add(rdbtnMinaSubmarinaPor);

		
		JLabel lbTurno = new JLabel();
		lbTurno.setFont(new Font("Papyrus", Font.BOLD, 15));
		lbTurno.setText("TURNO:");
		lbTurno.setBounds(42, 52, 96, 25);
		frame.getContentPane().add(lbTurno);
		
		JLabel lbPuntaje = new JLabel();
		lbPuntaje.setText("PUNTAJE:");
		lbPuntaje.setFont(new Font("Papyrus", Font.BOLD, 15));
		lbPuntaje.setBounds(322, 16, 112, 25);
		frame.getContentPane().add(lbPuntaje);
		
		JLabel lbLancha = new JLabel();
		lbLancha.setBackground(Color.MAGENTA);
		lbLancha.setForeground(Color.BLACK);
		lbLancha.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		lbLancha.setText("Lancha");
		lbLancha.setBounds(44, 475, 58, 25);
		frame.getContentPane().add(lbLancha);
		
		JLabel txtpnBuque = new JLabel();
		txtpnBuque.setBackground(Color.GREEN);
		txtpnBuque.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnBuque.setText("Buque");
		txtpnBuque.setBounds(212, 475, 58, 25);
		frame.getContentPane().add(txtpnBuque);
		
		JLabel txtpnDestructores = new JLabel();
		txtpnDestructores.setBackground(Color.CYAN);
		txtpnDestructores.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnDestructores.setText("Destructores");
		txtpnDestructores.setBounds(439, 475, 96, 25);
		frame.getContentPane().add(txtpnDestructores);
		
		JLabel txtpnPortaaviones = new JLabel();
		txtpnPortaaviones.setBackground(Color.YELLOW);
		txtpnPortaaviones.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnPortaaviones.setText("Portaaviones");
		txtpnPortaaviones.setBounds(303, 511, 99, 25);
		frame.getContentPane().add(txtpnPortaaviones);
		
		JLabel txtpnRompehielos = new JLabel();
		txtpnRompehielos.setBackground(Color.RED);
		txtpnRompehielos.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnRompehielos.setText("Rompehielos");
		txtpnRompehielos.setBounds(42, 511, 100, 25);
		frame.getContentPane().add(txtpnRompehielos);
		
	
		BufferedImage wpuntual = ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/puntual.png"));
		ImageIcon imagenPuntual = new ImageIcon(wpuntual);
		JLabel lblMinaPuntual = new JLabel();
		lblMinaPuntual.setIcon(new ImageIcon(imagenPuntual.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		lblMinaPuntual.setBounds(530, 207, 35, 30);
		frame.getContentPane().add(lblMinaPuntual);
		
		
		BufferedImage wdoble = ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/doble.png"));
		ImageIcon imagenDoble = new ImageIcon(wdoble);
		JLabel lblMinaDoble = new JLabel();
		lblMinaDoble.setIcon(new ImageIcon(imagenDoble.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		lblMinaDoble.setBounds(530, 247, 35, 30);
		frame.getContentPane().add(lblMinaDoble);
	
		
		BufferedImage wtriple = ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/triple.png"));
		ImageIcon imagenTriple = new ImageIcon(wtriple);
		JLabel lblMinaTriple = new JLabel();
		lblMinaTriple.setIcon(new ImageIcon(imagenTriple.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		lblMinaTriple.setBounds(530, 287, 35, 30);
		frame.getContentPane().add(lblMinaTriple);
		
		BufferedImage wcontacto = ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/contacto.png"));
		ImageIcon imagenContacto = new ImageIcon(wcontacto);
		JLabel lblMinaPorContacto = new JLabel();
		lblMinaPorContacto.setIcon(new ImageIcon(imagenContacto.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		lblMinaPorContacto.setBounds(530, 327, 35, 30);
		frame.getContentPane().add(lblMinaPorContacto);
		
		labelPuntaje = new JLabel("");
		labelPuntaje.setFont(new Font("Papyrus", Font.BOLD, 16));
		labelPuntaje.setBounds(455, 13, 112, 30);
		frame.getContentPane().add(labelPuntaje);
		
		labelTurno = new JLabel("");
		labelTurno.setFont(new Font("Papyrus", Font.BOLD, 16));
		labelTurno.setBounds(163, 52, 112, 30);
		frame.getContentPane().add(labelTurno);
		
				
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try {
					control.cargarBarcos();
					ArrayList<VistaNave> vistaNaves = control.getVistaNaves();
					for(VistaNave vista: vistaNaves){
						vista.dibujar(mat);
					}
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}

				ArrayList<VistaNave> vistaNaves = control.getVistaNaves();
				for(VistaNave vista: vistaNaves){
					vista.dibujar(mat);
				}

				String puntaje =Integer.toString(control.getPuntaje());
				labelPuntaje.setText(puntaje);
				String turno =Integer.toString(control.getTurno());
				labelTurno.setText(turno);
			
			}
		});
		btnIniciar.setBounds(42,16,233,25);
		frame.getContentPane().add(btnIniciar);
		

		
		
		JButton btnPasarTurno = new JButton("Pasar Turno");
		btnPasarTurno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){

				control.pasarTurno();
				try {
					limpiarTablero(mat);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ArrayList<VistaNave> vistaNaves = control.getVistaNaves();
				for(VistaNave vista: vistaNaves){
					vista.dibujar(mat);
				}
					
				ArrayList<VistaDisparo> vistaDisparos = control.getVistaDisparos();
				for(VistaDisparo vista: vistaDisparos){
					vista.dibujar(mat);
				}
				String puntaje =Integer.toString(control.getPuntaje());
				labelPuntaje.setText(puntaje);
				String turno =Integer.toString(control.getTurno());
				labelTurno.setText(turno);
			}
			
		});
		btnPasarTurno.setBounds(322,52,112,25);
		frame.getContentPane().add(btnPasarTurno);
		
		
		JLabel imagenLancha = new JLabel();
		BufferedImage wlancha = ImageIO.read(this.getClass().getResource("/Imagenes/Naves/lancha.jpg"));
		ImageIcon lancha = new ImageIcon(wlancha);
		imagenLancha.setIcon(new ImageIcon(lancha.getImage().getScaledInstance(79,29,Image.SCALE_SMOOTH)));
		imagenLancha.setBounds(112, 471, 79, 29);
		frame.getContentPane().add(imagenLancha);
		
		JLabel imagenBuque = new JLabel();
		BufferedImage wbuque = ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buque.jpg"));
		ImageIcon buque = new ImageIcon(wbuque);
		imagenBuque.setIcon(new ImageIcon(buque.getImage().getScaledInstance(149,29,Image.SCALE_SMOOTH)));
		imagenBuque.setBounds(280, 471, 149, 29);
		frame.getContentPane().add(imagenBuque);
		
		JLabel imagenDestructor = new JLabel();
		BufferedImage wdestruc = ImageIO.read(this.getClass().getResource("/Imagenes/Naves/DESTRUCTOR.PNG"));
		ImageIcon destructor = new ImageIcon(wdestruc);
		imagenDestructor.setIcon(new ImageIcon(destructor.getImage().getScaledInstance(112,29,Image.SCALE_SMOOTH)));
		imagenDestructor.setBounds(542, 471, 112, 29);
		frame.getContentPane().add(imagenDestructor);
		
		JLabel imagenRompehielos = new JLabel();
		BufferedImage wrompehielos = ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielos.jpg"));
		ImageIcon rompehielos = new ImageIcon(wrompehielos);
		imagenRompehielos.setIcon(new ImageIcon(rompehielos.getImage().getScaledInstance(112,29,Image.SCALE_SMOOTH)));
		imagenRompehielos.setBounds(149, 507, 112, 29);
		frame.getContentPane().add(imagenRompehielos);
		
		JLabel imagenPortaaviones = new JLabel();
		BufferedImage wportaaviones = ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaaviones.gif"));
		ImageIcon portaaviones = new ImageIcon(wportaaviones);
		imagenPortaaviones.setIcon(new ImageIcon(portaaviones.getImage().getScaledInstance(197,29,Image.SCALE_SMOOTH)));
		imagenPortaaviones.setBounds(423, 507, 197, 29);
		frame.getContentPane().add(imagenPortaaviones);
		
	}
	
	
	public void llenarArrayConLabels(JButtonID tablero[][]) throws IOException{
		for (int i=0 ; i<10 ; i++){
			for (int j=0 ; j<10 ; j++){	
				final JButtonID boton = new JButtonID(i,j);
				boton.setIcon(this.agua);
				
				boton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
					 
						control.disparar(boton.getFila(),boton.getColumna());
							
						try {
							limpiarTablero(mat);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						ArrayList<VistaNave> vistaNaves = control.getVistaNaves();
						for(VistaNave vista: vistaNaves){
							vista.dibujar(mat);
						}

						ArrayList<VistaDisparo> vistaDisparos = control.getVistaDisparos();
						for(VistaDisparo vista: vistaDisparos){
							vista.dibujar(mat);
						}
						String puntaje =Integer.toString(control.getPuntaje());
						labelPuntaje.setText(puntaje);
						String turno =Integer.toString(control.getTurno());
						labelTurno.setText(turno);
						
						rdbtnDisparoPuntual.setSelected(true);
						control.cambiarDisparoEnCurso(new DisparoConvencional());
						
					}
				});
				tablero[i][j] = boton;
				
				
			}
		}
	}

	public void agregarLabels(JButtonID tablero[][]){
		for (int i=0 ; i<10 ; i++){
			for (int j=0 ; j<10 ; j++){	
				panelTablero.add(tablero[i][j]);				
			}
		}
	}
	

	public void limpiarTablero(JButtonID tablero[][]) throws IOException{
		for (int i=0 ; i<10 ; i++){
			for (int j=0 ; j<10 ; j++){	
				tablero[i][j].setIcon(this.agua);
			}
		}
	}

}

