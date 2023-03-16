public class MyQueue<T> {
    /**
     * Head node contains front node in the queue
     */

    Node<T> head;


    /**
     * Tail node contains last node in the queue
     */

    Node<T> tail;

    public MyQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    void enqueue(T x) {
        if (isEmpty())
            head = tail = new Node<T>(x);
        else {
            tail.next = new Node<T>(x);
            tail = tail.next;
        }
    }
    void display() {
        Node<Product> current = (Node<Product>) head;
        if(head == null) {
            System.out.println("This list is empty");
            return;
        } else {
            System.out.printf("%4s | %12s | %10s | %5s","ID","Title","Quantify","Price");
            System.out.println();
            while (current != null) {
                System.out.printf("%4s | %12s | %10s | %5s",current.getInfo().getBcode(),current.getInfo().getTitle(),current.getInfo().getQuantify(),current.getInfo().getPrice());
                System.out.println();
                current = current.next;
            }
        }
    }
}
