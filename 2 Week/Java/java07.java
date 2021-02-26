import java.util.Arrays;
import java.util.Scanner;

public class java07 {
    public void exam003()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("두개의 실수를 입력하시오.");
        double a= sc.nextDouble();
        double b= sc.nextDouble();
        System.out.printf("두 실수의 곱은: %f", a*b);
    }

    public void exam005()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("정수를 하나 입력하시오.");
        int a= sc.nextInt();
        int div_value= 4;
        double share= a/div_value;
        double remainder= a%div_value;
        System.out.printf("%f로 나눈 몫: %f", div_value,share);
        System.out.printf("%f로 나눈 나머지: %f", div_value,remainder);
    }

    public void exam006(double a, double b)
    {
        System.out.println("---- 전 ----");
        System.out.printf("a와 b: %f %f\n", a, b);
        double temp= a;
        a= b;
        b= temp;
        System.out.println("---- 후 ----");
        System.out.printf("a와 b: %f %f\n", a, b);
    }

    public void exam008(char a)
    {
        if (a <= 90 && a>=65) a+= 32;
        else if (a>=97 && a<=122) a= a;
        else System.out.println("알파벳이 아닙니다.");

        switch(a)
        {
            case 'a': case 'e': case 'o': case 'i': case 'u':
                System.out.println("모음입니다.");
                    break;
            default:
                System.out.println("자음입니다.");
                break;
        }
    }

    public void exam009()
    {
        Scanner sc= new Scanner(System.in);
        final int RANGE= 3;
        int max= 0;
        int[] arr= new int[RANGE];

        System.out.println("정수를 입력하고 엔터를 누르세요.(3회)");
        for (int i=0; i<RANGE; i++) arr[i]= sc.nextInt();
        Arrays.sort(arr);
        max= arr[RANGE-1];
        System.out.println("가장 큰 수: " + max);
    }

    public static void main(String[] args) {
        java07 jv= new java07();
//        jv.exam003();
//        jv.exam005();
//        double a= 1.234, b= 2.341;
//        jv.exam006(a,b);
//        jv.exam008('d');
//        jv.exam009();
    }
}
