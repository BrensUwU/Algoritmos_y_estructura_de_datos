import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Scanner scanner = new Scanner(System.in);
        String operacion;
        List<Double> numeros = new ArrayList<>();

        while (true) {
            System.out.println("Elige una operación: suma, resta, multiplicacion, division, raiz, exponente, historial, eliminar, salir");
            operacion = scanner.next();

            if (operacion.equals("salir")) {
                break;
            } else if (operacion.equals("historial")) {
                calculadora.mostrarHistorial();
            } else if (operacion.equals("eliminar")) {
                calculadora.eliminarHistorial();
            } else {
                numeros.clear();
                if (operacion.equals("raiz")) {
                    System.out.println("Ingresa el número:");
                    numeros.add(scanner.nextDouble());
                } else {
                    System.out.println("¿Cuántos números quieres usar?");
                    int cantidad = scanner.nextInt();
                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("Ingresa el número " + (i + 1) + ":");
                        numeros.add(scanner.nextDouble());
                    }
                }

                double resultado = calculadora.realizarOperacion(operacion, numeros);
                System.out.println("Resultado: " + resultado);
            }
        }

        scanner.close();
    }
}
