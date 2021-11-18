
package obligatorio2.dominio.usuarios;

import obligatorio2.utilidades.EventoMesaUsuario;
import obligatorio2.utilidades.Observable;


public abstract class Usuario extends Observable{
    private String user;
    private String password;
    private String nombreCompleto;

    
    public Usuario (){}
    
    public Usuario(String user, String password, String nombreCompleto) {
        this.user = user;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    boolean validarPassword(String password) {
        return this.getPassword().equals(password);
    }
    
    
    public void avisarEvento(){
        avisar(EventoMesaUsuario.ACTUALIZAR_SALDO);

    }
}
