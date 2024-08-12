import java.util. *;
    class Calculadora {

            // Historial
            private Queue<String> historial;

            public Calculadora() {
                historial = new LinkedList<>();
            }

            // Operaciones básicas
            private double operarRecursivo(Stack<Double> numeros, String operador) {
                // Base case: If there's only one number left, return it
                if (numeros.size() == 1) {
                    return numeros.pop();
                }

                double resultado = numeros.pop();

                while (!numeros.isEmpty()) {
                    double num = numeros.pop();

                    switch (operador) {
                        case "+":
                            resultado += num;
                            break;
                        case "-":
                            resultado -= num;
                            break;
                        case "*":
                            resultado *= num;
                            break;
                        case "/":
                            if (num != 0) {
                                resultado /= num;
                            } else {
                                System.out.println("Error: División por cero");
                                return 0;
                            }
                            break;
                    }
                }

                return resultado;
            }

            // Raíz cuadrada
            private double raizCuadrada(double numero) {
                if (numero < 0) {
                    System.out.println("Error: Raíz cuadrada de número negativo");
                    return 0;
                }
                return Math.sqrt(numero);
            }

            // Exponente
            private double exponenteRecursivo(double base, int exponente) {
                if (exponente == 0) {
                    return 1;
                } else {
                    return base * exponenteRecursivo(base, exponente - 1);
                }
            }

            // Operaciones
            public double realizarOperacion(String operacion, List<Double> numeros) {
                Stack<Double> pilaNumeros = new Stack<>();
                // Insertamos los números en orden inverso para manejar la operación correctamente.
                for (int i = numeros.size() - 1; i >= 0; i--) {
                    pilaNumeros.push(numeros.get(i));
                }

                double resultado = 0;

                switch (operacion) {
                    case "suma":
                        resultado = operarRecursivo(pilaNumeros, "+");
                        break;
                    case "resta":
                        resultado = operarRecursivo(pilaNumeros, "-");
                        break;
                    case "multiplicacion":
                        resultado = operarRecursivo(pilaNumeros, "*");
                        break;
                    case "division":
                        resultado = operarRecursivo(pilaNumeros, "/");
                        break;
                    case "raiz":
                        if (numeros.size() == 1) {
                            resultado = raizCuadrada(numeros.get(0));
                        } else {
                            System.out.println("Error: La raíz cuadrada requiere un solo número");
                        }
                        break;
                    case "exponente":
                        if (numeros.size() == 2) {
                            resultado = exponenteRecursivo(numeros.get(0), numeros.get(1).intValue());
                        } else {
                            System.out.println("Error: La operación exponente requiere dos números");
                        }
                        break;
                    default:
                        System.out.println("Operación no válida");
                        break;
                }

                historial.add(operacion + " " + numeros.toString() + " = " + resultado);
                return resultado;
            }

            // Mostrar el historial
            public void mostrarHistorial() {
                if (historial.isEmpty()) {
                    System.out.println("No hay operaciones en el historial.");
                } else {
                    System.out.println("Historial de operaciones:");
                    for (String operacion : historial) {
                        System.out.println(operacion);
                    }
                }
            }

            // Eliminar el historial
            public void eliminarHistorial() {
                historial.clear();
                System.out.println("Historial eliminado.");
            }
    }
