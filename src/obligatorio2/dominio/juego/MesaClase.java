
package obligatorio2.dominio.juego;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import obligatorio2.dominio.juego.baraja.Mazo;
import obligatorio2.dominio.usuarios.Usuario;
import obligatorio2.dominio.usuarios.UsuarioJuego;
import obligatorio2.utilidades.EventoMesaUsuario;
import obligatorio2.utilidades.Observable;


public class MesaClase extends Observable{
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private int topeUsuarios = 6;
    private int luz;
    private boolean iniciado = false;
    private String nombreMesa;
    private Mazo mazo;
    private ArrayList<Apuesta> apuestas = new ArrayList<>();
    private int pozo;
    private boolean manoIniciada = false;
    private Usuario ganador;
    private LocalDateTime fechaInicio;
    private int TotalApostado = 0; 
    private int totalManos = 0;
    

    public MesaClase()
    {
        this.mazo = generarMazo();
    }
    
    public MesaClase(ArrayList<Usuario> usuarios, int topeUsuarios, int luz, String nombre) {
        this.usuarios = usuarios;
        this.topeUsuarios = topeUsuarios;
        this.luz = luz;
        this.nombreMesa = nombre;
        this.mazo = generarMazo();
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
        if(iniciado){
            this.fechaInicio = LocalDateTime.now();
            avisar(EventoMesaUsuario.MESA_INICIADA);

        }
    }

    public void setNombreMesa(String nombreMesa) {
        this.nombreMesa = nombreMesa;
    }

    public String getNombreMesa() {
        return nombreMesa;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public int getPozo() {
        return pozo;
    }

    public void setPozo(int pozo) {
        this.pozo = pozo;
    }

    public boolean isManoIniciada() {
        return manoIniciada;
    }

    public void setManoIniciada(boolean manoIniciada) {
        this.manoIniciada = manoIniciada;
    }

    public Usuario getGanador() {
        return ganador;
    }

    public void setGanador(Usuario ganador) {
        this.ganador = ganador;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getTotalApostado() {
        return TotalApostado;
    }

    public void setTotalApostado(int TotalApostado) {
        this.TotalApostado = TotalApostado;
    }

    public int getTotalManos() {
        return totalManos;
    }

    public void setTotalManos(int totalManos) {
        this.totalManos = totalManos;
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
    
    
    public Mazo generarMazo(){
        Mazo mazo = new Mazo();
        return mazo;
    }
    
    
    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }   
    
    public boolean agregarApuesta(int apuesta, Usuario usuario){
        if(!this.manoIniciada){
            this.apuestas.add(new Apuesta(0, usuario));
        }
        else {
            for(Apuesta a : apuestas){
                if(a.getUsuario().equals(usuario)){
                    a.setApuesta(apuesta);
                }
            }
            for(Usuario u : this.usuarios){
                if(u.equals(usuario)){
                    ((UsuarioJuego)u).restarApuesta(apuesta);
                }
            }
        }
        avisar(EventoMesaUsuario.APOSTO);

        this.pozo += apuesta;
        this.TotalApostado += apuesta;
        return true;        
    }
    
    
    
    public void quitarDeMano(Usuario usuario){
        for(Apuesta a : this.apuestas){
            if(a.getUsuario().equals(usuario)){
                this.apuestas.remove(a);
                avisar(EventoMesaUsuario.APOSTO);

            }
        }
    }
    
    public void iniciarMesa(){
        if(this.iniciado) {
            avisar(EventoMesaUsuario.JUGAR_AL_POKER);
        }
    }
    
    public void agregarMano(Mano mano, Usuario usuario){
        for(Usuario u : this.usuarios){
            if(u.equals(usuario)){
                ((UsuarioJuego)u).setMano(mano);
            }
        }
    }
    
    public Mano traerMano(Usuario usuario){
        Mano mano = null;
        for(Usuario u : this.usuarios){
            if(u.equals(usuario)){
                mano = ((UsuarioJuego)u).getMano();
            }
        }
        return mano;
    }
    
    
    public void usuarioPaso(Usuario usuario){
        for(Usuario u : this.usuarios){
            if(u.equals(usuario)){
                ((UsuarioJuego)u).setPaso(true);
                for(Apuesta a : this.apuestas){
                    if(a.getUsuario().equals(u)){
                        a.setApuesta(0);
                    }
                }
                avisar(EventoMesaUsuario.PASO_MANO);
            }
        }
    }
    
    public void habilitarMano(){
        for(Usuario u : this.usuarios){
            ((UsuarioJuego)u).setPaso(false);
        }
    }
    
    public void pasarTurno(Usuario usuario){
        int contador = 0;
        for(Usuario u : this.usuarios){
            if(u.equals(usuario)){
                ((UsuarioJuego)u).setPaso(true);
            }
            if(((UsuarioJuego)u).isPaso()){
                contador++;
            }
        }
        if(contador == this.usuarios.size()){
            jugarMano();
        }
    }
    
    public void jugarMano(){
        UsuarioJuego uAux = (UsuarioJuego)this.usuarios.get(0);
        
        for(int i = 1; i < this.usuarios.size(); i++){
            if(uAux.getMano().getFigura() != null){
                if(((UsuarioJuego)usuarios.get(i)).getMano().getFigura() != null){
                    if(!uAux.getMano().getFigura().masAlta(((UsuarioJuego)usuarios.get(i)).getMano().getFigura())){
                        uAux = (UsuarioJuego)usuarios.get(i);
                    } 
                }
            }
            else if(((UsuarioJuego)usuarios.get(i)).getMano().getFigura() != null){
                uAux = (UsuarioJuego)usuarios.get(i);
            }
        }
        
        this.ganador = uAux;
        this.totalManos ++;
        avisar(EventoMesaUsuario.GANADOR);

    }
    
    
    
}
