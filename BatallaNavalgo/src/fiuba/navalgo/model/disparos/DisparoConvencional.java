package fiuba.navalgo.model.disparos;

import java.io.IOException;
import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.naves.Nave;
import fiuba.navalgo.view.JButtonID;
import fiuba.navalgo.view.MostrarBuque;



public class DisparoConvencional extends Disparo{
	
	public DisparoConvencional(){
		costo = 200;		
	}
	
	public boolean listoParaDisparar() {
		this.explotar();
		return true;
	}

	
	public void agregarCasilla(Casilla casilla) {
		casillaPrincipal = casilla;
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(casilla);
		this.casillas = listaDeCasillas;
	}

	
	public void disparar(Nave unaNave) {
		unaNave.recibirDisparo(this);
		
	}

	@Override
	public void mostrarDisparos(JButtonID[][] mat, Disparo disparo) {
		}	
		
	
}


