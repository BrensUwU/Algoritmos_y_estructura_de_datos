public class ListasDoblementeEnlazadas {
    private Nodo head;

    public void add(int data) {
        Nodo newNode = new Nodo(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Nodo current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void printList() {
        Nodo current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void insertionSort() {
        if (head == null) return;
        Nodo sorted = null;
        Nodo current = head;
        while (current != null) {
            Nodo next = current.next;
            current.prev = current.next = null;
            sorted = sortedInsert(sorted, current);
            current = next;
        }
        head = sorted;
    }

    private Nodo sortedInsert(Nodo sorted, Nodo newNode) {
        if (sorted == null) return newNode;
        if (newNode.data < sorted.data) {
            newNode.next = sorted;
            sorted.prev = newNode;
            return newNode;
        }
        Nodo current = sorted;
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }
        newNode.next = current.next;
        if (current.next != null) {
            newNode.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
        return sorted;
    }

    public void quickSort() {
        quickSortRec(head, getLastNode(head));
    }

    private void quickSortRec(Nodo left, Nodo right) {
        if (right != null && left != right && left != right.next) {
            Nodo pivot = partition(left, right);
            quickSortRec(left, pivot.prev);
            quickSortRec(pivot.next, right);
        }
    }

    private Nodo partition(Nodo left, Nodo right) {
        int pivot = right.data;
        Nodo i = left.prev;
        for (Nodo j = left; j != right; j = j.next) {
            if (j.data <= pivot) {
                i = (i == null) ? left : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i == null) ? left : i.next;
        int temp = i.data;
        i.data = right.data;
        right.data = temp;
        return i;
    }

    private Nodo getLastNode(Nodo node) {
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }
}
