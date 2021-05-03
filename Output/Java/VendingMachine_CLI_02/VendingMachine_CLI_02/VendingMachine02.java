package VendingMachine_CLI_02;

import java.util.Scanner;

public class VendingMachine02
{
    private static int coin= -1;
    private static int produce_number;
    private static int price;
    private static boolean end= false;

    static Scanner sc= new Scanner(System.in);
    public static STRING.MENU strs_menu= STRING.MENU.getInstance();
    public static STRING.OUTPUT strs_output= STRING.OUTPUT.getInstance();


    public static boolean isEnd(boolean condition) { return end; }

    static void setCoin()
    {
        System.out.println(STRING.ENTER_COIN);
        if (coin == -1) { coin= sc.nextInt(); }
        else { coin+= sc.nextInt();}
    }

    static void printMenu()
    {
//        Print Strings saved a "STRING.MENU class"
//        If you want to add menu, add it in STRING.MENU class.
        for (String str:strs_menu.ONLY_MENU) { System.out.println(str); }
    }
    static void printSelectedMenu()
    {
        switch (produce_number)
        {
            case 1:
                System.out.println(strs_output.AMERICANO);
                break;
            case 2:
                System.out.println(strs_output.RATE);
                break;
            case 3:
                System.out.println(strs_output.CARAMEL);
                break;
            case 4:
                System.out.println(strs_output.TODAY);
                break;
            default:
                break;
        }
    }

    static void printCoin()
    {
        System.out.println(STRING.LINE);
        System.out.printf(STRING.PRESENT_COIN, coin);
    }

    static void selectMenu()
    {
        System.out.printf(STRING.SELECTED);
        produce_number= sc.nextInt();
    }

    static void calculate()
    {
        final int AMERICANO=1;  final int CARAMEL=3;
        final int RATE=2;       final int TODAY=4;

        switch (produce_number)
        {
            case AMERICANO:
                price= 2000; break;
            case RATE:
                price= 3000;  break;
            case CARAMEL:
                price= 5000; break;
            case TODAY:
                price= 4000; break;
        }

        if (price<coin)
        {
            int remain= coin-price;
            System.out.printf(STRING.RECHARGE, remain);
            coin-= price;
            printSelectedMenu();
        }
        else if (price>coin)
        {
            System.out.println(STRING.LEAK);
            System.out.printf(STRING.MORE, price-coin);
            init();
        }
        else
        {
            coin-= price;
            printSelectedMenu();
        }
        coin= 0;
    }


    public static void main(String[] args)
    {
        STRING.MAIN STR= new STRING.MAIN();
        while (end != true)
        {
            final int YES = 1;  final int NO = 2;

            System.out.println(STR.WAKE_UP + STR.LOGIC);
            int number = sc.nextInt();
            if (number == YES)
            {
                System.out.println(STR.WAKE_UP);
                init();
                break;
            }
            else if (number == NO)
            {
                System.out.println(STR.EXIT);
                break;
            }
            else { System.out.println(STRING.E_OUT_RANCE); }
        }
        if (end) System.out.println(STR.SHUT_DOWN);
    }

    static void init()
    {
        loop2: while (true)
        {
            final boolean EXIT_SWITCH_ON= true;
            for (String init_strs:STRING.INIT.INIT) System.out.println(init_strs);
            switch (sc.nextInt())
            {
                case 1:
                    setCoin();
                    init();
                case 2:
                    if (coin == -1)
                    {
                        for (String value:STRING.MENU.ONLY_MENU) System.out.println(value);
                        init();
                    }
                    else
                    {
                        printMenu();
                        init();
                    }
                case 3:
                    if (coin == -1)
                    {
                        System.out.println("0");
                        init();
                    }
                    else
                    {
                        printCoin();
                        init();
                    }

                case 4:
//                Setter (produce_number)
                    final int FIRST= 1; final int LAST=4;
                    if (coin == -1) { init(); }

                    selectMenu();
                    if (produce_number>FIRST || (produce_number<LAST && produce_number>0))
                    {
//                    Setter price
                        calculate();
                    }
                    else if (produce_number == 0) { System.out.println(STRING.MENU.ZERO); break; }
                    else { System.out.println(STRING.E_OUT_OF_PRODUCT); init(); }
                    init();
                case 5:
                    isEnd(EXIT_SWITCH_ON);
                    break loop2;
                default:
                    System.out.println(STRING.E_OUT_RANCE);
                    System.out.println();
            }
        }
    }
}


