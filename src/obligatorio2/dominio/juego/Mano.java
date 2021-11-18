
package obligatorio2.dominio.juego;

import java.util.ArrayList;
import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.juego.baraja.Carta;
import obligatorio2.dominio.juego.baraja.Figura;
import obligatorio2.dominio.usuarios.Usuario;

public class Mano {
    
    private ArrayList<Carta> mano = new ArrayList<>();
    private Figura figura;

    
    
    public Mano() {
        
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    } 

    
    public void limpiarMano(){
        this.mano = new ArrayList<>();
    }
    
    public void agregarCarta(Carta carta){
        this.mano.add(carta);
    }
    
    
    public void verificarSiTengoFigura(){
        for(Figura f : Sistema.getInstancia().getSistemaJuego().getFigurasPoker()){
           if(f.tengoFigura(mano)){
               if(figura == null || f.getValor() > figura.getValor()){
                   figura = f;
              
               }
           }
       }
    }
    
    
    
}
