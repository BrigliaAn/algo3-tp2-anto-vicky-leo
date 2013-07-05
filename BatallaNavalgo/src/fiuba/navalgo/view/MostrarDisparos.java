package fiuba.navalgo.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.navalgo.model.disparos.Disparo;
import fiuba.navalgo.model.disparos.MinaSubmarinaDoble;
import fiuba.navalgo.model.disparos.MinaSubmarinaPorContacto;
import fiuba.navalgo.model.disparos.MinaSubmarinaPuntual;
import fiuba.navalgo.model.disparos.MinaSubmarinaTriple;

public class MostrarDisparos {
	
public void mostrarDisparos(JButtonID tablero[][],Disparo disparo) throws IOException{
		
		int columna = disparo.devolverCasillaPrincipal().getPosicion().getColumna();
		int fila = disparo.devolverCasillaPrincipal().getPosicion().getFila();
			
		if(disparo instanceof MinaSubmarinaPuntual){		
			BufferedImage wpuntual= ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/puntual.png"));
			ImageIcon puntual = new ImageIcon(wpuntual);
			tablero[fila][columna].setIcon(new ImageIcon(puntual.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
		}
		if(disparo instanceof MinaSubmarinaDoble){
			BufferedImage wdoble= ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/doble.png"));
			ImageIcon doble = new ImageIcon(wdoble);
			tablero[fila][columna].setIcon(new ImageIcon(doble.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
		}
		
		if(disparo instanceof MinaSubmarinaTriple){
			BufferedImage wtriple= ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/triple.png"));
			ImageIcon triple = new ImageIcon(wtriple);
			tablero[fila][columna].setIcon(new ImageIcon(triple.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
		}
		if(disparo instanceof MinaSubmarinaPorContacto){
			BufferedImage wcontacto= ImageIO.read(this.getClass().getResource("/Imagenes/MinasSubmarinas/contacto.png"));
			ImageIcon contacto = new ImageIcon(wcontacto);
			tablero[fila][columna].setIcon(new ImageIcon(contacto.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
		}
	}
}
