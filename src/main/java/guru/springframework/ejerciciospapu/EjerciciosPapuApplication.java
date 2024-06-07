package guru.springframework.ejerciciospapu;

import guru.springframework.ejerciciospapu.models.Pedido;
import guru.springframework.ejerciciospapu.models.Producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Descripción: Crea una clase Pedido con atributos id, cliente, productos (lista de productos) y total. La clase Producto tiene atributos nombre y precio. Luego, crea una lista de pedidos y usa Streams para:
Obtener el pedido con el total más alto.
Obtener la lista de clientes que han realizado pedidos de más de un valor específico.
Calcular el total de ingresos generados.
 */
@SpringBootApplication
public class EjerciciosPapuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPapuApplication.class, args);

		Producto producto1 = new Producto("Ordenador", 1000.0);
		Producto producto2 = new Producto("Ratón", 25.0);
		Producto producto3 = new Producto("Teclado", 50.0);
		Producto producto4 = new Producto("Monitor", 200.0);
		Producto producto5 = new Producto("Impresora", 150.0);
		Producto producto6 = new Producto("Altavoces", 75.0);
		Producto producto7 = new Producto("Cámara Web", 90.0);


//Arrays.asList convierte un array en una lista fija,
// lo cual es necesario para inicializar la lista de productos en el constructor del objeto Pedido.
		List<Pedido> pedidos = new ArrayList<>();
		pedidos.add(new Pedido(1, "Sergio", Arrays.asList(producto1, producto2), 1025.0));
		pedidos.add(new Pedido(2, "Laura", Arrays.asList(producto3, producto4), 250.0));
		pedidos.add(new Pedido(3, "Ana", Arrays.asList(producto1, producto3), 1050.0));
		pedidos.add(new Pedido(4, "Carlos", Arrays.asList(producto5, producto6), 225.0));
		pedidos.add(new Pedido(5, "Elena", Arrays.asList(producto2, producto7), 115.0));
		pedidos.add(new Pedido(6, "Mario", Arrays.asList(producto1, producto4, producto5), 1350.0));
		pedidos.add(new Pedido(7, "Lucía", Arrays.asList(producto6, producto7), 165.0));
		pedidos.add(new Pedido(8, "Pedro", Arrays.asList(producto3, producto2, producto1), 1075.0));
		pedidos.add(new Pedido(9, "Marta", Arrays.asList(producto7, producto4), 290.0));
		pedidos.add(new Pedido(10, "Juan", Arrays.asList(producto5, producto2, producto6), 250.0));


//Obtener el pedido con el total más alto.
		System.out.println("Obtener el pedido con el total más alto.");

		Pedido pedidoConTotalMasAlto = pedidos.stream()
				.max(Comparator.comparingDouble(Pedido::getTotal))
				.orElse(null);

		if (pedidoConTotalMasAlto != null) {
			System.out.println("Pedido con el total más alto: " + pedidoConTotalMasAlto);
		} else {
			System.out.println("No hay pedidos disponibles.");
		}
		System.out.println("***************************************************");


//Obtener la lista de clientes que han realizado pedidos de más de un valor específico.
		/*pedidos.stream()
						.filter(precio->precio.getTotal()>1000)
				        .collect(Collectors.toList())
				        .forEach(System.out::println);*/
		System.out.println("Obtener la lista de clientes que han realizado pedidos de más de un valor específico.");

		double valorEspecifico = 500.0;
		List<String> clientesConPedidosAltos = pedidos.stream()
				.filter(pedido -> pedido.getTotal() > valorEspecifico)
				.map(Pedido::getCliente)
				.collect(Collectors.toList());

		System.out.println("Clientes con pedidos de más de " + valorEspecifico + ": " + clientesConPedidosAltos);
		System.out.println("***************************************************");

//Calcular el total de ingresos generados.
		System.out.println("Calcular el total de ingresos generados.");

		double totalIngresos = pedidos.stream()
				.mapToDouble(Pedido::getTotal)
				.sum();

		System.out.println("Total de ingresos generados: " + totalIngresos);


	}



}
