/**
 * INegocioEmpresaTransportista.java
 * 14 may. 2023 21:57:13
 */
package org.itson.implementacion;

import com.dominio.EmpresaTransportista;
import java.util.List;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioEmpresasTransportista;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase: Clase que actúa como puente para realizar las
 * operaciones en el sistema de persistencia, pero antes realizar operaciones
 * para comprobar que el traslado de datos sea correcto
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class NegocioEmpresaTransportista implements INegocioEmpresasTransportista {

    IPersistencia persistencia;

    /**
     * Constructor por default
     */
    public NegocioEmpresaTransportista() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Consulta todas las empresas transportistas registradas en el sistema.
     *
     * @return Una lista de objetos EmpresaTransportista que representan todas
     * las empresas transportistas.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia durante la consulta.
     */
    @Override
    public List<EmpresaTransportista> consultaTodasEmpresasTransportistas() throws PersistenciaException {
        try {
            return persistencia.consultaTodasEmpresasTransportistas();
        } catch (PersistenciaException e) {
            throw new NegocioException();
        }
    }

    /**
     * Inserta una empresa transportista en el sistema.
     *
     * @param o El objeto EmpresaTransportista a insertar.
     * @return El objeto EmpresaTransportista insertado.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia durante la inserción.
     */
    @Override
    public EmpresaTransportista insertar(EmpresaTransportista o) throws PersistenciaException {
        try {
            return persistencia.insertar(o);
        } catch (PersistenciaException e) {
            throw new NegocioException();
        }
    }

    /**
     * Realiza el inicio de sesión de una empresa transportista en el sistema.
     *
     * @param correo El correo de la empresa transportista.
     * @param contrasena La contraseña de la empresa transportista.
     * @return La empresa transportista que ha iniciado sesión.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia durante el inicio de sesión.
     */
    @Override
    public EmpresaTransportista loginEmpresaTrasnportista(String correo, String contrasena) throws PersistenciaException {
        try {

            if (correo == null || correo.isBlank()) {
                throw new ValidacionException("Correo Inválido");
            }

            return persistencia.loginEmpresaTrasnportista(correo, contrasena);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        } catch (ValidacionException a) {
            throw new PersistenciaException(a.getMessage());
        }
    }
}
