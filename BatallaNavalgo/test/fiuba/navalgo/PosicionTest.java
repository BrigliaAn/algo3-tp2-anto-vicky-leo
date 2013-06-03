package fiuba.navalgo;

import junit.framework.TestCase;

public class PosicionTest extends TestCase{
	
	public void testGetColumnaDeberiaDevolverLaColumna(){
		Posicion pos= new Posicion(2,5);
		assertEquals(pos.getColumna(),5);
	}
	
	public void testGetFilaDeberiaDevolverLaFila(){
		Posicion pos= new Posicion(2,5);
		assertEquals(pos.getFila(),2);
	}
	
}
