
package obligatorio2.dominio.juego;

import obligatorio2.dominio.usuarios.Usuario;


public class Apuesta {
    
    private int apuesta;
    private Usuario usuario;

    public Apuesta(int apuesta, Usuario usuario) {
        this.apuesta = apuesta;
        this.usuario = usuario;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
