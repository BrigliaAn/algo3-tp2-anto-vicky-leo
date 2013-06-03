package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;

public class DiagonalAbajoDerecha extends Movimiento{

	@Override
	public ArrayList<Casilla> mover(ArrayList<Casilla> listaActual) {
		// TODO Auto-generated method stub
		Abajo moverAbajo = new Abajo();
		listaActual = moverAbajo.mover(listaActual);
		Derecha moverDerecha = new Derecha();
		listaActual = moverDerecha.mover(listaActual);
		return listaActual;
	}

	@Override
	public Movimiento proximoMovimiento(ArrayList<Casilla> listaActual) {
		// TODO Auto-generated method stub
		return null;
	}

}
