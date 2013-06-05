package fiuba.navalgo.model.disparos;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Turno;

public class MinaSubmarinaDoble extends Disparo{
	public MinaSubmarinaDoble(ArrayList<Casilla> listaDeCasillas, Turno turno){
		super(listaDeCasillas,turno);
		costo = 100;		
	}

	@Override
	public boolean listoParaDisparar() {
		if((turno.devolverTurnoActual() - turnoDeCreacion) == 3){
			this.explotar();
			return true;
		}
		return false;
		
		//return ((turno.devolverTurno() - turnoDeCreacion) == 3);
	}
	
}
