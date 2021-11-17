package obligatorio2.dominio.usuarios;

public class Sesion {
    private Usuario usuario;

    public Sesion(){}
    
    public Sesion(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
