/**
 * INegocioProductor.java
 * 11 may. 2023 17:46:24
 */
package org.itson.interfaces;

import com.dominio.Productor;
import org.itson.DTO.ProductorDTO;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la clase: interfaz que contiene los métodos definidos para
 * realizar las operaciones en las clases que la implementen
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface INegocioProductor {

    /**
     * Inserta un nuevo productor en el sistema.
     *
     * @param productor El objeto Productor que se desea insertar.
     * @return El objeto Productor insertado en el sistema.
     */
    public Productor insertarProductor(Productor productor);

    /**
     * Realiza el inicio de sesión de un productor en el sistema.
     *
     * @param productor El objeto ProductorDTO que contiene los datos de inicio
     * de sesión.
     * @return El objeto Productor correspondiente al inicio de sesión exitoso.
     * @throws NegocioException Si ocurre un error en la lógica del negocio
     * durante el inicio de sesión.
     */
    public Productor loginProductor(ProductorDTO productor) throws NegocioException;

}
