package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class DerechaTest extends TestCase{
	
public void testArribaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaLaDerecha(){
	Derecha moverDerecha= new Derecha();
	Tablero tablero = Tablero.getInstance();
	ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
	listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
	listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
	listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,3)));
	listaDeCasillasActuales = moverDerecha.mover(listaDeCasillasActuales);
	
	assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,2))));
	assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,3))));
	assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,4))));
}


}