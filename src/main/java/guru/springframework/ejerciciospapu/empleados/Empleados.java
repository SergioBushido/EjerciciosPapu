package guru.springframework.ejerciciospapu.empleados;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleados {

    private String nombre;
    private int edad;
    private double salario;
    private String departamento;
}
