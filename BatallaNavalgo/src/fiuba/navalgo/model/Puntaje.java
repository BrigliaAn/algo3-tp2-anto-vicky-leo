package fiuba.navalgo.model;

public class Puntaje {
	private int puntos;
	
	public Puntaje(){
		puntos=10000;
	}
	
	public int obtenerPuntos() {

		return puntos;
	}

	public void restar(int puntosARestar) {

		puntos= puntos-puntosARestar;
	}

}
