package fiuba.navalgo.view;

import java.io.IOException;
import fiuba.navalgo.model.naves.Nave;

public class MostrarNaves {
	public void mostrarNaves(JButtonID tablero[][],Nave nave) throws IOException{

		nave.mostrarTipoDeNave(tablero,nave);
	}
}