/**
* INegocioResiduo.java
* 10 may. 2023 11:39:54
*/ 

package org.itson.interfaces;

import com.dominio.Residuo;
import java.util.List;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la interface: Define dos métodos relacionados con la gestión de los residuos en el sistema
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioResiduo {

    /**
 * Inserta un nuevo residuo en el sistema.
 *
 * @param residuo El objeto Residuo que se desea insertar.
 * @return El objeto Residuo insertado en el sistema.
 * @throws NegocioException Si ocurre un error en la lógica del negocio durante la inserción.
 */
public Residuo insertarResiduo(Residuo residuo) throws NegocioException;

/**
 * Consulta una lista de residuos filtrados según los criterios especificados.
 *
 * @param residuo El objeto Residuo que contiene los criterios de filtrado.
 * @return Una lista de objetos Residuo que cumplen con los criterios de filtrado.
 * @throws NegocioException Si ocurre un error en la lógica del negocio durante la consulta.
 */
public List<Residuo> consultarResiduoFiltro(Residuo residuo) throws NegocioException;
    
}
