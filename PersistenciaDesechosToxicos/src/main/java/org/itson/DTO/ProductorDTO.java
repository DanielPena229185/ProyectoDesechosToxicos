package org.itson.DTO;

/**
 * Descripción de la clase: Esta clase representa un DTO para un Productor
 * Contiene dos propiedades que son email y contrasena que son los datos para
 * poder iniciar sesion del productor
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ProductorDTO {

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
    public ProductorDTO() {
    }

    /**
     * Obtiene el email del Productor
     *
     * @return el email del productor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del Productor
     *
     * @param email del Productor
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del Productor.
     *
     * @return la contraseña del Productor.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del Productor.
     *
     * @param contrasena la contraseña del Productor.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
