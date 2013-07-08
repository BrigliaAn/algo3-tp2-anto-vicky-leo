package fiuba.navalgo.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LimpiarTablero {
	
	public void limpiarTablero(JButtonID tablero[][]) throws IOException{
		BufferedImage wagua= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/AGUA.png"));
		ImageIcon agua = new ImageIcon(wagua);
		for (int i=0 ; i<10 ; i++){
			for (int j=0 ; j<10 ; j++){	
				tablero[i][j].setIcon(new ImageIcon(agua.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
	
			}
		}
	}
}
