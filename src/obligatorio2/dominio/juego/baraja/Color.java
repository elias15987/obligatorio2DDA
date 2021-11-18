
package obligatorio2.dominio.juego.baraja;

import java.util.ArrayList;


public class Color extends Figura{
    
    public Color() {
    }

    
    public Color(String nombre, int valor) {
        super(nombre, valor);
    }
    
    public Color(String nombre, ArrayList<Carta> cartasFigura) {
        super(nombre, cartasFigura);
    }

    
    @Override
    public boolean tengoFigura(ArrayList<Carta> cartas) {
        
        boolean ret = true;
        
        for (int i = 0; i < (cartas.size()-1); i++) {
            if (!(cartas.get(i).getPalo().equals(cartas.get(i+1).getPalo()))) {
                ret=false;
            }
        }
        
        return ret;
    }
}
