package org.example.EJERCICIOS.E2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.SERIALIZACION_JAVA_JSON.Persona;
import org.example.SERIALIZACION_JAVA_JSON.Producto;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static org.example.Json.Constant.JSON_MAPPER;

public class Libreria {
    public static void main(String[] args) throws Exception {
        ArrayList<Libro> lista_libros=new ArrayList<Libro>();
        Libro l1=new Libro("El principito","Antoine de Saint-Exupéry",1943,978314046);
        Libro l2=new Libro("La sombra del viento","Carlos Ruiz Zafón",2001,945561458);
        Libro l3=new Libro("El día que se perdió la cordura","Javier Castillo",2023,454519845);
        Libro l4=new Libro("La paciente silenciosa","Alex Michaelides",2019,486156820);
        lista_libros.add(l1);lista_libros.add(l2);lista_libros.add(l3);lista_libros.add(l4);
        guardar(lista_libros);
        ArrayList<Libro>resultado;
        resultado=getArray();
        int respuesta,año_publi,isbn;
        String titulo,autor,basura;
        Scanner entrada=new Scanner(System.in);
        System.out.println("Bienvenido al menu");
        do{
            System.out.println("1.-Añadir un libro a la base de datos\n" +
                    "2.-Buscar un libro en la base de datos\n" +
                    "3.-Ver la lista de libros en la base de datos");
            respuesta=entrada.nextInt();
            while(respuesta<0 || respuesta>3){
                System.out.println("Introduce un numero del 1 al 3");
                respuesta=entrada.nextInt();
            }
            switch (respuesta){
                case 1:
                    basura=entrada.nextLine();
                    System.out.println("Introduce el titulo del libro");
                    titulo=entrada.nextLine();
                    System.out.println("Introduce el autor del libro");
                    autor=entrada.nextLine();
                    System.out.println("Introduce el año de publicación del libro");
                    año_publi=entrada.nextInt();
                    System.out.println("Introduce la ISBN del libro");
                    isbn=entrada.nextInt();
                    Libro lib =new Libro(titulo,autor,año_publi,isbn);
                    lista_libros.add(lib);
                    guardar(lista_libros);
                    break;
                case 2:
                    basura=entrada.nextLine();
                    System.out.println("Introduce el titulo del libro");
                    titulo=entrada.nextLine();
                    if(buscarlibro(titulo,lista_libros)==false){
                        System.out.println("No se encontró el libro");
                    }
                    break;
                case 3:
                    ArrayList<Libro> array=new ArrayList<>();
                    array=getArray();
                    array.forEach(System.out::println);
                    break;
            }
        }while (respuesta!=0);
        System.out.println("Fin del programa");
    }

    public static boolean buscarlibro(String titulo,ArrayList<Libro> lista){
        Iterator<Libro> iter=lista.iterator();
        while(iter.hasNext()){
            Libro l=iter.next();
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                System.out.println("Se encontro el libro"+l.toString());
                return true;
            }
        }
        return false;
    }
    public static void guardar(ArrayList<Libro> lista_libros) throws Exception{
        try {
            //ESTO PROVOCA EL CAMBIO DE LINEA EN EL ARCHIVO
            JSON_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
            JSON_MAPPER.writeValue(new File("/home/daw2/Escriptori/Ficheros/src/main/java/org/example/EJERCICIOS/E2/Libros.json"), lista_libros);
        }catch (IOException e){}
    }


    //TE DEVUELVE LA ARRAY DEL JSON
    public static ArrayList<Libro> getArray() throws Exception {
        ArrayList<Libro> libros;
        Path librosjson= Path.of("/home/daw2/Escriptori/Ficheros/src/main/java/org/example/EJERCICIOS/E2/Libros.json");
        try {
            libros = JSON_MAPPER.readValue(librosjson.toFile(), new TypeReference<ArrayList<Libro>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return libros;
    }
}
