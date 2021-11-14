
package DominioJuego;

import java.util.ArrayList;

public abstract class ManoJugador implements Comparable<ManoJugador>{
    
    private ArrayList<Carta> mano;
    private int tamanioMano = 5;
    private FigurasPosibles figuraMano;

    public ManoJugador(ArrayList<Carta> cartas) {
        
        if(cartas == null || cartas.size() != 5) {
            
            throw new IllegalArgumentException("Cantidad de cartas repartidas no es correcta");
        }
        
        mano = cartas;
        
    }
    
    public ArrayList<Carta> manoActualJugador(){
        
        return mano;
    }
    

    
    
}
