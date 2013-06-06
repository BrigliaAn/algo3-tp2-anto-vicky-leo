package fiuba.navalgo.model.naves;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.Movimiento;

import java.util.ArrayList;

public abstract class Nave {
	
	protected Movimiento movimiento;
	protected ArrayList<Casilla> casillas;
	
	public Nave (Movimiento unMovimiento, ArrayList<Casilla> listaDeCasillas){
			movimiento = unMovimiento;	
			casillas = listaDeCasillas;	
		
	}
	
	
	public boolean estaDestruido(){
		return casillas.isEmpty();
	}
	
	public void mover(){
		movimiento.mover(casillas);
	}
	
	public ArrayList<Casilla> devolverUbicacion(){
		return casillas;
	}
	
	public abstract void recibirDisparo(Disparo unDisparo);
	public abstract void recibirDisparo(DisparoConvencional unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaPuntual unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaDoble unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaTriple unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaPorContacto unDisparo);	

}
