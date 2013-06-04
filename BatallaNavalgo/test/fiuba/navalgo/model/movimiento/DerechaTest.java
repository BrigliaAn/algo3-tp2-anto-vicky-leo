package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class DerechaTest extends TestCase{
	
	public void testDerechaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaLaDerecha(){
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
	public void testDerechaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParLaDerecha(){
		Derecha moverDerecha= new Derecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,1)));
		listaDeCasillasActuales = moverDerecha.mover(listaDeCasillasActuales);
		
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(4,2))));
	
	}
	
	public void testDerechaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaLaDerecha(){
		Derecha moverDerecha= new Derecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,3)));
		listaDeCasillasActuales = moverDerecha.mover(listaDeCasillasActuales);
		
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,3))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(4,4))));
	
	}
	
	public void testProximoMovimientoDeberiaDevolverElMismoMovimientoSiLaNaveNoEstaEnElBorde(){
		Derecha moverDerecha= new Derecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,2)));
		Movimiento proxMovimiento = moverDerecha.proximoMovimiento(listaDeCasillasActuales);
		
		assertEquals(proxMovimiento,moverDerecha);
	}
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBorde(){
		Derecha moverDerecha= new Derecha();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(1,9)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,9)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,9)));
		Movimiento proxMovimiento = moverDerecha.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,8))));
	}

}