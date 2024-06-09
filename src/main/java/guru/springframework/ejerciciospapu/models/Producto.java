package guru.springframework.ejerciciospapu.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;
}
