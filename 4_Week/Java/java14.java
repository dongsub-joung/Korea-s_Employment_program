import java.util.Scanner;

class Example {
    int[][] i_arr;

    public Example(int[][] f_arr, int[][] s_arr)
    {
        this.i_arr= pluse(f_arr,s_arr);
    }
    public int[][] pluse (int[][] f_arr, int[][] s_arr)
    {
        final int OUT_MAX= f_arr.length;
        final int INNTER_MAX= f_arr[0].length;
        int[][] result= new int[OUT_MAX][INNTER_MAX];
        for (int i=0; i<OUT_MAX; i++)
        {
            for (int j=0; j<INNTER_MAX; j++)
            {
                result[i][j]= f_arr[i][j]+s_arr[i][j];
            }
        }
        return result;
    }
}

class Example02 {
    final int MAX_LEN= 5;
    int[][] i_arr;
    public Example02() {
        this.i_arr= inputData();
        printArray();
    }

    public int[][] inputData()
    {
        int num= 1;
        int[][] arr_result= new int[MAX_LEN][MAX_LEN];
        for (int i=0; i<MAX_LEN; i++)
        {
            for (int j=0; j<MAX_LEN; j++)
            {
                arr_result[i][j]= num;
                num++;
            }
        }
        return arr_result;
    }

    public void printArray()
    {
        for (int[] val : i_arr) {
            for (int element : val) System.out.printf("%d ",element);
            System.out.println();
        }
    }
}


class Example03
{
    final int MAX_LEN= 5;
    int[][] i_arr;

    public Example03()
    {
        this.i_arr= makeFormDataZ();
        printArray(i_arr);
    }

    public int[][] makeFormDataZ()
    {
        int num= 1;
        int[][] arr_result= new int[MAX_LEN][MAX_LEN];
        final int MAX_ROW= MAX_LEN;
        final int MAX_COL= MAX_LEN;
        for (int i=0; i<MAX_ROW; i++)
        {
            if (i%2 == 0)
            {
                for (int j= 0; j<MAX_COL; j++)
                {
                    arr_result[i][j]= num++;
                }
            }
            else {
                for (int j=MAX_COL-1; j>=0; j--)
                {
                    arr_result[i][j]= num++;
                }
            }
        }
        return arr_result;
    }

    public void printArray(int[][] arr)
    {
        for (int[] val : arr) {
            for (int element : val) System.out.printf("%d ",element);
            System.out.println();
        }
    }
}

public class java14 {
    public static void main(String[] args) {

        int[][] A= {{1,2,3},{1,2,3},{1,2,3}};
        int[][] B= {{1,2,3},{1,2,3},{1,2,3}};

        System.out.println("==========================");
        System.out.println("예제 1");
        Example ex= new Example(A,B);
        for (int[] val : ex.i_arr) {
            for (int element : val) System.out.printf("%d ",element);
            System.out.println();
        }

        System.out.println("==========================");
        System.out.println("예제2");
        Example02 ex02= new Example02();

        System.out.println("==========================");
        Example03 ex03= new Example03();

    }
}
