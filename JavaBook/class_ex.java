import java.util.Scanner;

class print {
    Scanner sc = new Scanner(System.in);
    String str;

    public print() {
        this.str = getValue();
    }

    private String getValue() {
        return sc.nextLine();
    }
}

class ex {
    final String VALUE = new print().str;

    public void printLen() {
        String str = VALUE;
        System.out.println(str.length());
    }
}

public class class_ex {
    public static void main(String[] args) {
//        new ex().printLen();
        System.err.println("Asdf");
    }
}
