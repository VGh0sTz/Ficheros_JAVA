import org.example.EJERICIOS.EJERCICIOS.E3.funkos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.example.EJERICIOS.EJERCICIOS.E3.Main.backup;
import static org.example.EJERICIOS.EJERCICIOS.E3.Main.restore;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FunkosTest {
    funkos f1;

    //ANTES DE CUALQUIER TEST QUEREMOS TENER ESTAS VARIABLES:
    @BeforeEach
    void Variables_comunes(){
        LocalDate date1 =LocalDate.parse("2029-01-01");
        //AÑADIMOS UN PRODUCTO
        f1=new funkos("013jinf0q214-dada219r0mn","Spooderman","MARVEL",100.00,date1);
    }

    @Test
    void testcomprobando_metodos() throws Exception{
        ArrayList<funkos> lista=new ArrayList<>();
        lista.add(f1);
        backup(lista);
        ArrayList<funkos> lista2=restore();
        ArrayList<funkos> lista3=new ArrayList<>();
        Assertions.assertEquals(lista,lista2);
    }

    @Test
    void testbuscar() throws Exception{
        ArrayList<funkos> lista=new ArrayList<>();
        lista.add(f1);
        lista.add(new funkos("asd","Dr. Estraño","MARVEL",89.99, LocalDate.parse("2023-01-05")));
        lista.add(new funkos("sdadsad","Gugu","ANIME",89.99, LocalDate.parse("2023-01-05")));
        lista.add(new funkos("a65","Boruto","ANIME",89.99, LocalDate.parse("2023-01-05")));
        int numero =(int) lista.stream().filter(p->p.getMODELO().equals("ANIME")).count();
        Assertions.assertEquals(numero,2);
    }

}