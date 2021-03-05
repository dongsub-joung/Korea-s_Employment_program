import javax.swing.*;
import java.util.Scanner;

public class java10 {

    static String[] str_title= {"국어", "영어", "수학", "총점", "평균"};
    final static int GRADES= 4;

    public void printGrade()
    {
        Scanner sc= new Scanner(System.in);
        final int GRAFES= 5;

        System.out.println("학생수를 입력해주세요.");
        final int STUDENT= sc.nextInt();

//        int[] i_arr= new int[MAX];
        int[] i_arrs= new int[GRAFES];
        char[] c_arr= {'A', 'B', 'C', 'D'};
        char[] c_title= {'국', '영', '수', '사', '과'};
        char[][] c_grade= new char[STUDENT][GRAFES];

        for (int j=0; j<STUDENT; j++)
        {
            System.out.printf("-- %d번째 학생의 성적을 입력해주세요. -- \n", j+1);
            for (int i=0; i<GRAFES; i++)
            {
                System.out.printf("%c  ", c_title[i]);
                int inputed_grade= i_arrs[i]= sc.nextInt();
                if (inputed_grade >= 90 && inputed_grade <= 100) c_grade[j][i]= c_arr[0];
                else if (inputed_grade>= 80) c_grade[j][i]= c_arr[1];
                else if (inputed_grade >= 70) c_grade[j][i]= c_arr[2];
                else c_grade[j][i]= c_arr[3];
            }
        }

//        출력
        int j= 1;
        for (char[] value : c_grade)
        {
            int i= 0;
            System.out.printf("%d 번째 학생 성적은..\n", j);
            for (char element : value)
            {
                System.out.printf("%c: %c  \n", c_title[i], element);
                i++;
            }
            j++;
        }
    }

    public void printScore(int[][] i_arrs)
    {
        System.out.printf("번호\t\t");
        for(String value : str_title) System.out.printf("%s\t", value);
        System.out.println();
        System.out.println("=========================");
        int i= 1;
        int sum= 0;
        for (int[] i_arr : i_arrs)
        {
            System.out.printf("%d \t\t", i);
            int j= 0;
            for (var value : i_arr)
            {
                System.out.printf("%d\t", value);
                if (j == 3) sum= value;
                j++;
            }
            i++;
            double avg= sum/(GRADES-1);
            System.out.printf("%f\n", avg);
        }
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        java10 jv= new java10();
//        jv.printGrade();

        Scanner sc= new Scanner(System.in);
        System.out.println("학생 수를 입력해주세요.");
        final int STUDENT= sc.nextInt();
        int[][] i_arrs= new int[STUDENT][GRADES];

        int sum= 0;
        for (int i=0; i<STUDENT; i++)
        {
            System.out.println(i+1+"번째 학생의 성적을 입력해주세요.");
            for (int j=0; j<GRADES-1; j++)
            {
                while (true)
                {
                    System.out.printf("%s \t" , str_title[j]);
                    int inputed_num= sc.nextInt();
                    if (inputed_num <= 100 && inputed_num >= 0)
                    {
                        i_arrs[i][j]= inputed_num;
                        i_arrs[i][3]+= inputed_num;
                        break;
                    }
                    else continue;
                }
            }
        }

        jv.printScore(i_arrs);
    }
}