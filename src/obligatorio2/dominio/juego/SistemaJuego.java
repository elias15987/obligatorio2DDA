/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio2.dominio.juego;

import java.util.ArrayList;
import java.util.List;
import obligatorio2.dominio.usuarios.Usuario;

/**
 *
 * @author eliasalcoba
 */
public class SistemaJuego {
    
    private MesaClase mesasDisponible;
    private ArrayList<MesaClase> mesasEnJuego = new  ArrayList<>();
    private ArrayList<MesaClase> mesasFinalizadas = new  ArrayList<>();
    private int luz;

    public int getLuz() {
        return luz;
    }

    public void setLuz(int Luz) {
        this.luz = Luz;
    }
    
    
    public void agregarMesa(){
        if(mesasDisponible == null){
            mesasDisponible = new MesaClase();
            mesasDisponible.setLuz(this.luz);
        }
    }
    
    public void comenzarJuegoMesa(){
        if(mesasDisponible != null){
            this.mesasDisponible.setIniciado(true);
            this.mesasEnJuego.add(this.mesasDisponible);
            this.mesasDisponible = null;
            this.agregarMesa();
        }
    }
    
    
    
    public MesaClase agregarUsuarioMesa(Usuario usuario){
        if(mesasDisponible == null){
            this.agregarMesa();
        }
        if(this.mesasDisponible.lugarDisponible() && !this.mesasDisponible.isIniciado()){
            if(this.mesasDisponible.agregarUsuario(usuario)){
                return this.mesasDisponible;
            }
        }
        
        return null;
    }
    
    
    
    
    
    

    
}
