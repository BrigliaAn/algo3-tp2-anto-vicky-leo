package fiuba.navalgo.view.naves;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.navalgo.model.naves.Nave;
import fiuba.navalgo.model.naves.PorcionDeNave;
import fiuba.navalgo.view.JButtonID;

public class VistaLancha extends VistaNave {

	private String rutaImagenParte1 = "/Imagenes/Naves/lanchaParte1.png";
	private String rutaImagenParte2 = "/Imagenes/Naves/lanchaParte2.png";
	private ImageIcon imagenParte1;
	private ImageIcon imagenParte2;

	
	public VistaLancha(Nave lancha) throws IOException{
		super(lancha);
		BufferedImage parte1 = ImageIO.read(VistaNave.class.getResource(rutaImagenParte1));
		BufferedImage parte2 = ImageIO.read(VistaNave.class.getResource(rutaImagenParte2));
		this.imagenParte1 = new ImageIcon(parte1);
		this.imagenParte2 = new ImageIcon(parte2);
	}


	@Override
	public void dibujar(JButtonID[][] tablero) {
		ArrayList<PorcionDeNave> porciones = this.nave.getPorcionesDeNave();
		int columna = porciones.get(0).getX();
		int fila = porciones.get(0).getY();
		if(porciones.get(0).estaDestruida()){
			tablero[fila][columna].setIcon(new ImageIcon(this.destruccion.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		}else{
			tablero[fila][columna].setIcon(new ImageIcon(this.imagenParte1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		}
		
		columna = porciones.get(1).getX();
		fila = porciones.get(1).getY();
		if(porciones.get(1).estaDestruida()){
			tablero[fila][columna].setIcon(new ImageIcon(this.destruccion.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		}else{
			tablero[fila][columna].setIcon(new ImageIcon(this.imagenParte2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		}
   		
	}

}
