package guru.springframework.ejerciciospapu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

@SpringBootApplication
public class EjerciciosPapuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPapuApplication.class, args);

		// Crear un conjunto ordenado en sentido decreciente
		Set<Integer> numeros = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		// Crear un generador de números aleatorios
		Random r = new Random();

		// Generar números aleatorios y añadirlos al conjunto
		while (numeros.size() < 20) {
			int numero = r.nextInt(100);
			numeros.add(numero);
		}

		// Mostrar la colección
		System.out.println("Colección en orden decreciente: " + numeros);
	}
}
