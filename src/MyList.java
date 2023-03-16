public class MyList<T> {

    /**
     * Head node, default is null
     */

    Node<T> head;


    /**
     * Tail node, default is null
     */

    Node<T> tail;


    /**
     * Default constructor
     */

    public MyList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Constructor with head and tail
     *
     * @param head Head node of this list
     * @param tail Tail node of this list
     */
    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    /**
     * Checking if this list is empty
     *
     * @return true if list is empty
     */

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    /**
     * Returning the length of this list
     *
     * @return The length of this list
     */

    public int length() {
        int length = 0;
        Node current = this.head;
        while (current != null) { //ko tính null
            length++;
            current = current.getNext(); //cập nhật vị trí mới
        }
        return length;
    }

    /**
     * Insert an item to the head of this list
     *
     * @param item The item to be inserted
     */

    public void insertToHead(T item) {
        Node<T> newNode = new Node<T>(item);
        if (head == null) {
            //nếu danh sách rỗng, thêm node mới và gán vào head và tail
            head = newNode;
            tail = newNode;
        } else {
            //node mới temp sẽ là head
            Node<T> temp = head;
            head = newNode; //node mới
            //lùi node đầu tiên đã gán temp ra phiasa sau
            head.next = temp;
        }
    }

    public void insertToTail(T item) {
        //tạo node mới
        Node<T> newNode = new Node<T>(item);

        //Kiểm tra xem đã cos dữ liệu
        if (head == null) {
            //nếu trống thì thêm cả head và tail
            head = newNode;
            tail = newNode;
        } else {
            //node mới sẽ thêm sau tail, cũng như tail sau sẽ thành node mới
            tail.next = newNode;
            //newNode sẽ trở thành tail
            tail = newNode;
        }
    }

    /**
     * Insert an item at position to this list
     * <p>
     * <p>
     * <p>
     * //     * @param position The position of new item
     *
     * @param item The item to be inserted
     */

    //lấy giá trị node
    Node<T> getNode(T item) {
        return new Node<T>(item);
    }
    public void insertAfterPosition(int position, T item) {
        //tạo nút mới
        Node<T> newNode = new Node<T>();
        newNode.info = item;
        newNode.next = null;
        //kiểm tra nếu position > 0
        if (position < 1) {
            System.out.println("\n Position should be >=1.");
        } else if (position == 1) {
            //nếu position = 1 thì tạo new node như head mới
            newNode.next = head; //gán node tiếp theo bằng node đầu tiên
            head = newNode; //node đầu tiên bằng newNode
        } else { //điền kiện position >1
            //tạo node tạm thời đi qua node trước đó
            Node<T> temp = new Node();
            temp = head;
            for (int i = 1; i < position - 1; i++) {
                if (temp != null) {
                    temp = temp.next;
                }
            }
            //nếu vị trí node trước ko null thì tạo newNode tiếp theo như node tạm thời tiếp,
            //và gán node tạm thời tiếp như newNode
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("\n The previous node is null.");
            }
        }
    }

    //deleteHead
    public void deleteHead() {
        this.head = this.head.getNext();
    }

    /**
     * Deleting the tail of this list
     */

    public void deleteTail() {
        if (tail == null) {
            return;
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Node<T> previousToTail = head;
                while (previousToTail.next != tail)
                    previousToTail = previousToTail.next;
                tail = previousToTail;
                tail.next = null;
            }
        }
    }

    /**
     * Searching and deleting an item from this list by comparing the ID of items
     *
     * @param item The item to be deleted
     */

    public void deleteElement(T item) {
        Node<T> temp = head;
        Node<T> prev = null;
        //nếu node đầu là item cần xóa thì
        if (temp != null && temp.info == item) {
            deleteHead();
            return;
        }
        //tìm item tron node
        while (temp != null && temp.info != item) {
            prev = temp;
            temp = temp.next;
        }
        //nếu item ko thuộc list
        if (temp == null) {
            return;
        }
        //liên kết lại vị trí vừa cắt
        prev.next = temp.next;
    }


    /**
     * Swaping two nodes [firstNode] and [secondNode]
     *
     * @param firstNode
     * @param secondNode
     */

    public void swap(Node<T> firstNode, Node<T> secondNode) {
        Node<T> prevNode1 = null, prevNode2 = null, node1 = head, node2 = head;
        //kiểm tra lại list trống hay ko
        if (head == null) {
            return;
        }
        //nếu 2 node bằng nhau thì return, ko trả về gì
        if (firstNode == secondNode) {
            return;
        }
        //tìm firstNode
        while (node1 != null && node1.info != firstNode) {
            prevNode1 = node1;
            node1 = node1.next;
        }
        //tìm secondNode
        while (node2 != null && node2.info != secondNode) {
            prevNode2 = node2;
            node2 = node2.next;
        }
        if (node1 != null && node2 != null) {
            if (prevNode1 != null) {
                prevNode1.next = node2;
            } else {
                head = node2;
            }
            if (prevNode2 != null) {
                prevNode2.next = node1;
            } else {
                head = node1;
            }
            //đổi vị trí node tiếp theo của 2 node 1 và 2
            Node<T> temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;
        } else {
            System.out.println("Swapping is not possible.");
        }
    }

    /**
     * Deleting all items in the list
     */

    public void clear() {
        head = null;
        tail = null;
    }

    //Add new element at the end of the list
    public void push_back(T item) {
        Node<T> newNode = new Node<T>();
        newNode.info = item;
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = new Node<T>();
            temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    //display the content of the list
    void display() {
        Node<Product> current = (Node<Product>) head;
        if (head == null) {
            System.out.println("This list is empty");
            return;
        } else {
            System.out.printf("%4s | %12s | %10s | %5s", "ID", "Title", "Quantify", "Price");
            System.out.println();
            while (current != null) {
                System.out.printf("%4s | %12s | %10s | %5s", current.getInfo().getBcode(), current.getInfo().getTitle(), current.getInfo().getQuantify(), current.getInfo().getPrice());
                System.out.println();
                current = current.next;
            }
        }
    }

    @Override
    public String toString() {
        Node<Product> current = (Node<Product>) head;
        if (head == null) {
        }
        return current.getInfo().getBcode() + "," + current.getInfo().getTitle() + "," + current.getInfo().getQuantify() + "," + current.getInfo().getPrice();

    }
}
