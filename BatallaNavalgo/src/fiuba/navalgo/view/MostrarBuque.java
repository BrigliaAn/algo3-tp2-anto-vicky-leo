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

public class MostrarBuque {
	int contadorB = 0;
	BufferedImage wB1;
	BufferedImage wB2;
	BufferedImage wB3;
	BufferedImage wB4;
	
	public void mostrarNave(JButtonID[][] tablero, Nave nave) throws IOException {
		ArrayList<PorcionDeNave> porciones = nave.getPorcionesDeNave();
		int columna = porciones.get(0).getX();
		int fila = porciones.get(0).getY();
		if(porciones.get(0).estaDestruida())
			wB1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
   			 if(contadorB == 0){
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wB1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte4Vertical.png"));
				else
					wB1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte1.png"));
			}
		}
		ImageIcon B1 = new ImageIcon(wB1);
		tablero[fila][columna].setIcon(new ImageIcon(B1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		
		
		int columna2 = porciones.get(1).getX();
		int fila2 = porciones.get(1).getY();
		if(porciones.get(1).estaDestruida())
			wB2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
			 if(contadorB == 0){
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wB2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte3Vertical.png"));
				else
					wB2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte2.png"));
			}
		}
		ImageIcon B2 = new ImageIcon(wB2);
		tablero[fila2][columna2].setIcon(new ImageIcon(B2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		 
		
		int columna3 = porciones.get(2).getX();
		int fila3 = porciones.get(2).getY();
		if(porciones.get(2).estaDestruida())
			wB3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
			if (contadorB == 0){				
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wB3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte2Vertical.png"));
				else
					wB3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte3.png"));
			}
		}
		ImageIcon B3 = new ImageIcon(wB3);
		tablero[fila3][columna3].setIcon(new ImageIcon(B3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
			
		int columna4 = porciones.get(3).getX();
		int fila4 = porciones.get(3).getY();
		if(porciones.get(3).estaDestruida())
			wB4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
			if (contadorB == 0){								
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wB4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte1Vertical.png"));
				else
					wB4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte4.png"));
			}
		}
		ImageIcon B4 = new ImageIcon(wB4);
		tablero[fila4][columna4].setIcon(new ImageIcon(B4.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
	
		contadorB++;
    }
		
}


