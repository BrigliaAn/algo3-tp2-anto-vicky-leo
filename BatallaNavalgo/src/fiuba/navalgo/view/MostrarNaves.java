package fiuba.navalgo.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.navalgo.model.direccion.Vertical;
import fiuba.navalgo.model.naves.Buque;
import fiuba.navalgo.model.naves.Destructor;
import fiuba.navalgo.model.naves.Lancha;
import fiuba.navalgo.model.naves.Nave;
import fiuba.navalgo.model.naves.PorcionDeNave;
import fiuba.navalgo.model.naves.PortaAviones;
import fiuba.navalgo.model.naves.RompeHielos;

public class MostrarNaves {
	public void mostrarNaves(JButtonID tablero[][],Nave nave) throws IOException{

		nave.mostrarTipoDeNave(tablero,nave);
	}
}