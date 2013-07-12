package fiuba.navalgo.view.naves;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import fiuba.navalgo.model.direccion.Direccion;
import fiuba.navalgo.model.direccion.Vertical;
import fiuba.navalgo.model.naves.*;

public class FactoryVistaNave {

        private Map<Class<? extends Nave>, Class<? extends VistaNave>> listaDeVistasNaves;
        private Map<Class<? extends Nave>, Class<? extends VistaNave>> listaDeVistasNavesVerticales;

        public FactoryVistaNave() {
                listaDeVistasNaves = new HashMap<Class<? extends Nave>, Class<? extends VistaNave>>();
                listaDeVistasNavesVerticales = new HashMap<Class<? extends Nave>, Class<? extends VistaNave>>();
                this.rellenarListaNaves();
        }

        private void rellenarListaNaves() {
                listaDeVistasNaves.put(Buque.class, VistaBuque.class);
                listaDeVistasNaves.put(Destructor.class, VistaDestructor.class);
                listaDeVistasNaves.put(Lancha.class, VistaLancha.class);
                listaDeVistasNaves.put(PortaAviones.class, VistaPortaAviones.class);
                listaDeVistasNaves.put(RompeHielos.class, VistaRompeHielos.class);
                listaDeVistasNavesVerticales.put(Buque.class, VistaBuqueVertical.class);
                listaDeVistasNavesVerticales.put(Destructor.class, VistaDestructorVertical.class);
                listaDeVistasNavesVerticales.put(Lancha.class, VistaLanchaVertical.class);
                listaDeVistasNavesVerticales.put(PortaAviones.class, VistaPortaAvionesVertical.class);
                listaDeVistasNavesVerticales.put(RompeHielos.class, VistaRompeHielosVertical.class);
          
        }


        public VistaNave crearVistaNave(Nave nave) throws IOException {

                VistaNave vistaNave = null;
                Direccion direccion = nave.getDireccion();
                Constructor<?>[] constructores;
                
                if (direccion instanceof Vertical){
                   	constructores = listaDeVistasNavesVerticales.get(
                	nave.getClass()).getConstructors();
                }else{
                	constructores = listaDeVistasNaves.get(
                    nave.getClass()).getConstructors();
                }
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