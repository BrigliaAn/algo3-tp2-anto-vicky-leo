package fiuba.navalgo.model.movimiento;

import java.util.ArrayList;

import junit.framework.TestCase;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.naves.PorcionDeNave;

public class AbajoTest extends TestCase{
	
	public void testAbajoDeberiaMoverLasCasillasDeLaNaveEnHorizontalUnaPosicionParaAbajo(){
		Abajo moverAbajo= new Abajo();
		Tablero tablero = Tablero.getInstance();
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,2))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,3))));
		moverAbajo.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(3,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(3,2)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(3,3)));
	}
	
	public void testAbajoDeberiaMoverLasCasillasDeLaNaveEnVerticalUnaPosicionParaAbajo(){
		Abajo moverAbajo= new Abajo();
		Tablero tablero = Tablero.getInstance();
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(3,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(4,1))));
		moverAbajo.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(3,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(4,1)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(5,1)));

	}

	public void testAbajoDeberiaMoverLasCasillasDeLaNaveEnDiagonalUnaPosicionParaAbajo(){
		Abajo moverAbajo= new Abajo();
		Tablero tablero = Tablero.getInstance();
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(2,1))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(3,2))));
		listaDePorciones.add(new PorcionDeNave(1,tablero.devolverCasilla(new Posicion(4,3))));
		moverAbajo.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(3,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(4,2)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(5,3)));

	}

	public void testProximoMovimientoDeberiaDevolverElMismoMovimientoSiLaNaveNoEstaEnElBorde(){
		Abajo moverAbajo= new Abajo();
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(4,2)));
		Movimiento proxMovimiento = moverAbajo.proximoMovimiento(listaDeCasillasActuales);
	
		assertEquals(proxMovimiento,moverAbajo);
	}
	public void testProximoMovimientoDeberiaDevolverElMovimientoContrarioSiLaNaveEstaEnElBordeInferior(){
		Abajo moverAbajo= new Abajo();
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		ArrayList<Casilla> listaDeCasillasActuales = new ArrayList<Casilla>();
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,2)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,3)));
		listaDeCasillasActuales.add(tablero.devolverCasilla(new Posicion(9,4)));
		Movimiento proxMovimiento = moverAbajo.proximoMovimiento(listaDeCasillasActuales);
		
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(0)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(1)));
		listaDePorciones.add(new PorcionDeNave(1,listaDeCasillasActuales.get(2)));
		
		proxMovimiento.mover(listaDePorciones);
	
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(8,2)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(8,3)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(8,4)));
		

	}


}