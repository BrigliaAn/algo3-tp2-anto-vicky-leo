package fiuba.navalgo.model.disparos;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Turno;

public class MinaSubmarinaPorContacto extends Disparo {

	
	public MinaSubmarinaPorContacto(ArrayList<Casilla> listaDeCasillas, Turno turno){
		super(listaDeCasillas, turno);
		costo = 150;
		
	}

	@Override
	public boolean listoParaDisparar() {
		return true;
	}


}
