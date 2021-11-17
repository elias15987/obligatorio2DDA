
package obligatorio2.dominio.juego;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import obligatorio2.dominio.usuarios.Usuario;
import obligatorio2.utilidades.EventoMesaUsuario;
import obligatorio2.utilidades.Observable;


public class MesaClase extends Observable{
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private int topeUsuarios = 6;
    private int luz;
    private boolean iniciado = false;
    private String nombreMesa;
    

    public MesaClase()
    {
    }
    
    public MesaClase(ArrayList<Usuario> usuarios, int topeUsuarios, int luz, String nombre) {
        this.usuarios = usuarios;
        this.topeUsuarios = topeUsuarios;
        this.luz = luz;
        this.nombreMesa = nombre;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public int getTopeUsuarios() {
        return topeUsuarios;
    }

    public int getLuz() {
        return luz;
    }

    public void setLuz(int luz) {
        this.luz = luz;
    } 

    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }

    public void setNombreMesa(String nombreMesa) {
        this.nombreMesa = nombreMesa;
    }

    public String getNombreMesa() {
        return nombreMesa;
    }
    
    
    
    public boolean agregarUsuario(Usuario usuario)
    {
        boolean ret = false;
        
        if(usuarios == null)
        {
            usuarios = new ArrayList<Usuario>();
        }
        
        if(this.lugarDisponible())
        {
            if(!usuarios.contains(usuario)){
            usuarios.add(usuario);
            this.setIniciado(usuarios.size() == topeUsuarios);            
            avisar(EventoMesaUsuario.LISTA_JUGADORES);
            ret = true;
            }
        }
        
        return ret;
    }
    
    
    public boolean eliminarUsuario(Usuario usuario){
        boolean ret = false;
        
        if(usuarios != null){
            if(usuarios.contains(usuario)){
                usuarios.remove(usuario);
                avisar(EventoMesaUsuario.LISTA_JUGADORES);
                ret = true;
            }
        }
        
        return ret;
    }
    
    
    public boolean lugarDisponible(){
        if(usuarios == null || usuarios.size() < topeUsuarios ){
            return true;
        }
        else {
            return false;
        }
    }
    
    
    public boolean existeUsuario(Usuario usuario){
        if(usuarios.contains(usuario)){
            return true;
        }
        else {
            return false;
        }
    }
    
}
