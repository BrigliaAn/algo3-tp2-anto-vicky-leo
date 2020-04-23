package fiuba.navalgo.control;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import fiuba.navalgo.model.Juego;
import fiuba.navalgo.model.Posicion;
import fiuba.navalgo.model.Tablero;
import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.direccion.Horizontal;
import fiuba.navalgo.model.direccion.Vertical;
import fiuba.navalgo.model.disparos.*;
import fiuba.navalgo.model.movimiento.*;
import fiuba.navalgo.model.naves.*;
import fiuba.navalgo.view.disparos.FactoryVistaDisparos;
import fiuba.navalgo.view.disparos.VistaDisparo;
import fiuba.navalgo.view.naves.FactoryVistaNave;
import fiuba.navalgo.view.naves.VistaNave;

public class ControlJuego {
	
	private Juego juego;
	private Disparo disparoEnCurso;
	private ArrayList<VistaNave> vistaNaves = new ArrayList<VistaNave>();
	private ArrayList<VistaDisparo> vistaDisparos = new ArrayList<VistaDisparo>();
	private boolean inicioJuego = false;
	
	public ControlJuego(){
		Juego nuevoJuego = new Juego();
		juego = nuevoJuego;
		disparoEnCurso = new DisparoConvencional();
	}
	
	
	
	public void print() {
		new 88888888888();
	}
	
	
	public void cargarBarcos() throws IOException{
		
		FactoryVistaNave factory = new FactoryVistaNave();
		
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
		Posicion posicion = new Posicion(fila, columna);
	
		
		Lancha lancha1 = new Lancha(listaDeMovimientos.get(0),direcciones.get(0), posicion);
		tablero.ponerNave(lancha1);
		
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		posicion = new Posicion(fila, columna);;
		
		Collections.shuffle(listaDeMovimientos);
		Collections.shuffle(direcciones);

		Lancha lancha2 = new Lancha(listaDeMovimientos.get(0),direcciones.get(0), posicion);
		tablero.ponerNave(lancha2);
		
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		posicion = new Posicion(fila, columna);
		
		
		Collections.shuffle(listaDeMovimientos);
		Collections.shuffle(direcciones);

		Destructor destructor1 = new Destructor(listaDeMovimientos.get(0),direcciones.get(0), posicion);
		tablero.ponerNave(destructor1);
		
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		posicion = new Posicion(fila, columna);
	
		Collections.shuffle(listaDeMovimientos);
		Collections.shuffle(direcciones);

		Destructor destructor2 = new Destructor(listaDeMovimientos.get(0),direcciones.get(0), posicion);
		tablero.ponerNave(destructor2);
		
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		posicion = new Posicion(fila, columna);
		Collections.shuffle(listaDeMovimientos);
		Collections.shuffle(direcciones);

		Buque buque = new Buque(listaDeMovimientos.get(0),direcciones.get(0), posicion);
		tablero.ponerNave(buque);
		
	
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		posicion = new Posicion(fila, columna);

		Collections.shuffle(listaDeMovimientos);
		Collections.shuffle(direcciones);

		PortaAviones portaAviones = new PortaAviones(listaDeMovimientos.get(0),direcciones.get(0), posicion);
		tablero.ponerNave(portaAviones);
		
		columna = (int) (Math.random() * 9);
		fila = (int) (Math.random() * 9);
		posicion = new Posicion(fila, columna);
		Collections.shuffle(direcciones);
		Collections.shuffle(listaDeMovimientos);
		
		RompeHielos rompeHielos = new RompeHielos(listaDeMovimientos.get(0),direcciones.get(0), posicion);
		tablero.ponerNave(rompeHielos);
		
		ArrayList<Nave> naves = tablero.verNaves();
		for(Nave nave: naves){
			this.vistaNaves.add(factory.crearVistaNave(nave));
		
		}
		
		
	}
	
	public void crearVistaDisparo(Disparo disparo) throws IOException{
		FactoryVistaDisparos factory = new FactoryVistaDisparos();
		this.vistaDisparos.add(factory.crearVistaDisparo(disparo));
	}
	
	public ArrayList<VistaDisparo> getVistaDisparos(){
		ArrayList<VistaDisparo> vistasADestruir = new ArrayList<VistaDisparo>();
		for(VistaDisparo vista: this.vistaDisparos){
			if(vista.explotada()){
				vistasADestruir.add(vista);
			}
		}
		for(VistaDisparo vistaDestruir: vistasADestruir){
			this.vistaDisparos.remove(vistaDestruir);
		}
		return this.vistaDisparos;
	}
	
	public ArrayList<VistaNave> getVistaNaves(){
		ArrayList<VistaNave> vistasADestruir = new ArrayList<VistaNave>();
		for(VistaNave vista: this.vistaNaves){
			if(vista.destruida()){
				vistasADestruir.add(vista);
				
			}
		}
		for(VistaNave vistaDestruir: vistasADestruir){
			this.vistaNaves.remove(vistaDestruir);
		}
		return this.vistaNaves;
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
	
	public Disparo getDisparoEnCurso(){
		return disparoEnCurso;

	}
	
	public void cambiarDisparoEnCurso(Disparo nuevoDisparo){
		disparoEnCurso = nuevoDisparo;

	}
	
	public void disparar(int fila, int col){
	
		juego.disparar(disparoEnCurso,new Posicion(fila,col));
		juego.pasarTurno();
	}
	
	public void pasarTurno(){
		juego.pasarTurno();
	}
	
	public boolean juegoEstaTerminado(){
	
		return this.juego.juegoTerminado();
	
	}
	
	public ArrayList<Disparo> getDisparos(){
		Tablero tablero = Tablero.getInstance();
		return tablero.verDisparos();
	}
	
	public void crearNuevoJuego(){
		juego = new Juego();
		inicioJuego = true;
		disparoEnCurso = new DisparoConvencional();
		vistaNaves.clear();
		vistaDisparos.clear();
		
	}


	public boolean inicioJuego() {
	
		return this.inicioJuego;
	}


	public void finalizarJuego() {
		this.inicioJuego = false;
		
	}
	
}
