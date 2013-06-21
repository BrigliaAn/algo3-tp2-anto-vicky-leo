package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.naves.PorcionDeNave;
import junit.framework.TestCase;

public class ArribaTest extends TestCase{
		
	public void testArribaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaArriba(){
		Arriba moverArriba= new Arriba();
		Tablero tablero = Tablero.getInstance();
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,2))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,3))));
		moverArriba.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(1,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(1,2)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(1,3)));

		
	}
	
	public void testArribaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParaArriba(){
		Arriba moverArriba= new Arriba();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(3,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(4,1))));
		moverArriba.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(1,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(2,1)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(3,1)));
	
	}
	
	public void testArribaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaArriba(){
		Arriba moverArriba= new Arriba();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(3,2))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(4,3))));
		moverArriba.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(1,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(2,2)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(3,3)));

		
	
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
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeSuperior(){
		Arriba moverArriba = new Arriba();
		Tablero tablero = Tablero.getInstance();

		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,3)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(0,4)));
		Movimiento proxMovimiento = moverArriba.proximoMovimiento(listaDeCasillasActuales);
		
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(0)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(1)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(2)));
		
		proxMovimiento.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(1,2)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(1,3)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(1,4)));
		
	}
	
}
