import java.util.Scanner;

public class java04_practice {
    public static void main(String[] args) {

//        Sheet j= new Sheet();

    }

    // 삼항식
    public int isPositive()
    {   // 양수면 1, 음수면 -1, 제로면 0
        Scanner sc= new Scanner(System.in);
        int num= sc.nextInt();
        return  (num>0) ? 1 : ((num<0) ? -1 :  0 );
    }

    // 연산자
    public double PoundToKg()
    {
        Scanner sc= new Scanner(System.in);
        double pound= sc.nextInt();
        double perKg= 0.45359237;
        return pound * perKg;
    }

    public void ex_01()
    {
        int a= 123/10;
        if (123 % 10 != 0) a++;
        System.out.println(a);
    }
}
