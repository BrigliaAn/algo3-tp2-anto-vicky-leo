package fiuba.navalgo.view.naves;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import fiuba.navalgo.model.naves.*;

public class FactoryVistaNave {

        private Map<Class<? extends Nave>, Class<? extends VistaNave>> listaDeVistasNaves;

        public FactoryVistaNave() {
                listaDeVistasNaves = new HashMap<Class<? extends Nave>, Class<? extends VistaNave>>();
                this.rellenarListaNaves();
        }

        private void rellenarListaNaves() {
                listaDeVistasNaves.put(Buque.class, VistaBuque.class);
                listaDeVistasNaves.put(Destructor.class, VistaDestructor.class);
                listaDeVistasNaves.put(Lancha.class, VistaLancha.class);
                listaDeVistasNaves.put(PortaAviones.class, VistaPortaAviones.class);
                listaDeVistasNaves.put(RompeHielos.class, VistaRompeHielos.class);
        }

        public VistaNave crearVistaNave(Nave nave) throws IOException {

                VistaNave vistaNave = null;
                Constructor<?>[] constructores = listaDeVistasNaves.get(
                                nave.getClass()).getConstructors();

                try {
                       vistaNave = (VistaNave) constructores[0].newInstance(nave);
                                                
                } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                } catch (InstantiationException e) {
                        e.printStackTrace();
                } catch (IllegalAccessException e) {
                        e.printStackTrace();
                } catch (InvocationTargetException e) {
                        e.printStackTrace();
                }
    
                return vistaNave;
        }
}