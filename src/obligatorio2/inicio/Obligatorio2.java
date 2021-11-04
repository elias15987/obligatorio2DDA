/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package obligatorio2.inicio;

import obligatorio2.ui.Login;

/**
 *
 * @author eliasalcoba
 */
public class Obligatorio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosPrueba.cargar();
        Login login = new Login() {};
        login.setVisible(true);
    }
    
}
