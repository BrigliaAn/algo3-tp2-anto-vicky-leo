package fiuba.navalgo.model.naves;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.Turno;
import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.direccion.Vertical;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.*;
import java.util.ArrayList;
import junit.framework.TestCase;

public class LanchaTest extends TestCase{
	
	public void testCrearUnaLanchaNueva(){
		Movimiento arriba = new Arriba();
		Direccion direccion = new Vertical();
		Posicion posicion = new Posicion(4,4);
		Lancha unaLancha = new Lancha(arriba, direccion, posicion);
		assertNotNull(unaLancha);
			
	}
	public void testCrearUnaLanchaNuevaNoEstaDestruida(){
		Movimiento arriba = new Arriba();
		Direccion direccion = new Vertical();
		Posicion posicion = new Posicion(4,4);
		Lancha unaLancha = new Lancha(arriba, direccion, posicion);
		assertFalse(unaLancha.estaDestruido());
	}
	
	public void testCrearUnaLanchaYRecibirDisparoConvencionalNoLaDestruyePorCompleto(){
		Movimiento arriba = new Arriba();
		Direccion direccion = new Vertical();
		Posicion posicion = new Posicion(4,4);
		Lancha unaLancha = new Lancha(arriba, direccion, posicion);
		Tablero tablero = Tablero.getInstance();
		Casilla casilla = tablero.devolverCasilla(new Posicion(4,4));
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla);
		unDisparo.agregarTurno(turno);
		unaLancha.recibirDisparo(unDisparo);
		assertFalse(unaLancha.estaDestruido());
	}
	
	
	public void testCrearUnaLanchaYRecibirDosDisparosConvencionalesDestruyePorCompleto(){
		Movimiento arriba = new Arriba();
		Direccion direccion = new Vertical();
		Posicion posicion = new Posicion(4,4);
		Lancha unaLancha = new Lancha(arriba, direccion, posicion);
		Tablero tablero = Tablero.getInstance();
		Casilla casilla1 = tablero.devolverCasilla(new Posicion(4,4));
		Casilla casilla2 = tablero.devolverCasilla(new Posicion(5,4));
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla1);
		unDisparo.agregarTurno(turno);
		unaLancha.recibirDisparo(unDisparo);
		DisparoConvencional otroDisparo = new DisparoConvencional();
		otroDisparo.agregarCasilla(casilla2);
		otroDisparo.agregarTurno(turno);
		unaLancha.recibirDisparo(otroDisparo);
		assertTrue(unaLancha.estaDestruido());
	}
	
	public void testMoverUnaLancha(){
		Tablero tablero = Tablero.getInstance();
		Movimiento arriba = new Arriba();
		Direccion direccion = new Vertical();
		Posicion posicion = new Posicion(4,4);
		Lancha unaLancha = new Lancha(arriba, direccion, posicion);
		tablero.ponerNave(unaLancha);
		unaLancha.mover();
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = unaLancha.getPorcionesDeNave();
		
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(3,4)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(4,4)));
		
	}
	
}
