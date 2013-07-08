package fiuba.navalgo.model.direccion;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;

public abstract class Direccion {

	public abstract ArrayList<Casilla> devolverCasillas(Posicion posicion, int tamanio);
	public abstract String dameTipoDeDireccion();
}
