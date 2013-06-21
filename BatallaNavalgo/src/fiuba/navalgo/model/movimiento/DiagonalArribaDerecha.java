package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.naves.PorcionDeNave;

public class DiagonalArribaDerecha extends Movimiento{


	public void mover(ArrayList<PorcionDeNave> listaDePorciones)  {
		Arriba moverArriba = new Arriba();
		moverArriba.mover(listaDePorciones);
		Derecha moverDerecha = new Derecha();
		moverDerecha.mover(listaDePorciones);
	
	}
	
	@Override
	public Movimiento proximoMovimiento(ArrayList<Casilla> listaActual) {
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
