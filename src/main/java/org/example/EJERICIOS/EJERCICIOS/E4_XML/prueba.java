package org.example.EJERICIOS.EJERCICIOS.E4_XML;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class prueba {
    public static void main(String[] args) {
        ArrayList<AtletaFemenina>  atleta=new ArrayList<>();
        ArrayList<String> pruebas=new ArrayList<String>();
        pruebas.add("Salto con Pértiga");
        pruebas.add("100 Metros con obstáculos");
        pruebas.add("Salto de Longitud");
        atleta.add(new AtletaFemenina("Maria Castañuela Sanchez",pruebas,25,"España"));
        atleta.add(new AtletaFemenina("Pamela Pérez",pruebas,31,"España"));
        atleta.add(new AtletaFemenina("Shasha Pietrovitch",pruebas,24,"Russia"));
        atleta.add(new AtletaFemenina("Victoria Mariel",pruebas,29,"US"));
        Path ruta =Path.of("/home/daw2/Escriptori/Ficheros/src/main/java/org/example/EJERCICIOS/E4_XML/PRUEBA.xml");
        //PROCESO DE ESCRITURA A UN XML
        LISTA a=new LISTA(atleta);
        try{
            Files.deleteIfExists(ruta);
            XmlMapper xmlMapper=new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(ruta.toFile(), a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<AtletaFemenina>asss=leer_archivo_xml(ruta);
        asss.forEach(System.out::println);
    }


        //METODO PARA LEER
    public static List<AtletaFemenina> leer_archivo_xml(Path ruta){
        try {
            XmlMapper xmlMapper = new XmlMapper();
            // return xmlMapper.readValue(ruta.toFile(), new TypeReference<List<Lenguaje2>>() { });
            return xmlMapper.readValue(ruta.toFile(),LISTA.class).getAtleta().stream().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
