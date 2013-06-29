package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.Turno;
import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.direccion.Horizontal;
import fiuba.navalgo.model.disparos.DisparoConvencional;
import fiuba.navalgo.model.movimiento.Abajo;
import fiuba.navalgo.model.movimiento.Arriba;
import fiuba.navalgo.model.movimiento.Movimiento;
import junit.framework.TestCase;

public class BuqueTest extends TestCase {
	public void testCrearUnBuque(){
		Movimiento arriba = new Arriba();
		Direccion direccion = new Horizontal();
		Posicion posicion = new Posicion(3,3);
		Buque unBuque = new Buque(arriba,direccion, posicion);
		assertNotNull(unBuque);
			
	}
	public void testCrearUnBuqueNoEstaDestruido(){
		Movimiento arriba = new Arriba();
		Direccion direccion = new Horizontal();
		Posicion posicion = new Posicion(3,3);
		Buque unBuque = new Buque(arriba,direccion, posicion);
		assertFalse(unBuque.estaDestruido());
	}
	
	public void testCrearUnBuqueYRecibirDisparoConvencionalLoDestruyePorCompleto(){
		Movimiento arriba = new Arriba();
		Direccion direccion = new Horizontal();
		Posicion posicion = new Posicion(3,3);
		Buque unBuque = new Buque(arriba,direccion, posicion);
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		Tablero tablero = Tablero.getInstance();
		Casilla casilla = tablero.devolverCasilla(new Posicion(3,3));
		unDisparo.agregarCasilla(casilla);
		unDisparo.agregarTurno(turno);
		unBuque.recibirDisparo(unDisparo);
		assertTrue(unBuque.estaDestruido());
	}
	

	public void testMoverUnBuque(){
		Tablero tablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,2)));
		Movimiento arriba = new Abajo();
		Direccion direccion = new Horizontal();
		Posicion posicion = new Posicion(2,1);
		Buque unBuque = new Buque(arriba,direccion, posicion);
		unBuque.mover();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = unBuque.getPorcionesDeNave();
		
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(3,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(3,2)));
	}

}
