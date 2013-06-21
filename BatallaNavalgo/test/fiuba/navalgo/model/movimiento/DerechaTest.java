package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.naves.PorcionDeNave;

public class DerechaTest extends TestCase{
	
	public void testDerechaDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaLaDerecha(){
		Derecha moverDerecha= new Derecha();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,2))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,3))));
		moverDerecha.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(2,2)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(2,3)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(2,4)));
		
	}
	public void testDerechaDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParLaDerecha(){
		Derecha moverDerecha= new Derecha();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(3,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(4,1))));
		moverDerecha.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(2,2)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(3,2)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(4,2)));
		
	
	}
	
	public void testDerechaDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaLaDerecha(){
		Derecha moverDerecha= new Derecha();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(3,2))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(4,3))));
		moverDerecha.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(2,2)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(3,3)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(4,4)));
		
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
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeDerecho(){
		Derecha moverDerecha= new Derecha();
		Tablero tablero = Tablero.getInstance();
		

		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(1,9)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,9)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,9)));
		Movimiento proxMovimiento = moverDerecha.proximoMovimiento(listaDeCasillasActuales);
		
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(0)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(1)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(2)));
		
		proxMovimiento.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(1,8)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(2,8)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(3,8)));
		
		
	}

}