class Point
{
    int x; int y;
    Point() {}
    Point(int x, int y) { this.x= x; this.y= y; }
    String getLocation() { return "x :" + x + ", y :" + y; }
}
class Point3D extends Point
{
    int z;
     Point3D() {}
     Point3D(int x, int y, int z) { super(x,y); this.z=z; }
//    overridding
    String getLocation() { return super.getLocation() + ", z :" + z; }
}

public class super_ex{
    public static void main(String[] args) {
        System.out.println("Default");
        System.out.println(new Point3D().getLocation());

        System.out.println("Set Value");
        Point3D p3d= new Point3D(1,1,1);
        System.out.println(p3d.getLocation());
    }
}
