package guru.springframework.ejerciciospapu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Persona {
    private String nombre;
    private int edad;
}