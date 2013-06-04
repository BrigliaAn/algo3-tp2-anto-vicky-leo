package fiuba.navalgo.model;

import java.util.ArrayList;

import fiuba.navalgo.model.disparos.Disparo;
import fiuba.navalgo.model.naves.Nave;


public class Tablero {
	
	private static Tablero INSTANCE = null;
	private Casilla[][] matriz;
	private ArrayList<Nave> naves ;
	private ArrayList<Disparo> disparos;
	
	public Tablero(){
		
		Casilla mat[][] = new Casilla[10][10];
		for(int f=0;f<10;f++){
			for(int c=0;c<10;c++){
				Casilla unaCasilla = new Casilla(f,c);
				mat[f][c] = unaCasilla;
			};
		};
		
		matriz= mat;
		ArrayList<Nave> listaDeNaves = new ArrayList<Nave>();
		this.naves = listaDeNaves;
		ArrayList<Disparo> listaDeDisparos = new ArrayList<Disparo>();
		this.disparos = listaDeDisparos;
	}
	
	public synchronized static Tablero getInstance(){
		if (INSTANCE == null) INSTANCE = new Tablero();
        return INSTANCE;
	}
	
	public Casilla devolverCasilla(Posicion pos) {
		// TODO Auto-generated method stub
		int fila = pos.getFila();
		int columna = pos.getColumna();
		return matriz[fila][columna];
	}
	
	public void ponerNave(Nave unaNave){
		this.naves.add(unaNave);
		
	}
	
	public void agregarDisparo(Disparo unDisparo){
		this.disparos.add(unDisparo);
	}
	
	public void ejecutarDisparo(){
		
		for(int pos=0; pos< (this.disparos.size());pos++){
			Disparo disparoDeLaPos = this.disparos.get(pos);
			if(disparoDeLaPos.listoParaDisparar()){
				for(int index=0;index< (this.naves.size());index++){
					Nave unaNaveDelTablero = this.naves.get(index);
					unaNaveDelTablero.recibirDisparo(disparoDeLaPos);
				};
			}
		};
	}
	
	public void moverNaves(){
		
		for(int index=0;index< (this.naves.size());index++){
			Nave unaNaveDelTablero = this.naves.get(index);
			unaNaveDelTablero.mover();
		};
	}
	
	public ArrayList<Nave> verNaves(){
		return this.naves;
	}

}
