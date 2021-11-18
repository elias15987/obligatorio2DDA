
package obligatorio2.dominio.juego.baraja;

import java.util.ArrayList;

public class Pierna extends Figura{
    
    public Pierna() {
    }

    public Pierna(Figuras nombre, int valor) {
        super(nombre, valor);
    }
    
    public Pierna(Figuras nombre, ArrayList<Carta> cartasFigura) {
        super(nombre, cartasFigura);
    }

    
    @Override
    public boolean tengoFigura(ArrayList<Carta> cartas) {
        
        boolean ret = false;
        
        int cont=0;
        ArrayList<Carta> cartasAux = new ArrayList<>();

        for (int i = 0; i < cartas.size(); i++) {
            for (int j = 0; j < cartas.size(); j++) {
                if (i!=j) {
                    if (cartas.get(i).getValor() == cartas.get(j).getValor()) {
                        if(!cartasAux.contains(cartas.get(i))){
                            cartasAux.add(cartas.get(i));
                        }
                        cont++;
                    }
                }
            }
        }
        super.setCartasFigura(cartasAux);

        
        if((cont / 2) >= 3){
            ret = true;
        }
        
        return ret;
    }

    @Override
    public ArrayList<Carta> retornoCartas(ArrayList<Carta> cartas) {
        ArrayList<Carta> cartasAux = new ArrayList<>();

        for (int i = 0; i < cartas.size(); i++) {
            for (int j = 0; j < cartas.size(); j++) {
                if (i!=j) {
                    if (cartas.get(i).getValor() == cartas.get(j).getValor()) {
                        if(!cartasAux.contains(cartas.get(i))){
                            cartasAux.add(cartas.get(i));
                        }
                    }
                }
            }
        }
        
        return cartasAux;
    }
}

