
package DominioJuego;

public abstract class Carta implements LaCasa, Comparable<Carta> {
    
    private int valor;
    private Palo palo;

    public Carta() {
    }

    public Carta(int valor, Palo palo) throws IllegalArgumentException {
        
        if (valor < 2 || valor > 14) {
            
            throw new IllegalArgumentException("Los valores de la carta son incorrectos.");
        }
        
        this.valor = valor;
        this.palo = palo;
                
    }

    public Palo getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }
    
    public String getValorCarta(){
        
        if(valor <= 10) {
            
            return Integer.toString(valor);
            
        }
        else{
            switch(valor){
                case (11) : return "J";
                case (12) : return "Q";
                case (13) : return "K";
                case (14) : return "A";
                default: return "Ocurrió un error inesperado.";
            }
        }
        
    }
    
    @Override
    public int compareTo(Carta otraCarta){ //le iba a poner con un boolean pero el compareTo me mandó a pasear si no era int
        
        if (this.valor > otraCarta.valor) {
            return 1;
        }
        else if (this.valor > otraCarta.valor){
            return -1;
        }
        else {
            return 0;
        }
    }
    
    //Falta ver como hacer que los enum se comparen para que los palos también jueguen en determinar cual es mayor
    
    @Override
    public String toString(){
        
        return (getValorCarta() + " de " + getPalo());
    }
    
    
    
}
