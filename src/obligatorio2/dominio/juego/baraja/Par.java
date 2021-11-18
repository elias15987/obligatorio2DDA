
package obligatorio2.dominio.juego.baraja;

import java.util.ArrayList;


public class Par extends Figura{

    public Par() {
    }

    public Par(String nombre, int valor) {
        super(nombre, valor);
    }
    
    public Par(String nombre, ArrayList<Carta> cartasFigura) {
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
        
        if((cont / 2) >= 1){
            ret = true;
        }
        
        return ret;
    }
    
}
