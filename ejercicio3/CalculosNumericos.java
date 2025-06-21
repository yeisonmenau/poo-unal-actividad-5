package ejercicio3;

import java.util.InputMismatchException;

public class CalculosNumericos {

    public CalculosNumericos() {
    }

    public double calcularLogaritmoNeperiano(double numero) {
        try{
            if (numero <= 0) {
                throw new ArithmeticException("El número debe ser positivo.");
            }
            return Math.log(numero);
        }catch (ArithmeticException e){
            throw new ArithmeticException("Debe ser un numero positivo");
        }catch (InputMismatchException e){
            throw new InputMismatchException("Debe ser un numero");
        }
    }
    public double calularRaizCuadrada(double numero){
        try {
            if (numero < 0){
                throw new ArithmeticException("El número debe ser mayor o igual a cero.");
            }
            return Math.sqrt(numero);
        }catch (ArithmeticException e) {
            throw new ArithmeticException("Debe ser un numero positivo o cero");
        }catch (InputMismatchException e){
            throw new InputMismatchException("Debe ser un numero");
        }
    }
}
