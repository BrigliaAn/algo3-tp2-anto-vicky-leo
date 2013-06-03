package fiuba.navalgo;
import junit.framework.TestCase;

public class TableroTest extends TestCase {
	
	public void testTableroDebeCrearseCorrectamenteConTodasLasCasillas(){
		
		Tablero unTablero = new Tablero();
		assertNotNull(unTablero.devolverCasilla(2,2));
	}
}
