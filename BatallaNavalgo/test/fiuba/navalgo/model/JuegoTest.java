package fiuba.navalgo.model;

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
		juegoNuevo.pasarTurno();
		
		//assertEquals();
	}
	
	public void testPasarTurnoDeberianExplotarLasMinasQueEstenListasParaExplotar(){
		Juego juegoNuevo = new Juego();
		juegoNuevo.pasarTurno();
		
		//Noc como testear esto
	}
	
	public void testDispararDeberiaDispararseDispararseEnElCasoQueEsteListoOGuardarseEnCasoContrario(){
		
	}
}
