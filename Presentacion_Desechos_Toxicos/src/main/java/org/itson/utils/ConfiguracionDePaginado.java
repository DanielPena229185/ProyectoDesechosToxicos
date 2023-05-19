/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

/**
 *
 * @author Usuario
 */
public class ConfiguracionDePaginado {
    
    /**
     * Numero de paginas
     */
    private int numeroPagina;
    /**
     * Elementos que habran por pagina
     */
    private int elementosPorPagina;

    /**
     * Constructor por defecto que inicializa los valores de numero de pagina
     * y elementos por pagina
     */
    public ConfiguracionDePaginado() {
        this.numeroPagina = 0;
        this.elementosPorPagina = 3;
    }

    /**
     * Constructor que recibe el numero de pagina por el que se empieza y
     * los elementos por pagina
     * @param numeroPagina numero de pagina
     * @param elementosPorPagina elementos por pagina
     */
    public ConfiguracionDePaginado(int numeroPagina, int elementosPorPagina) {
        this.numeroPagina = numeroPagina;
        this.elementosPorPagina = elementosPorPagina;
    }

    /**
     * Metodo que regresa el numero de pagina donde estas
     * @return Regresa el numero de pagina
     */
    public int getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * Metodo que setea el numero de pagina
     * @param numeroPagina Numero de pagina
     */
    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    /**
     * Metodo que regresa los elementos por pagina
     * @return Regresa los elementos por pagina
     */
    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    /**
     * Metodo que setea los elementos por pagina
     * @param elementosPorPagina elementos por pagina
     */
    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }
    
    /**
     * Metodo que regresa los elementos a saltar segun el numero de pagina y
     * los elementos por pagina
     * @return Regresa la cantidad de elementos a asaltar
     */
    public int getElementoASaltar(){
        return this.numeroPagina * this.elementosPorPagina;
    }
    
    /**
     * Metodo para avanzar pagina
     */
    public void avanzarPagina(){
        this.numeroPagina++;
    }
    
    /**
     * Metodo para retroceder pagina
     */
    public void retrocederPagina(){
        if(this.numeroPagina > 0){
            this.numeroPagina--;
        }
    }
}
