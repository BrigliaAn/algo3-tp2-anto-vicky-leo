package fiuba.navalgo.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.navalgo.model.disparos.Disparo;

public class MostrarMinaSubmarinaTriple {

	public void mostrardisparo(JButtonID[][] mat, Disparo disparo) throws IOException {

		int columna = disparo.devolverCasillaPrincipal().getPosicion().getColumna();
		int fila = disparo.devolverCasillaPrincipal().getPosicion().getFila();
		BufferedImage wtriple= ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/triple.png"));
		ImageIcon triple = new ImageIcon(wtriple);
		mat[fila][columna].setIcon(new ImageIcon(triple.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
	}

}
