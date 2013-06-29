package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.Turno;
import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.direccion.Horizontal;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.Arriba;
import fiuba.navalgo.model.movimiento.Derecha;
import fiuba.navalgo.model.movimiento.Movimiento;
import junit.framework.TestCase;

public class DestructorTest extends TestCase {
	public void testCrearDestructor(){
		Movimiento arriba = new Arriba();
		Posicion posicion = new Posicion(3,5);
		Direccion direccion = new Horizontal();
		Destructor unDestructor = new Destructor(arriba, direccion, posicion);
		assertNotNull(unDestructor);
			
	}
	public void testCrearUnDestructorNuevoNoEstaDestruida(){
		Movimiento arriba = new Arriba();
		Posicion posicion = new Posicion(3,5);
		Direccion direccion = new Horizontal();
		Destructor unDestructor = new Destructor(arriba, direccion, posicion);
		assertFalse(unDestructor.estaDestruido());
	}
	
	public void testCrearUnDestructorYRecibirDisparoConvencionalNoLoDestruyePorCompleto(){
		Movimiento arriba = new Arriba();
		Posicion posicion = new Posicion(1,1);
		Direccion direccion = new Horizontal();
		Destructor unDestructor = new Destructor(arriba, direccion, posicion);;
		Tablero tablero = Tablero.getInstance();
		Casilla casilla = tablero.devolverCasilla(new Posicion(1,1));
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla);
		unDisparo.agregarTurno(turno);
		unDestructor.recibirDisparo(unDisparo);
		assertFalse(unDestructor.estaDestruido());
	}
	
	
	public void testCrearUnDestructorYDestrurloConDisparosConvencionales(){
		Movimiento arriba = new Arriba();
		Posicion posicion = new Posicion(1,1);
		Direccion direccion = new Horizontal();
		Destructor unDestructor = new Destructor(arriba, direccion, posicion);;
		Tablero tablero = Tablero.getInstance();
		Casilla casilla1 = tablero.devolverCasilla(new Posicion(1,1));
		Casilla casilla2 = tablero.devolverCasilla(new Posicion(1,2));
		Casilla casilla3 = tablero.devolverCasilla(new Posicion(1,3));
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla1);
		unDisparo.agregarTurno(turno);
		unDestructor.recibirDisparo(unDisparo);
		unDisparo.agregarCasilla(casilla2);
		unDestructor.recibirDisparo(unDisparo);
		unDisparo.agregarCasilla(casilla3);
		unDestructor.recibirDisparo(unDisparo);
		assertTrue(unDestructor.estaDestruido());
	}

	public void testCrearUnDestructorYRecibirDisparoDeMinaPuntualNoLoDania(){
		Movimiento arriba = new Arriba();
		Posicion posicion = new Posicion(1,1);
		Direccion direccion = new Horizontal();
		Destructor unDestructor = new Destructor(arriba, direccion, posicion);;
		Tablero tablero = Tablero.getInstance();
		Casilla casilla1 = tablero.devolverCasilla(new Posicion(1,1));
		Turno turno = new Turno();
		MinaSubmarinaPuntual mina = new MinaSubmarinaPuntual();
		mina.agregarCasilla(casilla1);
		mina.agregarTurno(turno);
		unDestructor.recibirDisparo(mina);
		assertFalse(unDestructor.estaDestruido());

	}
	
	public void testCrearUnDestructorYRecibirDisparoDeMinaPorContactoNoLoDania(){
		Movimiento arriba = new Arriba();
		Posicion posicion = new Posicion(1,1);
		Direccion direccion = new Horizontal();
		Destructor unDestructor = new Destructor(arriba, direccion, posicion);;
		Tablero tablero = Tablero.getInstance();
		Casilla casilla1 = tablero.devolverCasilla(new Posicion(1,1));
		Turno turno = new Turno();
		MinaSubmarinaPorContacto mina = new MinaSubmarinaPorContacto();
		mina.agregarCasilla(casilla1);
		mina.agregarTurno(turno);
		unDestructor.recibirDisparo(mina);
		assertFalse(unDestructor.estaDestruido());

	}
	
	public void testCrearUnDestructorYRecibirDisparoDeMinaDobleNoLoDania(){
		Movimiento arriba = new Arriba();
		Posicion posicion = new Posicion(1,1);
		Direccion direccion = new Horizontal();
		Destructor unDestructor = new Destructor(arriba, direccion, posicion);;
		Tablero tablero = Tablero.getInstance();
		Casilla casilla1 = tablero.devolverCasilla(new Posicion(1,1));
		Turno turno = new Turno();
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		mina.agregarCasilla(casilla1);
		mina.agregarTurno(turno);
		
		unDestructor.recibirDisparo(mina);
		assertFalse(unDestructor.estaDestruido());

	}
	
	public void testMoverDestructor(){
		Tablero tablero = Tablero.getInstance();
		Movimiento arriba = new Derecha();
		Posicion posicion = new Posicion(2,2);
		Direccion direccion = new Horizontal();
		Destructor unDestructor = new Destructor(arriba, direccion, posicion);;
		tablero.ponerNave(unDestructor);
		unDestructor.mover();
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = unDestructor.getPorcionesDeNave();
		
		assertEquals(listaDePorciones.get(0).getCasilla(),tablero.devolverCasilla(new Posicion(2,3)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tablero.devolverCasilla(new Posicion(2,4)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tablero.devolverCasilla(new Posicion(2,5)));
	}

}
