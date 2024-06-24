package guru.springframework.ejerciciospapu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

@SpringBootApplication
public class EjerciciosPapuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPapuApplication.class, args);

		/* Crear una colección de 20 números enteros aleatorios menores que 10,
           mostrar la lista en el orden en que se vayan generando, ordenarla en sentido decreciente
           y volver a mostrar la lista ordenada. */

		// Crear una lista para almacenar los números
		ArrayList<Integer> numeros = new ArrayList<>();

		// Crear un generador de números aleatorios
		Random r = new Random();

		// Generar 20 números aleatorios menores que 10
		for (int i = 0; i < 20; i++) {
			int numero = r.nextInt(10); // Números aleatorios entre 0 y 9
			numeros.add(numero);
		}

		// Mostrar la lista generada
		System.out.println("Lista generada: " + numeros);

		// Ordenar la lista en sentido decreciente
		numeros.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		// Mostrar la lista ordenada en sentido decreciente
		System.out.println("Lista ordenada en sentido decreciente: " + numeros);
	}
}
