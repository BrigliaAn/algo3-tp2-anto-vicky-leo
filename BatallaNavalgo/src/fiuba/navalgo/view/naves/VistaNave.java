package fiuba.navalgo.view.naves;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


import fiuba.navalgo.model.naves.Nave;
import fiuba.navalgo.view.JButtonID;

public abstract class VistaNave {
	
	protected Nave nave;
	protected ImageIcon destruccion;
	private String rutaImagenDestruccion = "/Imagenes/Naves/explosion.png";

	public VistaNave(Nave nave) throws IOException{	
		this.nave = nave;
		BufferedImage bimage = ImageIO.read(VistaNave.class.getResource(rutaImagenDestruccion));
		this.destruccion = new ImageIcon(bimage);
	}
	
	public abstract void dibujar(JButtonID tablero[][]);

	public boolean destruida() {
		return this.nave.estaDestruido();
	}

}
