//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListasDoblementeEnlazadas list = new ListasDoblementeEnlazadas();
        list.add(4);
        list.add(7);
        list.add(19);
        list.add(34);
        list.add(0);
        list.add(2);
        list.add(5);

        System.out.println("Lista original:");
        list.printList();

        // Aplicar insertion sort
        list.insertionSort();
        System.out.println("Lista ordenada por insertion sort:");
        list.printList();

        // Restaurar lista original
        list = new ListasDoblementeEnlazadas();
        list.add(4);
        list.add(7);
        list.add(19);
        list.add(34);
        list.add(0);
        list.add(2);
        list.add(5);

        // Aplicar quick sort
        list.quickSort();
        System.out.println("Lista ordenada por quick sort:");
        list.printList();
    }
}