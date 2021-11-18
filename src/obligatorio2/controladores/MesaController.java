
package obligatorio2.controladores;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.juego.Apuesta;
import obligatorio2.dominio.juego.Mano;
import obligatorio2.dominio.juego.MesaClase;
import obligatorio2.dominio.juego.baraja.Carta;
import obligatorio2.dominio.juego.baraja.Color;
import obligatorio2.dominio.juego.baraja.Figura;
import obligatorio2.dominio.juego.baraja.Figuras;
import obligatorio2.dominio.juego.baraja.Par;
import obligatorio2.dominio.juego.baraja.Pierna;
import obligatorio2.dominio.usuarios.Sesion;
import obligatorio2.dominio.usuarios.Usuario;
import obligatorio2.dominio.usuarios.UsuarioJuego;
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
        
        if(((UsuarioJuego)this.sesion.getUsuario()).getSaldo() >= (modelo.traerLuzMesa() * 6) ){
            
            this.mesa = modelo.agregarUsuarioAMesa(sesion.getUsuario());
        
            if(mesa != null){
                this.mesa.agregar(this);
            
                this.vistaMesa = new Mesa(this.panel, false, this);
                this.vistaMesa.setVisible(true);
                this.vistaMesa.setLocationRelativeTo(this.panel);
                mostrarTitulo();
                if(this.mesa.getUsuarios().size() == 6 && this.mesa.isIniciado()){
                    this.mesa.iniciarMesa();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "No se pudo entrar en mesa, \n ya se encuentra dentro.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo entrar en mesa, \n  saldo insuficiente.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    
    public void salirDeMesa(){
        this.vistaMesa.dispose();
        this.mesa.eliminarUsuario(this.sesion.getUsuario());
        this.mesa.quitarDeMano(this.sesion.getUsuario());
        if(this.mesa.getUsuarios().size() == 1){
            this.finalizarMesa();
        }
        
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
    
    public void finalizarMesa(){
        
    }
    
    
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento.equals(EventoMesaUsuario.LISTA_JUGADORES)) {
            this.actualizarJugadoresEnMesa();
            this.actualizarTitulos();
        }
        else if (evento.equals(EventoMesaUsuario.JUGAR_AL_POKER)){
            this.nuevaMano();
        }
        else if(evento.equals(EventoMesaUsuario.CERRAR_MESA)){
            this.salirDeMesa();
        }
        else if(evento.equals(EventoMesaUsuario.APOSTO)){
            this.actualizarTabla();
        }
        
    }
    
    private void mostrarTitulo() {
        String titulo = sesion.getUsuario().getNombreCompleto() + " - Mesa: " + this.mesa.getNombreMesa();
        this.vistaMesa.mostrarTitulo(titulo);
        this.actualizarTitulos();
    }
    
    public void actualizarJugadoresEnMesa(){
        this.vistaMesa.marcarSillas();
    }
    
    public void actualizarTitulos(){
        this.vistaMesa.actualizarFaltantes();
    }
    
    
   public void nuevaMano(){
   
       if(((UsuarioJuego)this.sesion.getUsuario()).getSaldo() <= 0){
           this.salirDeMesa();
       }
       else {
           
            this.mesa.agregarApuesta(modelo.traerLuzMesa(), this.sesion.getUsuario());
            ((UsuarioJuego)this.sesion.getUsuario()).restarApuesta(modelo.traerLuzMesa());
            //this.sesion.getUsuario().avisarEvento();
            this.mesa.generarMazo().armarMazo();
            Mano mano = new Mano();
            for(int i = 1; i <= 5; i++){
                mano.agregarCarta(this.mesa.getMazo().repartirRandom());
            }
            mano.verificarSiTengoFigura();
            this.mesa.agregarMano(mano, this.sesion.getUsuario());
            this.actualizarCartasMostradas();

        }
       
       
   }
   
   private void actualizarCartasMostradas(){
       ArrayList<String> imgCartas = new ArrayList<>();
       for(Carta c : this.mesa.traerMano(this.sesion.getUsuario()).getMano()){
           String img = "";
           if(c.getValor().retornarNumero() > 10){
               img = c.getValor().name();
           }
           else{
               img = c.getValor().retornarNumero() + "";
           }
           img += c.getPalo().name().charAt(0) + ".gif";
           
           imgCartas.add(img);
       }
       
       this.vistaMesa.mostrarCartas(imgCartas);
   }
    
   
   private void actualizarTabla(){
       
       ArrayList<Usuario> uAux = new ArrayList<>();
       for(Apuesta apuesta : (this.mesa.getApuestas())){
           uAux.add(apuesta.getUsuario());
       }
       this.vistaMesa.actualizarTablaMano(uAux);
       this.vistaMesa.actualizarPozo(this.mesa.getPozo());

       
   }    
    
    
    
}
