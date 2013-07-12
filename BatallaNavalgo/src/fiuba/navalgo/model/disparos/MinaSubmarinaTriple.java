package fiuba.navalgo.model.disparos;

import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.naves.Nave;

public class MinaSubmarinaTriple extends Disparo{
	public MinaSubmarinaTriple(){
		costo = 125;		
	}

	public boolean listoParaDisparar()  {
		if((turno.devolverTurnoActual() - turnoDeCreacion) == 3){
			this.explotar();
			return true;
		}
		return false;
		
	}

	public void agregarCasilla(Casilla casilla) {
		casillaPrincipal = casilla;
		ArrayList<Casilla> listaDeCasillas = casilla.obtenerAdyacentes(2);
		this.casillas = listaDeCasillas;
	}

	public void disparar(Nave unaNave) {
		unaNave.recibirDisparo(this);
		
	}
}
