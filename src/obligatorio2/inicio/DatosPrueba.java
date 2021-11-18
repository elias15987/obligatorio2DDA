package obligatorio2.inicio;

import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.juego.baraja.Color;
import obligatorio2.dominio.juego.baraja.Figuras;
import obligatorio2.dominio.juego.baraja.Par;
import obligatorio2.dominio.juego.baraja.Pierna;
import obligatorio2.dominio.usuarios.UsuarioAdministrador;
import obligatorio2.dominio.usuarios.UsuarioJuego;



public class DatosPrueba {
    public static void cargar() {
        Sistema logica  = Sistema.getInstancia();
        
        //set Luz para las mesas
        logica.setLuzMesa(10);
        

        // Cargar usuarios
        logica.agregarUsuario(new UsuarioJuego("usuario1", "Usuario1", "Nombre Usuario 1", 100));
        logica.agregarUsuario(new UsuarioJuego("usuario2", "Usuario2", "Nombre Usuario 2", 200));
        logica.agregarUsuario(new UsuarioJuego("usuario3", "Usuario3", "Nombre Usuario 3", 300));        
        logica.agregarUsuario(new UsuarioJuego("usuario4", "Usuario4", "Nombre Usuario 4", 400));
        logica.agregarUsuario(new UsuarioJuego("usuario5", "Usuario5", "Nombre Usuario 5", 500));
        logica.agregarUsuario(new UsuarioJuego("usuario6", "Usuario6", "Nombre Usuario 6", 600));
        logica.agregarUsuario(new UsuarioJuego("usuario7", "Usuario7", "Nombre Usuario 7", 5));


        logica.agregarUsuario(new UsuarioAdministrador("admin", "Admin", "Usuario Administrador"));
        
        logica.agregarFigura(new Par(Figuras.PAR, Figuras.PAR.getValor()));
        logica.agregarFigura(new Pierna(Figuras.PIERNA, Figuras.PIERNA.getValor()));
        logica.agregarFigura(new Color(Figuras.COLOR, Figuras.COLOR.getValor()));
    }
}
