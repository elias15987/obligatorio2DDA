
package obligatorio2.controladores;

import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.usuarios.Sesion;
import obligatorio2.dominio.usuarios.Usuario;
import obligatorio2.dominio.usuarios.UsuarioJuego;
import obligatorio2.ui.Login;
import obligatorio2.ui.PanelJugador;

public class PanelController {
        
    private Sesion sesion;
    private PanelJugador vistaPanel;
    private Login login;
    private Sistema modelo = Sistema.getInstancia();

    
       public PanelController(Login login, Usuario usuario) {
        this.login = login;
        this.sesion = new Sesion(usuario);
    }
        
       
    public void cerrarSesion(){
        Sistema.getInstancia().logout(this.sesion);
    }
    
    
    private void mostrarTitulo() {
        String titulo = sesion.getUsuario().getNombreCompleto();
        vistaPanel.mostrarTitulo(titulo);
    }
    
    public String getNombreSesion(){
        return this.sesion.getUsuario().getNombreCompleto();
    }
    
    public double getSaldoSesion(){
        return ((UsuarioJuego)this.sesion.getUsuario()).getSaldo();
    }
    
    public Usuario getUsuarioSesion(){
        return this.sesion.getUsuario();
    }
       
}
