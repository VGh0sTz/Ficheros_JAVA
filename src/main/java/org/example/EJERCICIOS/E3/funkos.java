package org.example.EJERCICIOS.E3;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class funkos implements java.io.Serializable {
    private String COD,NOMBRE,MODELO;
    private Double precio;
    private LocalDate FECHA_LANZAMIENTO;
}
