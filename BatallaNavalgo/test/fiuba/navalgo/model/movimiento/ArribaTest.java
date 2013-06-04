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
	
	public void testArribaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParaArriba(){
		Arriba moverArriba= new Arriba();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,1)));
		listaDeCasillasActuales = moverArriba.mover(listaDeCasillasActuales);
		
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,1))));
	
	}
	
	public void testArribaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaArriba(){
		Arriba moverArriba= new Arriba();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,3)));
		listaDeCasillasActuales = moverArriba.mover(listaDeCasillasActuales);
		
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,3))));
	
	}
	
	public void testProximoMovimientoDeberiaDevolverElMismoMovimientoSiLaNaveNoEstaEnElBorde(){
		Arriba moverArriba = new Arriba();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,2)));
		Movimiento proxMovimiento = moverArriba.proximoMovimiento(listaDeCasillasActuales);
		
		assertEquals(proxMovimiento,moverArriba);
	}
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBorde(){
		Arriba moverArriba = new Arriba();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,3)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,4)));
		Movimiento proxMovimiento = moverArriba.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,2))));
	}
	
}
