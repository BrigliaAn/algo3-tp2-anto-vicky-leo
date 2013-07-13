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
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
		rdbtnDisparoPuntual.setBounds(571, 167, 159, 23);
		rdbtnDisparoPuntual.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					control.cambiarDisparoEnCurso(new DisparoConvencional());
									}
			});
		frame.getContentPane().add(rdbtnDisparoPuntual);
		
		JRadioButton rdbtnMinaSubmarinaPuntual = new JRadioButton("Mina submarina Puntual");
		rdbtnMinaSubmarinaPuntual.setBounds(571, 207, 222, 23);
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
		rdbtnMinaSubmarinaDoble.setBounds(571, 247, 222, 23);
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
		rdbtnMinaSubmarinaTriple.setBounds(571, 287, 209, 23);
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
		rdbtnMinaSubmarinaPor.setBounds(571, 327, 262, 23);
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

		VistaReferenciasNaves refNaves = new VistaReferenciasNaves();
		refNaves.agregarReferencias(frame);
		VistaReferenciasMinas refMinas = new VistaReferenciasMinas();
		refMinas.agregarImagenesMinas(frame);
		
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
					limpiarTablero(mat);
					control.crearNuevoJuego();
					control.cargarBarcos();
					ArrayList<VistaNave> vistaNaves = control.getVistaNaves();
					for(VistaNave vista: vistaNaves){
						vista.dibujar(mat);
					}
				} catch (IOException e1) {
					
					e1.printStackTrace();
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
				
				
				if (control.juegoEstaTerminado()){
					
					try {
						limpiarTablero(mat);
					} catch (IOException e) {
						e.printStackTrace();
					}
					;

					FinJuego finJuego = new FinJuego();
					finJuego.setResizable(true);
					finJuego.recibirPuntaje(Integer.toString(control.getPuntaje()));
					finJuego.setVisible(true);
						
				}
			}
			
			
		});
		btnPasarTurno.setBounds(322,52,139,25);
		frame.getContentPane().add(btnPasarTurno);
		
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					limpiarTablero(mat);
					control.crearNuevoJuego();
					control.cargarBarcos();
					ArrayList<VistaNave> vistaNaves = control.getVistaNaves();
					for(VistaNave vista: vistaNaves){
						vista.dibujar(mat);
					}
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			
				String puntaje =Integer.toString(control.getPuntaje());
				labelPuntaje.setText(puntaje);
				String turno =Integer.toString(control.getTurno());
				labelTurno.setText(turno);
			}
		});
		btnReiniciar.setBounds(518, 54, 112, 23);
		frame.getContentPane().add(btnReiniciar);
		
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
						
						if (control.juegoEstaTerminado()){
						
							try {
								limpiarTablero(mat);
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							FinJuego finJuego = new FinJuego();
							finJuego.setResizable(true);
							finJuego.recibirPuntaje(Integer.toString(control.getPuntaje()));
							finJuego.setVisible(true);
								
						}
						
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

