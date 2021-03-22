class Point implements Cloneable
{
    int x, y;
    int[] i_arr= new int[2];
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.i_arr[0]= x;
        this.i_arr[1]= y;
    }

    @Override
    public String toString() { return "x= " + x + "y= " + y; }

    public Point clone()
    {
        Object obj = null;
        try { obj = super.clone(); }
        catch(CloneNotSupportedException e) {}
        // convariant return type
        return (Point) obj;
    }
}

public class CloneEx {
    public static void main(String[] args)
    {
        Point original= new Point(3,5);
//        Object 객체라 형변환 후 대입 => convariant return type
        Point copy= original.clone();

        System.out.println(original);
        System.out.println(copy);
    }
}
