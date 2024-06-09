package guru.springframework.ejerciciospapu;

import guru.springframework.ejerciciospapu.models.Producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class EjerciciosPapuApplication {

	/*
	Descripción: Crea una clase Producto con atributos nombre, categoria, precio y cantidad en stock.
	 Luego, crea una lista de productos y usa Streams para:

			*Obtener una lista de productos de una determinada categoría.
			*Calcular el valor total del inventario.
			*Obtener el producto más caro.
	 */
	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPapuApplication.class, args);

		List<Producto> productos = new ArrayList<Producto>();

		productos.add(new Producto("Laptop", "Ordenadores", 1550.45, 12));
		productos.add(new Producto("Desktop", "Ordenadores", 1200.00, 8));
		productos.add(new Producto("Monitor", "Ordenadores", 299.99, 15));
		productos.add(new Producto("Impresora", "Ordenadores", 199.95, 10));
		productos.add(new Producto("Teclado Mecánico", "Ordenadores", 89.99, 25));
		productos.add(new Producto("Ratón Inalámbrico", "Ordenadores", 49.99, 30));
		productos.add(new Producto("MacBook Pro", "Ordenadores", 2400.00, 5));
		productos.add(new Producto("Chromebook", "Ordenadores", 450.00, 18));
		productos.add(new Producto("Servidor", "Ordenadores", 5000.00, 2));
		productos.add(new Producto("Tablet", "Ordenadores", 299.00, 20));

		productos.add(new Producto("Televisor LED", "Televisores", 799.99, 7));
		productos.add(new Producto("Televisor OLED", "Televisores", 1499.99, 3));
		productos.add(new Producto("Televisor QLED", "Televisores", 1299.99, 4));
		productos.add(new Producto("Televisor 4K", "Televisores", 999.99, 6));
		productos.add(new Producto("Televisor 8K", "Televisores", 2999.99, 2));
		productos.add(new Producto("Televisor Smart TV", "Televisores", 599.99, 10));

		productos.add(new Producto("Lavadora", "Electrodomésticos", 650.00, 5));
		productos.add(new Producto("Refrigerador", "Electrodomésticos", 1200.00, 3));
		productos.add(new Producto("Microondas", "Electrodomésticos", 150.00, 15));
		productos.add(new Producto("Aspiradora", "Electrodomésticos", 200.00, 8));
		productos.add(new Producto("Licuadora", "Electrodomésticos", 80.00, 20));
		productos.add(new Producto("Cafetera", "Electrodomésticos", 120.00, 12));
		productos.add(new Producto("Horno", "Electrodomésticos", 400.00, 4));
		productos.add(new Producto("Secadora", "Electrodomésticos", 700.00, 5));
		productos.add(new Producto("Aire Acondicionado", "Electrodomésticos", 900.00, 6));
		productos.add(new Producto("Plancha", "Electrodomésticos", 50.00, 30));

		System.out.println("******************************************************************");
		System.out.println("\t\t\t*Obtener una lista de productos de una determinada categoría.\n");

		List<Producto> productosOrdenadores = productos.stream()
				.filter(categoria -> categoria.getCategoria().equals("Ordenadores"))
				.collect(Collectors.toList());

		productosOrdenadores.forEach(System.out::println);

		System.out.println("******************************************************************");
		System.out.println("\t\t\t*Calcular el valor total del inventario.\n");

		Double 	valor = productos.stream()
				.mapToDouble(producto -> producto.getPrecio() * producto.getCantidad())
				.sum();
		System.out.println("Valor total del inventario: $" + valor);

		System.out.println("******************************************************************");
		System.out.println("\t\t\t*Obtener el producto más caro");

		Producto productoMasCaro = productos.stream()
				.max(Comparator.comparingDouble(Producto::getPrecio))
				.orElse(null);
		System.out.println("Producto más caro: " + productoMasCaro);
	}

}
