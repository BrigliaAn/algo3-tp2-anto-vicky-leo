package fiuba.navalgo.model.disparos;

import fiuba.navalgo.model.Turno;
import junit.framework.TestCase;

public class MinaSubmarinaPuntualTest extends TestCase {

	public void testCrearUnaMinaSubmarinaTriple(){
		MinaSubmarinaPuntual mina = new MinaSubmarinaPuntual();
		assertNotNull(mina);
	}
	
	public void testCrearUnMinaEstaListoParaSerDisparado(){
		MinaSubmarinaPuntual mina = new MinaSubmarinaPuntual();
		Turno turno = new Turno();
		mina.agregarTurno(turno);
		turno.aumentarContador();
		turno.aumentarContador();
		turno.aumentarContador();
		assertTrue(mina.listoParaDisparar());
	}
	
	public void testCostoDeMinaSubmarinaPuntualDeberiaSer50(){
		MinaSubmarinaPuntual mina = new MinaSubmarinaPuntual();
		assertTrue(mina.devolverCosto()==50);
	}
}
