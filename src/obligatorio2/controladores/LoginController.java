/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio2.controladores;

import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.usuarios.Sesion;
import obligatorio2.ui.Login;
import obligatorio2.ui.Prueba;

/**
 *
 * @author eliasalcoba
 */
public class LoginController {
    
    private Sesion sesion;
    private Login login;
    
    public LoginController(Login login){
        this.login = login;
    }
    
     public boolean login(String user, String password){
        boolean ret = false;
         this.sesion = Sistema.getInstancia().loginUsuario(user, password);
         
         if (sesion != null) {
            this.limpiarDatos();
            ret = true;
         }
         return ret;
    }
     
    public void limpiarDatos() {
        this.login.setTxt_Nombre("");
        this.login.setPw_Password("");
    }
    
    public void mostrarProximaInterfaz(){
        Prueba prueba = new Prueba(login, false, this.sesion);
        prueba.setVisible(true);
        prueba.setLocationRelativeTo(login);
    }
}
