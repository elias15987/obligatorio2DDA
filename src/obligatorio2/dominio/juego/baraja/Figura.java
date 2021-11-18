
package obligatorio2.dominio.juego.baraja;

import java.util.ArrayList;

public abstract class Figura {
    
    private String nombre;
    private int valor;
    private ArrayList<Carta> cartasFigura;
    
    public Figura(){
        
    }

    public Figura(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    
    public Figura(String nombre, ArrayList<Carta> cartasFigura) {
        this.nombre = nombre;
        this.cartasFigura = cartasFigura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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
    
    
}
