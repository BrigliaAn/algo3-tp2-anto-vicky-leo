package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.naves.PorcionDeNave;

public abstract class Movimiento {
	
	public abstract void mover(ArrayList<PorcionDeNave> listaDePorciones);
	public abstract Movimiento proximoMovimiento(ArrayList<Casilla> listaActual);
}
