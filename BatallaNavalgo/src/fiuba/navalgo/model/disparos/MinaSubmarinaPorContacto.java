package fiuba.navalgo.model.disparos;

import java.io.IOException;
import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.naves.Nave;
import fiuba.navalgo.view.JButtonID;
import fiuba.navalgo.view.MostrarMinaSubmarinaPorContacto;


public class MinaSubmarinaPorContacto extends Disparo {

	
	public MinaSubmarinaPorContacto(){
		costo = 150;
		
	}

	@Override
	public boolean listoParaDisparar() {
		return true;
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
		MostrarMinaSubmarinaPorContacto mostrarMinaContacto = new MostrarMinaSubmarinaPorContacto();
		try {
			mostrarMinaContacto.mostrardisparo(mat,disparo);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
}
