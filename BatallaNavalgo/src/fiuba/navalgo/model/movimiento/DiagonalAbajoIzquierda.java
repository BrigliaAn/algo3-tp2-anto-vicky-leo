package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.naves.PorcionDeNave;

public class DiagonalAbajoIzquierda extends Movimiento{

	
	public void mover(ArrayList<PorcionDeNave> listaDePorciones)  {
		Abajo moverAbajo = new Abajo();
		moverAbajo.mover(listaDePorciones);
		Izquierda moverIzquierda = new Izquierda();
		moverIzquierda.mover(listaDePorciones);
	
	}

	
	@Override
	public Movimiento proximoMovimiento(ArrayList<Casilla> listaActual) {
		for(int pos=0;pos<(listaActual.size());pos++){
			int fila = listaActual.get(pos).getPosicion().getFila();
	    	int columna = listaActual.get(pos).getPosicion().getColumna();
	    	if((columna==0) || (fila == 9)){
	    		return new DiagonalArribaDerecha();
	    	};
	    };
		return this;
	}

}
