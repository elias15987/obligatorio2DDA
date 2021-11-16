
package DominioJuego;

import java.util.List;

public abstract class Carta implements LaCasa, Comparable<Carta> {

    static List<Carta> mazoNuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
    
    
    
}
