package org.example.Json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Constant {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    /* DE JSON A JAVA
    Main objeto = JSON_MAPPER.readValue(new File("Personas.json", Main.class));

    OTRA MANERA DE HACERLO
    Main objeto = JSON_MAPPER.readValue(new URL("http://ruta/a/mijson.json",
            MiClase.class));
    */

    /*DE JAVA A JSON
    JSON_MAPPER.writeValue(new File("ASAHBI.json"), objeto);
    // ó:
    byte[] jsonBytes = JSON_MAPPER.writeValueAsBytes(objeto);
    // ó:
    String jsonString = JSON_MAPPER.writeValueAsString(objeto);
     */
}
