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

public class PortaAvionesTest extends TestCase {
	public void testCrearUnPortaAviones(){
		Movimiento arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		PortaAviones unPortaAviones  = new PortaAviones(arriba,listaDeCasillas);
		assertNotNull(unPortaAviones);
			
	}
	public void testCrearUnPortaAvionesNoEstaDestruido(){
		Movimiento arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		PortaAviones unPortaAviones  = new PortaAviones(arriba,listaDeCasillas);
		assertFalse(unPortaAviones.estaDestruido());
	}
	
	public void testCrearUnPortaAvionesYRecibirDisparoConvencionalNoLoDestruyePorCompleto(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		PortaAviones unPortaAviones  = new PortaAviones(arriba,listaDeCasillas);
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla1);
		unDisparo.agregarTurno(turno);
		unPortaAviones.recibirDisparo(unDisparo);
		assertFalse(unPortaAviones.estaDestruido());
	}
	
	public void testCrearUnPortaAvionesYRecibirDisparosConvencionalesDestruyePorCompleto(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		Casilla casilla3 = new Casilla(1,3);
		Casilla casilla4 = new Casilla(1,4);
		Casilla casilla5 = new Casilla(1,5);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		listaDeCasillas.add(casilla3);
		listaDeCasillas.add(casilla4);
		listaDeCasillas.add(casilla5);
		PortaAviones unPortaAviones  = new PortaAviones(arriba,listaDeCasillas);
		Turno turno = new Turno();
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
		Abajo abajo = new Abajo();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,2)));
		PortaAviones unPortaAviones  = new PortaAviones(abajo,listaDeCasillas);
		tablero.ponerNave(unPortaAviones);
		unPortaAviones.mover();
		listaDeCasillas = unPortaAviones.devolverCasillas();
		
	}

}
