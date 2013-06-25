package fiuba.navalgo.model.titiritero.dibujables;


import java.awt.Color;

import fiuba.navalgo.model.titiritero.modelo.ObjetoDibujable;
import fiuba.navalgo.model.titiritero.modelo.ObjetoPosicionable;
import fiuba.navalgo.model.titiritero.modelo.SuperficieDeDibujo;

public abstract class Figura implements ObjetoDibujable {

	private Color color;
	private ObjetoPosicionable posicionable;

	public abstract void dibujar(SuperficieDeDibujo superfice);

	public void setColor(Color unColor){
		this.color = unColor; 
	}

	public Color getColor() {
		return this.color;
	}

	public ObjetoPosicionable getPosicionable() {
		return this.posicionable;
	}

	public Figura(ObjetoPosicionable posicionable) {
		this.posicionable = posicionable;
		this.color = Color.BLACK;
	}

}