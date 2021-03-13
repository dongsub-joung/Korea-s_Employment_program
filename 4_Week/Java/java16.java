import java.util.Arrays;
import java.util.Scanner;

class Exam27 {
    private Scanner sc= new Scanner(System.in);
    final private String NUMBER;
    public Exam27()
    {
        System.out.println("Check narcissisticNumber. Enter Integer:  ");
        this.NUMBER= sc.next();
    }

    private int narcissisticNumber()
    {
        String str= NUMBER;
        char[] chrs= str.toCharArray();
        final int CAHR_LEN= chrs.length;
        int[] sums= new int[CAHR_LEN];
        for (int i=0; i<CAHR_LEN; i++)
        {
            int num= Integer.parseInt(String.valueOf(chrs[i]));
            int result= (int) Math.pow(num,CAHR_LEN);
            sums[i]= result;
        }
        return Arrays.stream(sums).sum();
    }

    public void printCompareValue()
    {
        int input_number= Integer.parseInt(NUMBER);
        int comparing_number= narcissisticNumber();
        final String NARCISSISTIC= "NARCISSISTIC NOMBER!";
        final String NOT= "NOT NARCISSISTIC NOMBER!";
        if (input_number == comparing_number) System.out.println(NARCISSISTIC);
        else System.out.println(NOT);
    }
}

class Exam025_02 {
    public void checkPrimeFactRangeInValue(int range)
    {
        int counter=0;
        int[] prime = new int[500];
        int ptr = 0;

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for(int n=5; n<=range; n+=2) {
            boolean flag = true;
            for(int i=1; prime[i]*prime[i]<=n; i++) {
                counter+=2;
                if(n%prime[i]==0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                counter++;
                prime[ptr++] = n;
                System.out.println(n);
            }
        }
        //총 연산 횟수 : 3774
        System.out.println("총 연산횟수 : " + counter);
    }
}

class Exam025 {
    private Scanner sc= new Scanner(System.in);
    public int n;
    final String INTRO= "소수 판별기, 정수를 입력하시오.";
    public Exam025()
    {
        System.out.println(INTRO);
        this.n= sc.nextInt();
    }

    private boolean checkPrimeFact()
    {
        int num= n;
        if (num%2==0) return false;
        for (int i=3; i<=num; i++)
        {
            int condition= num%i;
            if (condition == 0 && num == i) return true;
            if (condition == 0) return false;
        }
        return false;
    }

    public void print()
    {
        if (checkPrimeFact()) System.out.println("prime number");
        else System.out.println("Not prime number");
    }
}


class Exam023 {
    private Scanner sc= new Scanner(System.in);
    private int a,b;
    final String INTRO01= "정수 부분을 입력하시오.";
    final String INTRO02= "지수 부분을 입력하시오.";
    public Exam023() {
        System.out.println(INTRO01);
        this.a= sc.nextInt();
        System.out.println(INTRO02);
        this.b= sc.nextInt();
    }
    private int init()
    {
        int num= a, sm= b, result=1;
        for (int i=0; i<sm; i++) result*= num;
        return result;
    }

    public void printResult()
    {
        System.out.printf("Result: %d", init());
    }
}

class Exam022 {
    private String str= new Exam021().intToString();

    private String reverseString()
    {
        char[] c_arr= str.toCharArray();
        final int MAX_LEN= c_arr.length;
        char[] c_result= new char[MAX_LEN];
        for (int i=0, j=MAX_LEN-1; i<MAX_LEN; i++,j--)
        {
            c_result[i]= c_arr[j];
        }
        return String.valueOf(c_result);
    }
    public void printString()
    {
        System.out.println(reverseString());
    }
}

class Exam021 {
    private int n;
    final String INTRO= "Enter a Integer Number: ";
    private Scanner sc= new Scanner(System.in);
    public Exam021() {}

    public void setData()
    {
        this.n= intToString().length();
    }
    public String intToString()
    {
        System.out.printf(INTRO);
        int a= sc.nextInt();
        return String.valueOf(a);
    }
    public void printPlaceValue()
    {
        setData();
        System.out.printf("자리 수 출력: %d", n);
    }
}

public class java16 {
    private Scanner sc= new Scanner(System.in);
    final String INTRO_01= "숫자를 입력하시오:";
    final String INTRO_02= "연산자를 입력하시오:";
    public double setNumber()
    {
        System.out.printf(INTRO_01);
        return sc.nextDouble();
    }
    public char setOperator()
    {
        System.out.printf(INTRO_02);
        return sc.next().charAt(0);
    }

    public double calculator(double a, double b, char x)
    {
        switch (x)
        {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                break;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("==========================");
        java16 jv= new java16();
        double a= jv.setNumber();
        char x= jv.setOperator();
        double b= jv.setNumber();
        double result= jv.calculator(a,b,x);
        System.out.println(result);

        System.out.println("==========================");
        Exam021 e21= new Exam021();
        e21.printPlaceValue();

        System.out.println("==========================");
        Exam022 e22= new Exam022();
        e22.printString();

        System.out.println("==========================");
        Exam023 e23= new Exam023();
        e23.printResult();

        System.out.println("==========================");
        Exam025 e25= new Exam025();
        e25.print();

        System.out.println("==========================");
        System.out.println("정수 범위를 입력하시오. 0 ~ ");
        Exam025 e25_2= new Exam025();
        new Exam025_02().checkPrimeFactRangeInValue(e25_2.n);

        Exam27 e27= new Exam27();
        e27.printCompareValue();
    }
}
