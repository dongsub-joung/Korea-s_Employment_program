import java.util.Scanner;

class STRINGS {
    static class MACHINE {
        final static String INTRO= "A ice cream Vending machine - START(1: Yes, 2: No)";
        final static String START= "START!";
        final static String END= "SHUT DOWN!";
        final static String OUTOFRANGE= "Out Of Range!";
    }
    static class MAIN_STRING {
        final static String INIT= "Wellcome! A ice cream Vending machine!";
        final static String ENTER_COIN= "Enter the coin in machine!";
        final static String MENU= "1. Strawberry(3000), 2. Vanilla(3500), 3. Choco(4000), 4. Blueberry(5000), 5. EXIT";
    }
    static class PRODUCT_STRING {
        final static String NUM01= "A strawberry ice cream!";
        final static String NUM02= "A Vanilla ice cream!";
        final static String NUM03= "A choce ice cream!";
        final static String NUM04= "A blueberry ice cream!";
        final static String NUM05= "== EIXT!! ==";
    }
    static class COIN_STRING{
        final static String LEAK= "Scant of money. Enter more money!";
        final static String FIT= "FIT!!";
        final static String REMAIN= "Warnning: A remaining money: %d \n";
        final static String PRESENT= "Warnning: A present entered money: %d \n";
        final static String RESET= "Warnning:: Pay back a entered money. Restart a first step.";
        final static String RECHARGE= "Change: %d \n";
        final static String MORE= "If you purchase a chose ice cream, enter more money! (Shortage: %d)  \n ";
    }
}

class Product{
    private final int strob= 3000;
    private final int vanilla= 3500;
    private final int choco= 4000;
    private final int blueb= 4500;

    public int getStrob()   { return strob; }
    public int getVanilla() { return vanilla; }
    public int getChoco()   { return choco; }
    public int getBlueb()   { return blueb; }
}

class VendingMachine {
    STRINGS.COIN_STRING C_S;
    private int g_coin= 0;

//    Constructor
    public VendingMachine(){}
//    Setter
    public void setCoin(int coin) { this.g_coin = coin; }
//    Getter
    public int printRemainMoney() { return g_coin; }

    public void addCoin(int calculated)
    {
        Scanner s= new Scanner(System.in);
        int add= s.nextInt();
        g_coin+= add;
        if (add == calculated) System.out.println(C_S.FIT);
        else if (add < calculated) System.out.println(C_S.RESET);
        else System.out.printf(C_S.RECHARGE, add-calculated);
    }

    public void buy(int g_price)
    {
        int coin= g_coin;
        int price= g_price;
        int cal= coin-price;
        if (cal>=0) { g_coin= cal; System.out.printf(C_S.REMAIN, cal); }
        else if (cal == 0) { g_coin= cal; System.out.println(C_S.FIT); }
        else {
            cal*= -1;
            System.out.println(C_S.LEAK);
            System.out.printf(C_S.MORE, cal);
            addCoin(cal);
        }
    }
}

public class VendingMachineMain {
    private static Scanner sc= new Scanner(System.in);
    private static Product pd= new Product();
    private static VendingMachine VM= new VendingMachine();

    private static int g_selected_menu= 0;
    private static int g_selected_price= 0;
    private static boolean g_introBTN= false;
    private static boolean g_break_menu= false;

    private static STRINGS.MACHINE        MC_S;
    private static STRINGS.MAIN_STRING    MAIN_S;
    private static STRINGS.PRODUCT_STRING PRO_S;
    private static STRINGS.COIN_STRING    COIN_S;

    static public void selectProduct(int menu)
    {
        switch (menu)
        {
            case 1:
                System.out.println(PRO_S.NUM01);
                setG_selected_price(pd.getStrob());
                break;
            case 2:
                System.out.println(PRO_S.NUM02);
                setG_selected_price(pd.getVanilla());
                break;
            case 3:
                System.out.println(PRO_S.NUM03);
                setG_selected_price(pd.getChoco());
                break;
            case 4:
                System.out.println(PRO_S.NUM04);
                setG_selected_price(pd.getBlueb());
                break;
            default:
                break;
        }
    }

    private static int startIntroQuestion()
    {
        System.out.println("==================");
        System.out.println(MC_S.INTRO);
        return sc.nextInt();
    }

    private static void setG_selected_price(int price)
    { g_selected_price = price; }

    private static void setSelectedMenu(int number)
    { g_selected_menu= number; }

    public static void setG_coin(int coin)
    { VM.setCoin(coin); }

    private static void printPresentCoin()
    {
        int coin= VM.printRemainMoney();
        System.out.printf(COIN_S.PRESENT, coin);
    }


    public static void main(String[] args) {
        while (g_introBTN == false && g_break_menu == false)
        {
            /* kind: 1 => startVending();
             *       2 => break;
             *    else => out of range;
             */
            int kind= startIntroQuestion();
            responseQuestion(kind);
        }
    }

//     progress control method
    private static void responseQuestion(int kind)
    {
        if (kind == 1)      { System.out.println(MC_S.START); startVending();  }
        else if (kind == 2) { System.out.println(MC_S.END);   g_introBTN=true; }
        else System.out.println(MC_S.OUTOFRANGE);
    }
    private static void startVending()
    {
        selectMenu();
        if (g_break_menu==false)
        {
            paidPrice();
            accounting();
        } else {
            System.out.println(PRO_S.NUM05);
        }
    }
    private static void selectMenu()
    {
        System.out.println(MAIN_S.INIT);
        System.out.println(MAIN_S.MENU);
        int user_number= sc.nextInt();
        setSelectedMenu(user_number);
        if (g_selected_menu == 5) g_break_menu= true;
        else selectProduct(g_selected_menu);
    }
    private static void paidPrice()
    {
        System.out.println(MAIN_S.ENTER_COIN);
        setG_coin(sc.nextInt());
    }
    private static void accounting()
    {
        System.out.println("======= 계산 중 =======");
        VM.buy(g_selected_price);
        System.out.println("======= 계산 끝 =======");
    }
}

