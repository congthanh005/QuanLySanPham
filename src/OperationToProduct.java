import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OperationToProduct {
    Scanner scanner = new Scanner(System.in);
    /**
     * Searching and returning the index of product p in the list. If not found
     * <p>
     * return -1.
     *
     * @param p    Product for searching
     * @param list The Linked List
     * @return The index of product p in the list
     */
    public int index(Product p, MyList<Product> list) {
        int index = 0;
        for (int i = 0; i < list.length(); i++) {
            if (p.getBcode().equals(list.head.getInfo().getBcode())) {
                return index;
            }
            index++;
        }

        return -1;
    }

    /**
     * Creating and returning a product with info input from keyboard.
     *
     * @return The product
     */
    //thêm sản phẩm mới
    public Product createProduct() {
        String bcode;
        String title;
        int quantify;
        double price;
        System.out.print("Input product bcode: ");
        bcode = scanner.nextLine();
        System.out.print("Input product title: ");
        title = scanner.nextLine();
        System.out.print("Input product quantify: ");
        while (true) {
            try {
                quantify = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.print("Please input product quantify: ");
                scanner.nextLine();
            }
        }
        System.out.print("Input product price: ");
        while (true) {
            try {
                price = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Please input product price: ");
                scanner.nextLine();
            }
        }
        Product newPro = new Product(bcode, title, quantify, price);
        return newPro;
    }
    /**
     * Reading all products from the file and insert them to the list at tail.
     *
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */
    //chức năng 1
    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        try {
            //đọc file
            String[] txt;
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                //đọc từng dòng rồi lưu thành chuỗi String
                txt = line.split(",");
                //cắt mỗi đoạn bằng dấu phảy rồi lưu thành new Product
                Product newPro = new Product(txt[0], txt[1], Integer.parseInt(txt[2]), Double.parseDouble(txt[3]));
                //thêm vào tail của list ban đầu
                list.insertToTail(newPro);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reading all products from the file and insert them to the stack.
     *
     * @param fileName The file name of the file
     * @param stack    The Stack contains all products that read from file
     */
    //chức năng 9
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        try {
            //đọc file
            String[] txt;
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                //đọc từng dòng rồi lưu thành chuỗi String
                txt = line.split(",");
                //cắt mỗi đoạn bằng dấu phảy rồi lưu thành new Product
                Product newPro = new Product(txt[0], txt[1], Integer.parseInt(txt[2]), Double.parseDouble(txt[3]));
                //thêm vào tail của list ban đầu
                stack.stack_push(newPro);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reading all products from the file and insert them to the queue.
     *
     * @param fileName The file name of the file
     * @param queue    The Queue contains all products that read from file
     */
    //chức năng 10
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        try {
            //đọc file
            String[] txt;
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                //đọc từng dòng rồi lưu thành chuỗi String
                txt = line.split(",");
                //cắt mỗi đoạn bằng dấu phảy rồi lưu thành new Product
                Product newPro = new Product(txt[0], txt[1], Integer.parseInt(txt[2]), Double.parseDouble(txt[3]));
                //thêm vào tail của list ban đầu
                queue.enqueue(newPro);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adding a product to the list, info of the product input from keyboard.
     *
     * @param list The Linked list
     */
    //chức năng 2: input and add to end
    public void addLast(MyList<Product> list) {
        Product newPro = createProduct(); //tạo new product
        Node<Product> cur = list.getHead();
        boolean flag = false;
        while (cur != null) {
            if (cur.getInfo().getBcode().equals(newPro.getBcode())) {
                flag = true;
            }
            cur = cur.getNext();
        }
        if (flag == false) {
            list.insertToTail(newPro); //them vào vị trí cuối cùng
            System.out.println("Add product is successful!");
        } else {
            System.out.println("Input's Id is exited!");
        }
    }

    /**
     * Printing all prodcuts of the list to console screen
     *
     * @param list
     */

    public void displayAll(MyList<Product> list) {
        Node<Product> temp = new Node();
        temp = list.head;
        if (temp != null) {
            System.out.print("The list contains: ");
            while (temp != null) {
                System.out.print(temp.info + " ");
                temp = temp.next;
            }
            System.out.println();
        } else {
            System.out.println("The list is empty.");
        }
    }

    /**
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */
    //chức năng 4: lưu vào file data.txt
    public void writeAllItemsToFile(String fileName, MyList<Product> list) {
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            Node<Product> cur = list.getHead();
            while (cur != null) {
                bw.write(String.format("%s,%s,%s,%s", cur.getInfo().getBcode(), cur.getInfo().getTitle(), cur.getInfo().getQuantify(), cur.getInfo().getPrice()));
                bw.newLine();
                cur = cur.getNext();

            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //đọc file
    private static void ReadFromFile(String name, MyList<Product> list) {
        Product product = new Product();
        try {
            FileInputStream fis = new FileInputStream(name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            product = (Product) obj;
            list.insertToTail(product);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Searching product by ID input from keyboard.
     *
     * @param list
     */
//chức năng 5:
    //đọc file lấy ra list product
    //gọi ra sử dụng luôn
    public void searchByCode(MyList<Product> list) {
        String id;
        System.out.println("Input the ID to search: ");
        id = scanner.nextLine().toUpperCase();
        Node<Product> currentNode = list.getHead();
        boolean flag = false;
        while (currentNode != null) {
            if (currentNode.getInfo().getBcode().toUpperCase().equals(id)) {
                flag = true;
                System.out.println("result: ");
                System.out.printf("%4s | %12s | %10s | %5s", "ID", "Title", "Quantify", "Price");
                System.out.println();
                System.out.printf("%4s | %12s | %10s | %5s", currentNode.getInfo().getBcode(), currentNode.getInfo().getTitle(), currentNode.getInfo().getQuantify(), currentNode.getInfo().getPrice());
                System.out.println();
                return;
            }
            currentNode = currentNode.getNext();
        }
        if (flag == false) {
            System.out.println("-1");
        }
    }

    /**
     * Deleting first product that has the ID input from keyboard from the list.
     *
     * @param list
     */

    //chức năng 6
    public void deleteByCode(MyList<Product> list) {
        String id;
        System.out.println("Input the ID to delete: ");
        id = scanner.nextLine().toUpperCase();
        //gọi head trong list
        Node<Product> temp = list.head, prev = null;
        boolean flag = false;
        //nếu id cần tìm là head đầu tiên
        if (temp != null && temp.info.getBcode().toUpperCase().equals(id)) {
//            list.head = temp.next;
            list.deleteHead();
            System.out.println("Deleted!");
            return;
        }
//        list.deleteElement(temp.info);
        //id cần tìm nằm giữa
        int size = list.length();
        while (temp != null && !temp.info.getBcode().toUpperCase().equals(id)) {
            prev = temp;
            temp = temp.next;
            size = size - 1;
        }
        //nếu là node cuối, update node cuối node tail = null
        if (temp != null && temp.info.getBcode().toUpperCase().equals(id) && size == 1) { //khi size =1 tức là node cần tìm là node cuối
            list.deleteTail();
            System.out.println("Deleted!");
            return;
        }

        //nếu node cần tìm ko có thì in ra -1
        if (temp == null) {
            System.out.println("-1");
            return;
        }
        //liên kết lại node vừa xóa
        prev.next = temp.next;
        System.out.println("Deleted!");
    }

    /**
     * Sorting products in linked list by ID
     *
     * @param list The Linked list
     */
    //chức năng 7
    public void sortByCode(MyList<Product> list) {
        MyList<Product> listSmaller = new MyList<>();
        MyList<Product> listGreater = new MyList<>();
        Node<Product> flag, pointer;
        if (list.head == list.tail) return;
        flag = list.head;
        list.head = list.head.next;
        flag.next = null;                       // cô lập cờ flag lại
        // partition thành 2 list nhỏ hơn và lớn hơn
        while (list.head != null) {
            pointer = list.head;
            list.head = list.head.next;
            pointer.next = null;                // cô lập con trỏ
            // nhảy con trỏ tới điểm nào thì so sánh, nếu nhỏ hơn cờ thì vào list nhỏ hơn, ngược lại vào list lớn hơn
            if (pointer.getInfo().getBcode().compareTo(flag.getInfo().getBcode()) <= 0)
                listSmaller.insertToTail(pointer.info);
            else listGreater.insertToTail(pointer.info);
        }
        //Gọi đệ quy 2 list nhỏ hơn và lớn hơn
        sortByCode(listSmaller);
        sortByCode(listGreater);
        // nếu danh sách nhỏ hơn không rỗng thì danh sách của chúng ta bắt đầu bởi danh sách nhỏ
        // và nối tiếp với node cờ flag
        // còn nếu danh sách nhỏ hơn mà rỗng thì danh sách của chúng ta bắt đầu bằng cờ luôn
        if (listSmaller.head != null) {
            list.head = listSmaller.head;
            listSmaller.tail.next = flag;
        } else list.head = flag;
        // Tiếp nối sau cờ sẽ là danh sách lớn hơn
        // nếu danh sách lớn hơn không rỗng thì đuôi danh sách lớn hơn chính là đuôi của danh sách kết quả
        // còn nếu danh sách lớn hơn rỗng thì đuôi danh sách kết quả chính là cờ flag
        flag.next = listGreater.head;
        if (listGreater.head != null) list.tail = listGreater.tail;
        else list.tail = flag;
    }

    /**
     * Adding new product to head of Linked List. The info input from keyboard.
     *
     * @param list The linked list
     */

    public void addFirst(MyList<Product> list) {
        Product newPro = createProduct(); //tạo new product
        list.insertToHead(newPro); //them vào vị trí đầu tiên
    }


    /**
     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010
     *
     * @param i Input decimal number
     * @return a integer numbers
     */
    //chức năng 8
    public int convertToBinary(int i) {
        //nếu giá trị bằng 0 thì trả về số 0
        if (i == 0) {
            return 0;
        } else {
            //chạy đệ quy
            return (i % 2) + 10 * convertToBinary(i / 2);
        }
    }


    /**
     * Deleting the product at position
     *
     * @param list The Linked List
     * @param pos  The position of product to be deleted
     */

    public void deleteAtPosition(MyList<Product> list, int pos) {
    }

    public class Logger {
        public static void log(String message) {
            try {
                PrintWriter out = new PrintWriter(new FileWriter("output.txt", true), true);
                out.write(message);
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
