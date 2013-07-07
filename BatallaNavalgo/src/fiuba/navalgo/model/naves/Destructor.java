package fiuba.navalgo.model.naves;

import java.io.IOException;
import java.util.ArrayList;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.Movimiento;
import fiuba.navalgo.view.JButtonID;
import fiuba.navalgo.view.MostrarBuque;
import fiuba.navalgo.view.MostrarDestructor;

public class Destructor extends Nave{
	private static int vida = 1;
	private static int tamanio = 3;
	
	public Destructor(Movimiento unMovimiento, Direccion direccion, Posicion posicion){
		super(unMovimiento, direccion, posicion, vida, tamanio);
	}
	
	@Override
	public void recibirDisparo(DisparoConvencional unDisparo) {
		ArrayList<Casilla> casillasDeDisparo = unDisparo.devolverCasillas();
		for(Casilla casillaAdestruir: casillasDeDisparo){
			for(PorcionDeNave porcion: porciones){
				if (porcion.getCasilla()==(casillaAdestruir)){
					porcion.destruir();		
				}
			}
				
		}
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPuntual unDisparo) {
		
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaDoble unDisparo) {
		
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaTriple unDisparo) {
	
		
	}

	@Override
	public void recibirDisparo(MinaSubmarinaPorContacto unDisparo) {

	}

	@Override
	public void mostrarTipoDeNave(JButtonID[][] tablero, Nave nave) {
		MostrarDestructor mostrarDestructor = new MostrarDestructor();
		try {
			mostrarDestructor.mostrarNave(tablero,nave);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		


}
