import java.util.Scanner;

class Exception01
{
    int n;
    public void init()
    {
        Scanner sc= new Scanner(System.in);
        loop1:while (true)
        {
            try {
                n= sc.nextInt();
                System.out.println("입력한 값은: " + n);
                break loop1;
            }
            catch (Exception e){
                System.out.println("입력한 값은 정수가 아닙니다.");
                init();
            }
        }
    }
}

class Exception02
{
    String str;
    Exception02()
    {
        Scanner sc= new Scanner(System.in);
        try {
            str= sc.next();
            if (str == null)
            {
                throw new MyException("null 인 문자열입니다.");
            }
            else if (str.length()>20)
            {
                throw new MyException("문자열 길이가 20이상입니다.");
            }
            else
            {
                checkLength(str);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void checkLength(String s)
    {
        System.out.println(s);
    }
}

public class java32_03 {
    public static void main(String[] args) {
        Exception01 e= new Exception01();
        e.init();
    }
}
