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
		int col = posicion.getColumna();
		int fil =posicion.getFila();
		Tablero tab = Tablero.getInstance();
		for(int i=1; i<=rango; i++){
			lista.add(this);
			lista.add(tab.devolverCasilla(new Posicion(fil+i, col)));
			lista.add(tab.devolverCasilla(new Posicion(fil, col+i)));
			lista.add(tab.devolverCasilla(new Posicion(fil-i, col)));
			lista.add(tab.devolverCasilla(new Posicion(fil, col-i)));
			lista.add(tab.devolverCasilla(new Posicion(fil+i, col+i)));
			lista.add(tab.devolverCasilla(new Posicion(fil-i, col-i)));
			lista.add(tab.devolverCasilla(new Posicion(fil-i, col+i)));
			lista.add(tab.devolverCasilla(new Posicion(fil+i, col-i)));
		};
		return lista; 
	
	}
	public Posicion getPosicion(){
		return this.posicion;
	}

}
