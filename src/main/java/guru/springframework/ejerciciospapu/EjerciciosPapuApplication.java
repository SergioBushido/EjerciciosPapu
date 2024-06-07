package guru.springframework.ejerciciospapu;

import guru.springframework.ejerciciospapu.models.Curso;
import guru.springframework.ejerciciospapu.models.Estudiantes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class EjerciciosPapuApplication {
/*
Descripción: Crea una clase Curso con atributos nombre, duracion (en horas), instructor y estudiantes (lista de nombres de estudiantes).
 Luego, crea una lista de cursos y usa Streams para:
Obtener la lista de cursos con duración mayor a 20 horas.
Agrupar los cursos por instructor.
Obtener el curso con el mayor número de estudiantes.
 */
	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPapuApplication.class, args);

		Estudiantes estudiante1 = new Estudiantes("Paco");
		Estudiantes estudiante2 = new Estudiantes("Maria");
		Estudiantes estudiante3 = new Estudiantes("Ana");
		Estudiantes estudiante4 = new Estudiantes("Fran");
		Estudiantes estudiante5 = new Estudiantes("Rober");
		Estudiantes estudiante6 = new Estudiantes("Isa");


		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso(1, "Java", 33.5, "Manolo", Arrays.asList(estudiante1, estudiante2)));
		cursos.add(new Curso(2, "Python", 15.0, "Carlos", Arrays.asList(estudiante3, estudiante4)));
		cursos.add(new Curso(3, "JavaScript", 25.0, "Manolo", Arrays.asList(estudiante1, estudiante3, estudiante5)));
		cursos.add(new Curso(4, "C++", 40.0, "Lucia", Arrays.asList(estudiante2, estudiante4, estudiante6)));
		cursos.add(new Curso(5, "Ruby", 10.0, "Carlos", Arrays.asList(estudiante3, estudiante5)));
		cursos.add(new Curso(6, "Go", 22.5, "Lucia", Arrays.asList(estudiante1, estudiante4, estudiante5, estudiante6)));



		System.out.println("Obtener la lista de cursos con duración mayor a 20 horas.\n");

		List<Curso> cursoList = cursos.stream()
				.filter(duracion->duracion.getDuracion()>20)
				.collect(Collectors.toList());
		cursoList.forEach(System.out::println);


		System.out.println("*************************************************************");
		System.out.println("Agrupar los cursos por instructor.");
		Map<String, List<Curso>> cursosPorInstructor = cursos.stream()
				.collect(Collectors.groupingBy(Curso::getInstructor));

		System.out.println("Cursos agrupados por instructor: " + cursosPorInstructor);


		System.out.println("*************************************************************");
		System.out.println("Obtener el curso con el mayor número de estudiantes.");
		Curso cursoConMayorNumeroDeEstudiantes = cursos.stream()
				.max(Comparator.comparingInt(curso -> curso.getEstudiantes().size()))
				.orElse(null);

		if (cursoConMayorNumeroDeEstudiantes != null) {
			System.out.println("Curso con el mayor número de estudiantes: " + cursoConMayorNumeroDeEstudiantes);
		} else {
			System.out.println("No hay cursos disponibles.");
		}

		};







	}


