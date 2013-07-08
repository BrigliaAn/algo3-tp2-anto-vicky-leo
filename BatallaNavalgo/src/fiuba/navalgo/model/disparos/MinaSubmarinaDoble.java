package fiuba.navalgo.model.disparos;

import java.io.IOException;
import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.naves.Nave;
import fiuba.navalgo.view.JButtonID;
import fiuba.navalgo.view.MostrarBuque;
import fiuba.navalgo.view.MostrarMinaSubmarinaDoble;


public class MinaSubmarinaDoble extends Disparo{
	public MinaSubmarinaDoble(){
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

	@Override
	public void agregarCasilla(Casilla casilla) {
		casillaPrincipal = casilla;
		ArrayList<Casilla> listaDeCasillas = casilla.obtenerAdyacentes(1);
		this.casillas = listaDeCasillas;
		
	}
	public void disparar(Nave unaNave) {
		unaNave.recibirDisparo(this);
		
	}

	@Override
	public void mostrarDisparos(JButtonID[][] mat, Disparo disparo) {
		MostrarMinaSubmarinaDoble mostrarMinaDoble = new MostrarMinaSubmarinaDoble();
		try {
			mostrarMinaDoble.mostrardisparo(mat,disparo);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
