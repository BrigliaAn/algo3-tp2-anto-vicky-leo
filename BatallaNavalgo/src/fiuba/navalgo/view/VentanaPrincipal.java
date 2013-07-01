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
				control.cargarBarcos();
				ArrayList<Nave> listaNaves = control.getNaves();
				
				for(Nave unaNave: listaNaves){
					try {
						mostrarNaves(mat,unaNave);
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
				try {
					limpiarTablero(mat);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ArrayList<Nave> listaNaves = control.getNaves();
				for(Nave unaNave: listaNaves){
					try {
						mostrarNaves(mat,unaNave);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}	
				ArrayList<Disparo> disparos = control.getDisparos();
				for(Disparo disparo: disparos){
					try {
						mostrarDisparos(mat,disparo);
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
				BufferedImage wagua= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/AGUA.png"));
				ImageIcon agua = new ImageIcon(wagua);
				boton.setIcon(new ImageIcon(agua.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				boton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
					 
						control.disparar(boton.getFila(),boton.getColumna());
						ArrayList<Nave> listaNaves = control.getNaves();
						try {
							limpiarTablero(mat);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						for(Nave unaNave: listaNaves){
							try {
								mostrarNaves(mat,unaNave);
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}	
						ArrayList<Disparo> disparos = control.getDisparos();
						for(Disparo disparo: disparos){
							try {
								mostrarDisparos(mat,disparo);
							} catch (IOException e) {
								e.printStackTrace();
							}
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
	
	public void mostrarNaves(JButtonID tablero[][],Nave nave) throws IOException{
		ArrayList<PorcionDeNave> porciones = nave.getPorcionesDeNave();
	
			if( nave instanceof Lancha ){
							
				int columna = porciones.get(0).getX();
				int fila = porciones.get(0).getY();
				BufferedImage wL1;
				if(porciones.get(0).estaDestruida()){
					wL1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wL1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/lanchaParte2Vertical.png"));
					}else{
						wL1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/lanchaParte1.png"));
					}
				}
				ImageIcon L1 = new ImageIcon(wL1);
				tablero[fila][columna].setIcon(new ImageIcon(L1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
				int columna2 = porciones.get(1).getX();
				int fila2 = porciones.get(1).getY();
				BufferedImage wL2;
				if(porciones.get(1).estaDestruida()){
					wL2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wL2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/lanchaParte1Vertical.png"));
					}else{
						wL2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/lanchaParte2.png"));
					}
				}
				ImageIcon L2 = new ImageIcon(wL2);
				tablero[fila2][columna2].setIcon(new ImageIcon(L2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
		    }
		    if( nave instanceof Buque ){
		    	
		    	int columna = porciones.get(0).getX();
				int fila = porciones.get(0).getY();
				BufferedImage wB1;
				if(porciones.get(0).estaDestruida()){
					wB1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wB1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte4Vertical.png"));
					}else{
						wB1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte1.png"));
					}
				}
				ImageIcon B1 = new ImageIcon(wB1);
				tablero[fila][columna].setIcon(new ImageIcon(B1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
				int columna2 = porciones.get(1).getX();
				int fila2 = porciones.get(1).getY();
				BufferedImage wB2;
				if(porciones.get(1).estaDestruida()){
					wB2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wB2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte3Vertical.png"));
					}else{
					wB2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte2.png"));
					}
				}
				ImageIcon B2 = new ImageIcon(wB2);
				tablero[fila2][columna2].setIcon(new ImageIcon(B2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				   
				int columna3 = porciones.get(2).getX();
				int fila3 = porciones.get(2).getY();
				BufferedImage wB3;
				if(porciones.get(2).estaDestruida()){
					wB3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wB3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte2Vertical.png"));
					}else{
						wB3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte3.png"));
					}
				}
				ImageIcon B3 = new ImageIcon(wB3);
				tablero[fila3][columna3].setIcon(new ImageIcon(B3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
				int columna4 = porciones.get(3).getX();
				int fila4 = porciones.get(3).getY();
				BufferedImage wB4;
				if(porciones.get(3).estaDestruida()){
					wB4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wB4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte1Vertical.png"));
					}else{
						wB4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte4.png"));
					}
				}
				ImageIcon B4 = new ImageIcon(wB4);
				tablero[fila4][columna4].setIcon(new ImageIcon(B4.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				         
		    }
		    if( nave instanceof Destructor ){
		    	int columna = porciones.get(0).getX();
				int fila = porciones.get(0).getY();
				BufferedImage wD1;
				if(porciones.get(0).estaDestruida()){
					wD1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wD1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte3Vertical.png"));
					}else{
						wD1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte1.png"));
					}
				}
				ImageIcon D1 = new ImageIcon(wD1);
				tablero[fila][columna].setIcon(new ImageIcon(D1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
				int columna2 = porciones.get(1).getX();
				int fila2 = porciones.get(1).getY();
				BufferedImage wD2;
				if(porciones.get(1).estaDestruida()){
					wD2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wD2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte2Vertical.png"));
					}else{
						wD2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte2.png"));
					}
				}
				ImageIcon D2 = new ImageIcon(wD2);
				tablero[fila2][columna2].setIcon(new ImageIcon(D2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				   
				int columna3 = porciones.get(2).getX();
				int fila3 = porciones.get(2).getY();
				BufferedImage wD3;
				if(porciones.get(2).estaDestruida()){
					wD3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wD3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte1Vertical.png"));
					}else{
						wD3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte3.png"));
					}
				}
				ImageIcon D3 = new ImageIcon(wD3);
				tablero[fila3][columna3].setIcon(new ImageIcon(D3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
		            
		    }
		    if( nave instanceof PortaAviones){
		    	int columna = porciones.get(0).getX();
				int fila = porciones.get(0).getY();
				BufferedImage wPA1;
				if(porciones.get(0).estaDestruida()){
					wPA1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wPA1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte5Vertical.png"));
					}else{
						wPA1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte1.png"));
					}
				}
				ImageIcon PA1 = new ImageIcon(wPA1);
				tablero[fila][columna].setIcon(new ImageIcon(PA1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
				int columna2 = porciones.get(1).getX();
				int fila2 = porciones.get(1).getY();
				BufferedImage wPA2;
				if(porciones.get(1).estaDestruida()){
					wPA2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wPA2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte4Vertical.png"));
					}else{
						wPA2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte2.png"));
					}
				}	
				ImageIcon PA2 = new ImageIcon(wPA2);
				tablero[fila2][columna2].setIcon(new ImageIcon(PA2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				   
				int columna3 = porciones.get(2).getX();
				int fila3 = porciones.get(2).getY();
				BufferedImage wPA3;
				if(porciones.get(2).estaDestruida()){
					wPA3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wPA3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte3Vertical.png"));
					}else{
						wPA3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte3.png"));
					}
				}
				ImageIcon PA3 = new ImageIcon(wPA3);
				tablero[fila3][columna3].setIcon(new ImageIcon(PA3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
				int columna4 = porciones.get(3).getX();
				int fila4 = porciones.get(3).getY();
				BufferedImage wPA4;
				if(porciones.get(3).estaDestruida()){
					wPA4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wPA4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte2Vertical.png"));
					}else{
						wPA4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte4.png"));
					}
				}
				ImageIcon PA4 = new ImageIcon(wPA4);
				tablero[fila4][columna4].setIcon(new ImageIcon(PA4.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				      
				int columna5 = porciones.get(4).getX();
				int fila5 = porciones.get(4).getY();
				BufferedImage wPA5;
				if(porciones.get(4).estaDestruida()){
					wPA5= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wPA5= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte5Vertical.png"));
					}else{
						wPA5= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte1.png"));
					}
				}
				ImageIcon PA5 = new ImageIcon(wPA5);
				tablero[fila5][columna5].setIcon(new ImageIcon(PA5.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				           
		    }
		    if( nave instanceof RompeHielos){
		           
		    	int columna = porciones.get(0).getX();
				int fila = porciones.get(0).getY();
				BufferedImage wRH1;
				if(porciones.get(0).estaDestruida()){
					wRH1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wRH1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte3Vertical.png"));
					}else{
						wRH1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte1.png"));
					}
				}
				ImageIcon RH1 = new ImageIcon(wRH1);
				tablero[fila][columna].setIcon(new ImageIcon(RH1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
				int columna2 = porciones.get(1).getX();
				int fila2 = porciones.get(1).getY();
				BufferedImage wRH2;
				if(porciones.get(1).estaDestruida()){
					wRH2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wRH2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte2Vertical.png"));
					}else{
						wRH2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte2.png"));
					}
				}
				ImageIcon RH2 = new ImageIcon(wRH2);
				tablero[fila2][columna2].setIcon(new ImageIcon(RH2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				   
				int columna3 = porciones.get(2).getX();
				int fila3 = porciones.get(2).getY();
				BufferedImage wRH3;
				if(porciones.get(2).estaDestruida()){
					wRH3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wRH3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte1Vertical.png"));
					}else{
						wRH3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte3.png"));
					}
				}
				ImageIcon RH3 = new ImageIcon(wRH3);
				tablero[fila3][columna3].setIcon(new ImageIcon(RH3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				      
		    }
	
		
	}
	
	public void mostrarDisparos(JButtonID tablero[][],Disparo disparo) throws IOException{
		
		if(disparo instanceof MinaSubmarinaPuntual){
			int columna = disparo.devolverCasillaPrincipal().getPosicion().getColumna();
			int fila = disparo.devolverCasillaPrincipal().getPosicion().getFila();
			BufferedImage wpuntual= ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/puntual.png"));
			ImageIcon puntual = new ImageIcon(wpuntual);
			tablero[fila][columna].setIcon(new ImageIcon(puntual.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
		}
		if(disparo instanceof MinaSubmarinaDoble){
			int columna = disparo.devolverCasillaPrincipal().getPosicion().getColumna();
			int fila = disparo.devolverCasillaPrincipal().getPosicion().getFila();
			BufferedImage wdoble= ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/doble.png"));
			ImageIcon doble = new ImageIcon(wdoble);
			tablero[fila][columna].setIcon(new ImageIcon(doble.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
		}
		
		if(disparo instanceof MinaSubmarinaTriple){
			int columna = disparo.devolverCasillaPrincipal().getPosicion().getColumna();
			int fila = disparo.devolverCasillaPrincipal().getPosicion().getFila();
			BufferedImage wtriple= ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/triple.png"));
			ImageIcon triple = new ImageIcon(wtriple);
			tablero[fila][columna].setIcon(new ImageIcon(triple.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
		}
		if(disparo instanceof MinaSubmarinaPorContacto){
			int columna = disparo.devolverCasillaPrincipal().getPosicion().getColumna();
			int fila = disparo.devolverCasillaPrincipal().getPosicion().getFila();
			BufferedImage wcontacto= ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/contacto.png"));
			ImageIcon contacto = new ImageIcon(wcontacto);
			tablero[fila][columna].setIcon(new ImageIcon(contacto.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
		}
		
	}

	public void limpiarTablero(JButtonID tablero[][]) throws IOException{
		for (int i=0 ; i<10 ; i++){
			for (int j=0 ; j<10 ; j++){	
				BufferedImage wagua= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/AGUA.png"));
				ImageIcon agua = new ImageIcon(wagua);
				tablero[i][j].setIcon(new ImageIcon(agua.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
	
			}
		}
	}

}
