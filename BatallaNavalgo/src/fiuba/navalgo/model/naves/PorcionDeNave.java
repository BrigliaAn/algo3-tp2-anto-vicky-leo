package fiuba.navalgo.model.naves;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.navalgo.model.Casilla;

public class PorcionDeNave implements ObjetoPosicionable {
	
		private int vida;
		private Casilla casilla;

		
		public PorcionDeNave(int vida, Casilla casilla){
			this.vida = vida;
			this.casilla = casilla;
			
		}
		
		public boolean estaDestruida(){
			return (this.vida == 0);
		}
		
		public void destruir(){
			this.vida = this.vida -1;
		}
		
		public void mover(Casilla nuevaCasilla){
			this.casilla = nuevaCasilla;
		}
		public Casilla getCasilla(){
			return casilla;
		}

		@Override
		public int getX() {

			return (this.casilla.getPosicion().getColumna());
		}

		@Override
		public int getY() {

			return (this.casilla.getPosicion().getFila());
		}
}	
