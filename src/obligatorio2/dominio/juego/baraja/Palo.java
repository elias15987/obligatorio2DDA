
package obligatorio2.dominio.juego.baraja;

public enum Palo {
    CORAZONES(4), 
    DIAMANTES(3),
    PIQUES(2),
    TREBOLES(1);
    
    private int numero;
    
    Palo(){}
    
    Palo(int numero) {
        this.numero = numero;
    }

    int retornarNumero() {
        return numero;
    }
}
