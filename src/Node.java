public class Node<T> {

    /**

     * The info of this node

     */

    T info;

    /**

     * The next node

     */

    Node next;

    /**

     * Default constructor

     */
    public  Node() {}

    public Node(T info) {
        this.info = info;
        this.next = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    /**

     * Constructor with info and next node

     *

     * @param info The info of this node

     * @param next The next Node of this node

     */

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }

    /**

     * Overriding to convert this node to String

     */

    @Override
    public String toString() {
        return "Node{" +
                "info=" + info +
                ", next=" + next +
                '}';
    }
}
