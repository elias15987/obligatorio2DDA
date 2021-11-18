
package obligatorio2.dominio.juego.baraja;

public enum ValorCarta {
    A(14),
    K(13),
    Q(12),
    J(11),
    DIEZ(10),
    NUEVE(9),
    OCHO(8),
    SIETE(7),
    SEIS(6),
    CINCO(5),
    CUATRO(4),
    TRES(3),
    DOS(2);
    
    private int numero;
    
    ValorCarta(){}
    
    ValorCarta(int numero) {
        this.numero = numero;
    }

    public int retornarNumero() {
        return numero;
    }

}