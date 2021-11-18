
package obligatorio2.dominio.juego.baraja;

import java.util.ArrayList;


public enum Figuras {
    PAR(1),
    PIERNA(2),
    COLOR(3);
    
    private int numero;
    
    Figuras(){}
    
    Figuras(int numero) {
        this.numero = numero;
    }

    public int getValor() {
        return this.numero;
    }
}
