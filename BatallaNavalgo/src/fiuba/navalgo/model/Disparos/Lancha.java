package fiuba.navalgo.model.Disparos;

import java.util.ArrayList;
import fiuba.navalgo.model.naves.*;
import fiuba.navalgo.model.*;

public class Lancha extends Nave{

	public Lancha(Movimiento unMovimiento, ArrayList<Casilla> listaDeCasillas){
		super(unMovimiento, listaDeCasillas);
	}
	
	public void recibirDisparo(Disparo unDisparo){
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.remove(casillaAdestruir);					
			}
		}
	}
	
}
