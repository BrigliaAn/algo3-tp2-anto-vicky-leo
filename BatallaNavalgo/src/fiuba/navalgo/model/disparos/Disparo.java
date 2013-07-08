package fiuba.navalgo.model.disparos;

import java.util.ArrayList;
import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Turno;
import fiuba.navalgo.model.naves.Nave;

public abstract class Disparo {
	protected ArrayList<Casilla> casillas;
	protected Casilla casillaPrincipal;
	protected int costo;
	protected int turnoDeCreacion;
	protected Turno turno;
	protected boolean explotado;
	
	public Disparo(){
		
	}
	
	public abstract void agregarCasilla(Casilla casilla);
	
	public abstract boolean listoParaDisparar();
	
	public void agregarTurno(Turno turno){
		turnoDeCreacion = turno.devolverTurnoActual();
		this.turno = turno;
	}
	
	public ArrayList<Casilla> devolverCasillas() {
		return casillas;
	}
	
	public Casilla devolverCasillaPrincipal(){
		return casillaPrincipal;
	}
	
	public int devolverCosto(){
		return costo;
	}
	
	public boolean haExplotado(){
		return explotado;
	}

	public void explotar() {
		explotado = true;
		
	}

	public abstract void disparar(Nave unaNave);
}
