package org.example.EXAMEN_REPASO.Streams;

import org.example.EXAMEN_REPASO.Personas;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        ArrayList<Personas> personas=new ArrayList<>();
        Personas per1=new Personas(22);
        Personas per2=new Personas(13);
        personas.add(per1);
        personas.add(per2);

        //METODO FILTER
        Stream<Personas> adultos=
                personas.stream().filter(p->p.getEdad() >=18);


        //METODO MAP (te quedas solo con cierta parte de la collección)
        Stream<Integer> edades=
            personas.stream().map(Personas::getEdad);    //o personas.stream().map(p-> p.getEdad());


        //METODO SORT (ORDENAR)
        Stream<Personas> PersonasOrdenadas=
                personas.stream()
                        .sorted((p1,p2)->p2.getEdad()-p1.getEdad());

        //METODO TO LIST (DEVUELVE UNA LISTA)
        List<Personas> lista_personas=
                personas.stream()
                        .filter(p->p.getEdad() >=18)
                        .toList();

        //METODO COLLECTORS JOINING (UNA ESPECIE DE TOSTRING)
        String edades_adultos=
                personas.stream()
                        .filter(p->p.getEdad() >=18)
                        .map(p->p.toString()) // por que esta con @DATA realmente valdria con las edades si lo hacemos manual
                        .collect(Collectors.joining(",","Adultos: ",""));

        //METODO FOR EACH
                personas.stream()
                        .filter(p->p.getEdad() >=18)
                        .forEach(System.out::println);

        //METODO AVG (MEDIA)
        double media=
                personas.stream()
                        .mapToInt(Personas::getEdad)
                        .average().getAsDouble();

    }


}
