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
		this.naves = new ArrayList<Nave>();
		this.disparos= new ArrayList<Disparo>();
	
	}
	
	public synchronized static Tablero getInstance(){
		if (INSTANCE == null) INSTANCE = new Tablero();
        return INSTANCE;
	}
	
	public Casilla devolverCasilla(Posicion pos) {
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
        ArrayList<Disparo> disparosARemover = new ArrayList<Disparo>();
        ArrayList<Nave> navesARemover = new ArrayList<Nave>();
        for(Disparo disparo: this.disparos){
                if(disparo.listoParaDisparar()){
                        for(Nave unaNaveDelTablero: this.naves){
                                disparo.disparar(unaNaveDelTablero);
                                
                                if(unaNaveDelTablero.estaDestruido()){
                                        navesARemover.add(unaNaveDelTablero);
                                }
                        }
                }
                if(disparo.haExplotado()){
                        disparosARemover.add(disparo);
                }
        }
        for(Disparo unDisparo: disparosARemover){
                this.disparos.remove(unDisparo);
        }
        for(Nave unaNave: navesARemover){
                this.naves.remove(unaNave);
        }
        
}
	
	public void moverNaves(){
		
		for(Nave unaNaveDelTablero: this.naves){
			unaNaveDelTablero.mover();
		};
	}
	
	public ArrayList<Nave> verNaves(){
		return this.naves;
	}

	public ArrayList<Disparo> verDisparos(){
		return this.disparos;
	}
	
	public void vaciarTablero(){
		naves.clear();
		disparos.clear();
	}
}
