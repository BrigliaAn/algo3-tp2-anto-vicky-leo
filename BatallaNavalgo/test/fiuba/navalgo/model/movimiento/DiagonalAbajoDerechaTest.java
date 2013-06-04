package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class DiagonalAbajoDerechaTest extends TestCase{
	
	public void testDiagonalAbajoDerechaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaAbajoYUnaParaLaDerecha(){
		DiagonalAbajoDerecha moverDiagonalAbajoDerecha= new DiagonalAbajoDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,3)));
		listaDeCasillasActuales = moverDiagonalAbajoDerecha.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,3))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,4))));
	}
	
	public void testDiagonalAbajoDerechaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParaAbajoYUnaParaLaDerecha(){
		DiagonalAbajoDerecha moverDiagonalAbajoDerecha= new DiagonalAbajoDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,1)));
		listaDeCasillasActuales = moverDiagonalAbajoDerecha.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(4,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(5,2))));

	}

	public void testDiagonalAbajoDerechaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaAbajoYUnaParaLaDerecha(){
		DiagonalAbajoDerecha moverDiagonalAbajoDerecha= new DiagonalAbajoDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,3)));
		listaDeCasillasActuales = moverDiagonalAbajoDerecha.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(4,3))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(5,4))));

	}

	public void testProximoMovimientoDeberiaDevolverElMismoMovimientoSiLaNaveNoEstaEnElBorde(){
		DiagonalAbajoDerecha moverDiagonalAbajoDerecha= new DiagonalAbajoDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,2)));
		Movimiento proxMovimiento = moverDiagonalAbajoDerecha.proximoMovimiento(listaDeCasillasActuales);
	
		assertEquals(proxMovimiento,moverDiagonalAbajoDerecha);
	}
	
	
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeInferior(){
		DiagonalAbajoDerecha moverDiagonalAbajoDerecha= new DiagonalAbajoDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,3)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,4)));
		Movimiento proxMovimiento = moverDiagonalAbajoDerecha.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(8,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(8,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(8,3))));
	}

	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeDerecho(){
		DiagonalAbajoDerecha moverDiagonalAbajoDerecha= new DiagonalAbajoDerecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,7)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,8)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,9)));
		Movimiento proxMovimiento = moverDiagonalAbajoDerecha.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,6))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,7))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,8))));
	}
	
}
