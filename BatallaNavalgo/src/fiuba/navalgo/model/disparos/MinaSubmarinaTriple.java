package fiuba.navalgo.model.disparos;

import java.io.IOException;
import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.naves.Nave;
import fiuba.navalgo.view.JButtonID;
import fiuba.navalgo.view.MostrarMinaSubmarinaTriple;

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
		//return ((turno.devolverTurno() - turnoDeCreacion) == 3);
	}

	public void agregarCasilla(Casilla casilla) {
		casillaPrincipal = casilla;
		ArrayList<Casilla> listaDeCasillas = casilla.obtenerAdyacentes(2);
		this.casillas = listaDeCasillas;
		for(Casilla cas: listaDeCasillas){
			System.out.print(cas.getPosicion().getFila());
			System.out.println(cas.getPosicion().getColumna());
		}
	}

	public void disparar(Nave unaNave) {
		unaNave.recibirDisparo(this);
		
	}

	@Override
	public void mostrarDisparos(JButtonID[][] mat, Disparo disparo) {
		MostrarMinaSubmarinaTriple mostrarMinaTriple = new MostrarMinaSubmarinaTriple();
		try {
			mostrarMinaTriple.mostrardisparo(mat,disparo);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
}
