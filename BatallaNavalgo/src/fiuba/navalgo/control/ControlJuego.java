package fiuba.navalgo.control;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import fiuba.navalgo.model.Casilla;
import fiuba.navalgo.model.Juego;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.direccion.Horizontal;
import fiuba.navalgo.model.direccion.Vertical;
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
		
		ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones.add(new Horizontal());
		direcciones.add(new Vertical());
		
		Collections.shuffle(listaDeMovimientos);
		
	
		int columna = (int) (Math.random() * 9);
		int fila = (int) (Math.random() * 9);
		Posicion posicion = new Posicion(3, 9);
		
		Lancha lancha1 = new Lancha(listaDeMovimientos.get(0),direcciones.get(0), posicion);
		tablero.ponerNave(lancha1);
		
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		Posicion posicion2 = new Posicion(fila, columna);;
		
		Collections.shuffle(listaDeMovimientos);
		Collections.shuffle(direcciones);
		Lancha lancha2 = new Lancha(listaDeMovimientos.get(0),direcciones.get(0), posicion2);
		tablero.ponerNave(lancha2);
		
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		Posicion posicion3 = new Posicion(fila, columna);
		
		
		Collections.shuffle(listaDeMovimientos);
		Collections.shuffle(direcciones);
		Destructor destructor1 = new Destructor(listaDeMovimientos.get(0),direcciones.get(0), posicion3);
		tablero.ponerNave(destructor1);
		
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		Posicion posicion4 = new Posicion(fila, columna);
		
	
		Collections.shuffle(listaDeMovimientos);
		Collections.shuffle(direcciones);
		Destructor destructor2 = new Destructor(listaDeMovimientos.get(0),direcciones.get(0), posicion4);
		tablero.ponerNave(destructor2);
		
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		Posicion posicion5 = new Posicion(fila, columna);
		Collections.shuffle(listaDeMovimientos);
		Collections.shuffle(direcciones);
		Buque buque = new Buque(listaDeMovimientos.get(0),direcciones.get(0), posicion5);
		tablero.ponerNave(buque);
		
	
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		Posicion posicion6 = new Posicion(fila, columna);
		
		Collections.shuffle(listaDeMovimientos);
		Collections.shuffle(direcciones);
		PortaAviones portaAviones = new PortaAviones(listaDeMovimientos.get(0),direcciones.get(0), posicion6);
		tablero.ponerNave(portaAviones);
		
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		Posicion posicion7 = new Posicion(fila, columna);
		Collections.shuffle(direcciones);
		Collections.shuffle(listaDeMovimientos);
		RompeHielos rompeHielos = new RompeHielos(listaDeMovimientos.get(0),direcciones.get(0), posicion7);
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
