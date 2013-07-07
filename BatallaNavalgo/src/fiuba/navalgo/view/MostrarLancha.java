package fiuba.navalgo.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.navalgo.model.direccion.Vertical;
import fiuba.navalgo.model.naves.Nave;
import fiuba.navalgo.model.naves.PorcionDeNave;

public class MostrarLancha {

	public void mostrarNave(JButtonID[][] tablero, Nave nave) throws IOException {
		ArrayList<PorcionDeNave> porciones = nave.getPorcionesDeNave();
		int columna = porciones.get(0).getX();
		int fila = porciones.get(0).getY();
			BufferedImage wL1;
			if(porciones.get(0).estaDestruida()){
				wL1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
			}else{
				if (nave.getDireccion() instanceof Vertical){
					wL1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/lanchaParte2Vertical.png"));
				}else{
					wL1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/lanchaParte1.png"));
				}
			}
			ImageIcon L1 = new ImageIcon(wL1);
			tablero[fila][columna].setIcon(new ImageIcon(L1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				
			int columna2 = porciones.get(1).getX();
			int fila2 = porciones.get(1).getY();
			BufferedImage wL2;
			if(porciones.get(1).estaDestruida()){
				wL2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
			}else{
				if (nave.getDireccion() instanceof Vertical){
					wL2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/lanchaParte1Vertical.png"));
				}else{
					wL2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/lanchaParte2.png"));
				}
			}
			ImageIcon L2 = new ImageIcon(wL2);
			tablero[fila2][columna2].setIcon(new ImageIcon(L2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
			
		
	}

}
