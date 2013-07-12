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
	
	protected ImageIcon imagenDisparo;
	protected ImageIcon imagenExplotado;
	protected Disparo disparo;
	private String rutaImagenExplotado = "/Imagenes/Naves/explosion.png";
	
	public VistaDisparo(Disparo disparo, String rutaImagen) throws IOException{
		BufferedImage bimage = ImageIO.read(VistaNave.class.getResource(rutaImagen));
		BufferedImage image = ImageIO.read(VistaNave.class.getResource(rutaImagenExplotado));
		this.imagenDisparo = new ImageIcon(bimage);
		this.imagenExplotado = new ImageIcon(image);
		this.disparo = disparo;
	}
	
	public void dibujar(JButtonID tablero[][]){
		int columna = this.disparo.devolverCasillaPrincipal().getPosicion().getColumna();
		int fila = this.disparo.devolverCasillaPrincipal().getPosicion().getFila();
		if (disparo.haExplotado()){
			tablero[fila][columna].setIcon(new ImageIcon(this.imagenExplotado.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		}else{
			tablero[fila][columna].setIcon(new ImageIcon(this.imagenDisparo.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		}
	}
}
