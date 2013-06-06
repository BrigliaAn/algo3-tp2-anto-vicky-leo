package fiuba.navalgo.model.disparos;

import fiuba.navalgo.model.Turno;
import junit.framework.TestCase;

public class MinaSubmarinaDobleTest extends TestCase {
	
	public void testCrearUnaMinaSubmarinaDoble(){
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		assertNotNull(mina);
	}
	
	public void testCrearUnMinaEstaListoParaSerDisparado(){
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		Turno turno = new Turno();
		mina.agregarTurno(turno);
		turno.aumentarContador();
		turno.aumentarContador();
		turno.aumentarContador();
		assertTrue(mina.listoParaDisparar());
	}
	
	public void testCostoDeMinaSubmarinaDobleDeberiaSer100(){
		MinaSubmarinaDoble mina = new MinaSubmarinaDoble();
		assertTrue(mina.devolverCosto()==100);
	}

}
