package fiuba.navalgo.model.disparos;


import junit.framework.TestCase;

public class MinaSubmarinaPorContactoTest extends TestCase {
	
	public void testCrearUnaMinaSubmarinaTriple(){
		MinaSubmarinaPorContacto mina = new MinaSubmarinaPorContacto();
		assertNotNull(mina);
	}
	
	public void testCrearUnMinaEstaListoParaSerDisparado(){
		MinaSubmarinaPorContacto mina = new MinaSubmarinaPorContacto();
		assertTrue(mina.listoParaDisparar());
	}
	
	public void testCostoDeMinaSubmarinaPorContactoDeberiaSer150(){
		MinaSubmarinaPorContacto mina = new MinaSubmarinaPorContacto();
		assertTrue(mina.devolverCosto()==150);
	}
}
