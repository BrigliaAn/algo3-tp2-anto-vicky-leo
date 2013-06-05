package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class Izquierda extends Movimiento {

	@Override
	public ArrayList<Casilla> mover(ArrayList<Casilla> listaDeCasillasActuales) {
		ArrayList<Casilla> list = new ArrayList<Casilla>();
		Tablero tablero = Tablero.getInstance();
		for(int pos=0;pos<(listaDeCasillasActuales.size());pos++){
			Casilla casilla = listaDeCasillasActuales.get(pos);
			Posicion posActual = casilla.getPosicion();
			Posicion posNueva = new Posicion(posActual.getFila(),posActual.getColumna()-1);
			list.add(tablero.devolverCasilla(posNueva));
		};
		
		return list;
	}

	@Override
	public Movimiento proximoMovimiento(ArrayList<Casilla> listaActual) {
		for(int pos=0;pos<(listaActual.size());pos++){
	    	int columna = listaActual.get(pos).getPosicion().getColumna();
	    	if(columna==0){
	    		return new Derecha();
	    	};
	    };
		return this;
	}
}
