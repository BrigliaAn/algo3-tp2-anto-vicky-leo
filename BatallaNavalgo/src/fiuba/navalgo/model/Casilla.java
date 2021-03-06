package fiuba.navalgo.model;

import java.util.*;


public class Casilla implements Comparable<Casilla>{
	
	private Posicion posicion;
	
	public Casilla(int fila, int columna){
		Posicion pos = new Posicion (fila,columna);
		this.posicion = pos;
	}
	public ArrayList<Casilla> obtenerAdyacentes(int rango) {
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
	
	@Override
	public int compareTo(Casilla otro) {
		Casilla otra = (Casilla) otro;
		if(this.posicion.getFila() == otra.posicion.getFila() 
				&& this.posicion.getColumna() == otra.posicion.getColumna()){
			return 0;
			
		}
		if(otra.posicion.getFila() <= this.posicion.getFila()
				&& otra.posicion.getColumna() <= this.posicion.getColumna()){
			//la otra es más pequeña
			return 1;
		}
		return -1;
	}

}
