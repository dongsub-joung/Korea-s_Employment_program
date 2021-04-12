package project1;

import com.sun.source.tree.BinaryTree;

import java.util.Calendar;
import java.util.Scanner;

class MyExceptions extends Exception {
    //    Default= 100;
    public final int ERR_CODE;

    public MyExceptions(String message, int ERR_CODE) {
        super(message);
        this.ERR_CODE = ERR_CODE;
    }
    public MyExceptions(String msg) {  this(msg, 100); }

    public int getERR_CODE() { return ERR_CODE; }

    public static void main(String[] args) {

    }
}

public class test2
{

    private static int user_number;
    private static String str_random_number;
    private static int int_randoom_number;
    private static int count;
    static { user_number=0; str_random_number= ""; count= 1;}

    private static final int MIN= 123;
    private static final int MAX= 987;
    private static Scanner sc= new Scanner(System.in);

    private static void setRandomNumbers()
    {
        int n; int nn; int nnn;
        loop1: while (true)
        {
            n= (int) Math.floor(Math.random()*9)+1;
            nn= (int) Math.floor(Math.random()*9)+1;
            nnn= (int) Math.floor(Math.random()*9)+1;
            if ((n == nn) && (nn == nnn) && (n == nnn)) continue;
            else break loop1;
        }
        String a= n+""; String b= nn + ""; String c= nnn + "";
        int_randoom_number= nnn*100 + nn*10 + n;
        if (int_randoom_number<MIN || int_randoom_number>MAX) setRandomNumbers();
        str_random_number= c+b+a;
    }



    private static void setUserNumber()
    {
        try{
            System.out.printf("%d ~ %d 사이의 숫자를 입력하세요 :", MIN, MAX);
            user_number= sc.nextInt();
            if (user_number>MAX || user_number<MIN) { throw new MyExceptions("범위 초과"); }
            if (checkInte(user_number)==false) { throw new MyExceptions("중복 숫자"); }
        }
        catch (Exception e) {
            System.out.println(e);
            setUserNumber();
        }
    }
    private static boolean checkInte(int num)
    {
        String str= num + "";
        char[] cs= str.toCharArray();
        if ((cs[0] == cs[1]) && (cs[0] == cs[2]) && (cs[1] == cs[2])) return false;
        else return true;
    }

    private static void compare()
    {
        if (int_randoom_number > user_number) System.out.println("Up");
        else if (int_randoom_number < user_number) System.out.println("Down");
    }

    private static boolean pipopn()
    {
        if (int_randoom_number == user_number) return true;
        else return false;
    }
    public static void main(String[] args)
    {
        setRandomNumbers();
        System.out.println("랜덤 넘버 생성 완료");

        loop1: while (true)
        {
            setUserNumber();
            System.out.println(int_randoom_number);
            compare();

            if (pipopn())
            {
                System.out.println(count+ "번 만에 정답을 맞추셨습니다");
                break loop1;
            }
            count++;
        }
    }
}