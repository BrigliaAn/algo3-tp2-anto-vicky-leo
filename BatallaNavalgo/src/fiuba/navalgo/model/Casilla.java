package fiuba.navalgo.model;

import java.util.*;


public class Casilla {
	
	private Posicion posicion;
	
	public Casilla(int fila, int columna){
		Posicion pos = new Posicion (fila,columna);
		this.posicion = pos;
	}
	public ArrayList<Casilla> obtenerAdyacentes(int rango) {
		// TODO Auto-generated method stub
		ArrayList<Casilla> lista = new ArrayList<Casilla>();
		int col = posicion.getColumna() -rango;
		int fil =posicion.getFila() -rango;
		int ciclo  = (2*rango)+1;
		
		Tablero tab = Tablero.getInstance();
		for(int i=fil; i<(ciclo+fil); i++){
			if((i>=0)&& (i<10)){
				for(int j=col; j<(ciclo+col); j++){
					if((j>=0) && (j<10)){
						lista.add(tab.devolverCasilla(new Posicion(i, j)));
					}
				}
			}
		};
		return lista; 
	
	}
	public Posicion getPosicion(){
		return this.posicion;
	}

}
