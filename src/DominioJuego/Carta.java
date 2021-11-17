
package DominioJuego;

import java.util.ArrayList;
import java.util.List;

public abstract class Carta implements Comparable<Carta> {
    
    private ValorCarta valor;
    private Palo palo;

    public Carta() {
    }
    
    public ValorCarta valor(){
        return valor;
    }
    
    public Palo palo(){
        return palo;
    }
    
    public Carta(ValorCarta valor, Palo palo) throws IllegalArgumentException {
        
        if (valor == null || palo == null) {
            
            throw new NullPointerException(valor + ", " + palo);
        }
        
        this.valor = valor;
        this.palo = palo;
                
    }

    public Palo getPalo() {
        return palo;
    }

    public ValorCarta getValor() {
        return valor;
    }
    
   @Override
    public int compareTo(Carta c) {
        int compararPalo = palo.compareTo(c.palo);
        return (compararPalo != 0 ?
                    compararPalo :
                    valor.compareTo(c.valor));
    }
    
    @Override
    public String toString(){
        
        return (getValor() + " de " + getPalo());
    }
    
    private static final List<Carta> auxMazo = new ArrayList<Carta>(52);

    static {
        for (Palo palo : Palo.values())
            for (ValorCarta valor : ValorCarta.values())
                auxMazo.add(new Carta(valor, palo) {});
    }

    // Returns a new deck
    public static List<Carta> mazoNuevo() {
        return new ArrayList<Carta>(auxMazo);
    }
    
    
}
