package org.example.EJERCICIOS.E4_XML;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AtletaFemenina {
    private String nombre;
    private List<String> prueba;
    private int edad;
    private String pais;

}
