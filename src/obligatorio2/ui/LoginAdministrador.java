package obligatorio2.ui;

import java.awt.Frame;
import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.usuarios.Sesion;
import obligatorio2.dominio.usuarios.UsuarioAdministrador;

public class LoginAdministrador extends Login {

    public LoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Login Administrador");
    }

    @Override
    public Sesion hacerLogin(String user, String password) {
        return Sistema.getInstancia().loginUsuarioAdministrador(user, password);
    }

    @Override
    public void mostrarProximaInterfaz(Sesion sesion) {
        
        Prueba prueba = new Prueba();
        prueba.setVisible(true);
        prueba.setLocationRelativeTo(this);
    }
    
}
