package fiuba.navalgo;

public class Posicion {
	private int columna;
	private int fila;
	
	public Posicion(int fil, int col){
		columna = col;
		fila = fil;
	}
	public int getColumna(){
		return columna;
	}
	public int getFila(){
		return fila;
	}
}
