package guru.springframework.ejerciciospapu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {


    private int idPedido;
    private String cliente;
    private List<Producto> productos;
    private double total;
}
