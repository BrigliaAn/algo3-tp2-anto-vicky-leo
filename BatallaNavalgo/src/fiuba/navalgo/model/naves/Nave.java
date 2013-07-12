package fiuba.navalgo.model.naves;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.Movimiento;


import java.util.ArrayList;

public abstract class Nave {
	
	protected Movimiento movimiento;
	protected ArrayList<PorcionDeNave> porciones;
	protected int tamanio;
	protected Direccion direccion;
	
	public Nave (Movimiento unMovimiento, Direccion direccion, Posicion posicion, int vida, int tamanio){
			ArrayList<Casilla> listaDeCasillas = direccion.devolverCasillas(posicion, tamanio);
			this.movimiento = unMovimiento.proximoMovimiento(listaDeCasillas);	
			this.direccion = direccion;
			ArrayList<PorcionDeNave> porciones = new ArrayList<PorcionDeNave>();
			for(Casilla casilla: listaDeCasillas){
				System.out.println("casilla "+casilla.getPosicion().getFila()+casilla.getPosicion().getColumna());
				PorcionDeNave porcion = new PorcionDeNave(vida, casilla);
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
	

	public ArrayList<PorcionDeNave> getPorcionesDeNave(){
		return porciones;
	}
	

	public abstract void recibirDisparo(DisparoConvencional unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaPuntual unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaDoble unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaTriple unDisparo);	
	public abstract void recibirDisparo(MinaSubmarinaPorContacto unDisparo);


	public Direccion getDireccion() {
		return this.direccion;
	}
	

}
