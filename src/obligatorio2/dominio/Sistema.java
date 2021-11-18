package obligatorio2.dominio;


import java.util.List;
import obligatorio2.dominio.juego.MesaClase;
import obligatorio2.dominio.juego.SistemaJuego;
import obligatorio2.dominio.juego.baraja.Carta;
import obligatorio2.dominio.juego.baraja.Figura;
import obligatorio2.dominio.usuarios.Sesion;
import obligatorio2.dominio.usuarios.SistemaUsuario;
import obligatorio2.dominio.usuarios.Usuario;
import obligatorio2.dominio.usuarios.UsuarioAdministrador;
import obligatorio2.dominio.usuarios.UsuarioJuego;
import obligatorio2.utilidades.Observable;

public class Sistema extends Observable {

    private SistemaUsuario sistemaUsuario = new SistemaUsuario();
    private SistemaJuego sistemaJuego = new SistemaJuego();

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
    
    public boolean agregarUsuario(UsuarioJuego usuario) {
        return sistemaUsuario.agregarUsuarioJuego(usuario);
    }
    
    public boolean agregarUsuario(UsuarioAdministrador usuario) {
        return sistemaUsuario.agregarUsuarioAdministrador(usuario);
    }

    public List<Sesion> getUsuariosLogueados() {
        return sistemaUsuario.getUsuariosLogueados();
    }
    
    public void logout(Sesion sesion) {
        sistemaUsuario.logout(sesion);
    }
    
    
    public MesaClase agregarUsuarioAMesa(Usuario usuario){
       MesaClase mesa = sistemaJuego.agregarUsuarioMesa(usuario);
       return mesa;
   }
    
    public void setLuzMesa(int luz){
        this.sistemaJuego.setLuz(luz);
    }
    
    public int traerLuzMesa(){
        return this.sistemaJuego.getLuz();
    }

    public SistemaJuego getSistemaJuego() {
        return sistemaJuego;
    }
    
    public void agregarFigura(Figura figura){
        this.sistemaJuego.agregarFigura(figura);
    }
     
}
