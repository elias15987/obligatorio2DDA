
package DominioJuego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepartirCartas {
    
    public static void main(String args[]) {
        int numeroMano     = Integer.parseInt(args[0]);
        int cartasPorManio = Integer.parseInt(args[1]);
        List<Carta> mazo  = Carta.mazoNuevo();
        Collections.shuffle(mazo);
        for (int i=0; i < numeroMano; i++)
            System.out.println(dealHand(mazo, cartasPorManio));
    }
    
    public static <E extends Comparable<E>>
    ArrayList<E> dealHand(List<E> deck, int n) {
        int tamanioMazo = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        ArrayList<E> hand = new ArrayList<>(handView);
        handView.clear();
        Collections.sort(hand);
        return hand;
    }
    
}
