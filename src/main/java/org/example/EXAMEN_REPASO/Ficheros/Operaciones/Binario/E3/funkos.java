package org.example.EXAMEN_REPASO.Ficheros.Operaciones.Binario.E3;

import lombok.*;

import java.time.LocalDate;

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
