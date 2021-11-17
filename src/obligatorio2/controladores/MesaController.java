
package obligatorio2.controladores;

import javax.swing.JOptionPane;
import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.juego.MesaClase;
import obligatorio2.dominio.usuarios.Sesion;
import obligatorio2.dominio.usuarios.Usuario;
import obligatorio2.ui.Mesa;
import obligatorio2.ui.PanelJugador;
import obligatorio2.utilidades.EventoMesaUsuario;
import obligatorio2.utilidades.Observable;
import obligatorio2.utilidades.Observador;

public class MesaController implements Observador{
    
    
    private MesaClase mesa;
    private PanelJugador panel;
    private Mesa vistaMesa;
    private Sesion sesion;
    private Sistema modelo = Sistema.getInstancia();

    public MesaController(PanelJugador panel, Usuario usuario) {
        this.panel = panel;
        this.sesion = new Sesion(usuario);
    }
    
    
    
    public void entrarEnMesa(){
        this.mesa = modelo.agregarUsuarioAMesa(sesion.getUsuario());
        
        if(mesa != null){
            this.mesa.agregar(this);
            
            this.vistaMesa = new Mesa(this.panel, false, this);
            this.vistaMesa.setVisible(true);
            this.vistaMesa.setLocationRelativeTo(this.panel);
            mostrarTitulo();
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo entrar en mesa", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    
    public void salirDeMesa(){
        this.vistaMesa.dispose();
        this.mesa.eliminarUsuario(this.sesion.getUsuario());
        
    }

    public MesaClase getMesa() {
        return mesa;
    }

    public void setMesa(MesaClase mesa) {
        this.mesa = mesa;
    }

    public Sesion getSesion() {
        return sesion;
    }
    
    
    
    
    @Override
    public void actualizar(Observable origen, Object evento) {
         if (evento.equals(EventoMesaUsuario.LISTA_JUGADORES)) {
           this.actualizarJugadoresEnMesa();
        }
        
    }
    
    private void mostrarTitulo() {
        String titulo = sesion.getUsuario().getNombreCompleto() + " - Mesa: " + this.mesa.getNombreMesa();
        this.vistaMesa.mostrarTitulo(titulo);
    }
    
    public void actualizarJugadoresEnMesa(){
        this.vistaMesa.marcarSillas();
    }
    
    
   
    
    
    
    
    
}
