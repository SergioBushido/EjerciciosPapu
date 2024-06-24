package guru.springframework.ejerciciospapu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@SpringBootApplication
public class EjerciciosPapuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPapuApplication.class, args);

		/*crear una colección de 20 números enteros aleatorios menores que 100,
		 mostrar la lista, ordenarla en sentido creciente y volver a mostrar la lista ordenada.*/

		ArrayList<Integer> numeros = new ArrayList<>();

		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			int numero = r.nextInt(100);
			numeros.add(numero);
		}

		System.out.println("Lista generada: "+numeros);

		Collections.sort(numeros);

		System.out.println("Lista ordenada: "+numeros);

		Collections.sort(numeros, Collections.reverseOrder());

		// Mostrar la lista ordenada en sentido decreciente
		System.out.println("Lista ordenada en sentido decreciente: " + numeros);
	}

}
