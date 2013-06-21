package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.naves.PorcionDeNave;

public class IzquierdaTest extends TestCase{
	
	public void testIzquierdaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaLaIzquierda(){
		Izquierda moverIzquierda= new Izquierda();
		Tablero tablero = Tablero.getInstance();
		

		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,2))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,3))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,4))));
		moverIzquierda.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(2,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(2,2)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(2,3)));
		
	}
	public void testIzquierdaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParLaIzquierda(){
		Izquierda moverIzquierda= new Izquierda();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(3,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(4,1))));
		moverIzquierda.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(2,0)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(3,0)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(4,0)));
		
	
	}
	
	public void testIzquierdaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaLaIzquierda(){
		Izquierda moverIzquierda= new Izquierda();
		Tablero tablero = Tablero.getInstance();

		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(3,2))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(4,3))));
		moverIzquierda.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(2,0)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(3,1)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(4,2)));

	
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

		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(1,0)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,0)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,0)));
		Movimiento proxMovimiento = moverIzquierda.proximoMovimiento(listaDeCasillasActuales);
		
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(0)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(1)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(2)));
		
		proxMovimiento.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(1,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(2,1)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(3,1)));
		
	}


}