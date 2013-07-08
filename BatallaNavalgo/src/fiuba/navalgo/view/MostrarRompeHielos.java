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
	int contadorR = 0;
	BufferedImage wRH1;
	BufferedImage wRH2;
	BufferedImage wRH3;
	
	public void mostrarNave(JButtonID[][] tablero, Nave nave) throws IOException {
		ArrayList<PorcionDeNave> porciones = nave.getPorcionesDeNave();
		int columna = porciones.get(0).getX();
		int fila = porciones.get(0).getY();
		if(porciones.get(0).estaDestruida())
			wRH1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
			if(contadorR == 0){
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wRH1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte3Vertical.png"));
				else
					wRH1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte1.png"));
			}
		}
		ImageIcon RH1 = new ImageIcon(wRH1);
		tablero[fila][columna].setIcon(new ImageIcon(RH1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
			
		int columna2 = porciones.get(1).getX();
		int fila2 = porciones.get(1).getY();
		if(porciones.get(1).estaDestruida())
			wRH2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
			if(contadorR == 0){
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wRH2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte2Vertical.png"));
				else
					wRH2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte2.png"));
			}
		}
		ImageIcon RH2 = new ImageIcon(wRH2);
		tablero[fila2][columna2].setIcon(new ImageIcon(RH2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		   
		int columna3 = porciones.get(2).getX();
		int fila3 = porciones.get(2).getY();
		if(porciones.get(2).estaDestruida())
			wRH3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
			if(contadorR == 0){
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wRH3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte1Vertical.png"));
				else
					wRH3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/rompehielosParte3.png"));
			}
		}
		ImageIcon RH3 = new ImageIcon(wRH3);
		tablero[fila3][columna3].setIcon(new ImageIcon(RH3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		      
		contadorR++;
    }

}

