package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class DiagonalArribaIzquierdaTest extends TestCase {

	public void testDiagonalArribaIzquierdaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaArribaYUnaParaLaIzquierda(){
		DiagonalArribaIzquierda moverDiagonalArribaIzquierda= new DiagonalArribaIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,3)));
		listaDeCasillasActuales = moverDiagonalArribaIzquierda.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,2))));
	}
	
	public void testDiagonalArribaIzquierdaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParaArribaYUnaParaLaIzquierda(){
		DiagonalArribaIzquierda moverDiagonalArribaIzquierda= new DiagonalArribaIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,1)));
		listaDeCasillasActuales = moverDiagonalArribaIzquierda.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,0))));

	}

	public void testDiagonalArribaIzquierdaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaArribaYUnaParaLaIzquierda(){
		DiagonalArribaIzquierda moverDiagonalArribaIzquierda= new DiagonalArribaIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,3)));
		listaDeCasillasActuales = moverDiagonalArribaIzquierda.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,2))));

	}

	public void testProximoMovimientoDeberiaDevolverElMismoMovimientoSiLaNaveNoEstaEnElBorde(){
		DiagonalArribaIzquierda moverDiagonalArribaIzquierda= new DiagonalArribaIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,2)));
		Movimiento proxMovimiento = moverDiagonalArribaIzquierda.proximoMovimiento(listaDeCasillasActuales);
	
		assertEquals(proxMovimiento,moverDiagonalArribaIzquierda);
	}
	
	
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeSuperior(){
		DiagonalArribaIzquierda moverDiagonalArribaIzquierda= new DiagonalArribaIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,3)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,4)));
		Movimiento proxMovimiento = moverDiagonalArribaIzquierda.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,3))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,4))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,5))));
	}

	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeIzquierdo(){
		DiagonalArribaIzquierda moverDiagonalArribaIzquierda= new DiagonalArribaIzquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,0)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		Movimiento proxMovimiento = moverDiagonalArribaIzquierda.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,3))));
	}
	
}


