import java.util.HashMap;
import java.util.Scanner;

class Book {
    final String isbn;
    String title;
    int price;
    Scanner sc= new Scanner(System.in);

    Book() {
        System.out.println("Enter isbn");
        this.isbn = sc.nextLine();
        System.out.println("Enter title");
        this.title = sc.nextLine();
        System.out.println("Enter price");
        this.price = sc.nextInt();
    }

    private String ISBN() {
        return isbn;
    }

    @Override
    public String toString() {
        return String.format("ISBN:%s Title:%s Price:%d", isbn, title, price);
    }
}

class BookManager{
    Scanner scan = new Scanner(System.in);
    HashMap<Integer, Book> book_dic = new HashMap<>();
    int count= book_dic.size();

    public void Run() {
        boolean condition= false;
        int key = 0;

        while (condition) {
            condition= (key = selectMenu()) != 0;

            switch (key) {
                case 1:
                    addBook();
                    break;
                case 2:
                    listBook();
                    break;
                default:
                    System.out.println("Out of Range.");
                    break;
            }
        }
        System.out.println("EXITING...");
    }

    int selectMenu() {
        System.out.println("1:ADD 2:LIST 3:SEARCHING 0:EXIT");
        int key = scan.nextInt();
        scan.nextLine();
        return key;
    }

    void addBook() {
        book_dic.put(count, new Book());
    }

    void listBook() {
        System.out.println("List Index");
        for (int i = 0; i < count; i++) {
            System.out.printf("%d ", i);
        }
        int index= scan.nextInt();
        book_dic.get(index).toString();
    }
}

public class Exam3 {
    public static void main(String[] args) {
        BookManager bm = new BookManager();
        bm.Run();
    }
}