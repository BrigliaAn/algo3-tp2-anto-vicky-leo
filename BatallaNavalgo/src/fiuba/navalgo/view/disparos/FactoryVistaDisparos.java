package fiuba.navalgo.view.disparos;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import fiuba.navalgo.model.disparos.*;

public class FactoryVistaDisparos {
	 private Map<Class<? extends Disparo>, Class<? extends VistaDisparo>> listaDeVistasDisparos;

     public FactoryVistaDisparos() {
             listaDeVistasDisparos = new HashMap<Class<? extends Disparo>, Class<? extends VistaDisparo>>();
             this.rellenarListaNaves();
     }

     private void rellenarListaNaves() {
    	 
    	 listaDeVistasDisparos.put(MinaSubmarinaDoble.class, VistaMinaSubmarinaDoble.class);
    	 listaDeVistasDisparos.put(MinaSubmarinaPorContacto.class, VistaMinaSubmarinaPorContacto.class);
    	 listaDeVistasDisparos.put(MinaSubmarinaPuntual.class, VistaMinaSubmarinaPuntual.class);
    	 listaDeVistasDisparos.put(MinaSubmarinaTriple.class, VistaMinaSubmarinaTriple.class);
     }

     public VistaDisparo crearVistaDisparo(Disparo disparo) throws IOException {

             VistaDisparo vistaDisparo = null;
             Constructor<?>[] constructores = listaDeVistasDisparos.get(
                             disparo.getClass()).getConstructors();

             try {
                    vistaDisparo = (VistaDisparo) constructores[0].newInstance(disparo);
                                             
             } catch (IllegalArgumentException e) {
                     e.printStackTrace();
             } catch (InstantiationException e) {
                     e.printStackTrace();
             } catch (IllegalAccessException e) {
                     e.printStackTrace();
             } catch (InvocationTargetException e) {
                     e.printStackTrace();
             }
 
             return vistaDisparo;
     }
}