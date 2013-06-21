package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.naves.PorcionDeNave;

public class DiagonalArribaIzquierdaTest extends TestCase {

	public void testDiagonalArribaIzquierdaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaArribaYUnaParaLaIzquierda(){
		DiagonalArribaIzquierda moverDiagonalArribaIzquierda= new DiagonalArribaIzquierda();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,2))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,3))));
		moverDiagonalArribaIzquierda.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(1,0)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(1,1)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(1,2)));
	}
	
	public void testDiagonalArribaIzquierdaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParaArribaYUnaParaLaIzquierda(){
		DiagonalArribaIzquierda moverDiagonalArribaIzquierda= new DiagonalArribaIzquierda();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(3,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(4,1))));
		moverDiagonalArribaIzquierda.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(1,0)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(2,0)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(3,0)));

	}

	public void testDiagonalArribaIzquierdaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaArribaYUnaParaLaIzquierda(){
		DiagonalArribaIzquierda moverDiagonalArribaIzquierda= new DiagonalArribaIzquierda();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(3,2))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(4,3))));
		moverDiagonalArribaIzquierda.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(1,0)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(2,1)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(3,2)));

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
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,3)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,4)));
		Movimiento proxMovimiento = moverDiagonalArribaIzquierda.proximoMovimiento(listaDeCasillasActuales);
		
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(0)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(1)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(2)));
		
		proxMovimiento.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(1,3)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(1,4)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(1,5)));
		
	}

	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeIzquierdo(){
		DiagonalArribaIzquierda moverDiagonalArribaIzquierda= new DiagonalArribaIzquierda();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,0)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		Movimiento proxMovimiento = moverDiagonalArribaIzquierda.proximoMovimiento(listaDeCasillasActuales);
		
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(0)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(1)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(2)));
		
		proxMovimiento.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(3,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(3,2)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(3,3)));
		
		
	}
	
}


