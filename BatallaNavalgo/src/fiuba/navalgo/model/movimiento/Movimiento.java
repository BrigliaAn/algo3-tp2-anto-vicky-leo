package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;

public abstract class Movimiento {

	public abstract ArrayList<Casilla> mover(ArrayList<Casilla> listaActual);
	public abstract Movimiento proximoMovimiento(ArrayList<Casilla> listaActual);
}
