import java.util.Scanner;

class Example01
{
    final String IN_1= "임의의 두자리 숫자를 발생했습니다.";
    final String IN_2= "자리수는 중복되지 않도록 ";
    final String QUESTION= "임의의 숫자를 맞추시오. 12-98";
    final String AN_UP= "더 큰수를 입력하시오.";
    final String AN_DOWN= "더 작은 수를 입력하시오.";

    public int setNumber()
    {
        final int ARRAY_MAX = 2;
        int[] i_arr = new int[ARRAY_MAX];
        do {
//            10~90
            final int MAX= 9;
            i_arr[0] = (int) (Math.random() * MAX) + 1;
//            0~9
            i_arr[1] = (int) (Math.random() * MAX);
        } while (i_arr[0] == i_arr[1]);

//        십의 자리 + 일의 자리
        return  i_arr[0]*10 + i_arr[1];
    }

    //    중복되지 않는 임의의 두자리 숫자 맞추기 게임
    public void init()
    {
        Example01 j= new Example01();
        int rand= j.setNumber();
        System.out.println(rand);

        System.out.println(j.IN_2);
        System.out.println(j.IN_1);

        Scanner sc= new Scanner(System.in);
        final String RESULT= "임의의 숫자 "+rand+"를 맞쳣습니다.";
        int input= 0;

        do {
            System.out.println(j.QUESTION);
            input= sc.nextInt();
            System.out.println(input);

            if (rand>input)
                System.out.println(j.AN_UP);
            else if
                (rand<input) System.out.println(j.AN_DOWN);
            else
                System.out.println(RESULT);
        }while (rand!=input);
    }
}

class Example02
{
    public int[][] addArray(int[][] f_arr,int[][] s_arr)
    {
        final int first= f_arr.length;
        final int second= f_arr[0].length;
        int[][] arr_result= new int[first][second];
        for (int i=0; i<first; i++)
        {
            for (int j=0; j<second;j++)
            {
                arr_result[i][j]= f_arr[i][j]+s_arr[i][j];
            }
        }
        return arr_result;
    }

    public void printArray(int[][] arr)
    {
        for (int[] value : arr)
        {
            for (int element : value) System.out.printf("%d ", element);
            System.out.println();
        }
    }

    public void  init()
    {
        int[][] arr_01= {{3,5,8}, {4,6,9}, {2,5,1}};
        int[][] arr_02= {{1,2,6}, {5,7,3}, {3,4,8}};
        printArray(addArray(arr_01,arr_02));
    }
}

public class java13 {
    public static void main(String[] args) {
        Example01 ex01= new Example01();
//        ex01.init();

        Example02 ex02= new Example02();
        ex02.init();
    }
}
