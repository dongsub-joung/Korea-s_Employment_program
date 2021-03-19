import java.util.Scanner;

public class Machine1 {
    static Scanner sc= new Scanner(System.in);
    static int coin;
    static int produce_number;
    static int price;
    static boolean end= false;

    static void setCoin() { System.out.println("넣을 금액을 입력하세요."); coin= sc.nextInt(); }
    static void printMenu()
    {
        System.out.println("==================");
        System.out.println("0. 메뉴로 돌아갑니다.");
        System.out.println("1. 아메리카노 (2000원) ");
        System.out.println("2. 카페라떼 (3000원) ");
        System.out.println("3. 카라멜 마끼아또 (5000원) ");
        System.out.println("4. 오늘의 커피 (4000원) ");
    }
    static void printSelectedMenu()
    {
        coin-= price;
        switch (produce_number)
        {
            case 1:
                System.out.println("  1. 아메리카노 (2000원) 나왔습니다.");
                break;
            case 2:
                System.out.println("  2. 카페라떼 (3000원) 나왔습니다.");
                break;
            case 3:
                System.out.println("  3. 카라멜 마끼아또 (5000원) 나왔습니다.");
                break;
            case 4:
                System.out.println("  4. 오늘의 커피 (4000원) 나왔습니다.");
                break;
            default:
                break;
        }
    }

    static void printCoin() {
        System.out.println("==================");
        System.out.printf("현재넣은 금액: %d\n", coin);
    }

    static void selectMenu()
    {
        System.out.println("고르신 음료의 번호를 누르세요.");
        produce_number= sc.nextInt();
    }
    static void calculate()
    {
        switch (produce_number)
        {
            case 1:
                price= 2000; break;
            case 2:
                price= 3000;  break;
            case 3:
                price= 5000; break;
            case 4:
                price= 4000; break;
        }
        account();
    }
    static void account()
    {
        if (price>coin)  System.out.println("돈을 더 넣어주세요.");
        else if (price<coin)
        {
            System.out.printf("거스름돈은 %d 입니다.", coin-price);
            printSelectedMenu();
        }
        else { printSelectedMenu(); }

    }
    static void init()
    {
        System.out.println("====== 상단 메뉴 ======");
        System.out.println("1. 금액 투입");
        System.out.println("2. 메뉴 출력");
        System.out.println("3. 투입 금액 표시");
        System.out.println("4. 메뉴 선택");
        System.out.println("5. 종료");
        System.out.println("====== 숫자 입력 ======");
        int selected_num= sc.nextInt();

        switch (selected_num)
        {
            case 1:
                setCoin();
            case 2:
                printMenu();
            case 3:
                printCoin();
            case 4:
                selectMenu();
                if (produce_number == 0) { System.out.println("메뉴로 돌아갑니다."); break; }
                if (produce_number>=5) { System.out.println("존재하지 않는 상품입니다."); }
                else calculate();
            case 5:
                end= true;
        }
    }

    public static void main(String[] args) {

        while (true)
        {
            System.out.println("저판기 기동");
            System.out.println("계속: 1, 종료: 2");
            int inputed =sc.nextInt();
            if (inputed == 2) { System.out.println("종료!"); break; }
            else if (inputed == 1)
            {
                System.out.println("기동!");
                while(end==false)
                {
                    init();
                    coin= 0;
                }
            }
            if (end == true) System.out.println("5. 종료키를 눌렀습니다. err: 부팅 불가능");
        }
    }
}
