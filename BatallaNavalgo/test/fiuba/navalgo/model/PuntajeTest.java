package fiuba.navalgo.model;

import junit.framework.TestCase;

public class PuntajeTest extends TestCase {
	
	
	public void testPuntajeInicialDebeSer10000(){
		Puntaje unPuntaje= new Puntaje();
		assertEquals(unPuntaje.obtenerPuntos(), 10000);
	}
	
	public void testRestarDebeSacarPuntosAlPuntaje(){
		Puntaje unPuntaje= new Puntaje();
		unPuntaje.restar(10);
		assertNotSame("Deberia ser 9990", unPuntaje.obtenerPuntos(), 10000);
		assertEquals(unPuntaje.obtenerPuntos(),9990);
	}
}
