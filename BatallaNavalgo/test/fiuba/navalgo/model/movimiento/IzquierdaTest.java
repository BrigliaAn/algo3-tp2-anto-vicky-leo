package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class IzquierdaTest extends TestCase{
	
public void testArribaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaLaIzquierda(){
	Izquierda moverIzquierda= new Izquierda();
	Tablero tablero = Tablero.getInstance();
	ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
	listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
	listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,3)));
	listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,4)));
	listaDeCasillasActuales = moverIzquierda.mover(listaDeCasillasActuales);
	
	assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,1))));
	assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,2))));
	assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,3))));
}


}