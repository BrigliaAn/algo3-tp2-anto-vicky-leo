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

	public void mostrarNave(JButtonID[][] tablero, Nave nave) throws IOException {
		ArrayList<PorcionDeNave> porciones = nave.getPorcionesDeNave();
		int columna = porciones.get(0).getX();
		int fila = porciones.get(0).getY();
		BufferedImage wPA1;
		if(porciones.get(0).estaDestruida()){
			wPA1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		}else{
			if (nave.getDireccion() instanceof Vertical){
				wPA1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte5Vertical.png"));
			}else{
				wPA1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte1.png"));
			}
		}
		ImageIcon PA1 = new ImageIcon(wPA1);
		tablero[fila][columna].setIcon(new ImageIcon(PA1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
			
		int columna2 = porciones.get(1).getX();
		int fila2 = porciones.get(1).getY();
		BufferedImage wPA2;
		if(porciones.get(1).estaDestruida()){
			wPA2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		}else{
			if (nave.getDireccion() instanceof Vertical){
				wPA2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte4Vertical.png"));
			}else{
				wPA2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte2.png"));
			}
		}	
		ImageIcon PA2 = new ImageIcon(wPA2);
		tablero[fila2][columna2].setIcon(new ImageIcon(PA2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		   
		int columna3 = porciones.get(2).getX();
		int fila3 = porciones.get(2).getY();
		BufferedImage wPA3;
		if(porciones.get(2).estaDestruida()){
			wPA3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		}else{
			if (nave.getDireccion() instanceof Vertical){
				wPA3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte3Vertical.png"));
			}else{
				wPA3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte3.png"));
			}
		}
		ImageIcon PA3 = new ImageIcon(wPA3);
		tablero[fila3][columna3].setIcon(new ImageIcon(PA3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
			
		int columna4 = porciones.get(3).getX();
		int fila4 = porciones.get(3).getY();
		BufferedImage wPA4;
		if(porciones.get(3).estaDestruida()){
			wPA4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		}else{
			if (nave.getDireccion() instanceof Vertical){
				wPA4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte2Vertical.png"));
			}else{
				wPA4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte4.png"));
			}
		}
		ImageIcon PA4 = new ImageIcon(wPA4);
		tablero[fila4][columna4].setIcon(new ImageIcon(PA4.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		      
		int columna5 = porciones.get(4).getX();
		int fila5 = porciones.get(4).getY();
		BufferedImage wPA5;
		if(porciones.get(4).estaDestruida()){
			wPA5= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
		}else{
			if (nave.getDireccion() instanceof Vertical){
				wPA5= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte1Vertical.png"));
			}else{
				wPA5= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/portaavionesParte5.png"));
			}
		}
		ImageIcon PA5 = new ImageIcon(wPA5);
		tablero[fila5][columna5].setIcon(new ImageIcon(PA5.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
		  
	}

}
