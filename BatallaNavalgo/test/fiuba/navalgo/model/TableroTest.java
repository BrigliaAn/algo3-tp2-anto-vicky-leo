package fiuba.navalgo.model;
import java.util.ArrayList;

import fiuba.navalgo.model.movimiento.Arriba;
import fiuba.navalgo.model.naves.Lancha;

import junit.framework.TestCase;

public class TableroTest extends TestCase {
	
	public void testTableroDebeCrearseCorrectamenteConTodasLasCasillas(){
		
		Tablero unTablero = Tablero.getInstance();
		Posicion pos22 = new Posicion(2,2);
		assertNotNull(unTablero.devolverCasilla(pos22));
	}
	
	public void testTableroDeberiaCrearTodasCasillasDiferentesParaCadaPosicion(){
		Tablero unTablero = Tablero.getInstance();
		Posicion pos11 = new Posicion(1,1);
		Posicion pos22 = new Posicion(2,2);
		assertNotSame(unTablero.devolverCasilla(pos11),unTablero.devolverCasilla(pos22));
	}
	public void testTableroDeberiaDevolverLaCasillaCorrespondienteAEsaPosicion(){
		ArrayList<Casilla> list = new ArrayList<Casilla>();
		Posicion pos22 = new Posicion(2,2);
		Casilla casilla1 = Tablero.getInstance().devolverCasilla(pos22);
		Casilla casilla2 = Tablero.getInstance().devolverCasilla(pos22);
		list.add(casilla1);
		assertTrue(list.contains(casilla2));
	}
	
	public void testPonerNavesDeberiaAgregarLaNaveALaLista(){
		Arriba movArriba = new Arriba();
		Tablero unTablero = Tablero.getInstance();
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(unTablero.devolverCasilla(new Posicion(2,2)));
		listaDeCasillas.add(unTablero.devolverCasilla(new Posicion(2,3)));
		Lancha unaNave = new Lancha(movArriba, listaDeCasillas);
		unTablero.ponerNave(unaNave);
		assertEquals(unTablero.verNaves().get(0),unaNave);
	}
	

}
