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

public class MostrarDestructor {

	public void mostrarNave(JButtonID[][] tablero, Nave nave) throws IOException {
		ArrayList<PorcionDeNave> porciones = nave.getPorcionesDeNave();
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

}
