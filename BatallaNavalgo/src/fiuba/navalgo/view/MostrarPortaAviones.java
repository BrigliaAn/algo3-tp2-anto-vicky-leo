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

public class MostrarPortaAviones {
	int contadorP = 0;
	BufferedImage wPA1;
	BufferedImage wPA2;
	BufferedImage wPA3;
	BufferedImage wPA4;
	BufferedImage wPA5;

	public void mostrarNave(JButtonID[][] tablero, Nave nave) throws IOException {
		ArrayList<PorcionDeNave> porciones = nave.getPorcionesDeNave();
		int columna = porciones.get(0).getX();
		int fila = porciones.get(0).getY();
		if(porciones.get(0).estaDestruida())
			wPA1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
   			 if(contadorP == 0){
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wPA1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/PortaavionesParte5Vertical.png"));
				else
					wPA1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/PortaavionesParte1.png"));
			}
		}
		ImageIcon P1 = new ImageIcon(wPA1);
		tablero[fila][columna].setIcon(new ImageIcon(P1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		
		
		int columna2 = porciones.get(1).getX();
		int fila2 = porciones.get(1).getY();
		if(porciones.get(1).estaDestruida())
			wPA2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
			 if(contadorP == 0){
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wPA2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/PortaavionesParte4Vertical.png"));
				else
					wPA2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/PortaavionesParte2.png"));
			}
		}
		ImageIcon P2 = new ImageIcon(wPA2);
		tablero[fila2][columna2].setIcon(new ImageIcon(P2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		 
		
		int columna3 = porciones.get(2).getX();
		int fila3 = porciones.get(2).getY();
		if(porciones.get(2).estaDestruida())
			wPA3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
			if (contadorP == 0){				
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wPA3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/PortaavionesParte3Vertical.png"));
				else
					wPA3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/PortaavionesParte3.png"));
			}
		}
		ImageIcon P3 = new ImageIcon(wPA3);
		tablero[fila3][columna3].setIcon(new ImageIcon(P3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
			
		int columna4 = porciones.get(3).getX();
		int fila4 = porciones.get(3).getY();
		if(porciones.get(3).estaDestruida())
			wPA4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
			if (contadorP == 0){								
				if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
					wPA4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/PortaavionesParte2Vertical.png"));
				else
					wPA4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/PortaavionesParte4.png"));
			}
		}
		ImageIcon P4 = new ImageIcon(wPA4);
		tablero[fila4][columna4].setIcon(new ImageIcon(P4.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
	
		int columna5 = porciones.get(4).getX();
		int fila5 = porciones.get(4).getY();
		if(porciones.get(4).estaDestruida())
			wPA5= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		else{
			 	if(contadorP == 0){
			 		if (nave.getDireccion().dameTipoDeDireccion() == "vertical")
			 			wPA5= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/PortaavionesParte1Vertical.png"));
			 		else
			 			wPA5= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/PortaavionesParte5.png"));
			 	}
		}
		ImageIcon P5 = new ImageIcon(wPA5);
		tablero[fila5][columna5].setIcon(new ImageIcon(P5.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
	
		contadorP++;
	}
	
}
