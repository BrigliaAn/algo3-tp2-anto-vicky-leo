package fiuba.navalgo.model.titiritero.dibujables;

import java.awt.Graphics;

import fiuba.navalgo.model.titiritero.modelo.ObjetoPosicionable;
import fiuba.navalgo.model.titiritero.modelo.SuperficieDeDibujo;

public class Cuadrado extends Figura {

	private int ancho;
	private int alto;

	public Cuadrado(int ancho, int alto, ObjetoPosicionable objetoPosicionable) {
		super(objetoPosicionable);
		this.ancho = ancho;
		this.alto = alto;
	}


	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = ((SuperficiePanel)superfice).getBuffer();
		grafico.setColor(this.getColor());
		grafico.fillRect(getPosicionable().getX() , getPosicionable().getY(), this.ancho, this.alto);
	}

}