package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.Turno;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.Abajo;
import fiuba.navalgo.model.movimiento.Arriba;
import fiuba.navalgo.model.movimiento.Movimiento;
import junit.framework.TestCase;

public class DestructorTest extends TestCase {
	public void testCrearDestructor(){
		Movimiento arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		Destructor unDestructor = new Destructor(arriba,listaDeCasillas);
		assertNotNull(unDestructor);
			
	}
	public void testCrearUnDestructorNuevoNoEstaDestruida(){
		Movimiento arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		Destructor unDestructor = new Destructor(arriba,listaDeCasillas);
		assertFalse(unDestructor.estaDestruido());
	}
	
	public void testCrearUnDestructorYRecibirDisparoConvencionalNoLoDestruyePorCompleto(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		Destructor unDestructor = new Destructor(arriba,listaDeCasillas);
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla1);
		unDisparo.agregarTurno(turno);
		unDestructor.recibirDisparo(unDisparo);
		assertFalse(unDestructor.estaDestruido());
	}
	
	
	public void testCrearUnDestructorYDestrurloConDisparosConvencionales(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		Casilla casilla3 = new Casilla(1,3);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		listaDeCasillas.add(casilla3);
		Destructor unDestructor = new Destructor(arriba,listaDeCasillas);
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
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		Casilla casilla3 = new Casilla(1,3);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		listaDeCasillas.add(casilla3);
		Destructor unDestructor = new Destructor(arriba,listaDeCasillas);
		Turno turno = new Turno();
		MinaSubmarinaPuntual mina = new MinaSubmarinaPuntual();
		mina.agregarCasilla(casilla1);
		mina.agregarTurno(turno);
		unDestructor.recibirDisparo(mina);
		assertFalse(unDestructor.estaDestruido());
		assertTrue((unDestructor.devolverUbicacion().size())==3);
	}
	
	public void testCrearUnDestructorYRecibirDisparoDeMinaPorContactoNoLoDania(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		Casilla casilla3 = new Casilla(1,3);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		listaDeCasillas.add(casilla3);
		Destructor unDestructor = new Destructor(arriba,listaDeCasillas);
		Turno turno = new Turno();
		MinaSubmarinaPorContacto mina = new MinaSubmarinaPorContacto();
		mina.agregarCasilla(casilla1);
		mina.agregarTurno(turno);
		unDestructor.recibirDisparo(mina);
		assertFalse(unDestructor.estaDestruido());
		assertTrue((unDestructor.devolverUbicacion().size())==3);
	}
	
	public void testCrearUnDestructorYRecibirDisparoDeMinaDobleNoLoDania(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		Casilla casilla3 = new Casilla(1,3);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		listaDeCasillas.add(casilla3);
		Destructor unDestructor = new Destructor(arriba,listaDeCasillas);
		Turno turno = new Turno();
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		mina.agregarCasilla(casilla1);
		mina.agregarTurno(turno);
		unDestructor.recibirDisparo(mina);
		assertFalse(unDestructor.estaDestruido());
		assertTrue((unDestructor.devolverUbicacion().size())==3);
	}
	
	public void testMoverDestructor(){
		Tablero tablero = Tablero.getInstance();
		Abajo abajo = new Abajo();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,2)));
		Destructor unDestructor = new Destructor(abajo,listaDeCasillas);
		tablero.ponerNave(unDestructor);
		unDestructor.mover();
		listaDeCasillas = unDestructor.devolverUbicacion();
		
	}

}
