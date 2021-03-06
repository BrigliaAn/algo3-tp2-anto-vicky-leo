package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.Turno;
import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.direccion.Horizontal;
import fiuba.navalgo.model.disparos.DisparoConvencional;
import fiuba.navalgo.model.movimiento.*;
import junit.framework.TestCase;

public class RompeHielosTest extends TestCase {
	public void testCrearUnRompeHielos(){
		Movimiento arriba = new Arriba();
		Direccion horizontal = new Horizontal();
		RompeHielos unRompeHielos  = new RompeHielos(arriba,horizontal,new Posicion(3,3));
		assertNotNull(unRompeHielos);
			
	}
	public void testCrearUnRompeHielosNoEstaDestruido(){
		Movimiento arriba = new Arriba();
		Direccion horizontal = new Horizontal();
		RompeHielos unRompeHielos  = new RompeHielos(arriba,horizontal,new Posicion(3,3));
		assertNotNull(unRompeHielos);
		assertFalse(unRompeHielos.estaDestruido());
	}
	
	public void testCrearUnRompeHielosYRecibirDisparoConvencionalNoLoDestruyePorCompleto(){
		Movimiento arriba = new Arriba();
		Direccion horizontal = new Horizontal();
		RompeHielos unRompeHielos  = new RompeHielos(arriba,horizontal,new Posicion(3,3));
		assertNotNull(unRompeHielos);
		Tablero tablero = Tablero.getInstance();
		Casilla casilla = tablero.devolverCasilla(new Posicion(3,4));
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla);
		unDisparo.agregarTurno(turno);
		unRompeHielos.recibirDisparo(unDisparo);
		assertFalse(unRompeHielos.estaDestruido());
	}
	
	public void testCrearUnRompeHielosYRecibirDisparosConvencionalesDestruyePorCompleto(){
		Movimiento arriba = new Arriba();
		Direccion horizontal = new Horizontal();
		RompeHielos unRompeHielos  = new RompeHielos(arriba,horizontal,new Posicion(3,3));
		assertNotNull(unRompeHielos);
		Tablero tablero = Tablero.getInstance();
		Casilla casilla1 = tablero.devolverCasilla(new Posicion(3,3));
		Casilla casilla2 = tablero.devolverCasilla(new Posicion(3,4));
		Casilla casilla3 = tablero.devolverCasilla(new Posicion(3,5));
		Turno turno = new Turno();
		DisparoConvencional disparo1 = new DisparoConvencional();
		disparo1.agregarCasilla(casilla1);
		disparo1.agregarTurno(turno);
		unRompeHielos.recibirDisparo(disparo1);
		assertFalse(unRompeHielos.estaDestruido());
		DisparoConvencional disparo2 = new DisparoConvencional();
		disparo2.agregarCasilla(casilla2);
		disparo2.agregarTurno(turno);
		unRompeHielos.recibirDisparo(disparo2);
		DisparoConvencional disparo3= new DisparoConvencional();
		disparo3.agregarCasilla(casilla3);
		disparo3.agregarTurno(turno);
		unRompeHielos.recibirDisparo(disparo3);
		assertFalse(unRompeHielos.estaDestruido());
		DisparoConvencional disparo4 = new DisparoConvencional();
		disparo4.agregarCasilla(casilla1);
		disparo4.agregarTurno(turno);
		unRompeHielos.recibirDisparo(disparo4);
		DisparoConvencional disparo5 = new DisparoConvencional();
		disparo5.agregarCasilla(casilla2);
		disparo5.agregarTurno(turno);
		unRompeHielos.recibirDisparo(disparo5);
		DisparoConvencional disparo6= new DisparoConvencional();
		disparo6.agregarCasilla(casilla3);
		disparo6.agregarTurno(turno);
		unRompeHielos.recibirDisparo(disparo6);
		assertTrue(unRompeHielos.estaDestruido());
	}
	
	public void testMoverUnaLancha(){
		Tablero tablero = Tablero.getInstance();
		Movimiento arriba = new Arriba();
		Direccion horizontal = new Horizontal();
		RompeHielos unRompeHielos  = new RompeHielos(arriba,horizontal,new Posicion(3,3));
		assertNotNull(unRompeHielos);
		tablero.ponerNave(unRompeHielos);
		unRompeHielos.mover();
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = unRompeHielos.getPorcionesDeNave();
		
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(2,3)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(2,4)));
		
	}
}
