public class Nodo {
    int dato;
    Nodo siguiente;
    Nodo anterior;

    // Constructor para inicializar el nodo
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    // Método para mostrar el contenido del nodo
    public void mostrarNodo() {
        System.out.print(dato + " ");
    }
}
