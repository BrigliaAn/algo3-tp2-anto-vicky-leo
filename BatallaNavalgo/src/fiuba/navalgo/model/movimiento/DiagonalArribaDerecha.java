package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;

public class DiagonalArribaDerecha extends Movimiento{

	@Override
	public ArrayList<Casilla> mover(ArrayList<Casilla> listaActual) {
		// TODO Auto-generated method stub
		Arriba moverArriba = new Arriba();
		listaActual = moverArriba.mover(listaActual);
		Derecha moverDerecha = new Derecha();
		listaActual = moverDerecha.mover(listaActual);
		return listaActual;
	}

	@Override
	public Movimiento proximoMovimiento(ArrayList<Casilla> listaActual) {
		// TODO Auto-generated method stub
		for(int pos=0;pos<(listaActual.size());pos++){
			int fila = listaActual.get(pos).getPosicion().getFila();
	    	int columna = listaActual.get(pos).getPosicion().getColumna();
	    	if((columna==9) || (fila == 0)){
	    		return new DiagonalAbajoIzquierda();
	    	};
	    };
		return this;
	}

}
