
package obligatorio2.dominio.juego.baraja;

import java.util.ArrayList;


public class Color extends Figura{
    
    public Color() {
    }

    
    public Color(Figuras nombre, int valor) {
        super(nombre, valor);
    }
    
    public Color(Figuras nombre, ArrayList<Carta> cartasFigura) {
        super(nombre, cartasFigura);
    }

    
    @Override
    public boolean tengoFigura(ArrayList<Carta> cartas) {
        
        boolean ret = true;
        
        for (int i = 0; i < (cartas.size()-1); i++) {
            if (!(cartas.get(i).getPalo().equals(cartas.get(i+1).getPalo()))) {
                ret=false;
            }
        }
        ArrayList<Carta> cartasAux = new ArrayList<>();
        cartasAux.add(cartas.get(0));
        
        super.setCartasFigura(cartasAux);

        return ret;
    }
    
    @Override
    public boolean masAlta(Figura figura) {
        if(this.getValor() > figura.getValor()){
           return true;
        }
        else if(this.getValor() == figura.getValor()){
            if(super.getCartasFigura().get(0).getPalo().retornarNumero() > figura.getCartasFigura().get(0).getPalo().retornarNumero()){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public ArrayList<Carta> retornoCartas(ArrayList<Carta> cartas) {
        
        ArrayList<Carta> cartasAux = new ArrayList<>();
        boolean bandera = false;
        
        for (int i = 0; i < (cartas.size()-1); i++) {
            if (!(cartas.get(i).getPalo().equals(cartas.get(i+1).getPalo()))) {
                bandera = true;
            }
        }
        if(!bandera){
            cartasAux.add(cartas.get(0));
        }
        

        return cartasAux;
    }
}
