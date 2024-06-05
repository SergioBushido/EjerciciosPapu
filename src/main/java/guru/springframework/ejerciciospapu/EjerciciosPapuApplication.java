package guru.springframework.ejerciciospapu;

import guru.springframework.ejerciciospapu.biblioteca.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Descripción: Crea una clase Libro con atributos titulo, autor, año de publicación y precio.
Luego, crea una lista de libros y usa Streams para:

*Obtener la lista de libros publicados después del año 2000.

*Agrupar los libros por autor.

*Calcular el precio total de todos los libros.
*/
@SpringBootApplication
public class EjerciciosPapuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPapuApplication.class, args);

		List<Book> book = new ArrayList<>();
		book.add(new Book("Lord of the rings", "Tolkien", 1956, 22.30));
		book.add(new Book("Game of thrones", "JRR", 20010, 30.55));
		book.add(new Book("D&D", "Aiden Stormweaver", 1970, 14.33));
		book.add(new Book("Storm Bringer", "M.Moorkock", 1980, 10.33));



//*Obtener la lista de libros publicados después del año 2000.

		List<Book> publicatedBooks = book.stream()
				.filter(books->books.getYear()>2000)
				.collect(Collectors.toList());


		//Imperativa
		//for (Book books : publicatedBooks) {
		//	System.out.println(book);}

		//Declarativa
		publicatedBooks.forEach(System.out::println);

		//Utilizando Lambda
		//publicatedBooks.forEach(books -> System.out.println(books));

		System.out.println("****************************************");

		//* Agrupar los libros por autor.
		Map<String, List<Book>> booksByAuthor = book.stream()
				.collect(Collectors.groupingBy(Book::getAuthor));
/*Collectors.groupingBy(Book::getAuthor) es un método del API de Streams de Java que agrupa los elementos del stream basándose en un criterio especificado.*/
		booksByAuthor.forEach((author, booksList) -> {
			System.out.println("Author: " + author);
			booksList.forEach(System.out::println);
		});

		System.out.println("****************************************");

//*Calcular el precio total de todos los libros.

		double totalPrice = book.stream()
				.mapToDouble(Book::getPrice)//Mapeo a DoubleStream de precios: [22.30, 30.55, 14.33, 10.33]
				.sum();

		System.out.println("Total price of all books: " + totalPrice);

	}


}
