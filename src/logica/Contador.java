
package logica;

import obligatorio2.utilidades.EventoContador;
import obligatorio2.utilidades.Observable;

public class Contador extends Observable{
    
    private int valor = 0;
    
    public void sumar() {
        valor += 1;
        avisar(EventoContador.CAMBIO_VALOR);
    }
    
    public void restar() {
        valor -= 1;
        if (valor < 0) {
            valor = 0;
        }
        avisar(EventoContador.CAMBIO_VALOR);
    }
    
    public int getValor() {
        return valor;
    }
    
}
