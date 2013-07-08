package fiuba.navalgo.view.disparos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.navalgo.model.disparos.Disparo;
import fiuba.navalgo.view.JButtonID;
import fiuba.navalgo.view.naves.VistaNave;

public abstract class VistaDisparo {
	
	protected ImageIcon imagen;
	protected Disparo disparo;
	
	public VistaDisparo(Disparo disparo, String rutaImagen) throws IOException{
		BufferedImage bimage = ImageIO.read(VistaNave.class.getResource(rutaImagen));
		this.imagen = new ImageIcon(bimage);
		this.disparo = disparo;
	}
	
	public void dibujar(JButtonID tablero[][]){
		int columna = this.disparo.devolverCasillaPrincipal().getPosicion().getColumna();
		int fila = this.disparo.devolverCasillaPrincipal().getPosicion().getFila();
		tablero[fila][columna].setIcon(new ImageIcon(this.imagen.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
		}

}
