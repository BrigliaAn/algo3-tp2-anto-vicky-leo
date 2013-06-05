package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.Movimiento;

public class Destructor extends Nave{
	
	public Destructor(Movimiento unMovimiento, ArrayList<Casilla> listaDeCasillas){
		super(unMovimiento, listaDeCasillas);
	}
	

	@Override
	public void recibirDisparo(DisparoConvencional unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.remove(casillaAdestruir);					
			}
		}
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPuntual unDisparo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaDoble unDisparo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaTriple unDisparo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPorContacto unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				unDisparo.explotar();
			}
		}
		
		
	}


	@Override
	public void recibirDisparo(Disparo unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.remove(casillaAdestruir);					
			}
		}
		
	}
}
