package fiuba.navalgo.model.naves;
import fiuba.navalgo.model.Casilla;

public class PorcionDeNave {
	
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
}	
