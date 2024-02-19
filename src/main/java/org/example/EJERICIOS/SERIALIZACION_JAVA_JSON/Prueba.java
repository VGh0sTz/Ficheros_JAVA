package org.example.EJERICIOS.SERIALIZACION_JAVA_JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

//import static org.example.Json.Constant.JSON_MAPPER;

public class Prueba {
    //PARA CREAR ARRAYLISTS DE PERSONAS Y PRODUCTOS
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    public static void main(String[] args) {
        ArrayList<Persona> personas;
        ArrayList<Producto> productos;
        Path Personasjson= Path.of("/home/daw2/Escriptori/Ficheros/src/main/java/org/example/SERIALIZACION_JAVA_JSON/Personas.json");
        Path Prodcutosjson= Path.of("/home/daw2/Escriptori/Ficheros/src/main/java/org/example/SERIALIZACION_JAVA_JSON/Productos.json");
        try {
            personas = JSON_MAPPER.readValue(Personasjson.toFile(), new TypeReference<ArrayList<Persona>>() {});
            productos = JSON_MAPPER.readValue(Prodcutosjson.toFile(), new TypeReference<ArrayList<Producto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        personas.forEach(System.out::println);
        productos.forEach(System.out::println);
    }



}
