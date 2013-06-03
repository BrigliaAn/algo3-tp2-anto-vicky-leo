package fiuba.navalgo.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class CasillaTest extends TestCase {
	
	public void testObtenerAdyacentesDeberiaDevolverUnaListaConLasCasillasAdyacentesAlRango(){
		Tablero unTablero = new Tablero();
		Casilla casilla22 =	unTablero.devolverCasilla(2,2);
		ArrayList<Casilla> listaDeAdyacentes = casilla22.obtenerAdyacentes(1);
		assert(listaDeAdyacentes.contains(unTablero.devolverCasilla(1,1)));
		assert(listaDeAdyacentes.contains(unTablero.devolverCasilla(1,2)));
		assert(listaDeAdyacentes.contains(unTablero.devolverCasilla(1,3)));
		assert(listaDeAdyacentes.contains(unTablero.devolverCasilla(2,2)));
		assert(listaDeAdyacentes.contains(unTablero.devolverCasilla(2,1)));
		assert(listaDeAdyacentes.contains(unTablero.devolverCasilla(2,3)));
		assert(listaDeAdyacentes.contains(unTablero.devolverCasilla(3,1)));
		assert(listaDeAdyacentes.contains(unTablero.devolverCasilla(3,2)));
		assert(listaDeAdyacentes.contains(unTablero.devolverCasilla(3,3)));
	}
	
	public void testObtenerAdyacentesDeUnaCeldaEnElLimiteDelTableroDeberiaLanzarError(){
		Tablero unTablero = new Tablero();
		boolean thrown = false;
		Casilla casillaLimite =	unTablero.devolverCasilla(9,9);
		try {
			ArrayList<Casilla> listaDeAdyacentes = casillaLimite.obtenerAdyacentes(1);
			  } catch (IndexOutOfBoundsException e) {
				  thrown = true;
		 }

			  assertTrue(thrown);
	}
}
