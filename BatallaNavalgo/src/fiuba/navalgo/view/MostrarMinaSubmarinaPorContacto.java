package fiuba.navalgo.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.navalgo.model.disparos.Disparo;

public class MostrarMinaSubmarinaPorContacto {

	public void mostrardisparo(JButtonID[][] mat, Disparo disparo) throws IOException {
		int columna = disparo.devolverCasillaPrincipal().getPosicion().getColumna();
		int fila = disparo.devolverCasillaPrincipal().getPosicion().getFila();
		BufferedImage wcontacto= ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/contacto.png"));
		ImageIcon contacto = new ImageIcon(wcontacto);
		mat[fila][columna].setIcon(new ImageIcon(contacto.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		
	}

}
