package fiuba.navalgo.control;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Juego;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.movimiento.*;
import fiuba.navalgo.model.naves.*;

public class ControlJuego {
	
	private Juego juego;
	
	public ControlJuego(){
		Juego nuevoJuego = new Juego();
		juego = nuevoJuego;
		
	}
	
	
	public void cargarBarcos(){
		//int columna = (int) (Math.random() * 9);
		//int fila = (int) (Math.random() * 9);
		Tablero tablero = Tablero.getInstance();
		
		ArrayList<Movimiento> listaDeMovimientos = new ArrayList<Movimiento>();
		listaDeMovimientos.add(new Derecha());
		listaDeMovimientos.add(new Izquierda());
		listaDeMovimientos.add(new Arriba());
		listaDeMovimientos.add(new Abajo());
		listaDeMovimientos.add(new DiagonalAbajoDerecha());
		listaDeMovimientos.add(new DiagonalAbajoIzquierda());
		listaDeMovimientos.add(new DiagonalArribaDerecha());
		listaDeMovimientos.add(new DiagonalArribaIzquierda());
		
		Collections.shuffle(listaDeMovimientos);
			
		ArrayList<Casilla> listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,3)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,4)));
		
		Lancha lancha1 = new Lancha(listaDeMovimientos.get(0),listaDeCasillas);
		tablero.ponerNave(lancha1);
		
		listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(5,6)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(6,7)));
		
		Collections.shuffle(listaDeMovimientos);
		Lancha lancha2 = new Lancha(listaDeMovimientos.get(0),listaDeCasillas);
		tablero.ponerNave(lancha2);
		
		listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(9,0)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(9,1)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(9,2)));
		
		Collections.shuffle(listaDeMovimientos);
		Destructor destructor1 = new Destructor(listaDeMovimientos.get(0),listaDeCasillas);
		tablero.ponerNave(destructor1);
		
		listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(0,6)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(1,7)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,8)));
		
		Collections.shuffle(listaDeMovimientos);
		Destructor destructor2 = new Destructor(listaDeMovimientos.get(0),listaDeCasillas);
		tablero.ponerNave(destructor2);
		
		listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(3,4)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(4,4)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(5,4)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(6,4)));
		Collections.shuffle(listaDeMovimientos);
		Buque buque = new Buque(listaDeMovimientos.get(0),listaDeCasillas);
		tablero.ponerNave(buque);
		
		listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(7,3)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(7,4)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(7,5)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(7,6)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(7,7)));
		
		Collections.shuffle(listaDeMovimientos);
		PortaAviones portaAviones = new PortaAviones(listaDeMovimientos.get(0),listaDeCasillas);
		tablero.ponerNave(portaAviones);
		
		listaDeCasillas = new ArrayList<Casilla>();
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(3,2)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(2,3)));
		listaDeCasillas.add(tablero.devolverCasilla(new Posicion(1,4)));
	
		Collections.shuffle(listaDeMovimientos);
		RompeHielos rompeHielos = new RompeHielos(listaDeMovimientos.get(0),listaDeCasillas);
		tablero.ponerNave(rompeHielos);
		
		
		
	}
	
	public ArrayList<Nave> getNaves(){
		return juego.verNavesDelTablero();
	}
	
	public int getPuntaje(){
		return juego.verPuntajeActual();
	}
	
	public int getTurno(){
		return juego.devolverTurnoActual(); 
	}
	
	
}
