package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.Turno;
import fiuba.navalgo.model.disparos.DisparoConvencional;
import fiuba.navalgo.model.movimiento.*;
import junit.framework.TestCase;

public class RompeHielosTest extends TestCase {
	public void testCrearUnRompeHielos(){
		Movimiento arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		RompeHielos unRompeHielos  = new RompeHielos(arriba,listaDeCasillas);
		assertNotNull(unRompeHielos);
			
	}
	public void testCrearUnRompeHielosNoEstaDestruido(){
		Movimiento arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		RompeHielos unRompeHielos  = new RompeHielos(arriba,listaDeCasillas);
		assertFalse(unRompeHielos.estaDestruido());
	}
	
	public void testCrearUnRompeHielosYRecibirDisparoConvencionalNoLoDestruyePorCompleto(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		Casilla casilla3 = new Casilla(1,3);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		listaDeCasillas.add(casilla3);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		listaDeCasillas.add(casilla3);
		RompeHielos unRompeHielos  = new RompeHielos(arriba,listaDeCasillas);
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla1);
		unDisparo.agregarTurno(turno);
		unRompeHielos.recibirDisparo(unDisparo);
		assertFalse(unRompeHielos.estaDestruido());
	}
	
	public void testCrearUnRompeHielosYRecibirDisparosConvencionalesDestruyePorCompleto(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		Casilla casilla3 = new Casilla(1,3);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		listaDeCasillas.add(casilla3);
		RompeHielos unRompeHielos  = new RompeHielos(arriba,listaDeCasillas);
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
		Abajo abajo = new Abajo();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,2)));
		RompeHielos unRompeHielos  = new RompeHielos(abajo,listaDeCasillas);
		tablero.ponerNave(unRompeHielos);
		unRompeHielos.mover();
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = unRompeHielos.getPorcionesDeNave();
		
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(3,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(3,2)));
		
	}
}
