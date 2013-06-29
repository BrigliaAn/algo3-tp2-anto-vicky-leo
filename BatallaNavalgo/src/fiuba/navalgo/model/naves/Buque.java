package fiuba.navalgo.model.naves;

import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.Movimiento;

public class Buque extends Nave {
	private static int vida = 1;
	private static int tamanio = 4;
	
	public Buque(Movimiento unMovimiento, Direccion direccion, Posicion posicion){
		super(unMovimiento, direccion, posicion, vida, tamanio);
	}
	

	@Override
	public void recibirDisparo(DisparoConvencional unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			for(PorcionDeNave porcion: porciones){
				if (porcion.getCasilla()==(casillaAdestruir)){
					destruccionTotal();
					return;
				}
			}
		}
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPuntual unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			for(PorcionDeNave porcion: porciones){
				if (porcion.getCasilla()==(casillaAdestruir)){
					destruccionTotal();
					return;
				}
			}
				
		}
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaDoble unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			for(PorcionDeNave porcion: porciones){
				if (porcion.getCasilla()==(casillaAdestruir)){
					destruccionTotal();
					return;
				}
			}
		}
	}

	@Override
	public void recibirDisparo(MinaSubmarinaTriple unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			for(PorcionDeNave porcion: porciones){
				if (porcion.getCasilla()==(casillaAdestruir)){
					destruccionTotal();
					return;
				}
			}
		}
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPorContacto unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			for(PorcionDeNave porcion: porciones){
				if (porcion.getCasilla()==(casillaAdestruir)){
					destruccionTotal();
					return;
				}
			}
		}
	}

	public void destruccionTotal(){
		for(PorcionDeNave porcion: porciones){
			porcion.destruir();
		}
	}

}


