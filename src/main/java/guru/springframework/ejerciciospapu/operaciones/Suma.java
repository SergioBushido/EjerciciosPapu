package guru.springframework.ejerciciospapu.operaciones;


public class Suma extends Operacion{

    public Suma(double valor1, double valor2) {
        super(valor1, valor2);
    }
    @Override
    public void operar() {
        resultado = valor1 + valor2;

    }
}
