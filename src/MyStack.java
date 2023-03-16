import java.util.Stack;

public class MyStack<T> {
    Node<T> head;

    public MyStack() {
        head = null;
    }

    public void stack_push(T stack) {
        head = new Node<T>(stack, head);
    }

    boolean isEmpty() {
        return (head == null);
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "head=" + head +
                '}';
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
