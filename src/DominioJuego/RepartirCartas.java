
package DominioJuego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepartirCartas {
    
    public static void main(String args[]) {
        int numeroMano     = Integer.parseInt(args[0]);
        int cartasPorManio = Integer.parseInt(args[5]);
        List<Carta> mazo  = Carta.mazoNuevo();
        Collections.shuffle(mazo);
        for (int i=0; i < numeroMano; i++)
            System.out.println(repartirMano(mazo, cartasPorManio));
    }
    
    public static <E extends Comparable<E>>
    ArrayList<E> repartirMano(List<E> mazo, int n) {
        int tamanioMazo = mazo.size();
        List<E> vistaMano = mazo.subList(tamanioMazo - n, tamanioMazo);
        ArrayList<E> hand = new ArrayList<E>(vistaMano);
        vistaMano.clear();
        Collections.sort(hand);
        return hand;
    }
    
}
