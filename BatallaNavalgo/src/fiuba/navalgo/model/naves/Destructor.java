package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.Movimiento;

public class Destructor extends Nave{
	private static int vida = 1;
	
	public Destructor(Movimiento unMovimiento, ArrayList<Casilla> listaDeCasillas){
		super(unMovimiento, listaDeCasillas,vida);
	}
	
	@Override
	public void recibirDisparo(DisparoConvencional unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			for(PorcionDeNave porcion: porciones){
				if (porcion.getCasilla()==(casillaAdestruir)){
					porcion.destruir();		
				}
			}
				
		}
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPuntual unDisparo) {
		
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaDoble unDisparo) {
		
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaTriple unDisparo) {
	
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPorContacto unDisparo) {

	}
		


}
