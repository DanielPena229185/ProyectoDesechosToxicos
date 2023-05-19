package org.itson.implementaciones.bd;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * Descripción de la clase: Clase que se va a encargar de conectar el sistema a
 * la base de datos.
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ConexionBD {

    //private static String BASE_DATOS;
    private static MongoDatabase baseDatos;

    /**
     * Método constructor.
     */
    private ConexionBD() {
        //this.BASE_DATOS = "residuos_toxicos";
    }

    /**
     * Se utiliza el singleton
     *
     * @return la base de datos conectada.
     */
    public static MongoDatabase getBaseDatos() {
        //ConexionBD.BASE_DATOS = "residuos_toxicos";

        if (ConexionBD.baseDatos == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));

            MongoClientSettings configuraciones = MongoClientSettings.builder()
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            MongoClient conexion = MongoClients.create(configuraciones);
            ConexionBD.baseDatos = conexion.getDatabase("residuos_toxicos");
        }

        return ConexionBD.baseDatos;
    }
}
