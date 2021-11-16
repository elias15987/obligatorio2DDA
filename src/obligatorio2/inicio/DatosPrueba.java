package obligatorio2.inicio;

import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.usuarios.UsuarioAdministrador;
import obligatorio2.dominio.usuarios.UsuarioJuego;



public class DatosPrueba {
    public static void cargar() {
        Sistema logica  = Sistema.getInstancia();
        

        // Cargar usuarios
        logica.agregarUsuario(new UsuarioJuego("usuario1", "Usuario1", "Nombre Usuario 1"));
        logica.agregarUsuario(new UsuarioJuego("usuario2", "Usuario2", "Nombre Usuario 2"));
        logica.agregarUsuario(new UsuarioJuego("usuario3", "Usuario3", "Nombre Usuario 3"));
        logica.agregarUsuario(new UsuarioAdministrador("admin", "Admin", "Usuario Administrador"));
    }
}
