/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio2.controladores;

import javax.swing.JOptionPane;
import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.juego.MesaClase;
import obligatorio2.dominio.usuarios.Usuario;
import obligatorio2.ui.Mesa;
import obligatorio2.ui.PanelJugador;

/**
 *
 * @author eliasalcoba
 */
public class MesaController {
    
    
    private MesaClase mesa;
    private PanelJugador panel;

    public MesaController(PanelJugador panel) {
        this.panel = panel;
    }
    
    
    
    public void entrarEnMesa(LoginController controladorLogin){
        this.mesa = Sistema.getInstancia().agregarUsuarioAMesa(controladorLogin.getUsuarioSesion());
        
        if(mesa != null){
            Mesa mesa = new Mesa(this.panel, false, controladorLogin, this);
            mesa.setVisible(true);
            mesa.setLocationRelativeTo(this.panel);
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo entrar en mesa", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public MesaClase getMesa() {
        return mesa;
    }

    public void setMesa(MesaClase mesa) {
        this.mesa = mesa;
    }
    
    
    
    
    
}
