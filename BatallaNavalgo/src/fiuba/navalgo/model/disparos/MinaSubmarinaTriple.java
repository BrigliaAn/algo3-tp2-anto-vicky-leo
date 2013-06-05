package fiuba.navalgo.model.disparos;

import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Turno;

public class MinaSubmarinaTriple extends Disparo{
	public MinaSubmarinaTriple(ArrayList<Casilla> listaDeCasillas, Turno turno){
		super(listaDeCasillas,turno);
		costo = 125;		
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
