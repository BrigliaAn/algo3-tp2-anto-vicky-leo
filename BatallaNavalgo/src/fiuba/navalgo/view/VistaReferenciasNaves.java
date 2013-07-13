package fiuba.navalgo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VistaReferenciasNaves {

	
	public void agregarReferencias(JFrame frame) throws IOException{

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
		txtpnDestructores.setBounds(439, 475, 130, 25);
		frame.getContentPane().add(txtpnDestructores);
		
		JLabel txtpnPortaaviones = new JLabel();
		txtpnPortaaviones.setBackground(Color.YELLOW);
		txtpnPortaaviones.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnPortaaviones.setText("Portaaviones");
		txtpnPortaaviones.setBounds(303, 511, 130, 25);
		frame.getContentPane().add(txtpnPortaaviones);
		
		JLabel txtpnRompehielos = new JLabel();
		txtpnRompehielos.setBackground(Color.RED);
		txtpnRompehielos.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		txtpnRompehielos.setText("Rompehielos");
		txtpnRompehielos.setBounds(42, 511, 100, 25);
		frame.getContentPane().add(txtpnRompehielos);
		
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
		imagenDestructor.setBounds(560, 471, 112, 29);
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
		imagenPortaaviones.setBounds(430, 507, 197, 29);
		frame.getContentPane().add(imagenPortaaviones);
	}

}
