package fiuba.navalgo.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.navalgo.model.direccion.Vertical;
import fiuba.navalgo.model.naves.Buque;
import fiuba.navalgo.model.naves.Destructor;
import fiuba.navalgo.model.naves.Lancha;
import fiuba.navalgo.model.naves.Nave;
import fiuba.navalgo.model.naves.PorcionDeNave;
import fiuba.navalgo.model.naves.PortaAviones;
import fiuba.navalgo.model.naves.RompeHielos;

public class MostrarNaves {
	public void mostrarNaves(JButtonID tablero[][],Nave nave) throws IOException{
		ArrayList<PorcionDeNave> porciones = nave.getPorcionesDeNave();
	
			if( nave instanceof Lancha ){
							
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
		    if( nave instanceof Buque ){
		    	
		    	int columna = porciones.get(0).getX();
				int fila = porciones.get(0).getY();
				BufferedImage wB1;
				if(porciones.get(0).estaDestruida()){
					wB1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wB1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte4Vertical.png"));
					}else{
						wB1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte1.png"));
					}
				}
				ImageIcon B1 = new ImageIcon(wB1);
				tablero[fila][columna].setIcon(new ImageIcon(B1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
				int columna2 = porciones.get(1).getX();
				int fila2 = porciones.get(1).getY();
				BufferedImage wB2;
				if(porciones.get(1).estaDestruida()){
					wB2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wB2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte3Vertical.png"));
					}else{
					wB2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte2.png"));
					}
				}
				ImageIcon B2 = new ImageIcon(wB2);
				tablero[fila2][columna2].setIcon(new ImageIcon(B2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				   
				int columna3 = porciones.get(2).getX();
				int fila3 = porciones.get(2).getY();
				BufferedImage wB3;
				if(porciones.get(2).estaDestruida()){
					wB3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wB3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte2Vertical.png"));
					}else{
						wB3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte3.png"));
					}
				}
				ImageIcon B3 = new ImageIcon(wB3);
				tablero[fila3][columna3].setIcon(new ImageIcon(B3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
				int columna4 = porciones.get(3).getX();
				int fila4 = porciones.get(3).getY();
				BufferedImage wB4;
				if(porciones.get(3).estaDestruida()){
					wB4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wB4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte1Vertical.png"));
					}else{
						wB4= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/buqueParte4.png"));
					}
				}
				ImageIcon B4 = new ImageIcon(wB4);
				tablero[fila4][columna4].setIcon(new ImageIcon(B4.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				         
		    }
		    if( nave instanceof Destructor ){
		    	int columna = porciones.get(0).getX();
				int fila = porciones.get(0).getY();
				BufferedImage wD1;
				if(porciones.get(0).estaDestruida()){
					wD1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wD1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte3Vertical.png"));
					}else{
						wD1= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte1.png"));
					}
				}
				ImageIcon D1 = new ImageIcon(wD1);
				tablero[fila][columna].setIcon(new ImageIcon(D1.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
				int columna2 = porciones.get(1).getX();
				int fila2 = porciones.get(1).getY();
				BufferedImage wD2;
				if(porciones.get(1).estaDestruida()){
					wD2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wD2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte2Vertical.png"));
					}else{
						wD2= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte2.png"));
					}
				}
				ImageIcon D2 = new ImageIcon(wD2);
				tablero[fila2][columna2].setIcon(new ImageIcon(D2.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
				   
				int columna3 = porciones.get(2).getX();
				int fila3 = porciones.get(2).getY();
				BufferedImage wD3;
				if(porciones.get(2).estaDestruida()){
					wD3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/explosion.png"));
				}else{
					if (nave.getDireccion() instanceof Vertical){
						wD3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte1Vertical.png"));
					}else{
						wD3= ImageIO.read(this.getClass().getResource("/Imagenes/Naves/destructorParte3.png"));
					}
				}
				ImageIcon D3 = new ImageIcon(wD3);
				tablero[fila3][columna3].setIcon(new ImageIcon(D3.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH)));
					
		            
		    }
		    if( nave instanceof PortaAviones){
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
		    if( nave instanceof RompeHielos){
		           
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
	
	
}
