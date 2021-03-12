class Example01
{
    Example01(){}
    public void printDownToUp() {
        for (int r=0; r<5; r++)
        {
            for (int c=0; c<r+1; c++)  System.out.printf("*");
            System.out.println();
        }
    }
    public void printUptoDown()
    {
        for (int r=0; r<5; r++)
        {
            for (int c=4; c>=r; c--) System.out.printf("*");
            System.out.println();
        }
    }
}

class Book
{
    String name, Author;
    int price;
    public Book(String name, String author, int price)
    {
        this.name= name;
        this.Author= author;
        this.price= price;
    }
}

public class java15 {
    public static void main(String[] args) {
        System.out.println("============================");
        Example01 ex01= new Example01();
        ex01.printDownToUp();
        ex01.printUptoDown();
    }
}
