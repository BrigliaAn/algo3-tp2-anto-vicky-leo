package fiuba.navalgo.model;

import java.util.ArrayList;

import fiuba.navalgo.model.disparos.*;
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
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(9,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(9,4)));
		
		Lancha unaLancha = new Lancha(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unaLancha);
		
		listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(6,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(7,4)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(8,5)));
		
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
		int pos = listaDeNaves.lastIndexOf(unaLancha);
	    listaDeCasillas = listaDeNaves.get(pos).devolverUbicacion();
		assertEquals(listaDeCasillas.get(0),tableroDeBatalla.devolverCasilla(new Posicion(8,3)));
		assertEquals(listaDeCasillas.get(1),tableroDeBatalla.devolverCasilla(new Posicion(8,4)));
	
		listaDeCasillas = listaDeNaves.get(pos+1).devolverUbicacion();
		assertEquals(listaDeCasillas.get(0),tableroDeBatalla.devolverCasilla(new Posicion(7,4)));
		assertEquals(listaDeCasillas.get(1),tableroDeBatalla.devolverCasilla(new Posicion(8,5)));
		assertEquals(listaDeCasillas.get(2),tableroDeBatalla.devolverCasilla(new Posicion(9,6)));
		
		listaDeCasillas = listaDeNaves.get(pos+2).devolverUbicacion();
		assertTrue(listaDeCasillas.contains(tableroDeBatalla.devolverCasilla(new Posicion(7,5))));
		assertTrue(listaDeCasillas.contains(tableroDeBatalla.devolverCasilla(new Posicion(8,5))));
		assertTrue(listaDeCasillas.contains(tableroDeBatalla.devolverCasilla(new Posicion(9,5))));
		
	}
	
	public void testDispararDeberiaRestarElPuntajeDependiendoDelDisparo(){
		Juego juegoNuevo = new Juego();
		DisparoConvencional disparoDirecto = new DisparoConvencional();
		juegoNuevo.disparar(disparoDirecto, new Posicion(2,3));
		
		assertEquals(juegoNuevo.verPuntajeActual(),9800);
	}
	
	public void testSiUnDisparoDirectoLeDaAUnaNaveSeDeberiaDestruirEsaParte(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(1,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(1,4)));
		
		Lancha unaLancha = new Lancha(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unaLancha);
		
		DisparoConvencional disparoDirecto = new DisparoConvencional();
		juegoNuevo.disparar(disparoDirecto, new Posicion(1,3));
		
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unaLancha);
	    listaDeCasillas = listaDeNaves.get(pos).devolverUbicacion();
	
		assertEquals(listaDeCasillas.size(),1);
		
	}
	  
	public void testLuegoDeTresTurnosDeberianExplotarLasMinas(){
		Juego juegoNuevo = new Juego();		
		Tablero unTablero = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(unTablero.devolverCasilla(new Posicion(5,2)));
		listaDeCasillas.add(unTablero.devolverCasilla(new Posicion(5,3)));
		Lancha unaNave = new Lancha(movArriba, listaDeCasillas);
		unTablero.ponerNave(unaNave);
		
		MinaSubmarinaPuntual unaMinaSubmarinaPuntual = new MinaSubmarinaPuntual();
		juegoNuevo.disparar(unaMinaSubmarinaPuntual, new Posicion(2,3));
		
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		
		ArrayList<Nave> listaDeNaves = unTablero.verNaves();
	    int pos = listaDeNaves.lastIndexOf(unaNave);
	    listaDeCasillas = listaDeNaves.get(pos).devolverUbicacion(); 
	    assertEquals(listaDeCasillas.size(),1);
		
	}

	public void testSiUnaMinaSubmarinaDobleLeDaAUnaNaveSeDeberiaDestruirTodasLasPartesDondeEstaLaMina(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,4)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,5)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,6)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,7)));
		
		PortaAviones unPortaAviones = new PortaAviones(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unPortaAviones);
		
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		juegoNuevo.disparar(mina, new Posicion(2,4));
		
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unPortaAviones);
	    listaDeCasillas = listaDeNaves.get(pos).devolverUbicacion();
	
		assertEquals(listaDeCasillas.size(),2);
		
	}
	
	public void testSiUnaMinaSubmarinaTripleLeDaAUnaNaveSeDeberiaDestruirTodasLasPartesDondeEstaLaMina(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,4)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,5)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,6)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,7)));
		
		PortaAviones unPortaAviones = new PortaAviones(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unPortaAviones);
		
		MinaSubmarinaTriple mina = new MinaSubmarinaTriple();
		juegoNuevo.disparar(mina, new Posicion(2,4));
		
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unPortaAviones);
	    listaDeCasillas = listaDeNaves.get(pos).devolverUbicacion();
	
		assertEquals(listaDeCasillas.size(),1);
	}
	
	public void testSiUnaMinaSubmarinaLeDaAUnDestructorNoSeDeberiaDestruir(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,4)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,5)));
		
		Destructor unDestructor = new Destructor(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unDestructor);
		
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		juegoNuevo.disparar(mina, new Posicion(2,4));

		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
	
		
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unDestructor);
	    listaDeCasillas = listaDeNaves.get(pos).devolverUbicacion();
	 
	    assertFalse(listaDeNaves.get(pos).estaDestruido());
	    assertEquals(listaDeCasillas.size(),3);
	}
	
	public void testSiUnDisparoPuntualLeDaAUnDestructorSeDeberiaDestruir(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,4)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,5)));
		
		Destructor unDestructor = new Destructor(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unDestructor);
		
		DisparoConvencional disparoDirecto = new DisparoConvencional();
		juegoNuevo.disparar(disparoDirecto, new Posicion(5,4));

	
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unDestructor);
	    listaDeCasillas = listaDeNaves.get(pos).devolverUbicacion();
	 
	    assertFalse(listaDeNaves.get(pos).estaDestruido());
	    assertEquals(listaDeCasillas.size(),2);
	}
	
	public void testSiUnDisparoLeDaAUnBuqueSeDeberiaDestruirCompletamente(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,4)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,5)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,6)));
		
		Buque unBuque = new Buque(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unBuque);
		
		DisparoConvencional disparoDirecto = new DisparoConvencional();
		juegoNuevo.disparar(disparoDirecto, new Posicion(5,4));

	
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
	    	 
	    assertFalse(listaDeNaves.contains(unBuque));
	   
	}
	
	public void testSiUnDisparoLeDaAUnRompeHielosNoSeDeberiaDestruir(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,4)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,5)));
		
		RompeHielos unRompeHielos = new RompeHielos(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unRompeHielos);
		
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		juegoNuevo.disparar(mina, new Posicion(2,4));

		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
	
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unRompeHielos);
	    listaDeCasillas = listaDeNaves.get(pos).devolverUbicacion();
	    
	    assertEquals(listaDeCasillas.size(),3);
	   
	}
	
	public void testSiUnDisparoLeDaAUnRompeHielos2VecesSeDeberiaDestruir(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,4)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,5)));
		
		RompeHielos unRompeHielos = new RompeHielos(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unRompeHielos);
		
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		juegoNuevo.disparar(mina, new Posicion(2,4));
		MinaSubmarinaDoble mina2 = new MinaSubmarinaDoble();
		juegoNuevo.disparar(mina2, new Posicion(2,4));
		
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
	
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		    
	    assertFalse(listaDeNaves.contains(unRompeHielos));
	}
	
	public void testUnaMinaSubmarinaPuntualDeberiaExplotarCuandoUnaNaveEsteSobreElla(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,3)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,4)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,5)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,6)));
		listaDeCasillas.add(tableroDeBatalla.devolverCasilla(new Posicion(5,7)));
		
		PortaAviones unPortaAviones = new PortaAviones(movArriba,listaDeCasillas);
		tableroDeBatalla.ponerNave(unPortaAviones);
		
		MinaSubmarinaPorContacto mina = new MinaSubmarinaPorContacto();
		juegoNuevo.disparar(mina, new Posicion(4,4));

		juegoNuevo.pasarTurno();
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unPortaAviones);
	    listaDeCasillas = listaDeNaves.get(pos).devolverUbicacion();
	    
	    assertEquals(listaDeCasillas.size(),4);
	}

}
