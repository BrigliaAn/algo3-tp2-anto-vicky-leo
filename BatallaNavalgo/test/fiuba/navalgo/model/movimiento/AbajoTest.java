package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class AbajoTest extends TestCase{
	
public void testArribaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaAbajo(){
	Abajo moverAbajo= new Abajo();
	Tablero tablero = Tablero.getInstance();
	ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
	listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
	listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
	listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,3)));
	listaDeCasillasActuales = moverAbajo.mover(listaDeCasillasActuales);
	
	assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,1))));
	assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,2))));
	assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,3))));
}


}