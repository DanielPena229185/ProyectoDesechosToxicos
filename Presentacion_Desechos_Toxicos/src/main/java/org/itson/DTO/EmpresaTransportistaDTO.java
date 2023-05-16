/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DTO;

/**
 *
 * @author arace
 */
public class EmpresaTransportistaDTO {
    /**
     * Email de productor
     */
    private String email;
    /**
     * Contrasena de productor
     */
    private String contrasena;
    /**
     * Constructor vacio 
     */
    public EmpresaTransportistaDTO() {    
    }

    /**
     * Obtiene el email del Productor
     * @return el email del productor
     */
    public String getEmail() {
        return email;
    }
    /**
     * Establece el email del Productor
     * @param email del Productor
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Obtiene la contraseña del Productor.
     * @return la contraseña del Productor.
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * Establece la contraseña del Productor.
     * @param contrasena la contraseña del Productor.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
