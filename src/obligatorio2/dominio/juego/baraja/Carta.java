
package obligatorio2.dominio.juego.baraja;


public class Carta {

    private Palo palo;
    private ValorCarta valor;

    public Carta(Palo palo, ValorCarta valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public Palo getPalo() {
        return palo;
    }

    public ValorCarta getValor() {
        return valor;
    }

    public int getValue() {
        return valor.ordinal() + 2;
    }

    @Override
    public boolean equals(Object o) {
        return (o != null && o instanceof Carta && ((Carta) o).valor == valor && ((Carta) o).palo == palo);
    }
}

