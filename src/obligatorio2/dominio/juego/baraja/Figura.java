
package obligatorio2.dominio.juego.baraja;

import java.util.ArrayList;

public abstract class Figura {
    
    private Figuras nombre;
    private int valor;
    private ArrayList<Carta> cartasFigura;
    
    public Figura(){
        
    }

    public Figura(Figuras nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    
    public Figura(Figuras nombre, ArrayList<Carta> cartasFigura) {
        this.nombre = nombre;
        this.cartasFigura = cartasFigura;
    }

    public Figuras getNombre() {
        return nombre;
    }

    public void setNombre(Figuras nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carta> getCartasFigura() {
        return cartasFigura;
    }

    public void setCartasFigura(ArrayList<Carta> cartasFigura) {
        this.cartasFigura = cartasFigura;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
    public abstract boolean tengoFigura(ArrayList<Carta> cartas);
    
    public abstract ArrayList<Carta>  retornoCartas(ArrayList<Carta> cartas);

    
    
    public boolean masAlta(Figura figura) {
        
       if(this.getValor() > figura.getValor()){
           return true;
       }
       else if(this.getValor() == figura.getValor()){
           Carta cartaAlta = null;
           
           for(Carta c : this.getCartasFigura()){
               for(Carta c2 : figura.getCartasFigura()){
                   if(c.getValor().retornarNumero() > c2.getValor().retornarNumero()){
                       cartaAlta = c;
                       return true;
                   }
                   else if(c.getValor().retornarNumero() == c2.getValor().retornarNumero()){
                       if(c.getPalo().retornarNumero() > c2.getPalo().retornarNumero()){
                           cartaAlta = c;
                           return true;
                       }
                   }
                   else {
                       return false;
                   }
                }
           }
       }else{
           return false;
       }
        return false;
    }
    
}
