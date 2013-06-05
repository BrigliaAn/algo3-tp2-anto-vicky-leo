package fiuba.navalgo.model.disparos;

import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;


public class MinaSubmarinaPuntual extends Disparo{
	public MinaSubmarinaPuntual(){
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

	@Override
	public void agregarCasilla(Casilla casilla) {
		
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(casilla);
		this.casillas = listaDeCasillas;
		
	}

}
