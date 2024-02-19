package org.example.EJERCICIOS.E3;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        List<String> lista;
        Path funkoscsv= Path.of("/home/daw2/Escriptori/Ficheros/src/main/java/org/example/EJERCICIOS/E3/funkos.csv");
        ArrayList<funkos> funk=new ArrayList();
        try {
            String contenido=new String(Files.readAllBytes(funkoscsv));
            System.out.println(contenido);
            String[] separados=contenido.split(",|\n");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            /*
            List<String> list = new ArrayList<>(Arrays.asList(separados));
            list.forEach(System.out::println);
            */
            String COD;
            String NOMBRE;
            String MODELO;
            double PRECIO;
            LocalDate FECHA_LANZAMIENTO;
            /*MAGIA MOMENTO (Declaracion ArrayList)*/
            for(int cont=0;cont<separados.length;cont++){
                if(cont%5==0 && cont!=0 && cont!=5){
                    COD=separados[(cont-5)];
                    NOMBRE=separados[(cont-4)];
                    MODELO=separados[(cont-3)];
                    PRECIO=Double.parseDouble(separados[(cont-2)]);
                    FECHA_LANZAMIENTO=LocalDate.parse(separados[cont-1]);
                    funkos f1=new funkos(COD,NOMBRE,MODELO,PRECIO,FECHA_LANZAMIENTO);
                    funk.add(f1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        funk.forEach(System.out::println);

        //OBTENCION DEL PRECIO MAXIMO
        Double funko_mas_caro=funk.stream()
                .map(funkos::getPrecio)
                .max(Double::compare).get();

        //Media de precio de Funkos
        Double media_precio=funk.stream()
                .mapToDouble(funkos::getPrecio).average().getAsDouble();

        //FUNKOS DE MARVEL
        List<funkos> Marvel=funk.stream()
                .filter(p->p.getMODELO().equals("MARVEL")).toList();

        //FUNKOS DE ANIME
        List<funkos> Anime=funk.stream()
                .filter(p->p.getMODELO().equals("ANIME")).toList();

        //FUNKOS DE DISNEY
        List<funkos> DISNEY=funk.stream()
                .filter(p->p.getMODELO().equals("DISNEY")).toList();

        //FUNKOS DE OTROS
        List<funkos> OTROS=funk.stream()
                .filter(p->p.getMODELO().equals("OTROS")).toList();

        //NUMERO DE MARVEL
        Double num_Marvel= (double) Marvel.stream().count();
        //NUMERO DE ANIME
        Double num_ANIME= (double) Anime.stream().count();
        //NUMERO DE DISNEY
        Double num_DISNEY= (double) DISNEY.stream().count();
        //NUMERO DE MARVEL
        Double num_OTROS= (double) OTROS.stream().count();

        //2023
        List<funkos> f2023=funk.stream().filter(p->p.getFECHA_LANZAMIENTO().getYear()==2023).toList();

        backup(funk);
        ArrayList<funkos> aaaa=restore();
    }

    public static void backup(ArrayList< funkos > funk) throws Exception {
        File fichero = new File("/home/daw2/Escriptori/Ficheros/src/main/java/org/example/EJERCICIOS/E3/funkos.dat");
        try (ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero))) {
            ficheroSalida.writeObject(funk);
            System.out.println("Pacientes guardados correctamente...");
        }

    }


    //TE DEVUELVE LA ARRAY DEL dat
    public static ArrayList<funkos> restore() throws Exception {
        File funk_dat= new File("/home/daw2/Escriptori/Ficheros/src/main/java/org/example/EJERCICIOS/E3/funkos.dat");
        try (ObjectInputStream leer= new ObjectInputStream(new FileInputStream(funk_dat))){
            return (ArrayList<funkos>) leer.readObject();
        }
    }
}
