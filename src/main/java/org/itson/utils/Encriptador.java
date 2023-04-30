/**
 * Encriptador.java
 * 28 abr. 2023 15:36:07
 */
package org.itson.utils;
//importanciones

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Encriptador {

    private static final String clave = "itson_nainary256";

    /**
     * Encripta una cadena de texto utilizando el algoritmo AES.
     *
     * @param texto La cadena de texto a encriptar.
     * @return La cadena de texto encriptada.
     */
    public static String encriptar(String texto) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textoEnBytes = texto.getBytes("UTF-8");
            byte[] textoEncriptado = cipher.doFinal(textoEnBytes);
            return Base64.getEncoder().encodeToString(textoEncriptado);
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar el texto", e);
        }
    }
}
