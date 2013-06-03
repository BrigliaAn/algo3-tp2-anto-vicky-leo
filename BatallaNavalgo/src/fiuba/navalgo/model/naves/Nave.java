package fiuba.navalgo.model.naves;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Movimiento;
import fiuba.navalgo.model.Disparos.Disparo;

import java.util.ArrayList;

public abstract class Nave {
	
	protected Movimiento movimiento;
	protected ArrayList<Casilla> casillas;
	
	public Nave (Movimiento unMovimiento, ArrayList<Casilla> listaDeCasillas){
			movimiento = unMovimiento;
			casillas = listaDeCasillas;			
		
	}
	
	public boolean estaDestruido(){
		return casillas.isEmpty();
	}
	
	public void mover(){
		movimiento.mover();
	}
	
	public abstract void recibirDisparo(Disparo unDisparo);
	/*public void recibirDisparo(Disparo unDisparo){
			ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
			for(Casilla casillaAdestruir: casillasDeDisparo){
				if (casillas.contains(casillaAdestruir)){
					casillas.remove(casillaAdestruir);					
				}
			}
		
	}*/
	
	
}
