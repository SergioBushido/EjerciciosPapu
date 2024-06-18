package guru.springframework.ejerciciospapu;

import guru.springframework.ejerciciospapu.operaciones.Operacion;
import guru.springframework.ejerciciospapu.operaciones.Resta;
import guru.springframework.ejerciciospapu.operaciones.Suma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EjerciciosPapuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPapuApplication.class, args);

		Suma suma1 = new Suma(2,5);
		Suma suma2 = new Suma(2,6);
		Suma suma3 = new Suma(2,7);
		Suma suma4 = new Suma(2,8);



		Resta resta1 = new Resta(10,5);
		Resta resta2 = new Resta(9,5);
		Resta resta3 = new Resta(8,5);
		Resta resta4 = new Resta(7,5);


		List<Operacion> operacines = new ArrayList<>();

		operacines.add(suma1);
		operacines.add(suma2);
		operacines.add(suma3);
		operacines.add(suma4);
		operacines.add(resta1);
		operacines.add(resta2);
		operacines.add(resta3);
		operacines.add(resta4);
		operacines.forEach(operacion -> {
			operacion.operar();
			System.out.println(operacion.getResultado());
		});

	}

}
