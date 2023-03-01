package org.itson.dominio;

import java.util.List;

/**
 *
 * @author @author @author @author
 */
public class RegistroEnPartes extends Registro {

    List<EnPartes> lista;

    /**
     * Metodo por constructor por omision
     */
    public RegistroEnPartes() {
    }

    public RegistroEnPartes(Integer id, List<EnPartes> lista) {
        super(id);
        this.lista = lista;
    }

    public RegistroEnPartes(List<EnPartes> lista) {
        this.lista = lista;
    }

}
