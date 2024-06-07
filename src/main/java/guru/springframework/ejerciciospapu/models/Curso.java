package guru.springframework.ejerciciospapu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    private int id;
    private String nombre;
    private Double duracion;
    private String instructor;
    private List<Estudiantes>estudiantes ;
}
