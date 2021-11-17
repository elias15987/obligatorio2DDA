
package obligatorio2.dominio.usuarios;

public class UsuarioJuego extends Usuario{
    
    private double saldo; 
    
    
    public UsuarioJuego(){}
    
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
