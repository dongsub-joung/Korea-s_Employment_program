import java.lang.reflect.Array;
import java.util.Arrays;

public class java12 {

    public void randomNumber()
    {
        final int MAX_BALL_RANGE= 45;
        int[] ball= new int[MAX_BALL_RANGE];
        for (int i=0; i<ball.length; i++) ball[i]= i+1;
        for (int k=0; k<100; k++)
        {
            int temp= ball[0];
            int rand= (int)(Math.random()*MAX_BALL_RANGE);
            ball[0]= ball[rand];
            ball[rand]= temp;
        }
        for (int n=0; n<6; n++) System.out.printf("%d ", ball[n]);
    }

    public void printString()
    {
        int[] i_arr= {1,2,3,4,5};
        System.out.println(Arrays.toString(i_arr));
    }

    public void copyArray()
    {
        int[] i_arr= {1,2,3,4,5,6,7,8,8,9,10};
        int[] i_double= new int[15];
        System.arraycopy(i_arr,0,i_double,0,i_arr.length);
        for (int val : i_double)  System.out.println(val*val);
    }

    public void removeOverlapNumber()
    {
        final int ARRAY_RANGE= 9;
        final int INTEGER_NUMBER= 1;
        int[] i_arr= new int[ARRAY_RANGE];

        while (true)
        {
            for (int i=0; i<ARRAY_RANGE; i++)
            {
                int selected_num= (int) (Math.random()*ARRAY_RANGE)+INTEGER_NUMBER;
                i_arr[i]= selected_num;
            }
        }
    }

    public static void main(String[] args) {
        java12 jv= new java12();
//        jv.randomNumber();
//        jv.printString();
//        jv.copyArray();
    }
}