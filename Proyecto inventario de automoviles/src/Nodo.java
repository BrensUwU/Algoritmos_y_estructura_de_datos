public class Nodo {
    Automovil automovil;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(Automovil automovil) {
        this.automovil = automovil;
        this.siguiente = null;
        this.anterior = null;
    }
}
