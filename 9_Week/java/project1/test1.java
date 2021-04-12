package project1;

import java.util.Scanner;

public class test1
{
    private final static char STAR= '*';
    private static int n;
    { n= 0; }

    private static void setN()
    {
        Scanner sc= new Scanner(System.in);
        try {
            n = sc.nextInt();
            if (n<5) throw new Exception("5 이하");
            else if (n>20) throw new Exception("20 이상");
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("잘못된 입력");
            setN();
        }
    }
    private static void init()
    {
        for (int i=0; i<n; i++)
        {
            for (int j= -1; j<i; j++)
            {
                System.out.printf("%c ", STAR);
            }
            System.out.println();
        }
    }

    private static void decline()
    {
        for (int i=0; i<n-1; i++)
        {
            for (int j=n-1; j>i; j--)
            {
                System.out.printf("%c ", STAR);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        setN();
        init();
        decline();
    }
}
