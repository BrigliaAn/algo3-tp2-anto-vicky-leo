package fiuba.navalgo.model.naves;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.Turno;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.*;
import java.util.ArrayList;
import junit.framework.TestCase;

public class LanchaTest extends TestCase{
	
	public void testCrearUnaLanchaNueva(){
		Movimiento arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		Lancha unaLancha = new Lancha(arriba,listaDeCasillas);
		assertNotNull(unaLancha);
			
	}
	public void testCrearUnaLanchaNuevaNoEstaDestruida(){
		Movimiento arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		Lancha unaLancha = new Lancha(arriba,listaDeCasillas);
		assertFalse(unaLancha.estaDestruido());
	}
	
	public void testCrearUnaLanchaYRecibirDisparoConvencionalNoLaDestruyePorCompleto(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		Lancha unaLancha = new Lancha(arriba,listaDeCasillas);
		Turno turno = new Turno();
		DisparoConvencional unDisparo = new DisparoConvencional();
		unDisparo.agregarCasilla(casilla1);
		unDisparo.agregarTurno(turno);
		unaLancha.recibirDisparo(unDisparo);
		assertFalse(unaLancha.estaDestruido());
	}
	
	
	public void testCrearUnaLanchaYRecibirDosDisparosConvencionalesDestruyePorCompleto(){
		Arriba arriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		Casilla casilla1 = new Casilla(1,1);
		Casilla casilla2 = new Casilla(1,2);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		Lancha unaLancha = new Lancha(arriba,listaDeCasillas);
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
		Abajo abajo = new Abajo();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,1)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,2)));
		Lancha unaLancha = new Lancha(abajo, listaDeCasillas);
		tablero.ponerNave(unaLancha);
		unaLancha.mover();
		listaDeCasillas = unaLancha.devolverCasillas();
		
	}
	
}
