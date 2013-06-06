package fiuba.navalgo.model.disparos;

import junit.framework.TestCase;

public class DisparoConvencionalTest extends TestCase {
	public void testCrearUnDisparoConvencional(){
		DisparoConvencional disparo = new DisparoConvencional();
		assertNotNull(disparo);
	}
	
	public void testCrearUnDisparoEstaListoParaSerDisparado(){
		DisparoConvencional disparo = new DisparoConvencional();
		assertTrue(disparo.listoParaDisparar());
	}
	
	public void testCostoDeDisparoConvencionalDeberiaSer200(){
		DisparoConvencional disparo = new DisparoConvencional();
		assertTrue(disparo.devolverCosto()==200);
	}

}
