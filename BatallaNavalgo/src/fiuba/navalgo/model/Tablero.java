package fiuba.navalgo.model;


public class Tablero {
	
	private static Tablero INSTANCE = new Tablero();
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
	public Casilla devolverCasilla(int fila, int columna) {
		// TODO Auto-generated method stub
		return matriz[fila][columna];
	}
	
	public static Tablero getInstance(){
		return Tablero.INSTANCE;
	}

}
