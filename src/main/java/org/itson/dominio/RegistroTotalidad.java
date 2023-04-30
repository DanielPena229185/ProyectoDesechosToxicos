package org.itson.dominio;

import java.util.List;

/**
 *
 * @author @author @author @author
 */
public class RegistroTotalidad extends Registro {

    List<Completo> listaCompleto;

    public RegistroTotalidad(Integer id, List<Completo> listaCompleto) {
        super(id);
        this.listaCompleto = listaCompleto;
    }

    public RegistroTotalidad(List<Completo> listaCompleto) {
        this.listaCompleto = listaCompleto;
    }

}
