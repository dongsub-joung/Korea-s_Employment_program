import java.util.*;

public class java05 {
    public static void main(String[] args) {

        Ex ex= new Ex();
        
        // 사칙 연산
        // double result= ex.calculator();
        // System.out.println("Calculator result:" + result);
    
        // 계절 구하기
        // ex.sayWeather();
        
        // 가위바위보
        // ex.doRSP();
    }
}

class Ex {
    public double calculator()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("첫번째 정수를 입력하시오: ");
        int a= sc.nextInt();
        System.out.println("두번째 정수를 입력하시오:");
        int b= sc.nextInt();
        double result= 0;

        System.out.println("연산자를 입력하시오.");
        char c= sc.next().charAt(0);
        switch (c)
        {
            case '+':
                return a + b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return (double) (a / b);
        }
        return 0;
    }

    public void sayWeather()
    {        
        Scanner sc= new Scanner(System.in);
        System.out.println("현재 월을 입력하시오.");
        int month= sc.nextInt();
        
        switch(month)
        {
            case 3: case 4: case 5:
                System.out.println("봄 입니다.");
                break;
            case 6: case 7: case 8:
                System.out.println("여름 입니다.");
                break;
            case 9: case 10: case 11:
                System.out.println("가을 입니다.");
                break;
            default:
                // case 12: case 1: case 2:
                System.out.println("겨울 입니다.");
        }
    }

    public void doRSP()
    {
        Scanner sc= new Scanner(System.in);

        System.out.println("가위(1), 바위(2), 보(3) 중 하나를 입력하세요.");
        int user_num= sc.nextInt();
        // 0.0 ~ 1.0 사이의 double값을 반환 -> 정수로 만들기 위한 아래와 같은 작업이 필요
        final int RANDOM_RANGE= 3;
        final int INTEGER_PLUSE= 1;
        int com_num= (int) (Math.random() * RANDOM_RANGE) + INTEGER_PLUSE;

        switch(user_num-com_num)
        {
            case 2: case -1:
                System.out.println("You are LOSE");
                break;
            case 1: case -2:
                System.out.println("You are WIN");
                break;
            case 0:
                System.out.println("Drow");
        }
    }
}


