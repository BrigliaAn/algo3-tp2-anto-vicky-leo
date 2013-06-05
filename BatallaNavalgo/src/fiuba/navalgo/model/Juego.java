package fiuba.navalgo.model;

import java.util.ArrayList;

import fiuba.navalgo.model.disparos.Disparo;
import fiuba.navalgo.model.naves.Nave;

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
		
		return this.puntaje.obtenerPuntos();
	}

	public int devolverTurnoActual() {
		
		return this.turno.devolverTurnoActual();
	}

	public void pasarTurno() {
		
		this.turno.aumentarContador();
		this.puntaje.restar(10);
		Tablero tableroBatalla = Tablero.getInstance();
		tableroBatalla.moverNaves();
		
	}
	
	public void disparar(Disparo unDisparo,Posicion pos){
		Tablero tableroDeBatalla = Tablero.getInstance();
		
		unDisparo.agregarCasilla(tableroDeBatalla.devolverCasilla(pos));
		unDisparo.agregarTurno(turno);
		
		int costo = unDisparo.devolverCosto();
		this.puntaje.restar(costo);
		tableroDeBatalla.agregarDisparo(unDisparo);
		tableroDeBatalla.ejecutarDisparo();
		System.out.print("hoala");
	}
	
	public ArrayList<Nave> verNavesDelTablero(){
		Tablero tableroDeBatalla = Tablero.getInstance();
		return tableroDeBatalla.verNaves();
	}
	

}
