package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.disparos.Disparo;
import fiuba.navalgo.model.disparos.DisparoConvencional;
import fiuba.navalgo.model.disparos.MinaSubmarinaDoble;
import fiuba.navalgo.model.disparos.MinaSubmarinaPorContacto;
import fiuba.navalgo.model.disparos.MinaSubmarinaPuntual;
import fiuba.navalgo.model.disparos.MinaSubmarinaTriple;
import fiuba.navalgo.model.movimiento.Movimiento;
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
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.remove(casillaAdestruir);					
			}
		}
		unDisparo.explotar();
	}

	@Override
	public void recibirDisparo(MinaSubmarinaDoble unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.remove(casillaAdestruir);					
			}
		}
		unDisparo.explotar();
	}

	@Override
	public void recibirDisparo(MinaSubmarinaTriple unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.remove(casillaAdestruir);					
			}
		}
		unDisparo.explotar();
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPorContacto unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			if (casillas.contains(casillaAdestruir)){
				casillas.remove(casillaAdestruir);
				unDisparo.explotar();
			}
		}
	}

	
}
