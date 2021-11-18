
package obligatorio2.dominio.usuarios;

import obligatorio2.dominio.juego.Mano;
import obligatorio2.utilidades.EventoMesaUsuario;

public class UsuarioJuego extends Usuario {
    
    private int saldo; 
    private Mano mano;

    
    public UsuarioJuego(){}
    
    public UsuarioJuego(String user, String password, String nombreCompleto, int saldo) {
        super(user, password, nombreCompleto);
        this.saldo = saldo;
    }
    
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public void restarApuesta(int apuesta){
        this.saldo -= apuesta;
    }

    public Mano getMano() {
        return mano;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }
    
    
    
}
