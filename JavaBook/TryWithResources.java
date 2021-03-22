class WorkException extends Exception
{
    public WorkException(String message) { super(message); }
}
class CloseException extends Exception
{
    public CloseException(String message) { super(message); }
}

class CloseableResource implements AutoCloseable
{
    public void exceptionWork(boolean exception) throws WorkException
    {
        System.out.printf("exceptionWork 호출 \n", exception);
        if (exception) throw new WorkException("WorkException!");
    }
    public void close() throws CloseException
    {
        System.out.println("Close() 호출");
        throw new CloseException("CloseException 발생");
    }
}

//  close()도 예외가 발생할 수 있다.
public class TryWithResources {
    public static void main(String[] args)
    {
//        try()구문 안에서 객체를 생성하면 자동으로 close()가 실행된다.
        try (CloseableResource rc= new CloseableResource())
        {
            //        예외가 발생하지 않는 예제
            rc.exceptionWork(false);
        }
        catch(WorkException e) { e.printStackTrace(); }
        catch(CloseException e) { e.printStackTrace(); }
        System.out.println();


        try(CloseableResource cr= new CloseableResource())
        {
            //        예외가 발생하는 예제
            cr.exceptionWork(true);
        }
        catch (WorkException e) { e.printStackTrace(); }
        catch (CloseException e) { e.printStackTrace(); }
    }
}
