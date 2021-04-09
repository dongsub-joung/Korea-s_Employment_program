import java.util.*;

// 입력 받은 n의 약수 구하기
class Exam031
{
    int n= 0;
    Vector<Integer> numbers= new Vector<>();

    {
        Scanner sc= new Scanner(System.in);
        numbers.add(1);
        n= sc.nextInt();
        if (n<3) { numbers.add(1); numbers.add(2); }
        if (n%2 == 0) numbers.add(2);
        else if (n%2 == 1) numbers.add(n);
    }

    public void init()
    {
        for (int i=3; i<=n; i++)
        {
            if (n%i == 0) numbers.add(i);
        }
        System.out.println(numbers.toString());
    }
}


//재귀함수 사용 팩토리얼 계산하는 클래스
class Exam035
{
    int n= 0;
    {
        Scanner sc= new Scanner(System.in);
        n= sc.nextInt();
    }
    private int factorial(int number)
    {
        if (number<1) return number;
        else return number*(number-1);
    }
    public void init()
    {
        System.out.println(factorial(n));
    }
}

// 랜덤한 알파벳 4개를 추출하는 클래스
class Exam038
{
    final char A= 65;
    public void init()
    {
        Set<Integer> list= new HashSet<>();
        for ( ;list.stream().count()<4; ) list.add((int) Math.floor(Math.random()*25));
        for (Integer val: list) System.out.printf("%c", val+A);
    }
}

// 숫자 피라미드
class Exam039
{
    int n;
    {
        Scanner sc= new Scanner(System.in);
        n= sc.nextInt();
    }
    public void init()
    {
        for (int i=1; i<=n; i++)
        {
            for (int j= 1; j<=i; j++)
            {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}

// 문장 역 출력
class Exam040
{
    String str;
    {
        Scanner sc= new Scanner(System.in);
        str= sc.next();
    }

    public void init()
    {
        final int LEN= str.length();
        int index= LEN-1;

        while (true)
        {
            System.out.printf("%c", str.charAt(index));
            index--;
            if (index<0) break;
        }
    }
}

public class java32_02 {
    public static void main(String[] args) {
        Exam040 e= new Exam040();
        e.init();
    }
}
