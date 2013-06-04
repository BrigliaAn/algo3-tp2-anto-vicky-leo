package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class Derecha extends Movimiento {

	@Override
	public ArrayList<Casilla> mover(ArrayList<Casilla> listaDeCasillasActuales) {
		// TODO Auto-generated method stub
		ArrayList<Casilla> list = new ArrayList<Casilla>();
		Tablero tablero = Tablero.getInstance();
		for(int pos=0;pos<(listaDeCasillasActuales.size());pos++){
			Casilla casilla = listaDeCasillasActuales.get(pos);
			Posicion posActual = casilla.getPosicion();
			Posicion posNueva = new Posicion(posActual.getFila(),posActual.getColumna()+1);
			list.add(tablero.devolverCasilla(posNueva));
		};
		
		return list;
	}

	@Override
	public Movimiento proximoMovimiento(ArrayList<Casilla> listaActual) {
		// TODO Auto-generated method stub
		for(int pos=0;pos<(listaActual.size());pos++){
	    	int columna = listaActual.get(pos).getPosicion().getColumna();
	    	if(columna==9){
	    		return new Izquierda();
	    	};
	    };
		return this;
	}


}
