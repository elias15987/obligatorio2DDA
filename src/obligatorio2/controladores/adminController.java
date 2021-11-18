
package obligatorio2.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.juego.MesaClase;
import obligatorio2.dominio.usuarios.Sesion;
import obligatorio2.ui.Mesa;
import obligatorio2.ui.PanelAdmin;
import obligatorio2.utilidades.EventoMesaUsuario;
import obligatorio2.utilidades.Observable;
import obligatorio2.utilidades.Observador;

public class adminController implements Observador{
    private Sesion sesion;
    private PanelAdmin panel;    
    private Sistema modelo = Sistema.getInstancia();
    private MesaClase mesa;

    public adminController(Sesion sesion, PanelAdmin panel) {
        this.sesion = sesion;
        this.panel = panel;
        this.modelo.getSistemaJuego().agregar(this);
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }


    
    public ArrayList<MesaClase> traerMesas(){
        return this.modelo.getSistemaJuego().getMesasEnJuego();
    }
    
    public void MostrarJuegos(){
        ArrayList<MesaClase> mesas = this.traerMesas();
        
        ArrayList<Object> list = new ArrayList<Object>();
        list.add("Nombre");
        list.add("Fecha Inicio");
        list.add("Cant.Jugadores");
        list.add("Total Apostado");        
        list.add("Total Manos");

        
        for(Object col : list){
            this.panel.modelo.addColumn(col);
        }
        
        ArrayList<Object[]> datos = new ArrayList<Object[]>();
        
        
        for(MesaClase m : mesas){
            datos.add(new Object[]{m.getNombreMesa(),m.getFechaInicio(), m.getUsuarios().size(), m.getTotalApostado(), m.getTotalManos()});
        }
        
        for(Object[] DatoPersonal : datos){
            this.panel.modelo.addRow(DatoPersonal);
        }
        
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
         if (evento.equals(EventoMesaUsuario.MESA_INICIADA)) {
            this.panel.MostrarJuegos();
        }
        
    }
}
