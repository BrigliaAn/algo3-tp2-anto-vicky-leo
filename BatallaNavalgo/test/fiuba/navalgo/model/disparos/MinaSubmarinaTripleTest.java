package fiuba.navalgo.model.disparos;

import fiuba.navalgo.model.Turno;
import junit.framework.TestCase;

public class MinaSubmarinaTripleTest extends TestCase {
	
	public void testCrearUnaMinaSubmarinaTriple(){
		MinaSubmarinaTriple mina = new MinaSubmarinaTriple();
		assertNotNull(mina);
	}
	
	public void testCrearUnMinaEstaListoParaSerDisparado(){
		MinaSubmarinaTriple mina = new MinaSubmarinaTriple();
		Turno turno = new Turno();
		mina.agregarTurno(turno);
		turno.aumentarContador();
		turno.aumentarContador();
		turno.aumentarContador();
		assertTrue(mina.listoParaDisparar());
	}
	
	public void testCostoDeMinaSubmarinaTripleDeberiaSer125(){
		MinaSubmarinaTriple mina = new MinaSubmarinaTriple();
		assertTrue(mina.devolverCosto()==125);
	}
}
