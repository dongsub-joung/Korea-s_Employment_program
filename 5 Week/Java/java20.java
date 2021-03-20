import java.util.Scanner;

class STRINGS {
    static class MACHINE {
        final static String INTRO= "아이스크림 자판기: 시작(1: Yes, 2: No)";
        final static String START= "프로그램 기동";
        final static String END= "프로그램 종료";
        final static String OUTOFRANGE= "범위에 벗어납니다.";
    }
    static class MAIN_STRING {
        final static String INIT= "아이스크림 자판기 기동";
        final static String ENTER_COIN= "자판기에 넣을 금액을 입력하세요: ";
        final static String MENU= "1: 딸기(3000), 2:바닐라(3500), 3:초코(4000), 4:블루베리(5000), 5:없음";
    }
    static class PRODUCT_STRING {
        final static String NUM01= "딸기 아이스크림!";
        final static String NUM02= "바닐라 아이스크림!";
        final static String NUM03= "초코릿 아이스크림!";
        final static String NUM04= "블루베리 아이스크림!";
        final static String NUM05= "종료!!";
    }
    static class COIN_STRING{
        final static String LEAK= "금액이 부족합니다. 돈을 더 넣어주세요!";
        final static String FIT= "Fit!!";
        final static String REMAIN= "남은 금액: %d \n";
        final static String PRESENT= "현재 투입한 금액: %d \n";
        final static String RESET= "투입 금액을 반환합니다. 처음부터 다시 해주세요.";
        final static String RECHARGE= "거스름돈: %d \n";
        final static String MORE= "구입을 원하시면 %d만큼 돈을 넣어주세요.\n ";
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

public class java20 {
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

