//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int number = 5;
        int result = ArregloRecursivo.factorial(number);
        System.out.println("El factorial de " + number + " es: " + result);

        int num = 5;
        int resultado = FactorialIterativo.factorial(num);
        System.out.println("El factorial de " + num + " es: " + resultado);
    }
}