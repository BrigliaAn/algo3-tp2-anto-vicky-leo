package fiuba.navalgo;

public class Puntaje {
	private int puntos;
	
	public Puntaje(){
		puntos=10000;
	}
	
	public int obtenerPuntos() {
		// TODO Auto-generated method stub
		return puntos;
	}

	public void restar(int puntosARestar) {
		// TODO Auto-generated method stub
		puntos= puntos-puntosARestar;
	}

}
