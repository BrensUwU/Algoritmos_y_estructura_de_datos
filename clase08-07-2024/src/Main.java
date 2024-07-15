//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();

        // Agregar nodos al inicio
        lista.agregarInicio(3);
        lista.agregarInicio(18);
        lista.agregarInicio(7);

        // Mostrar los nodos de la lista
        lista.mostrarLista(); // Salida: 7 18 3

        // Imprimir los nodos de la lista
        lista.imprimir(); // Salida: 7 18 3

        // Agregar nodos al final
        lista.agregarAlFinal(5);
        lista.agregarAlFinal(12);

        // Mostrar los nodos de la lista
        lista.mostrarLista(); // Salida: 7 18 3 5 12

        // Imprimir los nodos de la lista
        lista.imprimir(); // Salida: 7 18 3 5 12

        // Eliminar el nodo al inicio
        lista.eliminarAlInicio();

        // Mostrar los nodos de la lista
        lista.mostrarLista(); // Salida: 18 3 5 12

        // Imprimir los nodos de la lista
        lista.imprimir(); // Salida: 18 3 5 12

        // Eliminar el nodo al final
        lista.eliminarAlFinal();

        // Mostrar los nodos de la lista
        lista.mostrarLista(); // Salida: 18 3 5

        // Imprimir los nodos de la lista
        lista.imprimir(); // Salida: 18 3 5
    }    
}