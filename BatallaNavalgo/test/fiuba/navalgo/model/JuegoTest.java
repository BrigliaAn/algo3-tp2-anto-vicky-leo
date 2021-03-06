package fiuba.navalgo.model;

import java.util.ArrayList;

import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.direccion.Horizontal;
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
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(9,3);
		DiagonalAbajoDerecha movAbaDer = new DiagonalAbajoDerecha();
		Lancha unaLancha = new Lancha(movArriba,horizontal,posicion);
		tableroDeBatalla.ponerNave(unaLancha);
		
		Posicion posicion2 = new Posicion(6,3);
		Destructor unDestructor = new Destructor(movAbaDer, horizontal, posicion2);
		tableroDeBatalla.ponerNave(unDestructor);
		
		Posicion posicion3 = new Posicion(1,1);
		RompeHielos unRompehielos = new RompeHielos(movAbajo, horizontal, posicion3);
		tableroDeBatalla.ponerNave(unRompehielos);
		
		juegoNuevo.pasarTurno();
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unaLancha);
		
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = listaDeNaves.get(pos).getPorcionesDeNave();
		
		assertEquals(listaDePorciones.get(0).getCasilla(),tableroDeBatalla.devolverCasilla(new Posicion(8,3)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tableroDeBatalla.devolverCasilla(new Posicion(8,4)));
		
		listaDePorciones = listaDeNaves.get(pos+1).getPorcionesDeNave();
		assertEquals(listaDePorciones.get(0).getCasilla(),tableroDeBatalla.devolverCasilla(new Posicion(7,4)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tableroDeBatalla.devolverCasilla(new Posicion(7,5)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tableroDeBatalla.devolverCasilla(new Posicion(7,6)));
		
		listaDePorciones = listaDeNaves.get(pos+2).getPorcionesDeNave();
		assertEquals(listaDePorciones.get(0).getCasilla(),tableroDeBatalla.devolverCasilla(new Posicion(2,1)));
		assertEquals(listaDePorciones.get(1).getCasilla(),tableroDeBatalla.devolverCasilla(new Posicion(2,2)));
		assertEquals(listaDePorciones.get(2).getCasilla(),tableroDeBatalla.devolverCasilla(new Posicion(2,3)));
		
	
		
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
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(1,3);
		Lancha unaLancha = new Lancha(movArriba, horizontal, posicion);
		tableroDeBatalla.ponerNave(unaLancha);
		
		DisparoConvencional disparoDirecto = new DisparoConvencional();
		juegoNuevo.disparar(disparoDirecto, new Posicion(1,3));
		
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unaLancha);
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = listaDeNaves.get(pos).getPorcionesDeNave();
		int partesDestruidas =0;
		for(PorcionDeNave porcion: listaDePorciones){
			if(porcion.estaDestruida()){
				partesDestruidas= partesDestruidas +1;
			}
		}
			
		assertEquals(partesDestruidas,1);
		
	}
	  
	public void testLuegoDeTresTurnosDeberianExplotarLasMinas(){
		Juego juegoNuevo = new Juego();		
		Tablero unTablero = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(5,2);
		Lancha unaNave = new Lancha(movArriba, horizontal, posicion);
		unTablero.ponerNave(unaNave);
		
		MinaSubmarinaPuntual unaMinaSubmarinaPuntual = new MinaSubmarinaPuntual();
		juegoNuevo.disparar(unaMinaSubmarinaPuntual, new Posicion(2,3));
		
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		
		ArrayList<Nave> listaDeNaves = unTablero.verNaves();
	    int pos = listaDeNaves.lastIndexOf(unaNave);
	    ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = listaDeNaves.get(pos).getPorcionesDeNave();
		int partesDestruidas =0;
		for(PorcionDeNave porcion: listaDePorciones){
			if(porcion.estaDestruida()){
				partesDestruidas= partesDestruidas +1;
			}
		}
			
		assertEquals(partesDestruidas,1);
		
	}

	public void testSiUnaMinaSubmarinaDobleLeDaAUnaNaveSeDeberiaDestruirTodasLasPartesDondeEstaLaMina(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(5,3);
		PortaAviones unPortaAviones = new PortaAviones(movArriba, horizontal, posicion);
		tableroDeBatalla.ponerNave(unPortaAviones);
		
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		juegoNuevo.disparar(mina, new Posicion(2,4));
		
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unPortaAviones);
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = listaDeNaves.get(pos).getPorcionesDeNave();
		int partesDestruidas =0;
		for(PorcionDeNave porcion: listaDePorciones){
		
			if(porcion.estaDestruida()){
				partesDestruidas= partesDestruidas +1;
			}
		}
			
		assertEquals(partesDestruidas,3);
		
	}
	
	public void testSiUnaMinaSubmarinaTripleLeDaAUnaNaveSeDeberiaDestruirTodasLasPartesDondeEstaLaMina(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(5,3);
		PortaAviones unPortaAviones = new PortaAviones(movArriba, horizontal, posicion);
		tableroDeBatalla.ponerNave(unPortaAviones);
		
		MinaSubmarinaTriple mina = new MinaSubmarinaTriple();
		juegoNuevo.disparar(mina, new Posicion(2,4));
		
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unPortaAviones);
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = listaDeNaves.get(pos).getPorcionesDeNave();
		int partesDestruidas =0;
		for(PorcionDeNave porcion: listaDePorciones){
			if(porcion.estaDestruida()){
				partesDestruidas= partesDestruidas +1;
			}
		}
			
		assertEquals(partesDestruidas,4);
	}
	
	public void testSiUnaMinaSubmarinaLeDaAUnDestructorNoSeDeberiaDestruir(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(5,3); 
		Destructor unDestructor = new Destructor(movArriba, horizontal, posicion);
		tableroDeBatalla.ponerNave(unDestructor);
		
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		juegoNuevo.disparar(mina, new Posicion(2,4));

		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
	
		
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unDestructor);
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = listaDeNaves.get(pos).getPorcionesDeNave();
		int partesDestruidas =0;
		for(PorcionDeNave porcion: listaDePorciones){
			if(porcion.estaDestruida()){
				partesDestruidas= partesDestruidas +1;
			}
		}
			
		assertEquals(partesDestruidas,0);
	    assertFalse(listaDeNaves.get(pos).estaDestruido());
	 
	}
	
	public void testSiUnDisparoPuntualLeDaAUnDestructorSeDeberiaDestruir(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(5,3); 
		Destructor unDestructor = new Destructor(movArriba, horizontal, posicion);
		tableroDeBatalla.ponerNave(unDestructor);
		
		DisparoConvencional disparoDirecto = new DisparoConvencional();
		juegoNuevo.disparar(disparoDirecto, new Posicion(5,4));

	
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unDestructor);
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = listaDeNaves.get(pos).getPorcionesDeNave();
		int partesDestruidas =0;
		for(PorcionDeNave porcion: listaDePorciones){
			if(porcion.estaDestruida()){
				partesDestruidas= partesDestruidas +1;
			}
		}
			
		assertEquals(partesDestruidas,1);
	    assertFalse(listaDeNaves.get(pos).estaDestruido());

	}
	
	public void testSiUnDisparoLeDaAUnBuqueSeDeberiaDestruirCompletamente(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(5,3); 
		Buque unBuque = new Buque(movArriba, horizontal, posicion);
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
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(5,3); 
		RompeHielos unRompeHielos = new RompeHielos(movArriba, horizontal, posicion);
		tableroDeBatalla.ponerNave(unRompeHielos);
		
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		juegoNuevo.disparar(mina, new Posicion(2,4));

		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
		juegoNuevo.pasarTurno();
	
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unRompeHielos);
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = listaDeNaves.get(pos).getPorcionesDeNave();
		int partesDestruidas =0;
		for(PorcionDeNave porcion: listaDePorciones){
			if(porcion.estaDestruida()){
				partesDestruidas= partesDestruidas +1;
			}
		}
			
		assertEquals(partesDestruidas,0);
	   
	}
	
	public void testSiUnDisparoLeDaAUnRompeHielos2VecesSeDeberiaDestruir(){
		Juego juegoNuevo = new Juego();
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		Arriba movArriba = new Arriba();		
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(5,3); 
		RompeHielos unRompeHielos = new RompeHielos(movArriba, horizontal, posicion);
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
		Direccion horizontal = new Horizontal();
		Posicion posicion = new Posicion(5,3); 
		PortaAviones unPortaAviones = new PortaAviones(movArriba, horizontal, posicion);
		tableroDeBatalla.ponerNave(unPortaAviones);
		
		MinaSubmarinaPorContacto mina = new MinaSubmarinaPorContacto();
		juegoNuevo.disparar(mina, new Posicion(4,4));

		juegoNuevo.pasarTurno();
		ArrayList<Nave> listaDeNaves = tableroDeBatalla.verNaves();
		int pos = listaDeNaves.lastIndexOf(unPortaAviones);
		ArrayList<PorcionDeNave> listaDePorciones = new ArrayList<PorcionDeNave>();
		listaDePorciones = listaDeNaves.get(pos).getPorcionesDeNave();
		int partesDestruidas =0;
		for(PorcionDeNave porcion: listaDePorciones){
			if(porcion.estaDestruida()){
				partesDestruidas= partesDestruidas +1;
			}
		}
			
		assertEquals(partesDestruidas,1);
	    
	}

}
