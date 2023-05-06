/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.bd;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.itson.interfaces.IConexionBD;

/**
 * Clase que se va a encargar de conectar el sistema a la base de datos.
 * @author oscar
 */
public class ConexionBD implements IConexionBD {

    private final String BASE_DATOS;
    
    private MongoDatabase baseDatos;
    
    /**
     * Método constructor que recibe una base datos como String.
     * @param BASE_DATOS la base de datos a conectarse.
     */
    public ConexionBD(String BASE_DATOS) {
        this.BASE_DATOS = BASE_DATOS;
    }
    
    /**
     * Método que obtiene la base de datos que recibió especificado como
     * atributo.
     * @return la base de datos conectada.
     */
    @Override
    public MongoDatabase getBaseDatos() {
        if (this.baseDatos == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
            MongoClientSettings configuraciones = MongoClientSettings.builder()
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            MongoClient conexion = MongoClients.create(configuraciones);
            this.baseDatos = conexion.getDatabase(this.BASE_DATOS);
        }
        
        return this.baseDatos;
    }
}
