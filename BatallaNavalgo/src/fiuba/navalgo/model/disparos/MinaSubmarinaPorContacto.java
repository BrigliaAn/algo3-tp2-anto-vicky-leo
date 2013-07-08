package fiuba.navalgo.model.disparos;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.naves.Nave;


public class MinaSubmarinaPorContacto extends Disparo {

	
	public MinaSubmarinaPorContacto(){
		costo = 150;
		
	}

	@Override
	public boolean listoParaDisparar() {
		return true;
	}

	@Override
	public void agregarCasilla(Casilla casilla) {
		casillaPrincipal = casilla;
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(casilla);
		this.casillas = listaDeCasillas;
		
	}

	public void disparar(Nave unaNave) {
		unaNave.recibirDisparo(this);
		
	}
}
