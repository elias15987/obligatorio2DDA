/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio2.dominio.usuarios;

/**
 *
 * @author eliasalcoba
 */
public abstract class Usuario {
    private String user;
    private String password;
    private String nombreCompleto;

    public Usuario(String user, String password, String nombreCompleto) {
        this.user = user;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    boolean validarPassword(String password) {
        return this.getPassword().equals(password);
    }
}
