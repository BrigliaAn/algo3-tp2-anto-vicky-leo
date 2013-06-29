package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.Turno;
import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.direccion.Vertical;
import fiuba.navalgo.model.disparos.DisparoConvencional;
import fiuba.navalgo.model.movimiento.Izquierda;
import fiuba.navalgo.model.movimiento.Movimiento;
import junit.framework.TestCase;

public class PortaAvionesTest extends TestCase {
	public void testCrearUnPortaAviones(){
		Movimiento arriba = new Izquierda();
		Direccion vertical = new Vertical();
		Posicion posicion = new Posicion(3,4);
		PortaAviones unPortaAviones  = new PortaAviones(arriba, vertical, posicion);
		assertNotNull(unPortaAviones);
			
	}
	public void testCrearUnPortaAvionesNoEstaDestruido(){
		Movimiento arriba = new Izquierda();
		Direccion vertical = new Vertical();
		Posicion posicion = new Posicion(3,4);
		PortaAviones unPortaAviones  = new PortaAviones(arriba, vertical, posicion);
		assertFalse(unPortaAviones.estaDestruido());
	}
	
	public void testCrearUnPortaAvionesYRecibirDisparoConvencionalNoLoDestruyePorCompleto(){
		Movimiento arriba = new Izquierda();
		Direccion vertical = new Vertical();
		Posicion posicion = new Posicion(3,4);
		PortaAviones unPortaAviones  = new PortaAviones(arriba, vertical, posicion);
		Tablero tablero = Tablero.getInstance();
		Casilla casilla = tablero.devolverCasilla(new Posicion(3,4));
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla);
		unDisparo.agregarTurno(turno);
		unPortaAviones.recibirDisparo(unDisparo);
		assertFalse(unPortaAviones.estaDestruido());
	}
	
	public void testCrearUnPortaAvionesYRecibirDisparosConvencionalesDestruyePorCompleto(){
		Movimiento arriba = new Izquierda();
		Direccion vertical = new Vertical();
		Posicion posicion = new Posicion(3,4);
		PortaAviones unPortaAviones  = new PortaAviones(arriba, vertical, posicion);
		Turno turno = new Turno();
		Tablero tablero = Tablero.getInstance();
		Casilla casilla1 = tablero.devolverCasilla(new Posicion(3,4));
		Casilla casilla2 = tablero.devolverCasilla(new Posicion(4,4));
		Casilla casilla3 = tablero.devolverCasilla(new Posicion(5,4));
		Casilla casilla4 = tablero.devolverCasilla(new Posicion(6,4));
		Casilla casilla5 = tablero.devolverCasilla(new Posicion(7,4));
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla1);
		unDisparo.agregarTurno(turno);
		unPortaAviones.recibirDisparo(unDisparo);
		DisparoConvencional otroDisparo = new DisparoConvencional();
		otroDisparo.agregarCasilla(casilla2);
		otroDisparo.agregarTurno(turno);
		unPortaAviones.recibirDisparo(otroDisparo);
		otroDisparo.agregarCasilla(casilla3);
		unPortaAviones.recibirDisparo(otroDisparo);
		otroDisparo.agregarCasilla(casilla4);
		unPortaAviones.recibirDisparo(otroDisparo);
		otroDisparo.agregarCasilla(casilla5);
		unPortaAviones.recibirDisparo(otroDisparo);
		assertTrue(unPortaAviones.estaDestruido());
	}
	
	public void testMoverUnaLancha(){
		Tablero tablero = Tablero.getInstance();
		Movimiento arriba = new Izquierda();
		Direccion vertical = new Vertical();
		Posicion posicion = new Posicion(3,4);
		PortaAviones unPortaAviones  = new PortaAviones(arriba, vertical, posicion);
		tablero.ponerNave(unPortaAviones);
		unPortaAviones.mover();
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = unPortaAviones.getPorcionesDeNave();
		
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(3,3)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(4,3)));
	}

}
