package fiuba.navalgo.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VistaReferenciasMinas {

	
	public void agregarImagenesMinas(JFrame frame) throws IOException{
		

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
		
	}
}
