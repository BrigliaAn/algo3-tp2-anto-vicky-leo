package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import junit.framework.TestCase;

public class ArribaTest extends TestCase{
		
	public void testArribaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaArriba(){
		Arriba moverArriba= new Arriba();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,3)));
		listaDeCasillasActuales = moverArriba.mover(listaDeCasillasActuales);
		
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,3))));
	}
	
	
}
