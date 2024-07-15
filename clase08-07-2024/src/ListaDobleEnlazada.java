public class ListaDobleEnlazada {
    private Nodo inicio;
    private Nodo fin;

    // Constructor para inicializar la lista
    public ListaDobleEnlazada() {
        this.inicio = null;
        this.fin = null;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacio() {
        return inicio == null;
    }

    // Método para agregar un nodo al inicio de la lista
    public void agregarInicio(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (estaVacio()) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            nuevoNodo.siguiente = inicio;
            inicio.anterior = nuevoNodo;
            inicio = nuevoNodo;
        }
    }

    // Método para agregar un nodo al final de la lista
    public void agregarAlFinal(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (estaVacio()) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
    }


    // Método para mostrar los nodos de la lista
    public void mostrarLista() {
        Nodo actual = inicio;
        while (actual != null) {
            actual.mostrarNodo();
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para imprimir los nodos de la lista
    public void imprimir() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para eliminar el nodo al inicio de la lista
    public void eliminarAlInicio() {
        if (!estaVacio()) {
            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.siguiente;
                inicio.anterior = null;
            }
        }
    }

    // Método para eliminar el nodo al final de la lista
    public void eliminarAlFinal() {
        if (!estaVacio()) {
            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                fin = fin.anterior;
                fin.siguiente = null;
            }
        }
    }
}

