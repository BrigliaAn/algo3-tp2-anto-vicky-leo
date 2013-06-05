package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;

public class DiagonalArribaIzquierda extends Movimiento{

	@Override
	public ArrayList<Casilla> mover(ArrayList<Casilla> listaActual) {
		Arriba moverArriba = new Arriba();
		listaActual = moverArriba.mover(listaActual);
		Izquierda moverIzquierda = new Izquierda();
		listaActual = moverIzquierda.mover(listaActual);
		return listaActual;
	}

	@Override
	public Movimiento proximoMovimiento(ArrayList<Casilla> listaActual) {
		for(int pos=0;pos<(listaActual.size());pos++){
			int fila = listaActual.get(pos).getPosicion().getFila();
	    	int columna = listaActual.get(pos).getPosicion().getColumna();
	    	if((columna==0) || (fila == 0)){
	    		return new DiagonalAbajoDerecha();
	    	};
	    };
		return this;
	}

}
