package fiuba.navalgo.model;

import fiuba.navalgo.model.excepciones.FueraDeMatriz;

public class Posicion {
	private int columna;
	private int fila;
	
	public Posicion(int fil, int col) {
		columna = col;
		fila = fil;
		if(columna>9 || fila > 9) throw new FueraDeMatriz();
	}
	public int getColumna(){
		return columna;
	}
	public int getFila(){
		return fila;
	}
}
