/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio2.dominio.usuarios;

/**
 *
 * @author eliasalcoba
 */
public class UsuarioJuego extends Usuario{
    
    private double saldo; 

    public UsuarioJuego(String user, String password, String nombreCompleto) {
        super(user, password, nombreCompleto);
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
