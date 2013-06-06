package fiuba.navalgo.model;

import java.util.ArrayList;

import fiuba.navalgo.model.disparos.DisparoConvencional;
import fiuba.navalgo.model.movimiento.*;
import fiuba.navalgo.model.naves.*;
import junit.framework.TestCase;

public class JuegoTest extends TestCase {
	
	public void testCrearUnJuegoDeberiaCrearloConPuntajeInicialYTurno1(){
		Juego juegoNuevo = new Juego();
		
		assertEquals(juegoNuevo.verPuntajeActual(),10000);
		assertEquals(juegoNuevo.devolverTurnoActual(),1);
	}
	
	public void testVerPuntajeActualDeberiaDevolverElPuntajeActual(){
		
		Juego juegoNuevo = new Juego();
		assertEquals(juegoNuevo.verPuntajeActual(),10000);
		
	}
	
	public void testDevolverTurnoActualDeberiaDevolverElTurnoEnQueSeEncuentraElJugador(){
		
		Juego juegoNuevo = new Juego();
		assertEquals(juegoNuevo.devolverTurnoActual(),1);
		
	}

	public void testPasarTurnoDeberiaAumentarUnoAlTurno(){
		Juego juegoNuevo = new Juego();
		juegoNuevo.pasarTurno();
		
		assertEquals(juegoNuevo.devolverTurnoActual(),2);
	}

	public void testPasarTurnoDeberiaRestar10PuntosAlPuntaje(){
		Juego juegoNuevo = new Juego();
		juegoNuevo.pasarTurno();
		assertEquals(juegoNuevo.verPuntajeActual(),9990);
	}

	public void testPasarTurnoDeberiaMoverLasNaves(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();
		Abajo movAbajo = new Abajo();
		DiagonalAbajoDerecha movAbaDer = new DiagonalAbajoDerecha();
		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(2,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(2,4)));
		
		Lancha unaLancha = new Lancha(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unaLancha);
		
		listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(4,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,4)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(6,5)));
		
		Destructor unDestructor = new Destructor(movAbaDer, listaDeCasillas);
		tableroDeBatalla.ponerNave(unDestructor);
		
		listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(6,5)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(7,5)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(8,5)));
		
		RompeHielos unRompehielos = new RompeHielos(movAbajo, listaDeCasillas);
		tableroDeBatalla.ponerNave(unRompehielos);
		
		juegoNuevo.pasarTurno();
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
	    listaDeCasillas = listaDeNaves.get(0).devolverUbicacion();
		assertEquals(listaDeCasillas.get(0),tableroDeBatalla.devolverCasilla(new Posicion(1,3)));
		assertEquals(listaDeCasillas.get(1),tableroDeBatalla.devolverCasilla(new Posicion(1,4)));
		
		listaDeCasillas = listaDeNaves.get(1).devolverUbicacion();
		assertEquals(listaDeCasillas.get(0),tableroDeBatalla.devolverCasilla(new Posicion(5,4)));
		assertEquals(listaDeCasillas.get(1),tableroDeBatalla.devolverCasilla(new Posicion(6,5)));
		assertEquals(listaDeCasillas.get(2),tableroDeBatalla.devolverCasilla(new Posicion(7,6)));
		
		listaDeCasillas = listaDeNaves.get(2).devolverUbicacion();
		assertEquals(listaDeCasillas.get(0),tableroDeBatalla.devolverCasilla(new Posicion(7,5)));
		assertEquals(listaDeCasillas.get(1),tableroDeBatalla.devolverCasilla(new Posicion(8,5)));
		assertEquals(listaDeCasillas.get(2),tableroDeBatalla.devolverCasilla(new Posicion(9,5)));
		
	}
	
	public void testPasarTurnoDeberianExplotarLasMinasQueEstenListasParaExplotar(){
		Juego juegoNuevo = new Juego();
		juegoNuevo.pasarTurno();
		
		//testar en tablero
	}
	
	public void testDispararDeberiaDispararseEnElCasoQueEsteListoOGuardarseEnCasoContrario(){
		
	} //tester en tablero
	
	public void testDispararDeberiaRestarElPuntajeDependiendoDelDisparo(){
		Juego juegoNuevo = new Juego();
		//DisparoConvencional disparoDirecto = new DisparoConvencional();
		//juegoNuevo.disparar(disparoDirecto);
		
		assertEquals(juegoNuevo.verPuntajeActual(),9800);
	}
	
	  
}
