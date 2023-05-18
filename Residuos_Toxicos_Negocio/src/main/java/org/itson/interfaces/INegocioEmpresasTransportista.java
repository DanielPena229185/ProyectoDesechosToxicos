/**
* IEmpresasTransportista.java
* 14 may. 2023 21:54:19
*/ 

package org.itson.interfaces;

import com.dominio.EmpresaTransportista;
import java.util.List;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la interface: Define varios métodos relacionados con la gestión de las empresas transportistas en el sistema
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioEmpresasTransportista {
    
     /**
     * Recupera todas las empresas transportistas almacenadas en alguna fuente de datos persistente
     * @return una lista de objetos EmpresaTransportista
     * @throws PersistenciaException si hay algún problema al realizar la consulta
     */
    List<EmpresaTransportista> consultaTodasEmpresasTransportistas() throws PersistenciaException;
    /**
     * Inserta un nuevo objeto EmpresaTransportista en alguna fuente de datos persistente
     * @param o el objeto EmpresaTransportista que se va a insertar
     * @return el objeto EmpresaTransportista recién insertado
     * @throws PersistenciaException si hay algún problema al realizar la inserción
     */
    EmpresaTransportista insertar(EmpresaTransportista o) throws PersistenciaException;
    /**
     * Autentica una empresa transportista en algun sistema
     * @param correo la dirección de correo electrónico de la empresa transportista
     * @param contrasena la contraseña de la empresa transportista
     * @return el objeto EmpresaTransportista correspondiente a los datos de inicio de sesión si son válidos
     * @throws PersistenciaException si los datos de inicio de sesión son incorrectos o hay algún problema al realizar la autenticación
     */
    EmpresaTransportista loginEmpresaTrasnportista(String correo,String contrasena)throws PersistenciaException;
    
}
