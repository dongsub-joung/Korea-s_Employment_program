
public class java30
{
    public static void main(String[] args) {
        int num= 100;
        int result= 0;

        for (int i=0; i<10; i++)
        {
            try {
                int r= (int) Math.floor(Math.random()*10);
                result= num/r;
            }catch (Exception e)
            {
                e.getMessage();
            }
            finally {
                System.out.println(result);
            }
        }
    }
}


