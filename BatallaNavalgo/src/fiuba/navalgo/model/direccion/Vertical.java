package fiuba.navalgo.model.direccion;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class Vertical extends Direccion {

	@Override
	public ArrayList<Casilla> devolverCasillas(Posicion posicion, int tamanio) {
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		Tablero tablero = Tablero.getInstance();
		int fila = posicion.getFila();
		if ((fila + tamanio) <= 9){
			for(int fil = fila; fil <= fila - 1 + tamanio; fil ++){
				casillas.add(tablero.devolverCasilla(new Posicion(fil, posicion.getColumna())));
			}
		}else{
			for( int fil = fila; fil > fila - tamanio; fil --){
			casillas.add(tablero.devolverCasilla(new Posicion(fil, posicion.getColumna())));
			}
		}
		return casillas;
	
	}
	

}
