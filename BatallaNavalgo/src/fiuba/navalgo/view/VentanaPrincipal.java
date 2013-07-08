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
import fiuba.navalgo.model.direccion.Vertical;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.naves.*;
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
				control.cambiarDisparoEnCurso(new MinaSubmarinaPuntual());
			}
		});
		frame.getContentPane().add(rdbtnMinaSubmarinaPuntual);
		
		JRadioButton rdbtnMinaSubmarinaDoble = new JRadioButton("Mina submarina Doble");
		rdbtnMinaSubmarinaDoble.setBounds(571, 247, 173, 23);
		rdbtnMinaSubmarinaDoble.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				control.cambiarDisparoEnCurso(new MinaSubmarinaDoble());
			}
		});
		frame.getContentPane().add(rdbtnMinaSubmarinaDoble);
		
		JRadioButton rdbtnMinaSubmarinaTriple = new JRadioButton("Mina submarina Triple");
		rdbtnMinaSubmarinaTriple.setBounds(571, 287, 173, 23);
		rdbtnMinaSubmarinaTriple.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				control.cambiarDisparoEnCurso(new MinaSubmarinaTriple());
			}
		});
		frame.getContentPane().add(rdbtnMinaSubmarinaTriple);
		
		JRadioButton rdbtnMinaSubmarinaPor = new JRadioButton("Mina submarina por contacto");
		rdbtnMinaSubmarinaPor.setBounds(571, 327, 222, 23);
		rdbtnMinaSubmarinaPor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				control.cambiarDisparoEnCurso(new MinaSubmarinaPorContacto());
			}
		});
		frame.getContentPane().add(rdbtnMinaSubmarinaPor);
		
		ButtonGroup grupoDisparos = new ButtonGroup();
		grupoDisparos.add(rdbtnDisparoPuntual);
		grupoDisparos.add(rdbtnMinaSubmarinaPuntual);
		grupoDisparos.add(rdbtnMinaSubmarinaDoble);
		grupoDisparos.add(rdbtnMinaSubmarinaTriple);
		grupoDisparos.add(rdbtnMinaSubmarinaPor);
		
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
				control.cargarBarcos();
				ArrayList<Nave> listaNaves = control.getNaves();
				MostrarNaves tipoDeNave = new MostrarNaves();
				for(Nave unaNave: listaNaves){
					try {
						tipoDeNave.mostrarNaves(mat,unaNave);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
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
				LimpiarTablero tableroLimpio = new LimpiarTablero();
				try {
					tableroLimpio.limpiarTablero(mat);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ArrayList<Nave> listaNaves = control.getNaves();
				MostrarNaves tipoDeNave = new MostrarNaves();
				for(Nave unaNave: listaNaves){
					try {
						tipoDeNave.mostrarNaves(mat,unaNave);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}	
				ArrayList<Disparo> disparos = control.getDisparos();
				for(Disparo disparo: disparos){
					disparo.mostrarDisparos(mat,disparo);
				}
				String puntaje =Integer.toString(control.getPuntaje());
				labelPuntaje.setText(puntaje);
				String turno =Integer.toString(control.getTurno());
				labelTurno.setText(turno);
			}
			
		});
		btnPasarTurno.setBounds(322,52,112,25);
		frame.getContentPane().add(btnPasarTurno);
		

		  	JButton btnFinalizarJuego = new JButton("Finalizar Juego");
	     	btnFinalizarJuego.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent arg0){
					control = new ControlJuego();
					LimpiarTablero tableroLimpio = new LimpiarTablero();
						try{
							tableroLimpio.limpiarTablero(mat);
						}catch(IOException e){
							e.printStackTrace();
						}
						labelPuntaje.setText("");
					labelTurno.setText("");
					}
				});
				btnFinalizarJuego.setBounds(480,52,200,25);
				frame.getContentPane().add(btnFinalizarJuego);
				
				MostrarMinas mostrarMinas = new MostrarMinas();
				mostrarMinas.MostrarEjemploDeTodasLasMinas(frame);
				
				MostrarNaves mostrarNaves = new MostrarNaves();
				mostrarNaves.mostrarEjemploDeTodasLasNaves(frame);
	}
	
	
	public void llenarArrayConLabels(JButtonID tablero[][]) throws IOException{
		for (int i=0 ; i<10 ; i++){
			for (int j=0 ; j<10 ; j++){	
				final JButtonID boton = new JButtonID(i,j);
				BufferedImage wagua= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/AGUA.png"));
				ImageIcon agua = new ImageIcon(wagua);
				boton.setIcon(new ImageIcon(agua.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				boton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
					 
						control.disparar(boton.getFila(),boton.getColumna());
						LimpiarTablero tableroLimpio = new LimpiarTablero();
						ArrayList<Nave> listaNaves = control.getNaves();
						try {
							tableroLimpio.limpiarTablero(mat);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						MostrarNaves tipoDeNave = new MostrarNaves();
						for(Nave unaNave: listaNaves){
							try {
								tipoDeNave.mostrarNaves(mat,unaNave);
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}	
						ArrayList<Disparo> disparos = control.getDisparos();
						for(Disparo disparo: disparos){
							disparo.mostrarDisparos(mat,disparo);
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

}
