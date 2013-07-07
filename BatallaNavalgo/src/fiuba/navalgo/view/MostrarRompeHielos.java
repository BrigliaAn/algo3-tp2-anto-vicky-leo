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

public class MostrarRompeHielos {
	public void mostrarNave(JButtonID[][] tablero, Nave nave) throws IOException {
		ArrayList<PorcionDeNave> porciones = nave.getPorcionesDeNave();
		int columna = porciones.get(0).getX();
		int fila = porciones.get(0).getY();
		BufferedImage wRH1;
		if(porciones.get(0).estaDestruida()){
			wRH1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		}else{
			if (nave.getDireccion() instanceof Vertical){
				wRH1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte3Vertical.png"));
			}else{
				wRH1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte1.png"));
			}
		}
		ImageIcon RH1 = new ImageIcon(wRH1);
		tablero[fila][columna].setIcon(new ImageIcon(RH1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
			
		int columna2 = porciones.get(1).getX();
		int fila2 = porciones.get(1).getY();
		BufferedImage wRH2;
		if(porciones.get(1).estaDestruida()){
			wRH2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		}else{
			if (nave.getDireccion() instanceof Vertical){
				wRH2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte2Vertical.png"));
			}else{
				wRH2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte2.png"));
			}
		}
		ImageIcon RH2 = new ImageIcon(wRH2);
		tablero[fila2][columna2].setIcon(new ImageIcon(RH2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		   
		int columna3 = porciones.get(2).getX();
		int fila3 = porciones.get(2).getY();
		BufferedImage wRH3;
		if(porciones.get(2).estaDestruida()){
			wRH3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		}else{
			if (nave.getDireccion() instanceof Vertical){
				wRH3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte1Vertical.png"));
			}else{
				wRH3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte3.png"));
			}
		}
		ImageIcon RH3 = new ImageIcon(wRH3);
		tablero[fila3][columna3].setIcon(new ImageIcon(RH3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		      
    }

}
