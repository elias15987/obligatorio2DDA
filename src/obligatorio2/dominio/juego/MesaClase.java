/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio2.dominio.juego;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import obligatorio2.dominio.usuarios.Usuario;

/**
 *
 * @author eliasalcoba
 */
public class MesaClase {
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private int topeUsuarios = 6;
    private int luz;
    private boolean iniciado = false;
    

    public MesaClase()
    {
    }
    
    public MesaClase(ArrayList<Usuario> usuarios, int topeUsuarios, int luz) {
        this.usuarios = usuarios;
        this.topeUsuarios = topeUsuarios;
        this.luz = luz;
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
    
    
    
    public boolean agregarUsuario(Usuario usuario)
    {
        boolean ret = false;
        
        if(usuarios == null)
        {
            usuarios = new ArrayList<Usuario>();
        }
        
        if(this.lugarDisponible())
        {
            usuarios.add(usuario);
            ret = true;
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
