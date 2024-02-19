package org.example.EJERCICIOS.E4_XML;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.*;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LISTA {
    @JacksonXmlElementWrapper(localName = "atletas")
    private ArrayList<AtletaFemenina> atleta;
}
