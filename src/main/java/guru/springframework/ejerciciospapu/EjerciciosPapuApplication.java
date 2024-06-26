package guru.springframework.ejerciciospapu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class EjerciciosPapuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPapuApplication.class, args);

		// Crear una lista de 15 personas con nombres y edades
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Juan", 25));
		personas.add(new Persona("Ana", 20));
		personas.add(new Persona("Pedro", 30));
		personas.add(new Persona("Lucía", 22));
		personas.add(new Persona("Carlos", 28));
		personas.add(new Persona("María", 21));
		personas.add(new Persona("Luis", 27));
		personas.add(new Persona("Elena", 24));
		personas.add(new Persona("Roberto", 29));
		personas.add(new Persona("Sofía", 23));
		personas.add(new Persona("Javier", 26));
		personas.add(new Persona("Laura", 19));
		personas.add(new Persona("Andrés", 31));
		personas.add(new Persona("Marta", 18));
		personas.add(new Persona("Miguel", 32));

		// Ordenar la lista por nombre
		List<Persona> sortedList = personas.stream()
				.sorted(Comparator.comparing(Persona::getNombre))
				.collect(Collectors.toList());

		// Imprimir la lista ordenada
		sortedList.forEach(System.out::println);

		System.out.println("******************************");

		// Ordenar la lista por edad
		List<Persona> sortedEdad = personas.stream()
				.sorted(Comparator.comparingInt(Persona::getEdad))
				.collect(Collectors.toList());

		// Imprimir la lista ordenada
		sortedEdad.forEach(System.out::println);
	}
}
