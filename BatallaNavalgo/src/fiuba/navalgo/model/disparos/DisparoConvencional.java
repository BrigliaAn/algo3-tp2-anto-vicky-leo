package fiuba.navalgo.model.disparos;

import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Turno;


public class DisparoConvencional extends Disparo{
	public DisparoConvencional(ArrayList<Casilla> listaDeCasillas, Turno turno){
		super(listaDeCasillas,turno);
		costo = 200;		
	}
	
	public boolean listoParaDisparar() {
		this.explotar();
		return true;
	}
}


