package fiuba.navalgo.model.naves;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.Movimiento;


import java.util.ArrayList;

public abstract class Nave {
	
	protected Movimiento movimiento;
	protected ArrayList<PorcionDeNave> porciones;
	
	public Nave (Movimiento unMovimiento, ArrayList<Casilla> listaDeCasillas, int vida){
			movimiento = unMovimiento;	
			ArrayList<PorcionDeNave> porciones = new ArrayList<PorcionDeNave>();
			for(Casilla cas: listaDeCasillas){
				PorcionDeNave porcion = new PorcionDeNave(vida, cas);
				porciones.add(porcion);
			}
			this.porciones = porciones;
	}
	
	
	public boolean estaDestruido(){
		for(PorcionDeNave porcion: porciones){
			if(porcion.estaDestruida() == false){
				return false;
			}
		}
		return true;
	}
	
	public void mover(){
	
		movimiento.mover(porciones);
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		for(PorcionDeNave porcion: porciones){
			casillas.add(porcion.getCasilla());
		}
		movimiento = movimiento.proximoMovimiento(casillas);
		
	}
	
	/*public ArrayList<Casilla> devolverUbicacion(){
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		for(PorcionDeNave porcion: porciones){
			casillas.add(porcion.getCasilla());
		}
		return casillas;
	}*/
	
	public ArrayList<PorcionDeNave> getPorcionesDeNave(){
		return porciones;
	}
	

	public abstract void recibirDisparo(DisparoConvencional unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaPuntual unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaDoble unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaTriple unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaPorContacto unDisparo);
	

}
