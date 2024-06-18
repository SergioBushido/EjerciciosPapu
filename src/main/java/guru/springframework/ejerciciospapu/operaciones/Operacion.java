package guru.springframework.ejerciciospapu.operaciones;

import lombok.Data;

@Data
public abstract class Operacion {

    double valor1;
    double valor2;
    double resultado;

    public Operacion(double valor1, double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public abstract void operar();
}
