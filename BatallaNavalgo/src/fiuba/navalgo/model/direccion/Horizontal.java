package fiuba.navalgo.model.direccion;

import java.util.ArrayList;
import java.util.Collections;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class Horizontal extends Direccion{

	@Override
	public ArrayList<Casilla> devolverCasillas(Posicion posicion, int tamanio) {
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		int columna = posicion.getColumna();
		Tablero tablero = Tablero.getInstance();
		if((columna + tamanio) <= 9){
			for( int col = columna; col <= columna - 1 + tamanio; col ++){
				casillas.add(tablero.devolverCasilla(new Posicion(posicion.getFila(), col)));
			}
		}else{
			for( int col = columna; col > columna - tamanio; col --){
				casillas.add(tablero.devolverCasilla(new Posicion(posicion.getFila(), col)));
			}
		}
		Collections.sort(casillas);
		return casillas;
		
	}
}
