
package DominioJuego;

import obligatorio2.dominio.Sistema;
import java.util.ArrayList;
import java.util.List;
import obligatorio2.dominio.usuarios.Usuario;
import obligatorio2.dominio.usuarios.UsuarioJuego;
import obligatorio2.utilidades.EventoJuego;
import obligatorio2.utilidades.EventoSistema;
import obligatorio2.utilidades.Observable;

public class PokerGame extends Observable{
    
    private List<UsuarioJuego> jugadores = new ArrayList<>();
    
    public int cantidadJugadores() {
        return jugadores.size();
    }

    public List<UsuarioJuego> getUsuarioJuego() {
        return jugadores;
    }
    
    public boolean agregarJugadorPartida(String nombreUsuario, double saldo){
        
            if(jugadores.contains(nombreUsuario)){
                return false;
            }
            jugadores.add(nombreUsuario);
            return true;
    }
    
    
}
