package org.itson.DTO;

import org.bson.types.ObjectId;

/**
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class AdministradorDTO {

    /**
     * El ID del administrador
     */
    private ObjectId id_Administrador;
    /**
     * El o los nombres del administrador
     */
    private String nombres;
    /**
     * El apellido paterno del administrador
     */
    private String apellido_paterno;
    /**
     * El apellido materno del administrador
     */
    private String apellido_materno;
    /**
     * El correo para iniciar sesion del administrador
     */
    private String correo;
    /**
     * La contrasena para iniciar sesion del administrador
     */
    private String contrasena;

    /**
     *
     * @return
     */
    public ObjectId getId_Administrador() {
        return id_Administrador;
    }

    /**
     *
     * @param id_Administrador
     */
    public void setId_Administrador(ObjectId id_Administrador) {
        this.id_Administrador = id_Administrador;
    }

    /**
     *
     * @return
     */
    public String getNombres() {
        return nombres;
    }

    /**
     *
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     *
     * @return
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     *
     * @param apellido_paterno
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     *
     * @return
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     *
     * @param apellido_materno
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     *
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
