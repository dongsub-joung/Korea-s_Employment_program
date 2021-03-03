import javax.swing.*;
import java.util.Scanner;

public class java09 {
  public void ex01()
  {
    int sum= 0;
    int sum_not= 0;
    for (int n= 1; n<=100; n++)
    {
        if(n%3==0) sum+=n;
        else sum_not+= n;
    }
    System.out.println("1~100 사이의 자연수중 ");
    System.out.println("3의 배수의 총합은 " + sum);
    System.out.println("3의 배수가 아닌 수의 총합은 " + sum_not);
  }

  public void ex02() 
  {
    // 단순하게 최솟값 구하기 (배열 x)
    Scanner sc= new Scanner(System.in);
    int min= 0;

    for (int i=0; i<5; i++)
    {
      System.out.println("숫자를 입력하시오: ");
      int input= sc.nextInt();
      if (i==1) min= input;
      else
        {
          if (input<min) min= input;
        }
    }

    System.out.println("최소 값은 "+ min);
  }

  public void ex03() 
  {
    // 입력한 행과 열만큼 별을 채운다.
    String strR= JOptionPane.showInputDialog("행(3-10)");
    String strC= JOptionPane.showInputDialog("열(3-10");
    final int R= Integer.valueOf(strR);
    final int C= Integer.valueOf(strC);

    for (int iR=1; iR<R; iR++)
    {
      for (int iC=1; iC<=C; iC++)
        {
          System.out.print("*");
        }
        System.out.println();
    }
  }

  public void ex04()
  {
    String str= JOptionPane.showInputDialog("정수 입력: ");
    final int N= Integer.valueOf(str);
    final int MAX_RANGE= N*N;
    for (int i=1; i<=MAX_RANGE; i++)
    {
      System.out.printf("%d ", i);
      if (i%5 == 0) System.out.printf("\n");
    }
  }

  public static void main (String[] args) 
  {
    java09 jc= new java09();
    // jc.ex01();
    // jc.ex02();
    // jc.ex03();
    jc.ex04();
  }
}
