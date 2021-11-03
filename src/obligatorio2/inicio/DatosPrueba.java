package obligatorio2.inicio;

import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.usuarios.UsuarioAdministrador;
import obligatorio2.dominio.usuarios.UsuarioJuego;



public class DatosPrueba {
    public static void cargar() {
        Sistema logica  = Sistema.getInstancia();
        

        // Cargar usuarios
        logica.agregarUsuario(new UsuarioJuego("Usuario1", "usuario1", "Nombre Usuario 1"));
        logica.agregarUsuario(new UsuarioJuego("Usuario2", "usuario2", "Nombre Usuario 2"));
        logica.agregarUsuario(new UsuarioJuego("Usuario3", "usuario3", "Nombre Usuario 3"));
        logica.agregarUsuario(new UsuarioJuego("Usuario5", "usuario5", "Nombre Usuario 5"));
        logica.agregarUsuario(new UsuarioAdministrador("Admin", "admin", "Usuario Administrador"));
    }
}
