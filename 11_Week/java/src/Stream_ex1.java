import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Stream_ex1
{
    public static void main(String[] args) {
        byte[] msrc= { 0,1,2,3,4,5,6,7,8,9,10};
        byte[] result= null;
        ByteArrayInputStream ba_in= null;
        ByteArrayOutputStream ba_out= null;
        int temp= 0;

        while ( (temp= ba_in.read()) != -1 ) ba_out.write(temp);
        result= ba_out.toByteArray();
        System.out.println(Arrays.toString(result));
    }
}