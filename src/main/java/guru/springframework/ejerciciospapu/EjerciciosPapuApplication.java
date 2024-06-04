package guru.springframework.ejerciciospapu;

import guru.springframework.ejerciciospapu.empleados.Empleados;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/*Descripción: Crea una clase Empleado con atributos nombre, edad, salario y departamento. Luego, crea una lista de empleados y usa Streams para:
Obtener la lista de empleados de un determinado departamento.
Calcular el salario promedio de los empleados mayores de 30 años.
Obtener el nombre del empleado con el salario más alto.*/


@SpringBootApplication
public class EjerciciosPapuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPapuApplication.class, args);

		// Inicializar la lista de empleados
		List<Empleados> empleados = new ArrayList<>();
		empleados.add(new Empleados("Sergio", 45, 850, "Becario"));
		empleados.add(new Empleados("Papu", 33, 4500, "Ingeniero"));
		empleados.add(new Empleados("Kenelma", 30, 3000, "Ingeniero"));
		empleados.add(new Empleados("Vicky", 29, 850, "Becario"));

		// Obtener la lista de empleados de un departamento determinado
		String departamentoObjetivo = "Ingeniero";
		List<Empleados> empleadosDepartamento = empleados.stream()
				.filter(empleado -> empleado.getDepartamento().equals(departamentoObjetivo))
				.collect(Collectors.toList());

		System.out.println("Empleados en el departamento de " + departamentoObjetivo + ": " + empleadosDepartamento);

		String departamentoObjetivo2 = "Becario";
		List<Empleados> empleadosDepartamento2 = empleados.stream()
				.filter(empleado -> empleado.getDepartamento().equals(departamentoObjetivo2))
				.collect(Collectors.toList());

		System.out.println("Empleados en el departamento de " + departamentoObjetivo2 + ": " + empleadosDepartamento2);


		// Calcular el salario promedio de los empleados mayores de 30 años
		double salarioPromedio = empleados.stream()
				.filter(empleado -> empleado.getEdad() > 30)
				.mapToDouble(Empleados::getSalario)
				.average()
				.orElse(0.0);

		System.out.println("Salario promedio de empleados mayores de 30 años: " + salarioPromedio);

		// Obtener el nombre del empleado con el salario más alto
		Empleados empleadoConSalarioMasAlto = empleados.stream()
				.max((empleado1, empleado2) -> Double.compare(empleado1.getSalario(), empleado2.getSalario()))
				.orElse(null);

		if (empleadoConSalarioMasAlto != null) {
			System.out.println("Empleado con el salario más alto: " + empleadoConSalarioMasAlto.getNombre());
		}
	}
}
