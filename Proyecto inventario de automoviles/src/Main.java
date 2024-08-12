import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Cabeza de la lista enlazada (el primer nodo)
    private Nodo cabeza = null;

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    // Método para mostrar el menú y manejar las opciones del usuario
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar opciones del menú
            System.out.println("\nMenú:");
            System.out.println("1. Alta de automovil");
            System.out.println("2. Mostrar inventario de automoviles");
            System.out.println("3. Actualizar Automovil");
            System.out.println("4. Baja de automovil");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            // Manejar la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    Altadeautomovil(); // Crear un nuevo automovil
                    break;
                case 2:
                    Mostrarinventariodeautomoviles(); // Leer e imprimir la lista de automoviles
                    break;
                case 3:
                    actualizarAutomovil(); // Actualizar un automovil existente
                    break;
                case 4:
                    Bajadeautomovil(); // Eliminar un automovil de la lista
                    break;
                case 5:
                    System.out.println("Saliendo..."); // Salir del programa
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }

    // Método para crear un nuevo automovil e insertarlo en la lista
    public void Altadeautomovil() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos del nuevo automovil al usuario
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Caballos de fuerza: ");
        int caballosDeFuerza = scanner.nextInt();

        // Crear un nuevo objeto Automovil
        Automovil nuevoAutomovil = new Automovil(placa, marca, modelo, precio, caballosDeFuerza);
        // Crear un nuevo nodo con el automovil creado
        Nodo nuevoNodo = new Nodo(nuevoAutomovil);

        // Insertar el nuevo nodo en la lista enlazada
        if (cabeza == null) {
            cabeza = nuevoNodo; // Si la lista está vacía, el nuevo nodo es la cabeza
        } else {
            Nodo actual = cabeza;
            // Recorrer la lista hasta el último nodo
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo; // Enlazar el nuevo nodo al final de la lista
            nuevoNodo.anterior = actual; // Establecer la referencia al nodo anterior
        }
        System.out.println("Automovil creado con éxito.");
    }

    // Método para leer e imprimir todos los automoviles en la lista
    public void Mostrarinventariodeautomoviles() {
        if (cabeza == null) {
            System.out.println("No hay automoviles en la lista.");
        } else {
            Nodo actual = cabeza;
            int index = 1;
            // Recorrer la lista e imprimir cada automovil
            while (actual != null) {
                System.out.println(index + ". " + actual.automovil);
                actual = actual.siguiente;
                index++;
            }
        }
    }

    // Método para actualizar los datos de un automovil existente
    public void actualizarAutomovil() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Buscar automovil por placa");
            System.out.println("2. Mostrar lista de automoviles y seleccionar");
            System.out.println("3. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            if (opcion == 3) {
                break;
            }

            Nodo automovilSeleccionado = null;

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la placa del automovil a actualizar: ");
                    String placa = scanner.nextLine();
                    automovilSeleccionado = buscarAutomovilPorPlaca(placa);
                    break;
                case 2:
                    automovilSeleccionado = seleccionarAutomovilDeLista();
                    break;
                default:
                    System.out.println("Opción no válida");
                    continue;
            }

            if (automovilSeleccionado != null) {
                // Solicitar los nuevos datos del automovil
                System.out.print("Nueva Marca: ");
                automovilSeleccionado.automovil.marca = scanner.nextLine();
                System.out.print("Nuevo Modelo: ");
                automovilSeleccionado.automovil.modelo = scanner.nextLine();
                System.out.print("Nuevo Precio: ");
                automovilSeleccionado.automovil.precio = scanner.nextDouble();
                System.out.print("Nuevos Caballos de fuerza: ");
                automovilSeleccionado.automovil.caballosDeFuerza = scanner.nextInt();
                scanner.nextLine();  // Limpiar buffer
                System.out.println("Automovil actualizado con éxito.");

                // Preguntar si desea actualizar otro automovil
                System.out.print("¿Deseas actualizar otro automovil? (si/no): ");
                String respuesta = scanner.nextLine();
                if (!respuesta.equalsIgnoreCase("si")) {
                    break;
                }
            } else {
                System.out.println("Automovil no encontrado.");
            }
        }
    }

    // Método para buscar un automovil por su placa
    private Nodo buscarAutomovilPorPlaca(String placa) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.automovil.placa.equals(placa)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // Método para mostrar la lista de automoviles y seleccionar uno
    private Nodo seleccionarAutomovilDeLista() {
        Mostrarinventariodeautomoviles();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Selecciona el número del automovil que deseas actualizar: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer

        Nodo actual = cabeza;
        int index = 1;
        while (actual != null) {
            if (index == seleccion) {
                return actual;
            }
            actual = actual.siguiente;
            index++;
        }
        return null;
    }

    // Método para eliminar un automovil de la lista
    public void Bajadeautomovil() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la placa del automovil a eliminar: ");
        String placa = scanner.nextLine();

        Nodo actual = cabeza;

        // Verificar si el automovil a eliminar es el primero en la lista
        if (actual != null && actual.automovil.placa.equals(placa)) {
            cabeza = actual.siguiente; // Cambiar la cabeza de la lista
            if (cabeza != null) {
                cabeza.anterior = null; // Eliminar la referencia al nodo anterior
            }
            System.out.println("Automovil eliminado con éxito.");
            return;
        }

        // Buscar el automovil en la lista
        while (actual != null && !actual.automovil.placa.equals(placa)) {
            actual = actual.siguiente;
        }

        // Si no se encuentra el automovil
        if (actual == null) {
            System.out.println("Automovil no encontrado.");
            return;
        }

        // Desenlazar el nodo de la lista
        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        }

        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        }

        System.out.println("Automovil eliminado con éxito.");
    }
}
