package fiuba.navalgo.model.disparos;

import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Turno;

public abstract class Disparo {
	protected ArrayList<Casilla> casillas;
	protected int costo;
	protected int turnoDeCreacion;
	protected Turno turno;
	protected boolean explotado;
	
	public Disparo(ArrayList<Casilla> listaDeCasillas, Turno turno){
		turnoDeCreacion = turno.devolverTurnoActual();
		casillas = listaDeCasillas;
		this.turno = turno;
		explotado = false;
		
	}
	
	public ArrayList<Casilla> devolverCasillas() {
		return casillas;
	}
	
	public int devolverCosto(){
		return costo;
	}
	
	public abstract boolean listoParaDisparar();
	
	public boolean haExplotado(){
		return explotado;
	}

	public void explotar() {
		explotado = true;
		
	}
}
