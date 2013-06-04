package fiuba.navalgo.model;

import junit.framework.TestCase;

public class TurnoTest extends TestCase {
	
	public void  testCrearUnTurnoSeEncuentraEnPrimerTurno(){
		Turno unTurno = new Turno ();
		assertEquals( unTurno.devolverTurnoActual(), 1);
	}
	public void testAumentarTurno(){
		Turno unTurno = new Turno();
		unTurno.aumentarContador();
		assertEquals (unTurno.devolverTurnoActual(),2);
		
	}
	
}
