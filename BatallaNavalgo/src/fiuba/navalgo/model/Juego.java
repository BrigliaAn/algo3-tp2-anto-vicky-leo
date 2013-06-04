package fiuba.navalgo.model;

public class Juego {
	
	private Puntaje puntaje;
	private Turno turno;
	
	public Juego(){
		Puntaje puntos = new Puntaje();
		this.puntaje = puntos;
		Turno turnoDelJuego = new Turno();
		this.turno = turnoDelJuego;
		
	}
	
	public int verPuntajeActual() {
		// TODO Auto-generated method stub
		return this.puntaje.obtenerPuntos();
	}

	public int devolverTurnoActual() {
		// TODO Auto-generated method stub
		return this.turno.devolverTurnoActual();
	}

	public void pasarTurno() {
		// TODO Auto-generated method stub
		this.turno.aumentarContador();
		this.puntaje.restar(10);
		Tablero tableroBatalla = Tablero.getInstance();
		tableroBatalla.moverNaves();
		
	}

}
