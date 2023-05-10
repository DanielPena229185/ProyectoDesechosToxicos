/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson;

import org.itson.implementacion.AdministradorNegocio;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Residuos_Toxicos_Negocio {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        AdministradorNegocio neg = new AdministradorNegocio();
        String f = neg.validarCaracteresEspeciales("dsbjd");
        System.out.println(f);
    }
}
