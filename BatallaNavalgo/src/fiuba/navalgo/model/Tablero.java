package fiuba.navalgo.model;


public class Tablero {
	
	private static Tablero INSTANCE = null;
	private Casilla[][] matriz;
	
	public Tablero(){
		
		Casilla mat[][] = new Casilla[10][10];
		for(int f=0;f<10;f++){
			for(int c=0;c<10;c++){
				Casilla unaCasilla = new Casilla(f,c);
				mat[f][c] = unaCasilla;
			};
		};
		
		matriz= mat;
	}
	public Casilla devolverCasilla(Posicion pos) {
		// TODO Auto-generated method stub
		int fila = pos.getFila();
		int columna = pos.getColumna();
		return matriz[fila][columna];
	}
	
	public synchronized static Tablero getInstance(){
		if (INSTANCE == null) INSTANCE = new Tablero();
        return INSTANCE;
	}

}
