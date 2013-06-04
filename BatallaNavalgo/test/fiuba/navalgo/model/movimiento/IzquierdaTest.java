package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;

public class IzquierdaTest extends TestCase{
	
	public void testIzquierdaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaLaIzquierda(){
		Izquierda moverIzquierda= new Izquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,3)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,4)));
		listaDeCasillasActuales = moverIzquierda.mover(listaDeCasillasActuales);
	
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,2))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,3))));
	}
	public void testIzquierdaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParLaIzquierda(){
		Izquierda moverIzquierda= new Izquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,1)));
		listaDeCasillasActuales = moverIzquierda.mover(listaDeCasillasActuales);
		
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(4,0))));
	
	}
	
	public void testIzquierdaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaLaIzquierda(){
		Izquierda moverIzquierda= new Izquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,3)));
		listaDeCasillasActuales = moverIzquierda.mover(listaDeCasillasActuales);
		
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,0))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(4,2))));
	
	}
	
	public void testProximoMovimientoDeberiaDevolverElMismoMovimientoSiLaNaveNoEstaEnElBorde(){
		Izquierda moverIzquierda= new Izquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,2)));
		Movimiento proxMovimiento = moverIzquierda.proximoMovimiento(listaDeCasillasActuales);
		
		assertEquals(proxMovimiento,moverIzquierda);
	}
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeIzquierdo(){
		Izquierda moverIzquierda= new Izquierda();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(1,0)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,0)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,0)));
		Movimiento proxMovimiento = moverIzquierda.proximoMovimiento(listaDeCasillasActuales);
		listaDeCasillasActuales=proxMovimiento.mover(listaDeCasillasActuales);
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(1,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(2,1))));
		assertTrue(listaDeCasillasActuales.contains(tablero.devolverCasilla(new Posicion(3,1))));
	}


}