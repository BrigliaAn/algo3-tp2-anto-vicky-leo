package fiuba.navalgo.view;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Color;
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
import javax.swing.JScrollPane;

import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.navalgo.control.ControlJuego;
import fiuba.navalgo.model.Juego;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.naves.*;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.Icon;


public class VentanaPrincipal extends JFrame {
	private JFrame frame;
	private JTable table;
	private ControlJuego control;
	
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
		

		
		JButton btnPasarTurno = new JButton("Pasar Turno");
		btnPasarTurno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		btnPasarTurno.setBounds(322,52,112,25);
		frame.getContentPane().add(btnPasarTurno);
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(42, 114, 457, 350);
		table.setRowHeight(35);
		frame.getContentPane().add(table);
		
		JRadioButton rdbtnDisparoPuntual = new JRadioButton("Disparo directo");
		rdbtnDisparoPuntual.setBounds(571, 167, 135, 23);
		frame.getContentPane().add(rdbtnDisparoPuntual);
		
		JRadioButton rdbtnMinaSubmarinaPuntual = new JRadioButton("Mina submarina Puntual");
		rdbtnMinaSubmarinaPuntual.setBounds(571, 207, 173, 23);
		frame.getContentPane().add(rdbtnMinaSubmarinaPuntual);
		
		JRadioButton rdbtnMinaSubmarinaDoble = new JRadioButton("Mina submarina Doble");
		rdbtnMinaSubmarinaDoble.setBounds(571, 247, 173, 23);
		frame.getContentPane().add(rdbtnMinaSubmarinaDoble);
		
		JRadioButton rdbtnMinaSubmarinaTriple = new JRadioButton("Mina submarina Triple");
		rdbtnMinaSubmarinaTriple.setBounds(571, 287, 173, 23);
		frame.getContentPane().add(rdbtnMinaSubmarinaTriple);
		
		JRadioButton rdbtnMinaSubmarinaPor = new JRadioButton("Mina submarina por contacto");
		rdbtnMinaSubmarinaPor.setBounds(571, 327, 222, 23);
		frame.getContentPane().add(rdbtnMinaSubmarinaPor);
		
		ButtonGroup grupoDisparos = new ButtonGroup();
		grupoDisparos.add(rdbtnDisparoPuntual);
		grupoDisparos.add(rdbtnMinaSubmarinaPuntual);
		grupoDisparos.add(rdbtnMinaSubmarinaDoble);
		grupoDisparos.add(rdbtnMinaSubmarinaTriple);
		grupoDisparos.add(rdbtnMinaSubmarinaPor);

		
		JTextPane txtpnTurno = new JTextPane();
		txtpnTurno.setFont(new Font("Papyrus", Font.BOLD, 15));
		txtpnTurno.setText("TURNO:");
		txtpnTurno.setBounds(42, 52, 96, 25);
		frame.getContentPane().add(txtpnTurno);
		
		JTextPane txtpnPuntaje = new JTextPane();
		txtpnPuntaje.setText("PUNTAJE:");
		txtpnPuntaje.setFont(new Font("Papyrus", Font.BOLD, 15));
		txtpnPuntaje.setBounds(322, 16, 112, 25);
		frame.getContentPane().add(txtpnPuntaje);
		
		JTextPane txtpnLancha = new JTextPane();
		txtpnLancha.setBackground(Color.MAGENTA);
		txtpnLancha.setForeground(Color.BLACK);
		txtpnLancha.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnLancha.setText("Lancha");
		txtpnLancha.setBounds(44, 475, 58, 25);
		frame.getContentPane().add(txtpnLancha);
		
		JTextPane txtpnBuque = new JTextPane();
		txtpnBuque.setBackground(Color.GREEN);
		txtpnBuque.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnBuque.setText("Buque");
		txtpnBuque.setBounds(112, 475, 58, 25);
		frame.getContentPane().add(txtpnBuque);
		
		JTextPane txtpnDestructores = new JTextPane();
		txtpnDestructores.setBackground(Color.CYAN);
		txtpnDestructores.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnDestructores.setText("Destructores");
		txtpnDestructores.setBounds(179, 475, 96, 25);
		frame.getContentPane().add(txtpnDestructores);
		
		JTextPane txtpnPortaaviones = new JTextPane();
		txtpnPortaaviones.setBackground(Color.YELLOW);
		txtpnPortaaviones.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnPortaaviones.setText("Portaaviones");
		txtpnPortaaviones.setBounds(285, 475, 99, 25);
		frame.getContentPane().add(txtpnPortaaviones);
		
		JTextPane txtpnRompehielos = new JTextPane();
		txtpnRompehielos.setBackground(Color.RED);
		txtpnRompehielos.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnRompehielos.setText("Rompehielos");
		txtpnRompehielos.setBounds(42, 511, 100, 25);
		frame.getContentPane().add(txtpnRompehielos);
		
	
		BufferedImage wpuntual = ImageIO.read(this.getClass().getResource("/Imagenes/puntual.png"));
		ImageIcon imagenPuntual = new ImageIcon(wpuntual);
		JLabel lblMinaPuntual = new JLabel();
		lblMinaPuntual.setIcon(new ImageIcon(imagenPuntual.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		lblMinaPuntual.setBounds(530, 207, 35, 30);
		frame.getContentPane().add(lblMinaPuntual);
		
		
		BufferedImage wdoble = ImageIO.read(this.getClass().getResource("/Imagenes/doble.png"));
		ImageIcon imagenDoble = new ImageIcon(wdoble);
		JLabel lblMinaDoble = new JLabel();
		lblMinaDoble.setIcon(new ImageIcon(imagenDoble.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		lblMinaDoble.setBounds(530, 247, 35, 30);
		frame.getContentPane().add(lblMinaDoble);
	
		
		BufferedImage wtriple = ImageIO.read(this.getClass().getResource("/Imagenes/triple.png"));
		ImageIcon imagenTriple = new ImageIcon(wtriple);
		JLabel lblMinaTriple = new JLabel();
		lblMinaTriple.setIcon(new ImageIcon(imagenTriple.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		lblMinaTriple.setBounds(530, 287, 35, 30);
		frame.getContentPane().add(lblMinaTriple);
		
		BufferedImage wcontacto = ImageIO.read(this.getClass().getResource("/Imagenes/contacto.png"));
		ImageIcon imagenContacto = new ImageIcon(wcontacto);
		JLabel lblMinaPorContacto = new JLabel();
		lblMinaPorContacto.setIcon(new ImageIcon(imagenContacto.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		lblMinaPorContacto.setBounds(530, 327, 35, 30);
		frame.getContentPane().add(lblMinaPorContacto);
		
		final JLabel labelPuntaje = new JLabel("");
		labelPuntaje.setFont(new Font("Papyrus", Font.BOLD, 16));
		labelPuntaje.setBounds(455, 13, 112, 30);
		frame.getContentPane().add(labelPuntaje);
		
		final JLabel labelTurno = new JLabel("");
		labelTurno.setFont(new Font("Papyrus", Font.BOLD, 16));
		labelTurno.setBounds(163, 52, 112, 30);
		frame.getContentPane().add(labelTurno);
		

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				control.cargarBarcos();
				ArrayList<PorcionDeNave> porciones;
				Tablero tablero = Tablero.getInstance();
				ArrayList<Nave> listaNaves = control.getNaves();
				TableCellRenderer renderer = new RenderCelda();
				for(Nave unaNave: listaNaves){
					porciones = unaNave.getPorcionesDeNave();
					for(PorcionDeNave porcion: porciones){
						 if( unaNave instanceof Lancha )
					        {
							
					        }
					        if( unaNave instanceof Buque )
					        {
					            
					              
					        }
					        if( unaNave instanceof Destructor )
					        {
					            
					        }
					        if( unaNave instanceof PortaAviones )
					        {
					            
					              
					        }
					        if(  unaNave instanceof RompeHielos)
					        {
					           
					              
					        }
						/*if(porcion.estaDestruida()){
							
							
							
							//renderer.getTableCellRendererComponent(table, porcion,true, false,porcion.getY(), porcion.getX());
							//table.setDefaultRenderer(Object.class, renderer);
							
						}else{
							//renderer.getTableCellRendererComponent(table,unaNave,true, false,porcion.getY(), porcion.getX());
							//table.setDefaultRenderer(Object.class, renderer);
							//table.getColumnModel().getColumn(porcion.getX()).setCellRenderer(renderer);
						}*/
					}
				String puntaje =Integer.toString(control.getPuntaje());
				labelPuntaje.setText(puntaje);
				String turno =Integer.toString(control.getTurno());
				labelTurno.setText(turno);
				
				}	
				
			
			}
		});
		btnIniciar.setBounds(42,16,233,25);
		frame.getContentPane().add(btnIniciar);
		
		
		
	}
}
