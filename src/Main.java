import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    static OperationToProduct op = new OperationToProduct();
    static MyList<Product> list = new MyList<>();
    static MyStack<Product> listStack = new MyStack<>();
    static MyQueue<Product> listQueue = new MyQueue<>();

    public static int showMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one of this options:");

        System.out.println("Product list:");

        System.out.println("1. Load data from file and display");

        System.out.println("2. Input & add to the end.");

        System.out.println("3. Display data");

        System.out.println("4. Save product list to file.");

        System.out.println("5. Search by ID");

        System.out.println("6. Delete by ID");

        System.out.println("7. Sort by ID.");

        System.out.println("8. Convert to Binary");

        System.out.println("9. Load to stack and display");

        System.out.println("10. Load to queue and display.");

//        System.out.println("11. Save console screen to file output.txt.");

        System.out.println("0. Exit");

        System.out.println("Input your choice: ");
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
//                scanner.next();
                if (choice >= 0 && choice <= 10) {
                    break;
                } else {
                    System.err.println("Please input your choice:");
                }
            } catch (Exception e) {
                System.err.println("Please input your choice:");

            }
        }
        return choice;
    }

    //chức năng 1: load đata
    public static void LoadData() {
        System.out.println("Choice: 1");
        System.out.println("Data: ");
        op.getAllItemsFromFile("src/data.txt", list);
        list.display();
        System.out.println("Load data is successfully!");
        System.out.println();
    }

    //chức năng 2: input
    public static void Input() {
        System.out.println("Choice: 2");
        op.addLast(list);
        System.out.println();
    }

    //chức năng 3: display all
    public static void DisplayData() {
        System.out.println("Choice: 3");
        list.display();
        System.out.println();

    }

    //chức năng 4: saveFile
    public static void saveFile() {
        System.out.println("Choice: 4");
        op.writeAllItemsToFile("src/data.txt", list);
        System.out.println("Save data to file is successfully!");
        System.out.println();

    }

    //chức năng 5: SearchById
    public static void SearchById() {
        System.out.println("Choice: 5");
        op.searchByCode(list);
        System.out.println();

    }

    //chức năng 6: delete ID
    public static void DeleteById() {
        System.out.println("Choice: 6");
        op.deleteByCode(list);
        System.out.println();

    }

    //chức năng 7: sort
    public static void SortById() {
        System.out.println("Choice: 7");
        op.sortByCode(list);
        System.out.println("Successfully!");
        System.out.println();
    }

    //chức năng 8: convert To binary
    public static void ConvertToBinary() {
        int i = list.getHead().getInfo().getQuantify();

        System.out.println("Quantify = " + i);
        int x = op.convertToBinary(i);
        System.out.println("=> binary: " + x);
        System.out.println();
    }

    //chức năng 9: Load to stack
    public static void LoadToStack() {
        System.out.println("Choice: 9");
        System.out.println("Stack display: ");
        op.getAllItemsFromFile("src/data.txt", listStack);
        listStack.display();
        System.out.println("Load data is successfully!");
        System.out.println();
    }

    //chức năng 10: Load to queue
    public static void LoadToQueue() {
        System.out.println("Choice: 10");
        System.out.println("Queue display: ");
        op.getAllItemsFromFile("src/data.txt", listQueue);
        listQueue.display();
        System.out.println("Load data is successfully!");
        System.out.println();
    }

    public static void main(String[] args) {
// hiển thị giao diện
        boolean flag = true;
        while (flag) {
            int chucnang = showMenu();
            switch (chucnang) {
                case 1:
                    LoadData();
                    break;
                case 2:
                    Input();
                    break;
                case 3:
                    DisplayData();
                    break;
                case 4:
                    saveFile();
                    break;
                case 5:
                    SearchById();
                    break;
                case 6:
                    DeleteById();
                    break;
                case 7:
                    SortById();
                    break;
                case 8:
                    ConvertToBinary();
                    break;
                case 9:
                    LoadToStack();
                    break;
                case 10:
                    LoadToQueue();
                    break;
//                case 11:
//                    SaveConsoleScreenToFile();
//                    break;
                case 0:
                    System.out.println("Kết thúc! Thanks!!!");
                    flag = false;
                    break;
                default:
                    System.out.println("Chọn chức năng để sử dụng: ");
            }

        }
    }
}