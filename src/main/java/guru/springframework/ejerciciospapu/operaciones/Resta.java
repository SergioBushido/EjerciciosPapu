package guru.springframework.ejerciciospapu.operaciones;

public class Resta extends Operacion{


    public Resta(double valor1, double valor2) {
        super(valor1, valor2);
    }

    @Override
    public void operar() {
        resultado = valor1 - valor2;
    }
}
