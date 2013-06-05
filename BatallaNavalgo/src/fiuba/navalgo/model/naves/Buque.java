package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.Movimiento;

public class Buque extends Nave {
	
	public Buque(Movimiento unMovimiento, ArrayList<Casilla> listaDeCasillas){
		super(unMovimiento,listaDeCasillas);
	}
	

	@Override
	public void recibirDisparo(DisparoConvencional unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.clear();					
			}
		}
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPuntual unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.clear();					
			}
		}
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaDoble unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.clear();					
			}
		}
	}

	@Override
	public void recibirDisparo(MinaSubmarinaTriple unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.clear();					
			}
		}
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPorContacto unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.clear();	
				unDisparo.explotar();
			}
		}
	}


	@Override
	public void recibirDisparo(Disparo unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.clear();					
			}
		}
		
	}
}


