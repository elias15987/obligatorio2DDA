
package obligatorio2.dominio.juego.baraja;

import java.util.ArrayList;

public class Pierna extends Figura{
    
    public Pierna() {
    }

    public Pierna(String nombre, int valor) {
        super(nombre, valor);
    }
    
    public Pierna(String nombre, ArrayList<Carta> cartasFigura) {
        super(nombre, cartasFigura);
    }

    
    @Override
    public boolean tengoFigura(ArrayList<Carta> cartas) {
        
        boolean ret = false;
        
        int cont=0;
        
        for (int i = 0; i < cartas.size(); i++) {
            for (int j = 0; j < cartas.size(); j++) {
                if (i!=j) {
                    if (cartas.get(i).getValor() == cartas.get(j).getValor()) {
                        cont++;
                    }
                }
            }
        }
        
        if((cont / 2) >= 3){
            ret = true;
        }
        
        return ret;
    }
}

