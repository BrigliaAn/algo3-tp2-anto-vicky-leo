package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class DiagonalAbajoIzquierdaTest extends TestCase{

	public void testDiagonalAbajoIzquierdaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaAbajoYUnaParaLaIzquierda(){
		DiagonalAbajoIzquierda moverDiagonalAbajoIzquierda= new DiagonalAbajoIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,3)));
		listaDeCasillasActuales = moverDiagonalAbajoIzquierda.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,2))));
	}
	
	public void testDiagonalAbajoIzquierdaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParaAbajoYUnaParaLaIzquierda(){
		DiagonalAbajoIzquierda moverDiagonalAbajoIzquierda= new DiagonalAbajoIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,1)));
		listaDeCasillasActuales = moverDiagonalAbajoIzquierda.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(4,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(5,0))));

	}

	public void testDiagonalAbajoIzquierdaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaAbajoYUnaParaLaIzquierda(){
		DiagonalAbajoIzquierda moverDiagonalAbajoIzquierda= new DiagonalAbajoIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,3)));
		listaDeCasillasActuales = moverDiagonalAbajoIzquierda.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(4,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(5,2))));

	}

	public void testProximoMovimientoDeberiaDevolverElMismoMovimientoSiLaNaveNoEstaEnElBorde(){
		DiagonalAbajoIzquierda moverDiagonalAbajoIzquierda= new DiagonalAbajoIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,2)));
		Movimiento proxMovimiento = moverDiagonalAbajoIzquierda.proximoMovimiento(listaDeCasillasActuales);
	
		assertEquals(proxMovimiento,moverDiagonalAbajoIzquierda);
	}
	
	
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeInferior(){
		DiagonalAbajoIzquierda moverDiagonalAbajoIzquierda= new DiagonalAbajoIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,3)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,4)));
		Movimiento proxMovimiento = moverDiagonalAbajoIzquierda.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(8,3))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(8,4))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(8,5))));
	}

	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeIzquierdo(){
		DiagonalAbajoIzquierda moverDiagonalAbajoIzquierda= new DiagonalAbajoIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,0)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		Movimiento proxMovimiento = moverDiagonalAbajoIzquierda.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,3))));
	}
	
}

