package obligatorio2.dominio;


import java.util.List;
import obligatorio2.dominio.usuarios.Sesion;
import obligatorio2.dominio.usuarios.SistemaUsuario;
import obligatorio2.dominio.usuarios.UsuarioAdministrador;
import obligatorio2.dominio.usuarios.UsuarioJuego;
import obligatorio2.utilidades.Observable;

public class Sistema extends Observable {

    //private SistemaTipo sistemaTipo = new SistemaTipo();
    private SistemaUsuario sistemaUsuario = new SistemaUsuario();

    private static Sistema instancia = new Sistema();
    
    public static Sistema getInstancia() {
        return instancia;
    }
    
    public Sesion loginUsuario(String user, String password) {
        Sesion retSesion = sistemaUsuario.loginUsuarioJuego(user, password);
        
        if(retSesion == null){
            retSesion = sistemaUsuario.loginUsuarioAdministrador(user, password);
        }
        return retSesion;
    }
    

    /*
    public List<TipoContacto> getTiposContacto() {
        return sistemaTipo.getTiposContacto();
    }
    
    public List<TipoTelefono> getTiposTelefono() {
        return sistemaTipo.getTiposTelefono();
    }
    */
    
    public boolean agregarUsuario(UsuarioJuego usuario) {
        return sistemaUsuario.agregarUsuarioJuego(usuario);
    }
    
    public boolean agregarUsuario(UsuarioAdministrador usuario) {
        return sistemaUsuario.agregarUsuarioAdministrador(usuario);
    }
    
    /*
    public boolean agregarTipoContacto(TipoContacto tipoContacto) {
        return sistemaTipo.agregarTipoContacto(tipoContacto);
    }
    
    public boolean agregarTipoTelefono(TipoTelefono tipoTelefono) {
        return sistemaTipo.agregarTipoTelefono(tipoTelefono);
    }
    
*/
    
    public List<Sesion> getUsuariosLogueados() {
        return sistemaUsuario.getUsuariosLogueados();
    }
    
    public void logout(Sesion sesion) {
        sistemaUsuario.logout(sesion);
    }
}
