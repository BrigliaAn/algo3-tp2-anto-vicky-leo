package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.naves.PorcionDeNave;

public class Izquierda extends Movimiento {


	public void mover(ArrayList<PorcionDeNave> listaDePorciones) {
		Tablero tablero = Tablero.getInstance();
		for(PorcionDeNave porcion: listaDePorciones){
			Casilla casilla = porcion.getCasilla();
			Posicion posActual = casilla.getPosicion();
			Posicion posNueva = new Posicion(posActual.getFila(),posActual.getColumna()-1);
			porcion.mover(tablero.devolverCasilla(posNueva));
		}

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
