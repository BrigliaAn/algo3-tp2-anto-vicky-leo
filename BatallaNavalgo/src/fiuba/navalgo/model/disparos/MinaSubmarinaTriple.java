package fiuba.navalgo.model.disparos;

import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;

public class MinaSubmarinaTriple extends Disparo{
	public MinaSubmarinaTriple(){
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

	@Override
	public void agregarCasilla(Casilla casilla) {
		
		ArrayList<Casilla> listaDeCasillas = casilla.obtenerAdyacentes(2);
		this.casillas = listaDeCasillas;
	}

}
