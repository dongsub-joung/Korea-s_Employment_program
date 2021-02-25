import java.util.Scanner;

public class java06 {
    public void ex01()
    {
        Scanner sc= new Scanner(System.in);
        int inputed_num= sc.nextInt();
        if (inputed_num%3 == 0)
            System.out.println("3의 배수.");
        else
            System.out.println("3의 배수가 아니다.");
    }

    public void ex02()
    {
        Scanner sc= new Scanner(System.in);
        int a=0, b=0;
        while(true)
        {
            System.out.println("졸업 학점을 입력하시오.");
            a= sc.nextInt();
            System.out.println("토익 점수를 입력하시오.");
            b= sc.nextInt();
            if (b <= 1000)
                break;
        }
        
        if(a>=140 && b>=700)
            System.out.println("졸업을 축하합니다.");
        else if(a>= 140 || b>=700)
            System.out.println("아쉽지만 수료하셨습니다.");
        else
            System.out.println("졸업이 불가합니다.");
    }

    public static void main (String[] args) {
        
        java06 jv= new java06();
        // jv.ex01();
        jv.ex02();
    }
}
