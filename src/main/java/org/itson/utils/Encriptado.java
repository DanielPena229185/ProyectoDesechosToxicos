/**
* Encriptado.java
* 30 abr. 2023 00:10:43
*/ 

package org.itson.utils;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.itson.excepciones.UtilsExcepcion;


/**
 * Descripción de la clase:
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Encriptado {

    private static final String clave = "itson_nainary256";
    
    /**
     * 
     * @param texto
     * @return 
     */
    public static String encriptadorTexto(String texto) throws UtilsExcepcion{
        try {
            SecretKeySpec secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textoEnBytes = texto.getBytes("UTF-8");
            byte[] textoEncriptado = cipher.doFinal(textoEnBytes);
            texto = Base64.getEncoder().encodeToString(textoEncriptado);
            return texto;
        } catch (Exception e) {
            throw new UtilsExcepcion("Algo salió mal con la encriptación", e);
        }
    }
}
