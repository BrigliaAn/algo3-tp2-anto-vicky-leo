package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class DiagonalArribaDerechaTest extends TestCase{

	public void testDiagonalArribaDerechaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaArribaYUnaParaLaDerecha(){
		DiagonalArribaDerecha moverDiagonalArribaDerecha= new DiagonalArribaDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,3)));
		listaDeCasillasActuales = moverDiagonalArribaDerecha.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,3))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,4))));
	}
	
	public void testDiagonalArribaDerechaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParaArribaYUnaParaLaDerecha(){
		DiagonalArribaDerecha moverDiagonalArribaDerecha= new DiagonalArribaDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,1)));
		listaDeCasillasActuales = moverDiagonalArribaDerecha.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,2))));

	}

	public void testDiagonalArribaDerechaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaArribaYUnaParaLaDerecha(){
		DiagonalArribaDerecha moverDiagonalArribaDerecha= new DiagonalArribaDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,3)));
		listaDeCasillasActuales = moverDiagonalArribaDerecha.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,3))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,4))));

	}

	public void testProximoMovimientoDeberiaDevolverElMismoMovimientoSiLaNaveNoEstaEnElBorde(){
		DiagonalArribaDerecha moverDiagonalArribaDerecha= new DiagonalArribaDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,2)));
		Movimiento proxMovimiento = moverDiagonalArribaDerecha.proximoMovimiento(listaDeCasillasActuales);
	
		assertEquals(proxMovimiento,moverDiagonalArribaDerecha);
	}
	
	
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeSuperior(){
		DiagonalArribaDerecha moverDiagonalArribaDerecha= new DiagonalArribaDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,3)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,4)));
		Movimiento proxMovimiento = moverDiagonalArribaDerecha.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,3))));
	}

	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeDerecho(){
		DiagonalArribaDerecha moverDiagonalArribaDerecha= new DiagonalArribaDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,7)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,8)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,9)));
		Movimiento proxMovimiento = moverDiagonalArribaDerecha.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,6))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,7))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,8))));
	}
}