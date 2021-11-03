package obligatorio2.ui;

import java.awt.Frame;
import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.usuarios.Sesion;

public class LoginJuego extends Login {

    public LoginJuego(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Login Juego");
    }

    @Override
    public Sesion hacerLogin(String nombre, String password) {
        return Sistema.getInstancia().loginUsuarioAgenda(nombre, password);
    }

    @Override
    public void mostrarProximaInterfaz(Sesion sesion) {
        
        Prueba prueba = new Prueba();
        prueba.setVisible(true);
        prueba.setLocationRelativeTo(this);
    }
    
}
