package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class Abajo extends Movimiento {

	@Override
	public ArrayList<Casilla> mover(ArrayList<Casilla> listaDeCasillasActuales) {
		ArrayList<Casilla> list = new ArrayList<Casilla>();
		Tablero tablero = Tablero.getInstance();
		for(int pos=0;pos<(listaDeCasillasActuales.size());pos++){
			Casilla casilla = listaDeCasillasActuales.get(pos);
			Posicion posActual = casilla.getPosicion();
			Posicion posNueva = new Posicion(posActual.getFila() +1,posActual.getColumna());
			list.add(tablero.devolverCasilla(posNueva));
		};
		
		return list;
	}

	@Override
	public Movimiento proximoMovimiento(ArrayList<Casilla> listaActual) {
		for(int pos=0;pos<(listaActual.size());pos++){
	    	int fila = listaActual.get(pos).getPosicion().getFila();
	    	if(fila==9){
	    		return new Arriba();
	    	};
	    };
		return this;
	}

}
