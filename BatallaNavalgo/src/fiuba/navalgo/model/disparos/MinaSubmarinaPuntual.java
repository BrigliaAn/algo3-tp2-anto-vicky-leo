package fiuba.navalgo.model.disparos;

import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Turno;

public class MinaSubmarinaPuntual extends Disparo{
	public MinaSubmarinaPuntual(ArrayList<Casilla> listaDeCasillas, Turno turno){
		super(listaDeCasillas,turno);
		costo = 50;		
	}

	@Override
	public boolean listoParaDisparar()  {
		if((turno.devolverTurnoActual() - turnoDeCreacion) == 3){
			this.explotar();
			return true;
		}
		return false;
		//return ((turno.devolverTurno() - turnoDeCreacion) == 3);
	}

}
