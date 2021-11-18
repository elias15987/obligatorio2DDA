
package obligatorio2.dominio.juego.baraja;

import java.util.ArrayList;
import java.util.Random;

public class Mazo {
    
    private ArrayList<Carta> cartas;
    private ArrayList<Carta> cartasRepartidas;
    private Random random;
    
    public Mazo() {
        random = new Random();
        cartasRepartidas = new ArrayList<Carta>();
        cartas = new ArrayList<Carta>(Palo.values().length * ValorCarta.values().length);
        armarMazo();
    }
    
    public void armarMazo() {
        cartasRepartidas.clear();
        cartas.clear();
        for (Palo p : Palo.values()) {
            for (ValorCarta v : ValorCarta.values()) {
                Carta c = new Carta(p, v);
                cartas.add(c);
            }
        }
    }

   
    public Carta repartirRandom() {
        if (cartas.isEmpty()){
            return null;
        }

        Carta res = cartas.remove(randInt(0, cartas.size() - 1));
        if (res != null){
            cartasRepartidas.add(res);
        }
        return res;
    }


    public Carta getRandom() {
        if (cartas.isEmpty()){
            return null;
        }
        Carta res = cartas.get(randInt(0, cartas.size() - 1));
        return res;
    }


    public int randInt(int min, int max) {
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }


    public boolean isEmpty(){
        return cartas.isEmpty();
    }

}
