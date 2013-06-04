package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class AbajoTest extends TestCase{
	
	public void testAbajoDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaAbajo(){
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
	
	public void testAbajoDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParaAbajo(){
		Abajo moverAbajo= new Abajo();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,1)));
		listaDeCasillasActuales = moverAbajo.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(4,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(5,1))));

	}

	public void testAbajoDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaAbajo(){
		Abajo moverAbajo= new Abajo();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,3)));
		listaDeCasillasActuales = moverAbajo.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(4,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(5,3))));

	}

	public void testProximoMovimientoDeberiaDevolverElMismoMovimientoSiLaNaveNoEstaEnElBorde(){
		Abajo moverAbajo= new Abajo();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,2)));
		Movimiento proxMovimiento = moverAbajo.proximoMovimiento(listaDeCasillasActuales);
	
		assertEquals(proxMovimiento,moverAbajo);
	}
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBorde(){
		Abajo moverAbajo= new Abajo();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,3)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,4)));
		Movimiento proxMovimiento = moverAbajo.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(8,2))));
	}


}