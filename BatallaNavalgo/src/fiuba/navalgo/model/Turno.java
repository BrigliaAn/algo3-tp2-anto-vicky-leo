package fiuba.navalgo.model;

public class Turno {
	private int contador;
	
	public Turno(){
		contador = 1;
	}
	
	public int devolverTurnoActual(){
		return contador;
	}
	
	public void aumentarContador(){
		contador = contador +1;		
	}

}
