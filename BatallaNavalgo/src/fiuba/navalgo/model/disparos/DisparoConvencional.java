package fiuba.navalgo.model.disparos;

import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;


public class DisparoConvencional extends Disparo{
	
	public DisparoConvencional(){
		costo = 200;		
	}
	
	public boolean listoParaDisparar() {
		this.explotar();
		return true;
	}

	@Override
	public void agregarCasilla(Casilla casilla) {
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(casilla);
		this.casillas = listaDeCasillas;
	}
}


