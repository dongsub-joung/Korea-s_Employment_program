import java.util.Scanner;

public class java11 {

    public void exam_012()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("double 입력");
        double num= sc.nextDouble();
        if (num >= 0) System.out.println("양수");
        else System.out.println("음수");
    }

    public boolean condition(byte c) {
        if (c>=97 && c<=122) return true;
        else return false;
    }
    public boolean condition_two(byte c){
        if (c>=65 && c<=90) return true;
        else return false ;
    }
    public void exam_013()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("문자를 입력하세요.");
        char c_chr= sc.next().charAt(0);
        byte chr= (byte) c_chr;
        if (condition(chr) || condition_two(chr))
            System.out.println("알파벳");
        else
            System.out.println("알파벳이 아님");
    }

    public int facto(int n){
        if (n<1) return n;
        else return (n-1)*n;
    }
    public void exam_015()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("팩토리얼 구하기! 정수 입력!");
        final int N= sc.nextInt();
        int result= facto(N);
        System.out.printf("!%d: %d", N,result);
    }

    public int pibonachi(int n) {
        if (n<=1) return n;
        else return pibonachi(n-2) + pibonachi(n-1);
    }
    public void exam_017()
    {
        final int MAX_RANGE= 10;
        System.out.printf("Range가 %d인 피보나치 배열 출력\n", MAX_RANGE);
        System.out.println("==============================");
        for (int i=0; i<MAX_RANGE; i++) System.out.printf("%d\t", pibonachi(i));
    }

    public void exam_020()
    {
        final int A= 97;
        final int Z= 122;
        for (int i= A; i<Z+1; i++)
        {
            char output= (char) i;
            System.out.printf("%c ", output);
        }
    }
    public static void main(String[] args) {
        java11 jv= new java11();
//        jv.exam_012();
//        jv.exam_013();
//        jv.exam_015();
//        jv.exam_017();
//        jv.exam_020();
    }
}
