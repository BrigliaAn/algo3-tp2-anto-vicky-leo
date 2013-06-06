package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.Turno;
import fiuba.navalgo.model.disparos.DisparoConvencional;
import fiuba.navalgo.model.movimiento.Abajo;
import fiuba.navalgo.model.movimiento.Arriba;
import fiuba.navalgo.model.movimiento.Movimiento;
import junit.framework.TestCase;

public class BuqueTest extends TestCase {
	public void testCrearUnBuque(){
		Movimiento arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		Buque unBuque = new Buque(arriba,listaDeCasillas);
		assertNotNull(unBuque);
			
	}
	public void testCrearUnBuqueNoEstaDestruido(){
		Movimiento arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		Buque unBuque = new Buque(arriba,listaDeCasillas);
		assertFalse(unBuque.estaDestruido());
	}
	
	public void testCrearUnBuqueYRecibirDisparoConvencionalLoDestruyePorCompleto(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		Buque unBuque = new Buque(arriba,listaDeCasillas);
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla1);
		unDisparo.agregarTurno(turno);
		unBuque.recibirDisparo(unDisparo);
		assertTrue(unBuque.estaDestruido());
	}
	

	public void testMoverUnBuque(){
		Tablero tablero = Tablero.getInstance();
		Abajo abajo = new Abajo();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,2)));
		Buque unBuque = new Buque(abajo,listaDeCasillas);
		tablero.ponerNave(unBuque);
		unBuque.mover();
		listaDeCasillas = unBuque.devolverUbicacion();
		
	}

}
