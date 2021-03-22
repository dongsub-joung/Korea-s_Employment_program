class Dices {
    private static int width= 3;
    private int face_value1;
    private int face_value2;

    //    Setter
    public void roll()
    {
        face_value1 = (int)(Math.random()*6)+1;;
        face_value2 = (int)(Math.random()*6)+1;;
    }

    //    Getter
    public int getDice1() { return face_value1; }
    public int getDice2() { return face_value2; }
}

class Dice {
    private int value;
    private static int width= 3;

    public void roll() { value = (int)(Math.random()*6)+1; }
    public int getValue() { return value; }
}

public class java22 {
    public static void main(String[] args) {
        Dices d= new Dices();
        d.roll();
        System.out.println("===========================");
        System.out.printf("Dice1: %d\n", d.getDice1());
        System.out.printf("Dice2: %d\n", d.getDice2());
        System.out.printf("Sum: %d\n", d.getDice1()+ d.getDice2());

        System.out.println("===========================");
        Dice d1= new Dice();
        Dice d2= new Dice();
        d1.roll(); d2.roll();
        System.out.printf("d1 value: %d\n", d1.getValue());
        System.out.printf("d2 value: %d\n", d2.getValue());
        System.out.printf("Sum: %d", d1.getValue()+ d2.getValue());
    }
}