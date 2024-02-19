package org.example.EJERICIOS.EJERCICIOS.E1;

import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

import static org.example.EJERICIOS.Json.Constant.JSON_MAPPER;

public class prueba {
    public static void main(String[] args){
        ArrayList<DeportistaFemenina> chicas=new ArrayList<DeportistaFemenina>();
        DeportistaFemenina c1=new DeportistaFemenina("Carla asasdas","Fútbol",25,"España");
        DeportistaFemenina c2=new DeportistaFemenina("Kathrine Switzer","Atleta",76,"Alemania");
        DeportistaFemenina c3=new DeportistaFemenina("Billie Jean King","Tenis",79,"Estados Unidos");
        chicas.add(c1);
        chicas.add(c3);
        chicas.add(c2);
        try {
            //ESTO PROVOCA EL CAMBIO DE LINEA EN EL ARCHIVO
            JSON_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
            JSON_MAPPER.writeValue(new File("/home/daw2/Escriptori/Ficheros/src/main/java/org/example/EJERCICIOS/E1/deportistas_fem.json"), chicas);
        }catch (IOException e){}
    }

}
