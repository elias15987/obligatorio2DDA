package obligatorio2.dominio.usuarios;

import java.util.ArrayList;
import java.util.List;
//import utilidades.EventoSistema;

public class SistemaUsuario {

    private List<UsuarioJuego> usuariosJuego = new ArrayList<>();
    private List<UsuarioAdministrador> usuariosAdministrador = new ArrayList<>();
    private List<Sesion> usuariosLogueados = new ArrayList<>();

    public boolean agregarUsuarioJuego(UsuarioJuego usuarioJuego) {
        if (usuariosJuego.contains(usuarioJuego)) {
            return false;
        }
        usuariosJuego.add(usuarioJuego);
        return true;
    }
    
    public boolean agregarUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador) {
        if (usuariosAdministrador.contains(usuarioAdministrador)) {
            return false;
        }
        usuariosAdministrador.add(usuarioAdministrador);
        return true;
    }
    
    public Sesion loginUsuarioAgenda(String user, String password) {
        Usuario usuario = login(user, password, usuariosJuego);
        if (usuario == null) {
            return null;
        }
        UsuarioJuego usuarioAgenda = (UsuarioJuego)usuario;
        Sesion sesion = new Sesion(usuarioAgenda);
        usuariosLogueados.add(sesion);
        //Sistema.getInstancia().avisar(EventoSistema.LISTA_LOGUEADOS);
        
        return sesion;
    }

    private Usuario login(String user, String password, List usuarios) {
        Usuario usuario = buscarUsuario(user, usuarios);
        if (usuario == null || !usuario.validarPassword(password)) {
            return null;
        }
        return usuario;
    }
    
    private Usuario buscarUsuario(String user, List usuarios) {
        Usuario usuario;
        for (Object object : usuarios) {
            usuario = (Usuario) object;
            if (usuario.getUser().equals(user)) {
                return usuario;
            }
        }
        return null;
    }
    
    public Sesion loginUsuarioAdministrador(String nombre, String password) {
        Usuario usuario = login(nombre, password, usuariosAdministrador);
        if (usuario == null) {
            return null;
        }
        UsuarioAdministrador usuarioAdministrador = (UsuarioAdministrador)usuario;
        Sesion sesion = new Sesion(usuarioAdministrador);
        
        return sesion;
    }
    
    public List<Sesion> getUsuariosLogueados() {
        return usuariosLogueados;
    }
    
    public void logout(Sesion sesion) {
        if (usuariosLogueados.contains(sesion)) {
            usuariosLogueados.remove(sesion);
        }
    }
}
