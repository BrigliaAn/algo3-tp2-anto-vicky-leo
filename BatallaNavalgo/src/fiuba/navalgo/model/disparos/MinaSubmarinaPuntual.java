package fiuba.navalgo.model.disparos;

import java.io.IOException;
import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.naves.Nave;
import fiuba.navalgo.view.JButtonID;
import fiuba.navalgo.view.MostrarMinaSubmarinaPuntual;


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
		MostrarMinaSubmarinaPuntual mostrarMinaPuntual = new MostrarMinaSubmarinaPuntual();
		try {
			mostrarMinaPuntual.mostrardisparo(mat,disparo);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
}
