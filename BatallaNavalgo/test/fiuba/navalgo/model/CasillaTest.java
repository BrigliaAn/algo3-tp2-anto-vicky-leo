package fiuba.navalgo.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class CasillaTest extends TestCase {
	
	public void testObtenerAdyacentesDeberiaDevolverUnaListaConLasCasillasAdyacentesAlRango(){
		Posicion pos22 = new Posicion(2,2);
		Tablero tab = Tablero.getInstance();
		Casilla casilla22 =	tab.devolverCasilla(pos22);
		ArrayList<Casilla> listaDeAdyacentes = casilla22.obtenerAdyacentes(1);
		assertTrue(listaDeAdyacentes.contains(tab.devolverCasilla(new Posicion(1,1))));
		assertTrue(listaDeAdyacentes.contains(tab.devolverCasilla(new Posicion(1,2))));
		assertTrue(listaDeAdyacentes.contains(tab.devolverCasilla(new Posicion(1,3))));
		assertTrue(listaDeAdyacentes.contains(tab.devolverCasilla(new Posicion(2,1))));
		assertTrue(listaDeAdyacentes.contains(tab.devolverCasilla(new Posicion(2,2))));
		assertTrue(listaDeAdyacentes.contains(tab.devolverCasilla(new Posicion(2,3))));
		assertTrue(listaDeAdyacentes.contains(tab.devolverCasilla(new Posicion(3,1))));
		assertTrue(listaDeAdyacentes.contains(tab.devolverCasilla(new Posicion(3,2))));
		assertTrue(listaDeAdyacentes.contains(tab.devolverCasilla(new Posicion(3,3))));
	}
	
	public void testObtenerAdyacentesDeUnaCeldaEnElLimiteDelTableroDeberiaLanzarError(){
		boolean thrown = false;
		Posicion pos99 = new Posicion(9,9);
		Casilla casillaLimite =	Tablero.getInstance().devolverCasilla(pos99);
		try {
			ArrayList<Casilla> listaDeAdyacentes = casillaLimite.obtenerAdyacentes(1);
			  } catch (IndexOutOfBoundsException e) {
				  thrown = true;
		 }

			  assertTrue(thrown);
	}
}
